package com.emindsoft.appstore.contract;

import com.emindsoft.appstore.base.BasePresenter;
import com.emindsoft.appstore.base.BaseView;
import com.emindsoft.appstore.data.model.AppInfo;

import java.util.HashMap;
import java.util.List;

/**
 * Author: Bob
 * Date: 2017/1/6.
 */

public class WonderfulFragmentContract {
    public interface View extends BaseView<Presenter> {

        void displaySlider(HashMap<String, String> file_maps);

        void displayHotApps(List<AppInfo> list);

        void displayHotDownloads(List<AppInfo> list);
    }

    public interface Presenter extends BasePresenter {
        void loadSlider();

        void loadHotApps();

        void loadHotDownloads();
    }
}
