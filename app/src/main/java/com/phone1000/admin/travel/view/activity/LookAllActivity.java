package com.phone1000.admin.travel.view.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import com.phone1000.admin.travel.R;
import com.phone1000.admin.travel.adapter.HotListAdapter;
import com.phone1000.admin.travel.bean.ItemDataInfo;
import com.phone1000.admin.travel.bean.ItemHeadDataInfo;
import com.phone1000.admin.travel.presenter.HotListPresenter;
import com.phone1000.admin.travel.presenter.IHotListPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LookAllActivity extends AppCompatActivity implements IHotList{

    @BindView(R.id.country_list_title)TextView country_list_title;
    @BindView(R.id.look_list)ListView look_list;
    @BindView(R.id.swipe)SwipeRefreshLayout swipe;

    List<ItemDataInfo.ResultBean> list = new ArrayList<>();
    private HotListAdapter adapter = null;
    private String id = null;
    private int start = 0 ;
    private boolean flag = false;
    private IHotListPresenter iHotListPresenter = new HotListPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_all);
        ButterKnife.bind(this);
        initView();
        setData();
        setListener();
    }

    private void setListener() {
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list.clear();
                start=0;
                setData();
            }
        });

        look_list.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if(flag){
                    flag = false;
                    setData();
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                if(i+i1==i2){
                    flag = true;
                }
            }
        });
    }

    private void setData() {
        iHotListPresenter.getAllId(id,""+start);
        start+=15;
    }

    private void initView() {
        country_list_title.setText(getIntent().getStringExtra("name")+"玩乐");
        id = getIntent().getStringExtra("id");
        adapter = new HotListAdapter(this,list);
        look_list.setAdapter(adapter);
    }

    @Override
    public void getData(List<ItemDataInfo.ResultBean> result) {
        list.addAll(result);
        adapter.notifyDataSetChanged();
        swipe.setRefreshing(false);
    }

    @Override
    public void getHeadData(ItemHeadDataInfo.ResultBean result) {

    }
}
