package com.gold.money;

import android.app.Application;

import com.emindsoft.appstore.BuildConfig;
import com.emindsoft.appstore.R;
import com.gold.money.data.api.ApiService;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Bob.
 */
public class StoreApplication extends Application {

    private static StoreApplication storeApplication;

    public static ApiService apiService;

    public static StoreApplication getAppContext() {
        return storeApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        storeApplication = (StoreApplication) getApplicationContext();
        initApiService();
        Fresco.initialize(this);
    }

    private void initApiService() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(logging);
        }

        builder.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(60 * 1000, TimeUnit.MILLISECONDS);

        OkHttpClient okHttpClient = builder.build();

        apiService = new Retrofit.Builder().client(okHttpClient)
                .baseUrl(getAppContext().getString(R.string.base_url))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(ApiService.class);
    }

}