package com.phone1000.admin.travel.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.phone1000.admin.travel.bean.HomeRecyclDataInfo;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

/**
 * Created by admin on 2016/11/11.
 */

public class HomeViewPagerAdapter extends PagerAdapter {

    private List<HomeRecyclDataInfo.ResultBean.ColumnsBean> list2 = null;
    private Context context = null;
    private ImageOptions options;

    public HomeViewPagerAdapter(List<HomeRecyclDataInfo.ResultBean.ColumnsBean> list2, Context context) {
        this.list2 = list2;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list2 == null ? 0 : list2.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        options = new ImageOptions.Builder().build();
        String url=list2.get(position).getImages().get(0).getUrl();
     x.image().bind(imageView,url,options);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
