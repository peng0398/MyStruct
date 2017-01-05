package com.emindsoft.appstore.data.api;

import com.google.common.collect.ImmutableList;

import java.util.List;

import com.emindsoft.appstore.data.api.response.RepositoryResponse;
import com.emindsoft.appstore.data.model.Repository;
import com.emindsoft.appstore.data.model.User;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Bob.
 */
public class RepositoriesManager {
    private User user;
    private GithubApiService githubApiService;

    public RepositoriesManager(User user, GithubApiService githubApiService) {
        this.user = user;
        this.githubApiService = githubApiService;
    }

    public Observable<ImmutableList<Repository>> getUsersRepositories() {
        return githubApiService.getUsersRepositories(user.login)
                .map(new Func1<List<RepositoryResponse>, ImmutableList<Repository>>() {
                    @Override
                    public ImmutableList<Repository> call(List<RepositoryResponse> repositoriesListResponse) {
                        final ImmutableList.Builder<Repository> listBuilder = ImmutableList.builder();
                        for (RepositoryResponse repositoryResponse : repositoriesListResponse) {
                            Repository repository = new Repository();
                            repository.id = repositoryResponse.id;
                            repository.name = repositoryResponse.name;
                            repository.url = repositoryResponse.url;
                            repository.stargazers_count = repositoryResponse.stargazers_count;
                            repository.forks_count = repositoryResponse.forks_count;
                            listBuilder.add(repository);
                        }
                        return listBuilder.build();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
