package com.emindsoft.appstore;

import javax.inject.Singleton;

import dagger.Component;
import com.emindsoft.appstore.data.api.GithubApiModule;
import com.emindsoft.appstore.data.UserComponent;
import com.emindsoft.appstore.data.api.UserModule;
import com.emindsoft.appstore.ui.activity.component.SplashActivityComponent;
import com.emindsoft.appstore.ui.activity.module.SplashActivityModule;

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

    UserComponent plus(UserModule userModule);

}