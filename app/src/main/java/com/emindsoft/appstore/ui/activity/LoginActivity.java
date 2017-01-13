package com.emindsoft.appstore.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.emindsoft.appstore.R;
import com.emindsoft.appstore.StoreApplication;
import com.emindsoft.appstore.contract.LoginActivityContract;
import com.emindsoft.appstore.di.module.LoginActivityModule;
import com.emindsoft.appstore.presenter.LoginActivityPresenter;

import javax.inject.Inject;

import butterknife.OnClick;

/**
 * Author: Bob
 * Date: 2017/1/13.
 */
public class LoginActivity extends BaseActivity implements LoginActivityContract.View{

    @Inject
    LoginActivityPresenter presenter;

    @OnClick(R.id.btn_regist)
    void login(){
        presenter.regist("bob","111111","111111");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbarVisiablity(View.VISIBLE);
        presenter.subscribe();
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void setupActivityComponent() {
        StoreApplication.getAppContext()
                .getAppComponent()
                .plus(new LoginActivityModule(this))
                .inject(this);
    }

    @Override
    public void setPresenter(LoginActivityContract.Presenter presenter) {

    }

    @Override
    public void showResult(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }
}
