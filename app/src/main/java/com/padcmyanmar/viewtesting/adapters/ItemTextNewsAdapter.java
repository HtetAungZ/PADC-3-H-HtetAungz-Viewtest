package com.padcmyanmar.viewtesting.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.viewtesting.R;
import com.padcmyanmar.viewtesting.viewholders.ItemNewsIntroViewHolder;
import com.padcmyanmar.viewtesting.viewholders.ItemTextNewsViewHolder;

/**
 * Created by ICE on 10-01-2018.
 */

public class ItemTextNewsAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View textNewsItemView = inflater.inflate(R.layout.item_text_news, parent, false);
        ItemTextNewsViewHolder itemTextNewsViewHolder = new ItemTextNewsViewHolder(textNewsItemView);
        return itemTextNewsViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
