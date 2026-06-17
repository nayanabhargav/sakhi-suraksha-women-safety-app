package com.Sakhii.Suraksha;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnContacts, btnHelplines, btnLaws, btnSelfDefense, btnPanic;
    ShakeDetector shakeDetector;

    ActivityResultLauncher<String[]> permissionLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnContacts = findViewById(R.id.btnContacts);
        btnHelplines = findViewById(R.id.btnHelplines);
        btnLaws = findViewById(R.id.btnLaws);
        btnSelfDefense = findViewById(R.id.btnSelfDefense);
        btnPanic = findViewById(R.id.btnPanic);

        btnContacts.setOnClickListener(v -> startActivity(new Intent(this, ContactsActivity.class)));
        btnHelplines.setOnClickListener(v -> startActivity(new Intent(this, HelplinesActivity.class)));
        btnLaws.setOnClickListener(v -> startActivity(new Intent(this, LawsActivity.class)));
        btnSelfDefense.setOnClickListener(v -> startActivity(new Intent(this, SelfDefenseActivity.class)));
        btnPanic.setOnClickListener(v -> startActivity(new Intent(this, PanicActivity.class)));

        permissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), result -> {
            // permissions result handled silently
        });

        requestEssentialPermissions();

        shakeDetector = new ShakeDetector(this, () -> {
            // On shake action: open PanicActivity
            startActivity(new Intent(MainActivity.this, PanicActivity.class));
        });
    }

    private void requestEssentialPermissions() {
        String[] perms = new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.SEND_SMS,
                Manifest.permission.CALL_PHONE,
                Manifest.permission.RECORD_AUDIO
        };
        permissionLauncher.launch(perms);
    }

    @Override
    protected void onResume() {
        super.onResume();
        shakeDetector.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        shakeDetector.stop();
    }
}
