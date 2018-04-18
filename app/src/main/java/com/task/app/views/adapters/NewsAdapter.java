package com.task.app.views.adapters;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.task.app.BR;
import com.task.app.R;
import com.task.app.databinding.RowBinding;
import com.task.app.models.Announcement;

import java.util.List;

/**
 * Created by Rafiq Ahmed on 4/18/2018.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.Holder> {

    private List<Announcement> announcements;
    private ItemClick itemClickListener;

    public NewsAdapter(List<Announcement> announcements, ItemClick itemClickListener) {
        this.announcements = announcements;
        this.itemClickListener = itemClickListener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        ViewDataBinding rowBinding = RowBinding.bind(v);
        return new Holder(rowBinding);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.bind(announcements.get(position));
    }

    @Override
    public int getItemCount() {
        if(announcements == null)
            return 0;
        else
            return announcements.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private ViewDataBinding viewDataBinding;

        public Holder(ViewDataBinding binding) {
            super(binding.getRoot());
            viewDataBinding = binding;

        }

        public void bind(final Announcement announcement){
            viewDataBinding.setVariable(BR.announcement, announcement);
            viewDataBinding.executePendingBindings();
            viewDataBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClickListener(announcement);
                }
            });
        }
    }

}
