package com.emindsoft.appstore.ui.activity.module;

import android.support.v7.widget.LinearLayoutManager;

import java.util.Map;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;
import com.emindsoft.appstore.data.api.RepositoriesManager;
import com.emindsoft.appstore.data.model.Repository;
import com.emindsoft.appstore.ui.activity.ActivityScope;
import com.emindsoft.appstore.ui.activity.RepositoriesListActivity;
import com.emindsoft.appstore.ui.activity.presenter.RepositoriesListActivityPresenter;
import com.emindsoft.appstore.ui.adapter.RepositoriesListAdapter;
import com.emindsoft.appstore.ui.adapter.viewholder.RepositoriesListViewHolderFactory;
import com.emindsoft.appstore.ui.adapter.viewholder.RepositoryViewHolderBigFactory;
import com.emindsoft.appstore.ui.adapter.viewholder.RepositoryViewHolderFeaturedFactory;
import com.emindsoft.appstore.ui.adapter.viewholder.RepositoryViewHolderNormalFactory;

/**
 * Created by Bob.
 */
@Module
public class RepositoriesListActivityModule {
    private RepositoriesListActivity repositoriesListActivity;

    public RepositoriesListActivityModule(RepositoriesListActivity repositoriesListActivity) {
        this.repositoriesListActivity = repositoriesListActivity;
    }

    @Provides
    @ActivityScope
    RepositoriesListActivity provideRepositoriesListActivity() {
        return repositoriesListActivity;
    }

    @Provides
    @ActivityScope
    RepositoriesListActivityPresenter provideRepositoriesListActivityPresenter(RepositoriesManager repositoriesManager) {
        return new RepositoriesListActivityPresenter(repositoriesListActivity, repositoriesManager);
    }

    @Provides
    @ActivityScope
    RepositoriesListAdapter provideRepositoriesListAdapter(RepositoriesListActivity repositoriesListActivity,
                                                           Map<Integer, RepositoriesListViewHolderFactory> viewHolderFactories) {
        return new RepositoriesListAdapter(repositoriesListActivity, viewHolderFactories);
    }

    @Provides
    @ActivityScope
    LinearLayoutManager provideLinearLayoutManager(RepositoriesListActivity repositoriesListActivity) {
        return new LinearLayoutManager(repositoriesListActivity);
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