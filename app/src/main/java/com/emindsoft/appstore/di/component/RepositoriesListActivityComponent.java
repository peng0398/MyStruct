package com.emindsoft.appstore.di.component;

import com.emindsoft.appstore.di.module.RepositoriesListActivityModule;
import com.emindsoft.appstore.di.scope.ActivityScope;
import com.emindsoft.appstore.ui.activity.RepositoriesListActivity;

import dagger.Subcomponent;

/**
 * Created by Bob.
 */
@ActivityScope
@Subcomponent( modules = RepositoriesListActivityModule.class )
public interface RepositoriesListActivityComponent {

    void inject(RepositoriesListActivity repositoriesListActivity);

}