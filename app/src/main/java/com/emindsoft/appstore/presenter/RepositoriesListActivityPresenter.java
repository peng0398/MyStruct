package com.emindsoft.appstore.presenter;

import com.emindsoft.appstore.contract.RepositoriesListContract;
import com.emindsoft.appstore.data.api.RepositoriesManager;
import com.emindsoft.appstore.data.model.Repository;
import com.emindsoft.appstore.utils.SimpleObserver;
import com.google.common.collect.ImmutableList;

/**
 * Created by Bob.
 */

public class RepositoriesListActivityPresenter implements RepositoriesListContract.Presenter{
    private RepositoriesListContract.View view;
    private RepositoriesManager repositoriesManager;

    public RepositoriesListActivityPresenter(RepositoriesListContract.View view,
                                             RepositoriesManager repositoriesManager) {
        this.view = view;
        this.repositoriesManager = repositoriesManager;
    }

    public void loadRepositories() {
        view.showLoading(true);
        repositoriesManager.getUsersRepositories().subscribe(new SimpleObserver<ImmutableList<Repository>>() {
            @Override
            public void onNext(ImmutableList<Repository> repositories) {
                view.showLoading(false);
                view.setRepositories(repositories);
            }

            @Override
            public void onError(Throwable e) {
                view.showLoading(false);
            }
        });
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
