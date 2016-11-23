package com.phone1000.admin.travel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.phone1000.admin.travel.R;
import com.phone1000.admin.travel.bean.ViewSpotDataInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/11/23.
 */

public class ViewSpotAdapter extends BaseAdapter{

    private Context context = null;
    private List<ViewSpotDataInfo.ResultBean> list = null;

    public ViewSpotAdapter(Context context, List<ViewSpotDataInfo.ResultBean> list) {
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
    public View getView(int i, View view, ViewGroup viewGroup){
        View v = null;
        ViewHolder holder = null;

        if(view == null){
            v = LayoutInflater.from(context).inflate(R.layout.viewspot_list_item,viewGroup,false);
            holder = new ViewHolder(v);
            v.setTag(holder);
        }else{
            v = view;
            holder = (ViewHolder) v.getTag();
        }

        holder.view_name.setText(list.get(i).getZhName());
        holder.view_level.setRating((float) list.get(i).getRating()*5);
        if("".equals(list.get(i).getTimeCostDesc())){
            holder.view_time.setText(list.get(i).getTimeCostDesc());
        }else{
            holder.view_time.setText("建议游玩"+list.get(i).getTimeCostDesc());
        }
        if(list.get(i).getImages().size()!=0){
        Glide.with(context)
                .load(list.get(i).getImages().get(0).getUrl())
                .placeholder(R.mipmap.shadow_top)//占位图片
                .error(R.mipmap.icon_error)//错误图片
                .crossFade()//淡入淡出效果
                .into(holder.view_item_iv);
        }else{
            holder.view_item_iv.setImageResource(R.mipmap.shadow_top);
        }

        return v;
    }
    class ViewHolder{
        @BindView(R.id.view_item_iv)ImageView view_item_iv;
        @BindView(R.id.view_name)TextView view_name;
        @BindView(R.id.view_level)RatingBar view_level;
        @BindView(R.id.view_time)TextView view_time;

        public ViewHolder(View v){
            ButterKnife.bind(this,v);
        }
    }
}
