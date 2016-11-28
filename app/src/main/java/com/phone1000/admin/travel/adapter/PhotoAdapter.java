package com.phone1000.admin.travel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.phone1000.admin.travel.R;
import com.phone1000.admin.travel.bean.PhotoDataInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/11/28.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoHolder> {

    private List<PhotoDataInfo.ResultBean.AlbumBean> list=null;
    private Context context = null;
    private int size = 0;

    public PhotoAdapter(List<PhotoDataInfo.ResultBean.AlbumBean> list, Context context,int size) {
        this.list = list;
        this.context = context;
        this.size = size;
    }

    @Override
    public PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.photo_item,parent,false);
        v.setLayoutParams(new ViewGroup.LayoutParams(size/3,size/3));
        return new PhotoHolder(v);
    }

    @Override
    public void onBindViewHolder(PhotoHolder holder, int position) {
        Glide.with(context).load(list.get(position).getUrl()).centerCrop().placeholder(R.mipmap.shadow_top)
                .crossFade().into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }
}
class PhotoHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.iv)ImageView iv;

    public PhotoHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
