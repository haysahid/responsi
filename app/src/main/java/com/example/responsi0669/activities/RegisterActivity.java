package com.example.responsi0669.activities;

import static com.example.responsi0669.room.AppApplication.db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.responsi0669.R;
import com.example.responsi0669.room.User;
import com.example.responsi0669.utils.PreferencesHelper;

public class RegisterActivity extends AppCompatActivity {

    private ImageView btnBack;
    private EditText etEmail, etPassword, etConfirmPassword;
    private Button btnRegister;

    private User user;
    private PreferencesHelper preferencesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnBack = findViewById(R.id.btnBack);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);

        preferencesHelper = PreferencesHelper.getInstance(getApplicationContext());

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String confirmPassword = etConfirmPassword.getText().toString();

                // Validasi inputan
                if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    Toast.makeText(getApplicationContext(), "Periksa kembali password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Register user baru dengan mengecek ketersediaannya
                user = new User();
                user = db.userDao().findByEmail(email);

                if (user == null) {
                    user = new User();
                    user.setEmail(email);
                    user.setPassword(password);

                    db.userDao().insertAll(user);

                    preferencesHelper.setLogin(true, email, password);

                    Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK );
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Email sudah terdaftar!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}