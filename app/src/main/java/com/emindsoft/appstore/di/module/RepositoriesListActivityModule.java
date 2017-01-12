package com.emindsoft.appstore.di.module;

import android.app.Application;
import android.support.v7.widget.LinearLayoutManager;

import com.emindsoft.appstore.contract.RepositoriesListContract;
import com.emindsoft.appstore.data.api.RepositoriesManager;
import com.emindsoft.appstore.data.model.Repository;
import com.emindsoft.appstore.di.scope.ActivityScope;
import com.emindsoft.appstore.presenter.RepositoriesListActivityPresenter;
import com.emindsoft.appstore.ui.adapter.RepositoriesListAdapter;
import com.emindsoft.appstore.ui.adapter.viewholder.RepositoriesListViewHolderFactory;
import com.emindsoft.appstore.ui.adapter.viewholder.RepositoryViewHolderBigFactory;
import com.emindsoft.appstore.ui.adapter.viewholder.RepositoryViewHolderFeaturedFactory;
import com.emindsoft.appstore.ui.adapter.viewholder.RepositoryViewHolderNormalFactory;

import java.util.Map;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;

/**
 * Created by Bob.
 */
@Module
public class RepositoriesListActivityModule {
    private RepositoriesListContract.View view;

    public RepositoriesListActivityModule(RepositoriesListContract.View view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    RepositoriesListContract.View provideRepositoriesListActivity() {
        return view;
    }

    @Provides
    @ActivityScope
    RepositoriesListActivityPresenter provideRepositoriesListActivityPresenter(RepositoriesManager repositoriesManager) {
        return new RepositoriesListActivityPresenter(view, repositoriesManager);
    }

    @Provides
    @ActivityScope
    RepositoriesListAdapter provideRepositoriesListAdapter(RepositoriesListContract.View view,
                                                           Map<Integer, RepositoriesListViewHolderFactory> viewHolderFactories) {
        return new RepositoriesListAdapter(view, viewHolderFactories);
    }

    @Provides
    @ActivityScope
    LinearLayoutManager provideLinearLayoutManager(Application application) {
        return new LinearLayoutManager(application);
    }

    @Provides
    @IntoMap
    @IntKey(Repository.TYPE_NORMAL)
    RepositoriesListViewHolderFactory provideViewHolderNormal() {
        return new RepositoryViewHolderNormalFactory();
    }

    @Provides
    @IntoMap
    @IntKey(Repository.TYPE_BIG)
    RepositoriesListViewHolderFactory provideViewHolderBig() {
        return new RepositoryViewHolderBigFactory();
    }

    @Provides
    @IntoMap
    @IntKey(Repository.TYPE_FEATURED)
    RepositoriesListViewHolderFactory provideViewHolderFeatured() {
        return new RepositoryViewHolderFeaturedFactory();
    }
}