package com.emindsoft.appstore.ui.activity.component;

import dagger.Subcomponent;
import com.emindsoft.appstore.ui.activity.ActivityScope;
import com.emindsoft.appstore.ui.activity.SplashActivity;
import com.emindsoft.appstore.ui.activity.module.SplashActivityModule;
import com.emindsoft.appstore.ui.activity.presenter.SplashActivityPresenter;

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