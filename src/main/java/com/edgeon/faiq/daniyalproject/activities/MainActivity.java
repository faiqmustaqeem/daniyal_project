package com.edgeon.faiq.daniyalproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.edgeon.faiq.daniyalproject.R;
import com.edgeon.faiq.daniyalproject.helperClasses.SharedPreferenceHelper;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnViewList)
    Button btnViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnViewList, R.id.logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnViewList:
                Intent intent = new Intent(this, ListActivity.class);
                startActivity(intent);
                break;
            case R.id.logout:
                SharedPreferenceHelper.clear(this);
                Intent intent2 = new Intent(this, SplashActivty.class);
                startActivity(intent2);
                finishAffinity();
                break;
        }
    }


}
