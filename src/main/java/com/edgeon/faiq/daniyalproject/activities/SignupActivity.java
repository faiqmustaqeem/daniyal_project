package com.edgeon.faiq.daniyalproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.edgeon.faiq.daniyalproject.R;
import com.edgeon.faiq.daniyalproject.helperClasses.SharedPreferenceHelper;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignupActivity extends AppCompatActivity {

    @BindView(R.id.etUsername)
    EditText etUsername;
    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.etMobileNumber)
    EditText etMobileNumber;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.etConfirmPassword)
    EditText etConfirmPassword;
    @BindView(R.id.btnSignup)
    Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSignup)
    public void onViewClicked() {

        if (!etPassword.getText().equals("") && etPassword.getText().toString().equals(etConfirmPassword.getText().toString())) {
            SharedPreferenceHelper.setSharedPreferenceString(this, "username", etUsername.getText().toString());
            SharedPreferenceHelper.setSharedPreferenceString(this, "email", etEmail.getText().toString());
            SharedPreferenceHelper.setSharedPreferenceString(this, "mobile", etMobileNumber.getText().toString());
            SharedPreferenceHelper.setSharedPreferenceString(this, "password", etPassword.getText().toString());

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "password dont match", Toast.LENGTH_SHORT).show();
        }


    }


}
