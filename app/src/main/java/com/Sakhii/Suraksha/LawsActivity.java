package com.Sakhii.Suraksha;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class LawsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laws);

        Button btnViewLaw = findViewById(R.id.btnViewLaw);
        btnViewLaw.setOnClickListener(v -> {
            Intent i = new Intent(this, LawsDetailActivity.class);
            i.putExtra("law_title", "Equal Remuneration Act, 1976");
            i.putExtra("law_text", getString(R.string.law_long_text));
            startActivity(i);
        });
    }
}
