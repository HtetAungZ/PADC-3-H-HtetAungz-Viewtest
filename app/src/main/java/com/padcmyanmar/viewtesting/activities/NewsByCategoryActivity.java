package com.padcmyanmar.viewtesting.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.padcmyanmar.viewtesting.R;
import com.padcmyanmar.viewtesting.adapters.NewsByCategoryAdapter;
import com.padcmyanmar.viewtesting.data.models.NewsModel;
import com.padcmyanmar.viewtesting.events.LoadedNewsEvent;
import com.padcmyanmar.viewtesting.fragments.InternationalNewsFragment;
import com.padcmyanmar.viewtesting.fragments.NewsByCategoryFragment;
import com.padcmyanmar.viewtesting.fragments.SportNewsFragment;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ICE on 07-01-2018.
 */

public class NewsByCategoryActivity extends AppCompatActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.vp_news_by_category)
    ViewPager vpNewsByCategory;

    @BindView(R.id.tb_news_by_category)
    TabLayout tbNewsByCategory;




    private NewsByCategoryAdapter mNewsByCategoryAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_by_category);
        ButterKnife.bind(this, this);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.title_news_by_category);
        }
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_24dp);//image button htae chin lo
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);// button paw chin lo
        mNewsByCategoryAdapter = new NewsByCategoryAdapter(getSupportFragmentManager());
        vpNewsByCategory.setAdapter(mNewsByCategoryAdapter);
        mNewsByCategoryAdapter.addTab("Local News", new NewsByCategoryFragment());
        mNewsByCategoryAdapter.addTab("International News", new InternationalNewsFragment());
        mNewsByCategoryAdapter.addTab("Sport News", new SportNewsFragment());
        tbNewsByCategory.setupWithViewPager(vpNewsByCategory);
        vpNewsByCategory.setOffscreenPageLimit(mNewsByCategoryAdapter.getCount());

    }


}
