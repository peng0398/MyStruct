package com.emindsoft.appstore.di.component;

import javax.inject.Singleton;

import dagger.Component;
import com.emindsoft.appstore.di.module.GithubApiModule;
import com.emindsoft.appstore.data.api.UserModule;
import com.emindsoft.appstore.di.module.AppModule;
import com.emindsoft.appstore.di.module.SplashActivityModule;
import com.emindsoft.appstore.di.module.WonderfulAppFragmentModule;

/**
 * Created by Bob.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                GithubApiModule.class
        }
)
public interface AppComponent {

    SplashActivityComponent plus(SplashActivityModule module);

    WonderfulAppFragmentComponent plus(WonderfulAppFragmentModule module);

    UserComponent plus(UserModule userModule);

}