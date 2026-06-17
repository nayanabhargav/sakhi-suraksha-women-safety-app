package com.Sakhii.Suraksha;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.List;

public class PanicActivity extends AppCompatActivity {
    MediaPlayer siren;
    TextView tvStatus;
    Button btnSendSOS, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panic);

        tvStatus = findViewById(R.id.tvStatus);
        btnSendSOS = findViewById(R.id.btnSendSOS);
        btnStop = findViewById(R.id.btnStop);

        siren = MediaPlayer.create(this, R.raw.siren);
        siren.setLooping(true);

        btnSendSOS.setOnClickListener(v -> doSos());
        btnStop.setOnClickListener(v -> stopSiren());

        // auto-start siren on open
        startSiren();
    }

    private void startSiren() {
        if (!siren.isPlaying()) siren.start();
        tvStatus.setText("Siren active");
    }
    private void stopSiren() {
        if (siren.isPlaying()) siren.stop();
        tvStatus.setText("Stopped");
    }

    private void doSos() {
        List<String> contacts = Utils.getEmergencyContacts(this);
        String location = LocationHelper.getLastLocationString(this);
        String msg = "I am in emergency. Please help. My location: " + location;

        SmsManager sms = SmsManager.getDefault();
        for (String c : contacts) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                sms.sendTextMessage(c, null, msg, null, null);
            }
        }
        Toast.makeText(this, "SOS messages sent", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (siren != null) siren.release();
    }
}
