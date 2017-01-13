package com.emindsoft.appstore.di.module;

import dagger.Module;
import dagger.Provides;

import com.emindsoft.appstore.data.api.GithubApiService;
import com.emindsoft.appstore.data.api.RepositoriesManager;
import com.emindsoft.appstore.di.scope.UserScope;
import com.emindsoft.appstore.data.model.User;

/**
 * Created by Bob.
 */
@Module
public class UserModule {

    private User user;

    public UserModule(User user) {
        this.user = user;
    }

    @Provides
    @UserScope
    User provideUser() {
        return user;
    }

    @Provides
    @UserScope
    RepositoriesManager provideRepositoriesManager(User user, GithubApiService githubApiService) {
        return new RepositoriesManager(user, githubApiService);
    }
}
