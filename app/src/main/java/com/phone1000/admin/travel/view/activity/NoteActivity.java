package com.phone1000.admin.travel.view.activity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.phone1000.admin.travel.HomeHead2Activity;
import com.phone1000.admin.travel.R;
import com.phone1000.admin.travel.adapter.NoteAdapter;
import com.phone1000.admin.travel.bean.ItemDataInfo;
import com.phone1000.admin.travel.bean.ItemHeadDataInfo;
import com.phone1000.admin.travel.bean.NoteDataInfo;
import com.phone1000.admin.travel.presenter.HotListPresenter;
import com.phone1000.admin.travel.presenter.IAllPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NoteActivity extends BaseActivity{

    @BindView(R.id.note_list)ListView note_list;
    @BindView(R.id.country_list_title)TextView title;
    @BindView(R.id.back)ImageView back;
    @BindView(R.id.load)ImageView load;
    @BindView(R.id.load_rl)RelativeLayout rl;

    private AnimationDrawable drawable = null;
    private String id = null;
    private int page = 0;
    private boolean flag = false;
    private IAllPresenter iHotListPresenter = new HotListPresenter(this);
    private List<NoteDataInfo.ResultBean> list = new ArrayList<>();
    private NoteAdapter adapter = null;
    private Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        ButterKnife.bind(this);
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

        note_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                intent = new Intent(NoteActivity.this, HomeHead2Activity.class);
                intent.putExtra("link",list.get(i).getDetailUrl());
                intent.putExtra("name","游记详情");
                startActivity(intent);
            }
        });
        note_list.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if(flag){
                    flag = false;
                    setData();
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                if(i + i1 == i2){
                    flag = true;
                }
            }
        });
    }

    private void setData() {
        iHotListPresenter.getNoteId(id,""+page++);
    }

    private void initView() {
        title.setText(getIntent().getStringExtra("name"));
        id = getIntent().getStringExtra("id");
        adapter = new NoteAdapter(this,list);
        note_list.setAdapter(adapter);
        drawable = (AnimationDrawable) load.getBackground();
        drawable.start();
    }

    @Override
    public void getData(List<ItemDataInfo.ResultBean> result) {

    }

    @Override
    public void getHeadData(ItemHeadDataInfo.ResultBean result) {

    }

    @Override
    public void getNoteData(List<NoteDataInfo.ResultBean> result) {
        if(result!=null){
            rl.setVisibility(View.GONE);
        list.addAll(result);
        adapter.notifyDataSetChanged();}
    }
}
