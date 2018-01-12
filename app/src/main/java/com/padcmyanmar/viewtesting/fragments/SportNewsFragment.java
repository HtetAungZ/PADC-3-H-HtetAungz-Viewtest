package com.padcmyanmar.viewtesting.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.viewtesting.R;
import com.padcmyanmar.viewtesting.adapters.ItemNewsIntroAdapter;
import com.padcmyanmar.viewtesting.adapters.ItemSubSportNewsAdapter;

import com.padcmyanmar.viewtesting.adapters.SportNewsAdapter;
import com.padcmyanmar.viewtesting.viewholders.ItemSubSportNewsViewHolder;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ICE on 07-01-2018.
 */

public class SportNewsFragment extends Fragment {

//    @BindView(R.id.rv_sub_sport_news)
//    RecyclerView rvSubSportNews;

    @BindView(R.id.rv_sport_news)
    RecyclerView rvSportNews;


//    private ItemSubSportNewsAdapter mitemSubSportNewsAdapter;
    private SportNewsAdapter msportNewsAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sport_news, container, false);
        ButterKnife.bind(this,view);

//        LinearLayoutManager subNewslinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true);
//        rvSubSportNews.setLayoutManager(subNewslinearLayoutManager);
//        mitemSubSportNewsAdapter = new ItemSubSportNewsAdapter();
//        rvSubSportNews.setAdapter(mitemSubSportNewsAdapter);

        LinearLayoutManager sportNewslinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true);
        rvSportNews.setLayoutManager(sportNewslinearLayoutManager);
        msportNewsAdapter = new SportNewsAdapter();
        rvSportNews.setAdapter(msportNewsAdapter);

        return view;
    }
}
