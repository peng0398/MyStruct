package com.emindsoft.appstore.di.component;

import dagger.Subcomponent;
import com.emindsoft.appstore.di.scope.ActivityScope;
import com.emindsoft.appstore.ui.activity.RepositoryDetailsActivity;
import com.emindsoft.appstore.di.module.RepositoryDetailsActivityModule;

/**
 * Created by Bob.
 */
@ActivityScope
@Subcomponent(
        modules = RepositoryDetailsActivityModule.class
)
public interface RepositoryDetailsActivityComponent {

    RepositoryDetailsActivity inject(RepositoryDetailsActivity repositoryDetailsActivity);

}