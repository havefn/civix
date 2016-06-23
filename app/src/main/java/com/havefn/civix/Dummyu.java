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
import java.util.Iterator;

public class Dummyu extends AppCompatActivity {
    private static final String TAG = "DummyActivity";
    public TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummyu);
        text = (TextView) findViewById(R.id.a12);


//        //create
//
//        Location bleh = new Location("ATLANTIS");
//        bleh.setLongitude(100);
//        bleh.setAltitude(200);
//        bleh.setLatitude(300);
//
//        Quest aa = new Quest("CAK", bleh, "Lokasi Harta", "blehblehblehbleh", "imageid", "type", "quest4");

//       //retrieve location
//
//        Global.mRoot.child("quests").child("quest4").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Quest aa = dataSnapshot.getValue(Quest.class);
//                Log.d(TAG, aa.getQuestLocation().getProvider());
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
   }
}

