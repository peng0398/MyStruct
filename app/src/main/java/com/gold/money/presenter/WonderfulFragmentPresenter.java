package com.gold.money.presenter;

import com.gold.money.contract.WonderfulFragmentContract;
import com.gold.money.data.model.AppInfo;

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
        file_maps.put("uu","http://img39.51tietu.net/pic/2017-011003/20170110030923zgwnujrdwlu107946.jpg");
        file_maps.put("ww","http://img39.51tietu.net/pic/2017-011003/20170110030923zgwnujrdwlu107946.jpg");
        file_maps.put("Big aa Theory","http://a.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=3e57409dab6eddc426b2bcff0ceb9acb/9c16fdfaaf51f3de842cd71c92eef01f3a29792f.jpg");
        file_maps.put("xx of Cards","http://img5q.duitang.com/uploads/item/201503/07/20150307203721_nnS2E.thumb.700_0.png");
        file_maps.put("qq of Thrones", "http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1408/27/c2/37948032_1409151438850_800x600.jpg");
        file_maps.put("hh of Thrones", "http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1408/27/c2/37948032_1409151438850_800x600.jpg");
        file_maps.put("Big cc Theory","http://a.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=3e57409dab6eddc426b2bcff0ceb9acb/9c16fdfaaf51f3de842cd71c92eef01f3a29792f.jpg");
        file_maps.put("rr of Cards","http://img5q.duitang.com/uploads/item/201503/07/20150307203721_nnS2E.thumb.700_0.png");
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
