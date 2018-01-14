package com.padcmyanmar.viewtesting.delegates;

import com.padcmyanmar.viewtesting.data.vo.NewsVO;

/**
 * Created by ICE on 17-12-2017.
 */

public interface NewsActionDelegate {


    void onTapNewsItem(NewsVO tappedNews);

    void onTapCommentButton();

    void onTapSentToButton();

    void onTapFavouriteButton();




}
