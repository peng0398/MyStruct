package com.emindsoft.appstore.data.api;

import java.util.List;

import com.emindsoft.appstore.data.api.response.RepositoryResponse;
import com.emindsoft.appstore.data.api.response.UserResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Bob.
 */
public interface GithubApiService {

    @GET("/users/{username}")
    Observable<UserResponse> getUser(@Path("username") String username);

    @GET("/users/{username}/repos")
    Observable<List<RepositoryResponse>> getUsersRepositories(@Path("username") String username);
}
