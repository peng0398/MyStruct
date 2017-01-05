package com.emindsoft.appstore.data.api;

import dagger.Module;
import dagger.Provides;
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
