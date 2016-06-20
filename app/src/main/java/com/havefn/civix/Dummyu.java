package com.havefn.civix;

import android.content.Intent;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class Dummyu extends AppCompatActivity {
    private static final String TAG = "DummyActivity";
    Quests quests;


    public TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummyu);
        text = (TextView) findViewById(R.id.a12);
//
//
//        User haha = new User("wkwk", "aufajelek", "aufa@jelek.com");
//
//        try {
//            NFCQuest questjelek = new NFCQuest("wisnukeren", null, "jadi orang jelek", "aufa jadi orang jelek", null, null);
//            questjelek.setTargetCount(5);
//            QuestProgression apakek = new QuestProgression(null, 5, "wkwk", "wisnukeren");
//            Intent intent = new Intent(this, NFCValidationActivity.class);
//            intent.putExtra("currentUserId","wkwk");
//            intent.putExtra("questId","wisnukeren");
//            haha.getTakenQuests().put("wkwk", apakek);
//            haha.updateDatabase();
//            startActivity(intent);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        Quests questlist = new Quests();
//        questlist.addQuest("haha", null);
//        questlist.updateDatabase();

        Location tempLoc = new Location("Aufa's");
        tempLoc.setLatitude(255);
        tempLoc.setAltitude(123);
        tempLoc.setLongitude(761);


        try {
            Quest ckck = new Quest("1233334", tempLoc , "Lokasi Atlantis", "Dimensi lain!!!!", "12334", "RFID");
        } catch (Exception e) {
            e.printStackTrace();
        }

//        Global.mRoot.getDatabase().getReference().child("quests").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                quests = (Quests) dataSnapshot.getValue(Quests.class);
//                Log.d(TAG, "" + quests.getQuests().get("haha"));
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
    }
}
