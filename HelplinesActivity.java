package com.Sakhii.Suraksha;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HelplinesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helplines);

        Button btnWomen = findViewById(R.id.btnWomen);
        btnWomen.setOnClickListener(v -> callNumber("1091"));

        Button btnPolice = findViewById(R.id.btnPolice);
        btnPolice.setOnClickListener(v -> callNumber("100"));

        Button btnAmb = findViewById(R.id.btnAmbulance);
        btnAmb.setOnClickListener(v -> callNumber("102"));
    }

    private void callNumber(String number) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:" + number));
        startActivity(callIntent);
    }
}
