package com.emindsoft.appstore.di.component;

import dagger.Subcomponent;
import com.emindsoft.appstore.di.scope.ActivityScope;
import com.emindsoft.appstore.ui.activity.RepositoriesListActivity;
import com.emindsoft.appstore.di.module.RepositoriesListActivityModule;

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