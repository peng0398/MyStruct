package com.emindsoft.appstore.contract;

import com.emindsoft.appstore.base.BasePresenter;
import com.emindsoft.appstore.base.BaseView;

/**
 * Author: Bob
 * Date: 2017/1/13.
 */

public interface LoginActivityContract {
    interface View extends BaseView<Presenter> {

        void showResult(String result);
    }

    interface Presenter extends BasePresenter {

        void regist(String username, String pwd, String repwd);
    }
}
