package com.emindsoft.appstore.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.emindsoft.appstore.R;
import com.emindsoft.appstore.data.model.AppInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Author: Bob
 * Date: 2017/1/6.
 */

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.ViewHolder> {

    private List<AppInfo> list = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.app_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }

    public void updateRepositoriesList(List<AppInfo> infos) {
        this.list.clear();
        this.list.addAll(infos);
        notifyDataSetChanged();
    }

}
