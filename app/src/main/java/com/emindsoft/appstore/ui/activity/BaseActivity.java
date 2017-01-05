package com.emindsoft.appstore.ui.activity;

import android.os.Bundle;
import android.view.WindowManager;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by Bob.
 */
public abstract class BaseActivity extends SupportActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setupActivityComponent();
    }

    protected abstract void setupActivityComponent();
}