package com.padcmyanmar.viewtesting.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.padcmyanmar.viewtesting.MMNewsApp;
import com.padcmyanmar.viewtesting.R;
import com.padcmyanmar.viewtesting.adapters.NewsAdapter;
import com.padcmyanmar.viewtesting.data.models.NewsModel;
import com.padcmyanmar.viewtesting.data.vo.NewsVO;
import com.padcmyanmar.viewtesting.delegates.NewsActionDelegate;
import com.padcmyanmar.viewtesting.events.LoadedNewsEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsActivity extends AppCompatActivity implements NewsActionDelegate {


    @BindView(R.id.rv_news)
    RecyclerView recyclerView;

    private NewsAdapter mNewsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view);
        ButterKnife.bind(this, this);

        mNewsAdapter = new NewsAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);

        //   GridLayoutManager gridLayoutManager= new GridLayoutManager(getApplicationContext(),2)


        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mNewsAdapter);

        NewsModel.getObjInstance().loadNews();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void onTapNewsItem(NewsVO tappedNews) {

        Intent intent = new Intent(getApplicationContext(), NewsDetailsActivity.class);
        intent.putExtra("news_id",tappedNews.getNewsId());
        startActivity(intent);


    }

    @Override
    public void onTapCommentButton() {


    }

    @Override
    public void onTapSentToButton() {


    }

    @Override
    public void onTapFavouriteButton() {


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNewsLoaded(LoadedNewsEvent event) {
        Log.d(MMNewsApp.Log_TAG, "onNewsLoaded :" + event.getNewsList().size());
        mNewsAdapter.setNews(event.getNewsList());
    }


}
