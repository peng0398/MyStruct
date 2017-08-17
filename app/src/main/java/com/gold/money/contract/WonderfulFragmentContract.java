package com.gold.money.contract;

import com.gold.money.base.BasePresenter;
import com.gold.money.base.BaseView;
import com.gold.money.data.model.AppInfo;

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
