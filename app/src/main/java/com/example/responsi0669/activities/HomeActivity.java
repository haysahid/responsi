package com.example.responsi0669.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.responsi0669.R;
import com.example.responsi0669.fragments.HistoryFragment;
import com.example.responsi0669.fragments.HomeFragment;
import com.example.responsi0669.fragments.PaymentFragment;
import com.example.responsi0669.fragments.SettingFragment;
import com.example.responsi0669.utils.PreferencesHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private Context context;
    private PreferencesHelper preferencesHelper;
    private BottomNavigationView bottomNavigationView;

    private long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        context = getApplicationContext();
        preferencesHelper = PreferencesHelper.getInstance(context);

        // Cek status login
        if (!preferencesHelper.isLogin()) {
            Intent intent = new Intent(context, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK );
            startActivity(intent);
        }

        loadFragment(new HomeFragment());

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        loadFragment(new HomeFragment());
                        return true;
                    case R.id.action_payment:
                        loadFragment(new PaymentFragment());
                        return true;
                    case R.id.action_history:
                        loadFragment(new HistoryFragment());
                        return true;
                    case R.id.action_setting:
                        loadFragment(new SettingFragment());
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            Toast.makeText(context, "Tekan sekali lagi untuk keluar", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fcvHome, fragment, null)
                .commit();
    }
}