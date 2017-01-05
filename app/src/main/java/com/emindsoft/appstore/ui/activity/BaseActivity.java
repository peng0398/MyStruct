package com.emindsoft.appstore.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.emindsoft.appstore.AppComponent;
import com.emindsoft.appstore.GithubClientApplication;

/**
 * Created by Bob.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent();
    }

    protected abstract void setupActivityComponent();
}