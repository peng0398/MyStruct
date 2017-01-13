package com.emindsoft.appstore.di.component;

import com.emindsoft.appstore.di.module.LoginActivityModule;
import com.emindsoft.appstore.di.scope.ActivityScope;
import com.emindsoft.appstore.ui.activity.LoginActivity;

import dagger.Subcomponent;

/**
 * Author: Bob
 * Date: 2017/1/13.
 */

@ActivityScope
@Subcomponent(modules = {LoginActivityModule.class})
public interface LoginActivityComponent {
    void inject(LoginActivity activity);
}
