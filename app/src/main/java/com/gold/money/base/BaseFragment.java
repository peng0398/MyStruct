package com.gold.money.base;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.emindsoft.appstore.R;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by YoKeyword on 16/2/3.
 */
public class BaseFragment extends SupportFragment {
    private static final String TAG = "Fragmentation";

    public void initToolbarMenu(Toolbar toolbar) {
        toolbar.inflateMenu(R.menu.hierarchy);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_hierarchy:
                        _mActivity.showFragmentStackHierarchyView();
                        _mActivity.logFragmentStackHierarchy(TAG);
                        break;
                }
                return true;
            }
        });
    }
}
