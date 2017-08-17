package com.gold.money.ui.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.emindsoft.appstore.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by Bob.
 */
public abstract class BaseActivity extends SupportActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setContentView(R.layout.activity_base);
        View content = View.inflate(this, getContentView(), null);
        ((FrameLayout) findViewById(R.id.fl_content)).addView(content);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setToolbarVisiablity(View.GONE);
    }

    public void setToolbarVisiablity(int visiablity){
        toolbar.setVisibility(visiablity);
    }

    protected abstract
    @LayoutRes
    int getContentView();

}