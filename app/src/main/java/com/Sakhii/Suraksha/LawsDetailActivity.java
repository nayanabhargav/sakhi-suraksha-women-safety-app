package com.Sakhii.Suraksha;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LawsDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laws_detail);

        TextView tvTitle = findViewById(R.id.tvLawTitle);
        TextView tvText = findViewById(R.id.tvLawText);

        String title = getIntent().getStringExtra("law_title");
        String text = getIntent().getStringExtra("law_text");

        tvTitle.setText(title);
        tvText.setText(text);
    }
}
