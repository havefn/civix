package com.havefn.civix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class DataEntryActivity extends AppCompatActivity {

    public Button submitButton;
    public EditText name;
    public EditText city;
    public EditText description;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);

        Intent i = getIntent();
        int uid = (int) i.getExtras().get("uid");

        name = (EditText) findViewById(R.id.entry_name);
        city = (EditText) findViewById(R.id.entry_city);
        description = (EditText) findViewById(R.id.entry_desc);


        Log.d("UserCreation","user" + uid + "creation success");

    }
}
