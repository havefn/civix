package com.havefn.civix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.SecureRandom;

public class MainMenuActivity extends AppCompatActivity {
    Button btnGrab;
    TextView layar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btnGrab = (Button) findViewById(R.id.btnGrab);
        layar = (TextView) findViewById(R.id.tv_view);

        Intent i = getIntent();
        String userId = i.getStringExtra("userId");

        DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference();
        DatabaseReference mCurrentUser =  mRoot.child("users").child(userId).getRef();

        mCurrentUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                layar.setText((String)dataSnapshot.child("name").getValue());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
