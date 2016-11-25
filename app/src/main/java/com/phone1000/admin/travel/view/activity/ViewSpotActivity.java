package com.phone1000.admin.travel.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.phone1000.admin.travel.R;
import com.phone1000.admin.travel.adapter.ViewSpotAdapter;
import com.phone1000.admin.travel.bean.ViewSpotDataInfo;
import com.phone1000.admin.travel.presenter.IViewSpotPresenter;
import com.phone1000.admin.travel.presenter.ViewSpotPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewSpotActivity extends AppCompatActivity implements IViewSpot{

    private int page = 0;
    private Intent intent = null;
    private String id = null;
    private ViewSpotAdapter adapter = null;
    private boolean flag = false;
    private List<ViewSpotDataInfo.ResultBean> list = new ArrayList<>();
    private IViewSpotPresenter iViewSpotPresenter = new ViewSpotPresenter(this);
    @BindView(R.id.view_spot)ListView view_spot;
    @BindView(R.id.country_list_title)TextView title;
    @BindView(R.id.swipe)SwipeRefreshLayout swipe;
    @BindView(R.id.back)ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_spot);
        ButterKnife.bind(this);
        title.setText(getIntent().getStringExtra("name")+"景点");
        initView();
        setData();
        setListener();
    }

    private void setListener() {

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 0;
                list.clear();
                setData();
            }
        });
        view_spot.setOnScrollListener(new AbsListView.OnScrollListener() {
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
        view_spot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent = new Intent(ViewSpotActivity.this,ItemActivity.class);
                intent.putExtra("id",list.get(i).getId());
                intent.putExtra("name",list.get(i).getZhName());
                startActivity(intent);
            }
        });
    }

    private void setData() {
        iViewSpotPresenter.getId(id,""+ page++);
    }

    private void initView() {
        adapter = new ViewSpotAdapter(this,list);
        view_spot.setAdapter(adapter);
        id = getIntent().getStringExtra("id");
    }

    @Override
    public void getData(List<ViewSpotDataInfo.ResultBean> result) {
        list.addAll(result);
        adapter.notifyDataSetChanged();
        swipe.setRefreshing(false);
    }
}
