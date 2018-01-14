package com.padcmyanmar.viewtesting.adapters;

import android.content.Context;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.viewtesting.R;
import com.padcmyanmar.viewtesting.data.vo.NewsVO;
import com.padcmyanmar.viewtesting.viewitems.ImageInNewsDetailsViewItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ICE on 10-12-2017.
 */

public class ImagesInNewsDetailsAdapter extends PagerAdapter {

    private List<NewsVO> mImages;

    public ImagesInNewsDetailsAdapter() {
        mImages = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mImages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

//        if(object instanceof  View) return  true;
//        else return false;
//        return(object instanceof View);
        return (view == (View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Context context = container.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ImageInNewsDetailsViewItem view = (ImageInNewsDetailsViewItem) layoutInflater.inflate(R.layout.item_news_details_images, container, false);
        view.setData(mImages.get(position).getImages());
        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View) object);


    }

    public void setImage(List<NewsVO> image)
    {
        mImages=image;
        notifyDataSetChanged();
    }


}