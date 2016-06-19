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

    protected Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);

        btnLogin = (Button) findViewById(R.id.btn_to_login);
        btnRegister = (Button) findViewById(R.id.btn_to_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartingActivity.this, NFCValidationActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartingActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
