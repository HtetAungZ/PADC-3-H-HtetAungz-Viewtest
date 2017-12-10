package com.padcmyanmar.viewtesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.padcmyanmar.viewtesting.adapters.NewsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewActivity extends AppCompatActivity {


    @BindView(R.id.rv_news)
    RecyclerView recyclerView;

    private NewsAdapter mNewsAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view);
        ButterKnife.bind(this,this);

        mNewsAdapter =new NewsAdapter();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,false);

     //   GridLayoutManager gridLayoutManager= new GridLayoutManager(getApplicationContext(),2)


        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mNewsAdapter);



    }
}
