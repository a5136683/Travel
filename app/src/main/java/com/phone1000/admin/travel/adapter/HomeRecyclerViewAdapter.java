package com.phone1000.admin.travel.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.phone1000.admin.travel.HomeHead2Activity;
import com.phone1000.admin.travel.R;
import com.phone1000.admin.travel.bean.HomeRecyclDataInfo;

import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */
public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.HomeRecyclerViewHolder> {
    private List<HomeRecyclDataInfo.ResultBean.ColumnsBean> list1 = null;
    private Context context = null;
    public HomeRecyclerViewAdapter(List<HomeRecyclDataInfo.ResultBean.ColumnsBean>  list1, Context context) {
        this.list1 = list1;
        this.context = context;
    }

    @Override
    public HomeRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.home_recycl_layout,parent,false);
        return  new HomeRecyclerViewHolder(v);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(HomeRecyclerViewHolder holder, final int position) {
            String url=list1.get(position).getImages().get(0).getUrl();
            x.image().bind(holder.home_rv_item_iv,url);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, HomeHead2Activity.class);
                intent.putExtra("link",list1.get(position).getLink());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list1==null?0:list1.size();
    }

    class HomeRecyclerViewHolder extends RecyclerView.ViewHolder {

        ImageView home_rv_item_iv;
        public HomeRecyclerViewHolder(View itemView) {
            super(itemView);
            home_rv_item_iv = (ImageView) itemView.findViewById(R.id.home_rv_item_iv);

        }

    }
}