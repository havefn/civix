package com.havefn.civix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Dummyu extends AppCompatActivity {

    public TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummyu);
        text = (TextView) findViewById(R.id.a12);
        DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference mA12 = mRoot.child("a12").getRef();

        mA12.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                text.setText((String)dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mRoot.child("test2").setValue("aaaaaa");
        String userId = "aaaaaaa";
        User newUser = new User(userId,"Mr. Aa" ,"a@a.com");
        mRoot.child("users").child(userId).setValue(newUser);

    }
}
