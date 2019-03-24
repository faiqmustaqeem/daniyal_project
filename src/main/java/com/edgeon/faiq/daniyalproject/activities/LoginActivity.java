package com.edgeon.faiq.daniyalproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.edgeon.faiq.daniyalproject.R;
import com.edgeon.faiq.daniyalproject.helperClasses.SharedPreferenceHelper;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.etUsername)
    EditText etUsername;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.btnSignin)
    Button btnSignin;
    @BindView(R.id.btnSignup)
    Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ligin);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnSignin, R.id.btnSignup})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnSignin:
                if (isValid()) {
                    SharedPreferenceHelper.setSharedPreferenceBoolean(this, "isLoggedIn", true);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "incorrect username or password", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnSignup:
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
                break;
        }
    }

    private boolean isValid() {
        if (
                SharedPreferenceHelper.getSharedPreferenceString(LoginActivity.this, "username", "default").equals(etUsername.getText().toString()) &&
                        SharedPreferenceHelper.getSharedPreferenceString(LoginActivity.this, "password", "default").equals(etPassword.getText().toString())) {
            return true;
        }
        return false;
    }
}
