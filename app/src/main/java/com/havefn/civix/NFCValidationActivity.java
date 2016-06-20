package com.havefn.civix;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Arrays;

/**
 * Created by Cak on 19/06/2016.
 */
public class NFCValidationActivity extends AppCompatActivity {

    private static final String TAG = "NFCActivity";
    protected NfcAdapter nfcAdapter;
    protected byte[] tagId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfcvalidation);

        //PendingIntent pi = PendingIntent.getActivity(this, 0, nfcIntent, 0);
        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if(nfcAdapter != null && nfcAdapter.isEnabled()) {
            Log.d(TAG, "NFC exist!!");
        } else {
            Log.d(TAG, "NFC notAvailable!!");
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        //Toast.makeText(this, "NFC Intent Received!", Toast.LENGTH_LONG).show();
        Tag targetTag = (Tag) intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
        tagId = targetTag.getId();
        Log.d(TAG, "NFC received " + Arrays.toString(tagId));
        // TODO: 19/06/2016 ini idnya udah direceive, disini ditambah untuk mensinkronasi data di quest user
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
