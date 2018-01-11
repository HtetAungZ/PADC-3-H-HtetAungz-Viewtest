package com.padcmyanmar.viewtesting.network.reponses;

import com.padcmyanmar.viewtesting.data.vo.NewsVO;

import java.util.List;

/**
 * Created by ICE on 24-12-2017.
 */

public class GetNewsResponse {

    private int code;
    private String message;
    private String apiVersion;
    private String page;
    private  List<NewsVO> mmNews;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<NewsVO> getMmNews() {
        return mmNews;
    }
}
