package com.example.responsi0669.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.responsi0669.R;

public class RecoveryActivity extends AppCompatActivity {

    private ImageView btnBack;
    private EditText etEmail;
    private Button btnSendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery);

        etEmail = findViewById(R.id.etEmail);
        btnBack = findViewById(R.id.btnBack);
        btnSendEmail = findViewById(R.id.btnSendEmail);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}