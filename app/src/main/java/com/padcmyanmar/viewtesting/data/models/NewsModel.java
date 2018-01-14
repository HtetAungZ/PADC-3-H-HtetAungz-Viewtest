package com.padcmyanmar.viewtesting.data.models;

import android.util.Log;

import com.padcmyanmar.viewtesting.MMNewsApp;
import com.padcmyanmar.viewtesting.data.vo.NewsVO;
import com.padcmyanmar.viewtesting.events.LoadedNewsEvent;
import com.padcmyanmar.viewtesting.network.HttpUrlConnectionDataAgent;
import com.padcmyanmar.viewtesting.network.NewsDataAgent;
import com.padcmyanmar.viewtesting.network.OkHttpDataAgent;
import com.padcmyanmar.viewtesting.network.reponses.RetrofitDataAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ICE on 23-12-2017.
 */

public class NewsModel {

    private static NewsModel sObjInstance;
    private NewsDataAgent mDataAgent;
    private Map<String, NewsVO> mNews;

    private NewsModel() {

//        mDataAgent= HttpUrlConnectionDataAgent.getsObjectInstance();
//        mDataAgent= OkHttpDataAgent.getObjectInstance();

        mDataAgent = RetrofitDataAgent.getsObjectInstance();
        mNews = new HashMap<>();

        EventBus.getDefault().register(this);

    }

    public static NewsModel getObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new NewsModel();
        }
        return sObjInstance;
    }

    /**
     * Load news from network api.
     */


    public void loadNews() {

        mDataAgent.loadNews();
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onNewsLoaded(LoadedNewsEvent event) {

        for (NewsVO news : event.getNewsList()) {
            mNews.put(news.getNewsId(), news);
        }


    }

    /**
     * Get News Object by id
     */

    public NewsVO getNewsById(String newsId) {
        return mNews.get(newsId);
    }


}

