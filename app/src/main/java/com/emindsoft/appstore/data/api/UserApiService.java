package com.emindsoft.appstore.data.api;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Author: Bob
 * Date: 2017/1/12.
 * User regist,login,smscode ... api.
 */

public interface UserApiService {

    @FormUrlEncoded
    @POST("account/regist")
    Observable<ResponseBody> regist(@Field("username") String username,
                                    @Field("password") String password,
                                    @Field("confirmPass") String confirmPass);

}
