package com.emindsoft.appstore.ui.activity.presenter;

import com.google.common.collect.ImmutableList;

import com.emindsoft.appstore.data.api.RepositoriesManager;
import com.emindsoft.appstore.data.model.Repository;
import com.emindsoft.appstore.ui.activity.RepositoriesListActivity;
import com.emindsoft.appstore.utils.SimpleObserver;

/**
 * Created by Bob.
 */
public class RepositoriesListActivityPresenter {
    private RepositoriesListActivity repositoriesListActivity;
    private RepositoriesManager repositoriesManager;

    public RepositoriesListActivityPresenter(RepositoriesListActivity repositoriesListActivity,
                                             RepositoriesManager repositoriesManager) {
        this.repositoriesListActivity = repositoriesListActivity;
        this.repositoriesManager = repositoriesManager;
    }

    public void loadRepositories() {
        repositoriesListActivity.showLoading(true);
        repositoriesManager.getUsersRepositories().subscribe(new SimpleObserver<ImmutableList<Repository>>() {
            @Override
            public void onNext(ImmutableList<Repository> repositories) {
                repositoriesListActivity.showLoading(false);
                repositoriesListActivity.setRepositories(repositories);
            }

            @Override
            public void onError(Throwable e) {
                repositoriesListActivity.showLoading(false);
            }
        });
    }

}
