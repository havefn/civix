package com.havefn.civix;

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
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Cak on 19/06/2016.
 */
public class NFCValidationActivity extends AppCompatActivity {

    private static final String TAG = "NFCActivity";
    private NfcAdapter nfcAdapter;
    private byte[] tagId;
    private Quest currentQuest;
    private String userId;
    private String questId;
    private QuestProgression takenQuestProgression;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfcvalidation);

        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if(nfcAdapter != null && nfcAdapter.isEnabled()) {
            Log.d(TAG, "NFC exist!!");
        } else {
            Log.d(TAG, "NFC not Available!!");
        }
    }

    @Override
    protected void onNewIntent(Intent intent)  {
        //Toast.makeText(this, "NFC Intent Received!", Toast.LENGTH_LONG).show();
        Tag targetTag = (Tag) intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
        tagId = targetTag.getId();
        userId = intent.getStringExtra("currentUserId").toString();

        Log.d(TAG, "NFC received " + Arrays.toString(tagId));
        // TODO: 19/06/2016 ini idnya udah direceive, disini ditambah untuk mensinkronasi data di quest user
       questId =  intent.getStringExtra("questId");
         Global.mRoot.child("quests").child(questId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                currentQuest = (NFCQuest) dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        Global.mRoot.child("users").child(userId).child("takenQuest").child(questId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        takenQuestProgression = (QuestProgression) dataSnapshot.getValue();
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});

        ArrayList<String> nfcIds = (ArrayList) ((NFCQuest) currentQuest).getNfcID();

        if(nfcIds.contains(tagId.toString())){
            
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
