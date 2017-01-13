package com.emindsoft.appstore.di.component;

import javax.inject.Singleton;

import dagger.Component;

import com.emindsoft.appstore.di.module.LoginActivityModule;
import com.emindsoft.appstore.di.module.StoreApiModule;
import com.emindsoft.appstore.di.module.UserModule;
import com.emindsoft.appstore.di.module.AppModule;
import com.emindsoft.appstore.di.module.SplashActivityModule;
import com.emindsoft.appstore.di.module.WonderfulAppFragmentModule;
import com.emindsoft.appstore.ui.activity.LoginActivity;

/**
 * Created by Bob.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                StoreApiModule.class
        }
)
public interface AppComponent {

    SplashActivityComponent plus(SplashActivityModule module);

    WonderfulAppFragmentComponent plus(WonderfulAppFragmentModule module);

    UserComponent plus(UserModule userModule);

    LoginActivityComponent plus(LoginActivityModule module);
}