package com.gold.money.contract;

import com.gold.money.base.BasePresenter;
import com.gold.money.base.BaseView;

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
