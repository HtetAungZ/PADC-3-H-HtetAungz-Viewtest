package com.padcmyanmar.viewtesting.events;

import com.padcmyanmar.viewtesting.data.vo.NewsVO;

import java.util.List;

/**
 * Created by ICE on 24-12-2017.
 */

public class LoadedNewsEvent {

    private List<NewsVO> newsList;

    public LoadedNewsEvent(List<NewsVO> newsList) {
        this.newsList = newsList;
    }

    public List<NewsVO> getNewsList() {
        return newsList;
    }
}
