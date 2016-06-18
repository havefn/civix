package com.havefn.civix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Cak on 18/06/2016.
 */
public class StartingActivity extends AppCompatActivity {

    protected Button btnSignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);

        btnSignin = (Button) findViewById(R.id.btn_to_register);

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartingActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}
