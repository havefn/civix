package com.havefn.civix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class QuestActivity extends AppCompatActivity {
    TextView typeText;
    TextView titleText;
    TextView locationText;
    TextView descriptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);


    }
}
