package com.emindsoft.appstore;

import android.app.Application;
import android.content.Context;

import com.emindsoft.appstore.di.component.DaggerAppComponent;
import com.emindsoft.appstore.di.component.UserComponent;
import com.emindsoft.appstore.data.api.UserModule;
import com.emindsoft.appstore.data.model.User;
import com.emindsoft.appstore.di.component.AppComponent;
import com.emindsoft.appstore.di.module.AppModule;

/**
 * Created by Bob.
 */
    public class StoreApplication extends Application {

    private AppComponent appComponent;
    private UserComponent userComponent;

    public static StoreApplication get(Context context) {
        return (StoreApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        if (BuildConfig.DEBUG) {
//            Timber.plant(new Timber.DebugTree());
//            AndroidDevMetrics.initWith(this);
//        }

        initAppComponent();
    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public UserComponent createUserComponent(User user) {
        userComponent = appComponent.plus(new UserModule(user));
        return userComponent;
    }

    public void releaseUserComponent() {
        userComponent = null;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public UserComponent getUserComponent() {
        return userComponent;
    }

}