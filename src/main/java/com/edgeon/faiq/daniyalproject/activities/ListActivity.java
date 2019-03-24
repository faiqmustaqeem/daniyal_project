package com.edgeon.faiq.daniyalproject.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.edgeon.faiq.daniyalproject.R;
import com.edgeon.faiq.daniyalproject.helperClasses.SharedPreferenceHelper;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity {

    @BindView(R.id.listview)
    ListView listview;
    List<String> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);

        users.add("hunain");
        users.add("razi");
        users.add("ali");
        users.add("sabih");
        users.add(SharedPreferenceHelper.getSharedPreferenceString(this, "username", ""));

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, users);
        listview.setAdapter(adapter);
    }
}
