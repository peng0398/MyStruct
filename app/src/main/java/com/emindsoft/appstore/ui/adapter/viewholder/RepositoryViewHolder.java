package com.emindsoft.appstore.ui.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.emindsoft.appstore.data.model.Repository;

/**
 * Created by Bob.
 */

public abstract class RepositoryViewHolder extends RecyclerView.ViewHolder {
    public RepositoryViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(Repository repository);
}
