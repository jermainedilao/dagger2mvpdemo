package com.jermaine.dagger2.view.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jermaine.dagger2.R;
import com.jermaine.dagger2.api.response.ApiResponse;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ReposViewHolder> {

    private List<ApiResponse> mRepos;

    public ReposAdapter(List<ApiResponse> repos) {
        mRepos = repos;
    }

    @Override
    public ReposViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ReposViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReposViewHolder holder, int position) {
        ApiResponse item = mRepos.get(position);

        holder.id.setText(item.getId());
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return mRepos.size();
    }

    public void updateData(List<ApiResponse> repos) {
        mRepos = repos;
        notifyDataSetChanged();
    }

    class ReposViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.item_id) TextView id;
        @Bind(R.id.item_name) TextView name;
        @Bind(R.id.item_description) TextView description;

        public ReposViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
