package com.emindsoft.appstore.presenter;

import com.emindsoft.appstore.contract.WonderfulFragmentContract;
import com.emindsoft.appstore.data.model.AppInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

/**
 * Author: Bob
 * Date: 2017/1/6.
 */
// Presenter for  WonderfulFragment.
public class WonderfulFragmentPresenter implements WonderfulFragmentContract.Presenter{

    private WonderfulFragmentContract.View view;

    @Inject
    public WonderfulFragmentPresenter(WonderfulFragmentContract.View view) {
        this.view = view;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void loadSlider() {
        HashMap<String,String> file_maps = new HashMap<String, String>();
        file_maps.put("Hannibal","http://h.hiphotos.baidu.com/zhidao/pic/item/e824b899a9014c0869f80ddd0d7b02087af4f482.jpg");
        file_maps.put("Big Bang Theory","http://pic10.nipic.com/20101103/5063545_000227976000_2.jpg");
        file_maps.put("House of Cards","http://sc.jb51.net/uploads/allimg/150703/14-150F3102113Y7.jpg");
        file_maps.put("Game of Thrones", "http://pic50.nipic.com/file/20141014/8442159_182826708000_2.jpg");
        view.displaySlider(file_maps);
    }

    @Override
    public void loadHotApps() {
        List<AppInfo> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new AppInfo());
        }
        view.displayHotApps(list);
    }

    @Override
    public void loadHotDownloads() {
        List<AppInfo> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new AppInfo());
        }
        view.displayHotDownloads(list);
    }
}
