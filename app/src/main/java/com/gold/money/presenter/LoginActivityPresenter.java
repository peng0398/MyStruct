package com.gold.money.presenter;

import com.gold.money.StoreApplication;
import com.gold.money.contract.LoginActivityContract;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author: Bob
 * Date: 2017/1/13.
 */
public class LoginActivityPresenter implements LoginActivityContract.Presenter{

    private LoginActivityContract.View view;

    public LoginActivityPresenter(LoginActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void regist(String username, String pwd, String repwd) {

        Observable<ResponseBody> observable = StoreApplication.apiService.regist(username, pwd, repwd);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<ResponseBody>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showResult(e.toString());
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            view.showResult(string);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
