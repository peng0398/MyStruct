package com.emindsoft.appstore.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emindsoft.appstore.R;
import com.emindsoft.appstore.listener.OnItemClickListener;
import com.emindsoft.appstore.ui.adapter.PagerAdapter;
import com.emindsoft.appstore.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;


public class PagerChildFragment extends BaseFragment {
    private static final String ARG_FROM = "arg_from";

    private int mFrom;

    private RecyclerView mRecy;
    private PagerAdapter mAdapter;

    public static PagerChildFragment newInstance(int from) {
        Bundle args = new Bundle();
        args.putInt(ARG_FROM, from);

        PagerChildFragment fragment = new PagerChildFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            mFrom = args.getInt(ARG_FROM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager, container, false);

        initView(view);

        return view;
    }

    private void initView(View view) {
        mRecy = (RecyclerView) view.findViewById(R.id.recy);

        mAdapter = new PagerAdapter(_mActivity);
        final LinearLayoutManager manager = new LinearLayoutManager(_mActivity);
        mRecy.setLayoutManager(manager);
        mRecy.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                if (getParentFragment() instanceof DiscoverFragment) {
//                    ((DiscoverFragment) getParentFragment()).start(CycleFragment.newInstance(1));
                }
            }
        });

        mRecy.post(new Runnable() {
            @Override
            public void run() {
                // Init Datas
                List<String> items = new ArrayList<>();
                for (int i = 0; i < 20; i++) {
                    String item = "";
                    switch (mFrom) {
                        case 0:
                            item = "精品 " + i;
                            break;
                        case 1:
                            item = "排行 " + i;
                            break;
                        case 2:
                            item = "分类 " + i;
                            break;
                        case 3:
                            item = "管理 " + i;
                            break;
                        case 4:
                            item = "下载 " + i;
                            break;
                    }
                    items.add(item);
                }
                mAdapter.setDatas(items);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mRecy.setAdapter(null);
    }
}
