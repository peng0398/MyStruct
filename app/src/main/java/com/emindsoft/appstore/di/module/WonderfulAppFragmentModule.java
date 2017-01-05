package com.emindsoft.appstore.di.module;

import com.emindsoft.appstore.data.api.WonderfulService;
import com.emindsoft.appstore.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Bob.
 */
@Module
public class WonderfulAppFragmentModule {

    @FragmentScope
    @Provides
    public WonderfulService provideWonderfulService(Retrofit restAdapter) {
        return restAdapter.create(WonderfulService.class);
    }
}