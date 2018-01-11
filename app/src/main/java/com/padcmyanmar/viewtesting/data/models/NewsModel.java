package com.padcmyanmar.viewtesting.data.models;

import com.padcmyanmar.viewtesting.network.HttpUrlConnectionDataAgent;
import com.padcmyanmar.viewtesting.network.NewsDataAgent;
import com.padcmyanmar.viewtesting.network.OkHttpDataAgent;
import com.padcmyanmar.viewtesting.network.reponses.RetrofitDataAgent;

/**
 * Created by ICE on 23-12-2017.
 */

public class NewsModel {

    private static NewsModel sObjInstance;
    private NewsDataAgent mDataAgent;

    private NewsModel() {

//        mDataAgent= HttpUrlConnectionDataAgent.getsObjectInstance();
//        mDataAgent= OkHttpDataAgent.getObjectInstance();
        mDataAgent= RetrofitDataAgent.getsObjectInstance();
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


}

