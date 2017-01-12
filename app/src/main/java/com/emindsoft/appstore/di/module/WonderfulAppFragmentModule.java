package com.emindsoft.appstore.di.module;

import android.app.Application;
import android.support.v7.widget.LinearLayoutManager;

import com.emindsoft.appstore.contract.WonderfulFragmentContract;
import com.emindsoft.appstore.data.api.WonderfulService;
import com.emindsoft.appstore.di.scope.ActivityScope;
import com.emindsoft.appstore.di.scope.FragmentScope;
import com.emindsoft.appstore.presenter.WonderfulFragmentPresenter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Bob.
 */
@Module
public class WonderfulAppFragmentModule {

    public WonderfulAppFragmentModule(WonderfulFragmentContract.View view) {
        this.view = view;
    }

    private WonderfulFragmentContract.View view;

    @FragmentScope
    @Provides
    public WonderfulService provideWonderfulService(Retrofit restAdapter) {
        return restAdapter.create(WonderfulService.class);
    }

    @FragmentScope
    @Provides
    public WonderfulFragmentContract.View providerWonderfulFragmentContractView(){
        return view;
    }

    @FragmentScope
    @Provides
    public WonderfulFragmentPresenter providerWonderfulFragmentPresenter(WonderfulFragmentContract.View view) {
        return new WonderfulFragmentPresenter(view);
    }

    @Provides
    @FragmentScope
    LinearLayoutManager provideLinearLayoutManager(Application application) {
        return new LinearLayoutManager(application);
    }

}