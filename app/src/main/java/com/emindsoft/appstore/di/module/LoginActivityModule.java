package com.emindsoft.appstore.di.module;

import com.emindsoft.appstore.contract.LoginActivityContract;
import com.emindsoft.appstore.data.api.UserApiService;
import com.emindsoft.appstore.di.scope.ActivityScope;
import com.emindsoft.appstore.presenter.LoginActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Author: Bob
 * Date: 2017/1/13.
 */

@ActivityScope
@Module
public class LoginActivityModule {

    private LoginActivityContract.View view;

    public LoginActivityModule(LoginActivityContract.View view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    LoginActivityContract.View provideLoginActivityView(){
        return view;
    }

    @Provides
    @ActivityScope
    LoginActivityPresenter provideLoginActivityPresenter(LoginActivityContract.View view , UserApiService service) {
        return new LoginActivityPresenter(view,service);
    }
}
