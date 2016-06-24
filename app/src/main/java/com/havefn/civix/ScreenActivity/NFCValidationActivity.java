package com.havefn.civix.ScreenActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.havefn.civix.Global;
import com.havefn.civix.Quest.NFCQuest;
import com.havefn.civix.Quest.Quest;
import com.havefn.civix.Quest.QuestProgression;
import com.havefn.civix.R;
import com.havefn.civix.User.User;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Cak on 19/06/2016.
 */
public class NFCValidationActivity extends AppCompatActivity {

    private static final String TAG = "NFCActivity";
    private static final boolean NFCALLOWED = true;
    private NfcAdapter nfcAdapter;
    private byte[] tagId;
    private Quest currentQuest;
    private User currentUser;
    private String questId;
    QuestProgression takenQuestProgression;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfcvalidation);

        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (nfcAdapter != null && nfcAdapter.isEnabled()) {
            Log.d(TAG, "NFC exist!!");
        } else {
            Log.d(TAG, "NFC not Available!!");
        }
        if (NFCALLOWED) {
            Intent intent = getIntent();
            final String currentUserId = intent.getStringExtra("currentUserId").toString();
            questId = intent.getStringExtra("questId").toString();
            Global.mRoot.child("users").child(currentUserId).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    currentUser = dataSnapshot.getValue(User.class);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            Global.mRoot.child("quests").child(questId).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    currentQuest = (NFCQuest) dataSnapshot.getValue();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        //Toast.makeText(this, "NFC Intent Received!", Toast.LENGTH_LONG).show();
        Tag targetTag = (Tag) intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
        tagId = targetTag.getId();

        Log.d(TAG, "NFC received " + Arrays.toString(tagId));
        if (NFCALLOWED) {
            takenQuestProgression = currentUser.getTakenQuests().get(questId);
            int temp = takenQuestProgression.getCurrentCount();
            takenQuestProgression.setCurrentCount(++temp);
            currentUser.setTakenQuests(currentUser.getTakenQuests());

            ArrayList<String> nfcIds = (ArrayList) ((NFCQuest) currentQuest).getNfcID();

            if (nfcIds.contains(tagId.toString())) {
                temp = takenQuestProgression.getCurrentCount();
                takenQuestProgression.setCurrentCount(++temp);
            }

            if (takenQuestProgression.isComplete()) {
                Log.d(TAG, "Quest complete");
            }
        }
        super.onNewIntent(intent);
    }

    @Override
    protected void onResume() {
        Intent intent = new Intent(this, NFCValidationActivity.class);
        intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        IntentFilter[] intentFilter = new IntentFilter[]{};

        nfcAdapter.enableForegroundDispatch(this, pendingIntent, intentFilter, null);
        super.onResume();
    }

    @Override
    protected void onPause() {
        nfcAdapter.disableForegroundDispatch(this);
        super.onPause();
    }
}
