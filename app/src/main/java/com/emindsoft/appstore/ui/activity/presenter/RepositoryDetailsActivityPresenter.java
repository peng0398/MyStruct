package com.emindsoft.appstore.ui.activity.presenter;

import com.emindsoft.appstore.data.model.User;
import com.emindsoft.appstore.ui.activity.RepositoryDetailsActivity;

/**
 * Created by Bob.
 */
public class RepositoryDetailsActivityPresenter {
    private RepositoryDetailsActivity repositoryDetailsActivity;
    private User user;

    public RepositoryDetailsActivityPresenter(RepositoryDetailsActivity repositoryDetailsActivity, User user) {
        this.repositoryDetailsActivity = repositoryDetailsActivity;
        this.user = user;
    }

    public void init() {
        repositoryDetailsActivity.setupUserName(user.login);
    }
}
