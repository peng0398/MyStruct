package com.emindsoft.appstore.data.api;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Author: Bob
 * Date: 2017/2/8.
 */
public interface ApiService {
    @GET("account/regist")
    Observable<ResponseBody> regist(@Query("username") String username,
                                    @Query("password") String password,
                                    @Query("confirmPass") String confirmPass);
}
