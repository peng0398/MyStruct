package com.emindsoft.appstore.ui.activity.component;

import dagger.Subcomponent;
import com.emindsoft.appstore.ui.activity.ActivityScope;
import com.emindsoft.appstore.ui.activity.RepositoryDetailsActivity;
import com.emindsoft.appstore.ui.activity.module.RepositoryDetailsActivityModule;

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