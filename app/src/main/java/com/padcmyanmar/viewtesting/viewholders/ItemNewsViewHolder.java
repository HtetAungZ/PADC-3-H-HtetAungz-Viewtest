package com.padcmyanmar.viewtesting.viewholders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.padcmyanmar.viewtesting.R;
import com.padcmyanmar.viewtesting.data.vo.*;
import com.padcmyanmar.viewtesting.data.vo.PublicationVO;
import com.padcmyanmar.viewtesting.delegates.NewsActionDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ICE on 03-12-2017.
 */

public class ItemNewsViewHolder extends RecyclerView.ViewHolder {

    private NewsActionDelegate mnewsActionDelegate;

    @BindView(R.id.tv_publication_title)
    TextView tvPublicationTitle;

    @BindView(R.id.tv_news_brief)
    TextView tvNewsBreif;

    @BindView(R.id.tv_posted_date)
    TextView tvPostedDate;

    @BindView(R.id.iv_publication_logo)
    ImageView ivPublicationLogo;

    @BindView(R.id.iv_news)
    ImageView ivNews;

    private NewsVO mNews;

    public ItemNewsViewHolder(View itemView, NewsActionDelegate newsActionDelegate) {
        super(itemView);

//        itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
        mnewsActionDelegate = newsActionDelegate;
        ButterKnife.bind(this, itemView);

    }

    @OnClick(R.id.cv_news_item_root)
    public void onNewsItemTap(View view) {

        //Toast.makeText(view.getContext(),"News Item Clicked",Toast.LENGTH_LONG).show();
        mnewsActionDelegate.onTapNewsItem(mNews);
    }

    public void setNews(NewsVO news) {
        mNews=news;
        tvPublicationTitle.setText(news.getPublication().getTitle());
        tvNewsBreif.setText(news.getBrief());
        tvPostedDate.setText(news.getPostedDate());

        Glide.with(ivPublicationLogo.getContext())
                .load(news.getPublication().getLogo())
                .into(ivPublicationLogo);


        if (news.getImages() != null) {
            ivNews.setVisibility(View.VISIBLE);
            Glide.with(ivNews.getContext())
                    .load(news.getImages().get(0))
                    .into(ivNews);
        } else {
            ivNews.setVisibility(View.GONE);
        }


    }

}
