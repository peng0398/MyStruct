package com.emindsoft.appstore.contract;

import com.emindsoft.appstore.base.BasePresenter;
import com.emindsoft.appstore.base.BaseView;
import com.emindsoft.appstore.data.model.Repository;
import com.google.common.collect.ImmutableList;

/**
 * Author: Bob
 * Date: 2017/1/6.
 */

public class RepositoriesListContract {

    public interface View extends BaseView<Presenter> {
        void showLoading(boolean flag);
        void setRepositories(ImmutableList<Repository> repositories);
        void onRepositoryClick(Repository repository);
    }

    public interface Presenter extends BasePresenter {
    }
}
