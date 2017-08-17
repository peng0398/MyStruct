package com.gold.money.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gold.money.ui.fragment.PagerChildFragment;
import com.gold.money.ui.fragment.WonderfulAPPFragment;

/**
 * Created by YoKeyword on 16/2/5.
 */
public class MainFragmentAdapter extends FragmentPagerAdapter {
    String[] mTitles = new String[]{"精品", "排行", "分类", "管理", "下载"};

    public MainFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return WonderfulAPPFragment.newInstance();
        } else {
            return PagerChildFragment.newInstance(position);
        }
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
