package com.phone1000.admin.travel.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.phone1000.admin.travel.R;
import com.phone1000.admin.travel.bean.HomeListDataInfo;

import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/11/18.
 */
public class HomeListAdapter extends BaseAdapter{
   private List<HomeListDataInfo.ResultBean> list=null;
    private Context context=null;
    private HomeListDataInfo.ResultBean list0=null;
    private HomeListDataInfo.ResultBean list1=null;

    public HomeListAdapter(List<HomeListDataInfo.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
                return list.size();
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
    public int getItemViewType(int position) {
        if (position%2==0) {
            return 0;
        }
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

           View v=  LayoutInflater.from(context).inflate(R.layout.home_item2,null);
           MyListView lv = (MyListView) v.findViewById(R.id.MyListView);
           lv.setAdapter(new HomeListItemAdapter(list,i,context));

        return v;
    }

}
