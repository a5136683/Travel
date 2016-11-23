package com.phone1000.admin.travel.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.phone1000.admin.travel.R;
import com.phone1000.admin.travel.bean.CountryDataInfo;
import com.phone1000.admin.travel.view.activity.HotListActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/11/22.
 */


public class CountryAdapter extends RecyclerView.Adapter<MyHolder> {

    private Context context = null;
    private List<CountryDataInfo.ResultBean> list = null;

    public CountryAdapter(Context context, List<CountryDataInfo.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.country_list_item, parent, false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, HotListActivity.class);
                intent.putExtra("id",list.get(position).getId());
                intent.putExtra("name",list.get(position).getZhName());
                context.startActivity(intent);
            }
        });
        holder.country_name.setText(list.get(position).getZhName());
        holder.country_english.setText(list.get(position).getEnName());
        Glide.with(context)
                .load(list.get(position).getImages().get(0).getUrl())
                .placeholder(R.mipmap.shadow_top)//占位图片
                .error(R.mipmap.icon_error)//错误图片
                .crossFade()//淡入淡出效果
                .into(holder.country_item_iv);
        holder.number.setText(list.get(position).getCommoditiesCnt() + "");
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }
}

class MyHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.country_item_name)
    TextView country_name;
    @BindView(R.id.country_item_english)
    TextView country_english;
    @BindView(R.id.number)
    TextView number;
    @BindView(R.id.country_item_iv)
    ImageView country_item_iv;

    public MyHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}

//public class CountryAdapter extends BaseAdapter {
//
//    private Context context = null;
//    private List<CountryDataInfo.ResultBean> list= null;
//
//    public CountryAdapter(Context context,List<CountryDataInfo.ResultBean> result) {
//        this.context = context;
//        this.list = result;
//    }
//
//    @Override
//    public int getCount() {
//        return list==null?0:list.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return list.get(i);
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return i;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        View v = null;
//        ViewHolder holder = null;
//        if(view == null){
//            v = LayoutInflater.from(context).inflate(R.layout.country_list_item,viewGroup,false);
//            holder = new ViewHolder(v);
//
//            v.setTag(holder);
//        }else{
//            v = view;
//            holder = (ViewHolder) v.getTag();
//        }
//
//            holder.country_name.setText(list.get(i).getZhName());
//            holder.country_english.setText(list.get(i).getEnName());
//            Glide.with(context)
//                    .load(list.get(i).getImages().get(0).getUrl())
//                    .placeholder(R.mipmap.shadow_top)//占位图片
//                    .error(R.mipmap.icon_error)//错误图片
//                    .crossFade()//淡入淡出效果
//                    .into(holder.country_item_iv);
//            holder.number.setText(list.get(i).getCommoditiesCnt() + "");
//
//        return v;
//    }
//    class ViewHolder{
//        @BindView(R.id.country_item_name) TextView country_name;
//        @BindView(R.id.country_item_english) TextView country_english;
//        @BindView(R.id.number) TextView number;
//        @BindView(R.id.country_item_iv) ImageView country_item_iv;
//
//        public ViewHolder(View view) {
//            ButterKnife.bind(this,view);
//        }
//    }
//}
