package com.Sakhii.Suraksha;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ContactsActivity extends AppCompatActivity {
    EditText etNumber;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        etNumber = findViewById(R.id.etNumber);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(v -> {
            String num = etNumber.getText().toString().trim();
            if (num.isEmpty()) {
                Toast.makeText(this, "Enter number", Toast.LENGTH_SHORT).show();
                return;
            }
            Utils.addEmergencyContact(this, num);
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
            etNumber.setText("") ;
        });
    }
}
