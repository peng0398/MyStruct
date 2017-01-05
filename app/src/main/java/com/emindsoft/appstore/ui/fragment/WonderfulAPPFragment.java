package com.emindsoft.appstore.ui.fragment;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.emindsoft.appstore.R;
import com.emindsoft.appstore.StoreApplication;
import com.emindsoft.appstore.data.api.WonderfulService;
import com.emindsoft.appstore.data.api.response.UserResponse;
import com.emindsoft.appstore.di.module.WonderfulAppFragmentModule;
import com.emindsoft.appstore.ui.base.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author: Bob
 * Date: 2017/1/5.
 */

public class WonderfulAPPFragment extends BaseFragment {

    public static WonderfulAPPFragment newInstance() {
        return new WonderfulAPPFragment();
    }

    @Inject
    Application application;

    @Inject
    WonderfulService wonderfulService;

    @BindView(R.id.tv_content)
    TextView tv_content;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StoreApplication.get(getContext())
                .getAppComponent()
                .plus(new WonderfulAppFragmentModule())
                .inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(application, R.layout.wonderful_fragment, null);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Observable<UserResponse> observable = wonderfulService.getUser("peng0398");
        observable.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Subscriber<UserResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(UserResponse userResponse) {
                tv_content.setText(userResponse.url);
            }
        });
    }
}
