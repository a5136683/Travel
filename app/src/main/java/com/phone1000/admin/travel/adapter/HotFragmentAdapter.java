package com.phone1000.admin.travel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.phone1000.admin.travel.R;
import com.phone1000.admin.travel.bean.HotDataInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/11/18.
 */

public class HotFragmentAdapter extends BaseAdapter {

    private Context context = null;
    private List<HotDataInfo.ResultBean> list = null;

    public HotFragmentAdapter(Context context, List<HotDataInfo.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = null;
        ViewHolder holder = null;
        if(view ==null){
            v = LayoutInflater.from(context).inflate(R.layout.hot_fragment_item,viewGroup,false);
            holder = new ViewHolder(v);
            v.setTag(holder);
        }else{
            v = view;
            holder = (ViewHolder) v.getTag();
        }
        holder.num.setText(list.get(i).getCommoditiesCnt()+"");
        holder.country_english_name.setText(list.get(i).getEnName());
        holder.country_name.setText(list.get(i).getZhName());
        Glide.with(context)
                .load(list.get(i).getImages().get(0).getUrl())
                .placeholder(R.mipmap.shadow_top)//占位图片
                .error(R.mipmap.icon_error)//错误图片
                .crossFade()//淡入淡出效果
                .into(holder.back_image);
//        Glide.with(context).load(list.get(i).getImages().get(i).getUrl()).into(holder.back_image);
        return v;
    }
    class ViewHolder{
        @BindView(R.id.country_name)TextView country_name;
        @BindView(R.id.country_english_name)TextView country_english_name;
        @BindView(R.id.num) TextView num;
        @BindView(R.id.back_image)ImageView back_image;
        public ViewHolder(View view){
            ButterKnife.bind(this,view);
        }
    }
}
