package com.padcmyanmar.viewtesting.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ICE on 17-12-2017.
 */

public class NewsVO {

    @SerializedName("news-id")
    private String newsId;
    private String brief;
    private String details;
    private List<String> images;

    @SerializedName("posted-date")
    private String postedDate;

    private PublicationVO publication;

    @SerializedName("favorite-id")
    private List<FavoritesVO> favourites;
    private List<CommentVO> comments;
    @SerializedName("sent-tos")
    private List<SentTosVO> sentTos;


    public List<String> getImages() {
        return images;
    }

    public List<FavoritesVO> getFavourites() {
        return favourites;
    }

    public List<CommentVO> getComments() {
        return comments;
    }

    public List<SentTosVO> getSentTos() {
        return sentTos;
    }

    public String getNewsId() {
        return newsId;
    }

    public String getBrief() {
        return brief;
    }

    public String getDetails() {
        return details;
    }



    public String getPostedDate() {
        return postedDate;
    }

    public PublicationVO getPublication() {
        return publication;
    }

}
