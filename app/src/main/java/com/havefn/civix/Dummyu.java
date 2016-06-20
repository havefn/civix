package com.havefn.civix;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class Dummyu extends AppCompatActivity {

    public TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummyu);
        text = (TextView) findViewById(R.id.a12);
        DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference mA12 = mRoot.child("wkwk").getRef();
         mA12.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 text.setText((String)dataSnapshot.getValue());
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {

             }
         });
    }
}
