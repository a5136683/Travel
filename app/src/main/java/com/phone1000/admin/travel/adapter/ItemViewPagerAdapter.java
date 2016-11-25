package com.phone1000.admin.travel.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.phone1000.admin.travel.R;
import com.phone1000.admin.travel.bean.Item2DataInfo;

import java.util.List;

/**
 * Created by admin on 2016/11/24.
 */

public class ItemViewPagerAdapter extends PagerAdapter {

    private List<Item2DataInfo.ResultBean.ImagesBean> list = null;
    private Context context = null;

    public ItemViewPagerAdapter(List<Item2DataInfo.ResultBean.ImagesBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        Glide.with(context).load(list.get(position).getUrl())
        .placeholder(R.mipmap.shadow_top)
        .centerCrop()
        .into(imageView);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
