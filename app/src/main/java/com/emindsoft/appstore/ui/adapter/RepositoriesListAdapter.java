package com.emindsoft.appstore.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.emindsoft.appstore.contract.RepositoriesListContract;
import com.emindsoft.appstore.data.model.Repository;
import com.emindsoft.appstore.ui.adapter.viewholder.RepositoriesListViewHolderFactory;
import com.emindsoft.appstore.ui.adapter.viewholder.BaseViewHolder;

/**
 * Created by Bob.
 */
public class RepositoriesListAdapter extends RecyclerView.Adapter {

    private RepositoriesListContract.View view;
    private Map<Integer, RepositoriesListViewHolderFactory> viewHolderFactories;

    private final List<Repository> repositories = new ArrayList<>();

    public RepositoriesListAdapter(RepositoriesListContract.View view,
                                   Map<Integer, RepositoriesListViewHolderFactory> viewHolderFactories) {
        this.view = view;
        this.viewHolderFactories = viewHolderFactories;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final RecyclerView.ViewHolder viewHolder = viewHolderFactories.get(viewType).createViewHolder(parent);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRepositoryItemClicked(viewHolder.getAdapterPosition());
            }
        });
        return viewHolder;
    }

    private void onRepositoryItemClicked(int adapterPosition) {
        view.onRepositoryClick(repositories.get(adapterPosition));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((BaseViewHolder) holder).bind(repositories.get(position));
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    @Override
    public int getItemViewType(int position) {
        Repository repository = repositories.get(position);
        if (repository.stargazers_count > 500) {
            if (repository.forks_count > 100) {
                return Repository.TYPE_FEATURED;
            }
            return Repository.TYPE_BIG;
        }
        return Repository.TYPE_NORMAL;
    }

    public void updateRepositoriesList(List<Repository> repositories) {
        this.repositories.clear();
        this.repositories.addAll(repositories);
        notifyDataSetChanged();
    }
}
