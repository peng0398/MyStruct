package com.gold.money.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.emindsoft.appstore.R;

/**
 * Author: Bob
 * Date: 2017/3/6.
 */

public class RequestPermissionActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.permission_activity);
    }

    public void allowPermission(View view){

    }
}
