package com.emindsoft.appstore.di.component;

import dagger.Subcomponent;
import com.emindsoft.appstore.di.scope.ActivityScope;
import com.emindsoft.appstore.ui.activity.SplashActivity;
import com.emindsoft.appstore.di.module.SplashActivityModule;

/**
 * Created by Bob.
 */
@ActivityScope
@Subcomponent(
        modules = SplashActivityModule.class
)
public interface SplashActivityComponent {

    SplashActivity inject(SplashActivity splashActivity);

}