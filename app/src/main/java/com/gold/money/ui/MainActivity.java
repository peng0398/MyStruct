package com.gold.money.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.view.View;

import com.emindsoft.appstore.R;
import com.gold.money.ui.activity.BaseActivity;
import com.gold.money.ui.activity.LoginActivity;
import com.gold.money.ui.fragment.MainFragment;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.OnClick;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * Author: Bob
 * Date: 2017/1/5.
 */

public class MainActivity extends BaseActivity {

    private SimpleDraweeView iv_icon;

    @OnClick(R.id.nav_view)
    void goLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_container, MainFragment.newInstance());
        }
        View headerView = navigationView.getHeaderView(0);
        iv_icon = ((SimpleDraweeView) headerView.findViewById(R.id.iv_icon));
        iv_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLogin();
            }
        });
    }

    @Override
    protected int getContentView() {
        return R.layout.main_activity;
    }

    @Override
    public void onExceptionAfterOnSaveInstanceState(Exception e) {
        // TODO: 16/12/7 在此可以监听到警告： Can not perform this action after onSaveInstanceState!
        // 建议在线上包中，此处上传到异常检测服务器（eg. 自家异常检测系统或Bugtags等崩溃检测第三方），来监控该异常
    }

    @Override
    public void onBackPressedSupport() {
        // 对于 4个类别的主Fragment内的回退back逻辑,已经在其onBackPressedSupport里各自处理了
        super.onBackPressedSupport();
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        // 设置横向(和安卓4.x动画相同)
        return new DefaultHorizontalAnimator();
    }
}
