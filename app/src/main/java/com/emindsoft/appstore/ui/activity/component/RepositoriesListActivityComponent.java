package com.emindsoft.appstore.ui.activity.component;

import dagger.Subcomponent;
import com.emindsoft.appstore.ui.activity.ActivityScope;
import com.emindsoft.appstore.ui.activity.RepositoriesListActivity;
import com.emindsoft.appstore.ui.activity.module.RepositoriesListActivityModule;
import com.emindsoft.appstore.ui.activity.presenter.RepositoriesListActivityPresenter;

/**
 * Created by Bob.
 */
@ActivityScope
@Subcomponent(
        modules = RepositoriesListActivityModule.class
)
public interface RepositoriesListActivityComponent {

    RepositoriesListActivity inject(RepositoriesListActivity repositoriesListActivity);

}