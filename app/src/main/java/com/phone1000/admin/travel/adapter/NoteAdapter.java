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
import com.phone1000.admin.travel.bean.NoteDataInfo;
import com.phone1000.admin.travel.utils.CircleTransform;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/11/24.
 */

public class NoteAdapter extends BaseAdapter {

    private Context context = null;
    private List<NoteDataInfo.ResultBean> list = null;
    private SimpleDateFormat df = null;

    public NoteAdapter(Context context, List<NoteDataInfo.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
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
        if (view == null) {
            v = LayoutInflater.from(context).inflate(R.layout.note_list_item, viewGroup, false);
            holder = new ViewHolder(v);
            v.setTag(holder);
        } else {
            v = view;
            holder = (ViewHolder) v.getTag();
        }
        holder.title.setText(list.get(i).getTitle());
        holder.user_name.setText(list.get(i).getAuthorName());
        df = new SimpleDateFormat("yyyy-MM-dd");
        holder.time.setText(df.format(new Date(list.get(i).getPublishTime())));
        holder.desc.setText(list.get(i).getSummary());
        if (list.get(i).getAuthorAvatar() != null) {
            Glide.with(context).load(list.get(i).getAuthorAvatar())
                    .centerCrop().transform(new CircleTransform(context))
                    .placeholder(R.mipmap.ic_home_more_avatar_unknown_corner)
                    .error(R.mipmap.ic_home_more_avatar_unknown_corner)
                    .crossFade()
                    .into(holder.user);
        }
        return v;
    }

    class ViewHolder {

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.user_name)
        TextView user_name;
        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.desc)
        TextView desc;
        @BindView(R.id.user)
        ImageView user;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
