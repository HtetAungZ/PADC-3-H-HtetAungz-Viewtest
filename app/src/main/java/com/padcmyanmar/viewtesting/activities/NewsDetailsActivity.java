package com.padcmyanmar.viewtesting.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.viewtesting.R;
import com.padcmyanmar.viewtesting.adapters.ImagesInNewsDetailsAdapter;
import com.padcmyanmar.viewtesting.data.models.NewsModel;
import com.padcmyanmar.viewtesting.data.vo.NewsVO;
import com.padcmyanmar.viewtesting.events.LoadedNewsEvent;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ICE on 09-12-2017.
 */

public class NewsDetailsActivity extends AppCompatActivity {

    @BindView(R.id.tv_news_details)
    TextView tvNewsDetail;

    @BindView(R.id.tv_publication_title)
    TextView tvPublicationTitle;

    @BindView(R.id.tv_publication_date)
    TextView tvPublicationDate;

    @BindView(R.id.iv_publicationlogo2)
    ImageView ivPublicationLogo;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.vp_news_details_images)
    ViewPager newsdetailsimage;

    private ImagesInNewsDetailsAdapter mimagesInNewsDetailsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        ButterKnife.bind(this, this);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        mimagesInNewsDetailsAdapter = new ImagesInNewsDetailsAdapter();
        newsdetailsimage.setAdapter(mimagesInNewsDetailsAdapter);
        String newsId = getIntent().getStringExtra("news_id");
        NewsVO news = NewsModel.getObjInstance().getNewsById(newsId);
        bindData(news);

    }

    private void bindData(NewsVO news) {
        tvNewsDetail.setText(news.getDetails());
        tvPublicationDate.setText(news.getPostedDate());
        tvPublicationTitle.setText(news.getPublication().getTitle());

        Glide.with(ivPublicationLogo)
                .load(news.getPublication().getLogo())
                .into(ivPublicationLogo);


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onImageLoaded(LoadedNewsEvent event) {
        mimagesInNewsDetailsAdapter.setImage(event.getNewsList());
    }

}
