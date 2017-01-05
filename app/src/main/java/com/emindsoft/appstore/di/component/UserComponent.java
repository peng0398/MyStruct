package com.emindsoft.appstore.di.component;

import dagger.Subcomponent;
import com.emindsoft.appstore.data.api.UserModule;
import com.emindsoft.appstore.di.scope.UserScope;
import com.emindsoft.appstore.di.module.RepositoriesListActivityModule;
import com.emindsoft.appstore.di.module.RepositoryDetailsActivityModule;

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