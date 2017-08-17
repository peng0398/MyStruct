package com.gold.money.ui.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.emindsoft.appstore.R;
import com.gold.money.contract.LoginActivityContract;
import com.gold.money.presenter.LoginActivityPresenter;

import butterknife.OnClick;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

/**
 * Author: Bob
 * Date: 2017/1/13.
 */
@RuntimePermissions
public class LoginActivity extends BaseActivity implements LoginActivityContract.View {

    LoginActivityPresenter presenter = new LoginActivityPresenter(this);

    @OnClick(R.id.btn_regist)
    void login() {
//        presenter.regist("bob", "111111", "111111");
        LoginActivityPermissionsDispatcher.showCameraWithCheck(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbarVisiablity(View.VISIBLE);
        presenter.subscribe();
    }

    @NeedsPermission(Manifest.permission.CAMERA)
    void showCamera() {
        Toast.makeText(this, "打开相机", Toast.LENGTH_SHORT).show();
    }

    @OnShowRationale(Manifest.permission.CAMERA)
    void showRationaleForCamera(final PermissionRequest request) {
        request.proceed();
    }

    @OnPermissionDenied(Manifest.permission.CAMERA)
    void showDeniedForCamera() {
        Toast.makeText(this, "无法获取相机权限", Toast.LENGTH_SHORT).show();
    }

    @OnNeverAskAgain(Manifest.permission.CAMERA)
    void showNeverAskCamera() {
        Toast.makeText(this, "请在设置中授予该app相机权限", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // NOTE: delegate the permission handling to generated method
        LoginActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    public void setPresenter(LoginActivityContract.Presenter presenter) {

    }

    @Override
    public void showResult(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }
}
