package com.emindsoft.appstore;

import android.app.Application;
import android.content.Context;

import com.emindsoft.appstore.di.component.DaggerAppComponent;
import com.emindsoft.appstore.di.component.UserComponent;
import com.emindsoft.appstore.di.module.UserModule;
import com.emindsoft.appstore.data.model.User;
import com.emindsoft.appstore.di.component.AppComponent;
import com.emindsoft.appstore.di.module.AppModule;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Bob.
 */
    public class StoreApplication extends Application {

    private AppComponent appComponent;
    private UserComponent userComponent;
    private static StoreApplication storeApplication;

    public static StoreApplication getAppContext() {
        return storeApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        storeApplication = (StoreApplication) getApplicationContext();
        initAppComponent();
        Fresco.initialize(this);
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