package com.emindsoft.appstore.data;

import dagger.Subcomponent;
import com.emindsoft.appstore.data.api.UserModule;
import com.emindsoft.appstore.ui.activity.component.RepositoriesListActivityComponent;
import com.emindsoft.appstore.ui.activity.component.RepositoryDetailsActivityComponent;
import com.emindsoft.appstore.ui.activity.component.SplashActivityComponent;
import com.emindsoft.appstore.ui.activity.module.RepositoriesListActivityModule;
import com.emindsoft.appstore.ui.activity.module.RepositoryDetailsActivityModule;
import com.emindsoft.appstore.ui.activity.module.SplashActivityModule;

/**
 * Created by Bob.
 */
@UserScope
@Subcomponent(
        modules = {
                UserModule.class
        }
)
public interface UserComponent {

    RepositoriesListActivityComponent plus(RepositoriesListActivityModule module);

    RepositoryDetailsActivityComponent plus(RepositoryDetailsActivityModule module);
}