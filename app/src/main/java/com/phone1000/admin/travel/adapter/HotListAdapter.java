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
import com.phone1000.admin.travel.bean.ItemDataInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/11/20.
 */

public class HotListAdapter extends BaseAdapter {

    private Context context = null;
    private List<ItemDataInfo.ResultBean> result = null;

    public HotListAdapter(Context context, List<ItemDataInfo.ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @Override
    public int getCount() {
        return result==null?0:result.size();
    }

    @Override
    public Object getItem(int i) {
        return result.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = null;
        ViewHolder holder = null;
        if(view == null){
            v = LayoutInflater.from(context).inflate(R.layout.hot_list_item,viewGroup,false);
            holder = new ViewHolder(v);

            v.setTag(holder);
        }else{
            v = view;
            holder = (ViewHolder) v.getTag();
        }

        holder.hot_item_title.setText(result.get(i).getTitle());
        holder.hot_item_name.setText(result.get(i).getSeller().getName());
        holder.hot_item_price.setText("￥"+result.get(i).getPrice()+"");
        holder.hot_item_marketPrice.setText("￥"+result.get(i).getMarketPrice()+"起");
        holder.sale.setText(result.get(i).getSalesVolume()+"已售");
        holder.level.setRating(result.get(i).getRating()*5);
        if(result.get(i).getCover()!=null)
        Glide.with(context).load(result.get(i).getCover().getUrl())
                .placeholder(R.mipmap.shadow_top)//占位图片
                .error(R.mipmap.icon_error)//错误图片
                .crossFade()//淡入淡出效果
                .into(holder.hot_item_iv);
        return v;
    }
    class ViewHolder{
        @BindView(R.id.hot_item_iv) ImageView hot_item_iv;
        @BindView(R.id.hot_item_title) TextView hot_item_title;
        @BindView(R.id.hot_item_name) TextView hot_item_name;
        @BindView(R.id.level) RatingBar level;
        @BindView(R.id.sale) TextView sale;
        @BindView(R.id.hot_item_price) TextView hot_item_price;
        @BindView(R.id.hot_item_marketPrice) TextView hot_item_marketPrice;
        public ViewHolder(View v){
            ButterKnife.bind(this,v);
        }
    }
}
