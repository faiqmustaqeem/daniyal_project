package com.edgeon.faiq.daniyalproject.activities;

import android.content.Intent;
import android.os.Bundle;

import com.edgeon.faiq.daniyalproject.R;
import com.edgeon.faiq.daniyalproject.helperClasses.SharedPreferenceHelper;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_activty);

        if (!isLoggedIn()) {
            Intent intent = new Intent(SplashActivty.this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else {

            Intent intent = new Intent(SplashActivty.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }

    private boolean isLoggedIn() {
        return SharedPreferenceHelper.getSharedPreferenceBoolean(SplashActivty.this, "isLoggedIn", false);
    }
}
