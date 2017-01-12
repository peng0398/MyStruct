package com.emindsoft.appstore.di.module;

import dagger.Module;
import dagger.Provides;
import com.emindsoft.appstore.data.model.User;
import com.emindsoft.appstore.di.scope.ActivityScope;
import com.emindsoft.appstore.ui.activity.RepositoryDetailsActivity;
import com.emindsoft.appstore.presenter.RepositoryDetailsActivityPresenter;

/**
 * Created by Bob.
 */
@Module
public class RepositoryDetailsActivityModule {
    private RepositoryDetailsActivity repositoryDetailsActivity;

    public RepositoryDetailsActivityModule(RepositoryDetailsActivity repositoryDetailsActivity) {
        this.repositoryDetailsActivity = repositoryDetailsActivity;
    }

    @Provides
    @ActivityScope
    RepositoryDetailsActivity provideRepositoryDetailsActivity() {
        return repositoryDetailsActivity;
    }

    @Provides
    @ActivityScope
    RepositoryDetailsActivityPresenter provideRepositoryDetailsActivityPresenter(User user) {
        return new RepositoryDetailsActivityPresenter(repositoryDetailsActivity, user);
    }
}