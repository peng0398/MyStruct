package com.gold.money.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.emindsoft.appstore.R;
import com.gold.money.StoreApplication;
import com.gold.money.base.BaseFragment;
import com.gold.money.contract.WonderfulFragmentContract;
import com.gold.money.data.model.AppInfo;
import com.gold.money.presenter.WonderfulFragmentPresenter;
import com.gold.money.ui.adapter.AppListAdapter;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Author: Bob
 * Date: 2017/1/5.
 */

public class WonderfulAPPFragment extends BaseFragment implements WonderfulFragmentContract.View {

    public static WonderfulAPPFragment newInstance() {
        return new WonderfulAPPFragment();
    }


    WonderfulFragmentPresenter presenter = new WonderfulFragmentPresenter(this);

    @BindView(R.id.sl_content)
    SliderLayout sl_content;

    @BindView(R.id.rv_hot_download)
    RecyclerView rv_hot_download;

    @BindView(R.id.rv_hot_app)
    RecyclerView rv_hot_app;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(StoreApplication.getAppContext(), R.layout.wonderful_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.loadSlider();

        //热门下载
        LinearLayoutManager hotDownloadLayout = new LinearLayoutManager(getActivity());
        hotDownloadLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_hot_download.setLayoutManager(hotDownloadLayout);
        rv_hot_download.setNestedScrollingEnabled(false);
        presenter.loadHotDownloads();

        //热门应用
        LinearLayoutManager hotAppLayout = new LinearLayoutManager(getActivity());
        hotAppLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_hot_app.setLayoutManager(hotAppLayout);
        rv_hot_app.setNestedScrollingEnabled(false);
        presenter.loadHotApps();

    }

    @Override
    public void setPresenter(WonderfulFragmentContract.Presenter presenter) {

    }

    @Override
    public void displaySlider(HashMap<String, String> file_maps) {
        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getContext());
            // initialize a SliderLayout
            textSliderView.image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            sl_content.addSlider(textSliderView);
        }
        sl_content.setPresetTransformer(SliderLayout.Transformer.Default);
        sl_content.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
//        sl_content.setCustomAnimation(new DescriptionAnimation());
        sl_content.setDuration(4000);
    }

    @Override
    public void displayHotApps(List<AppInfo> list) {
        AppListAdapter adapter = new AppListAdapter();
        adapter.updateRepositoriesList(list);
        rv_hot_app.setAdapter(adapter);
    }

    @Override
    public void displayHotDownloads(List<AppInfo> list) {
        AppListAdapter adapter = new AppListAdapter();
        adapter.updateRepositoriesList(list);
        rv_hot_download.setAdapter(adapter);
    }
}
