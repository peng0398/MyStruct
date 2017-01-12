package com.emindsoft.appstore.di.module;

import dagger.Module;
import dagger.Provides;

import com.emindsoft.appstore.HeavyLibraryWrapper;
import com.emindsoft.appstore.data.api.UserManager;
import com.emindsoft.appstore.di.scope.ActivityScope;
import com.emindsoft.appstore.ui.activity.SplashActivity;
import com.emindsoft.appstore.presenter.SplashActivityPresenter;
import com.emindsoft.appstore.utils.Validator;

/**
 * Created by Bob.
 */
@Module
public class SplashActivityModule {
    private SplashActivity splashActivity;

    public SplashActivityModule(SplashActivity splashActivity) {
        this.splashActivity = splashActivity;
    }

    @Provides
    @ActivityScope
    SplashActivity provideSplashActivity() {
        return splashActivity;
    }

    @Provides
    @ActivityScope
    SplashActivityPresenter
    provideSplashActivityPresenter(Validator validator, UserManager userManager, HeavyLibraryWrapper heavyLibraryWrapper) {
        return new SplashActivityPresenter(splashActivity, validator, userManager, heavyLibraryWrapper);
    }
}