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
import com.padcmyanmar.viewtesting.adapters.ItemTextNewsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ICE on 07-01-2018.
 */

public class InternationalNewsFragment extends Fragment {


//    @BindView(R.id.rv_international_news)
//    RecyclerView rvInternationalNews;

    @BindView(R.id.rv_intro)
    RecyclerView rvNewsIntro;

    @BindView(R.id.rv_text_news)
    RecyclerView rvTextNews;


    private ItemNewsIntroAdapter mitemNewsIntroAdapter;
    private ItemTextNewsAdapter mitemTextNewsAdapter;
//    private ItemInternationalNewsAdapter mitemInternationalNewsAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_international_news, container, false);
        ButterKnife.bind(this, view);

//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//        rvInternationalNews.setLayoutManager(linearLayoutManager);
//        mitemInternationalNewsAdapter = new ItemInternationalNewsAdapter();
//        rvInternationalNews.setAdapter(mitemInternationalNewsAdapter);


        LinearLayoutManager newsintrolinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true);
        rvNewsIntro.setLayoutManager(newsintrolinearLayoutManager);
        mitemNewsIntroAdapter = new ItemNewsIntroAdapter();
        rvNewsIntro.setAdapter(mitemNewsIntroAdapter);

        LinearLayoutManager textnewslinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true);
        rvTextNews.setLayoutManager(textnewslinearLayoutManager);
        mitemTextNewsAdapter = new ItemTextNewsAdapter();
        rvTextNews.setAdapter(mitemTextNewsAdapter);


        return view;

    }
}
