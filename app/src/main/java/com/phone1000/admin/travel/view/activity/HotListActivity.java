package com.phone1000.admin.travel.view.activity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.phone1000.admin.travel.HomeHead2Activity;
import com.phone1000.admin.travel.R;
import com.phone1000.admin.travel.adapter.HotListAdapter;
import com.phone1000.admin.travel.bean.ItemDataInfo;
import com.phone1000.admin.travel.bean.ItemHeadDataInfo;
import com.phone1000.admin.travel.bean.NoteDataInfo;
import com.phone1000.admin.travel.presenter.HotListPresenter;
import com.phone1000.admin.travel.presenter.IHotListPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HotListActivity extends AppCompatActivity implements IHotList,View.OnClickListener{
    String url = "http://api.lvxingpai.com/app/marketplace/commodities?count=3&locality=546f2da8b8ce0440eddb28e0&start=1";
    private IHotListPresenter iHotListPresenter = new HotListPresenter(this);
    private AnimationDrawable drawable = null;
    private Intent intent = null;
    private ItemHeadDataInfo.ResultBean itemInfo = null;
    private View v = null;
    private View list_foot = null;
    private ImageView foot_iv = null;
    private List<ItemDataInfo.ResultBean> list = new ArrayList<>();
    @BindView(R.id.hot_list)ListView hot_list;
    @BindView(R.id.load)ImageView load;
    @BindView(R.id.country_list_title)TextView hot_list_title;
    @BindView(R.id.foot)TextView foot;
    @BindView(R.id.back)ImageView back;
    private ImageView head_image;
    private TextView country_name,country_english_name,commodity_num,picture_list;
    private LinearLayout head_info,head_notice,traffic,head_viewSpot,head_plan,head_note,head_food,head_shopping;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_list);
        ButterKnife.bind(this);
        initView();
        setListener();
    }

    private void setListener() {
        head_plan.setOnClickListener(this);
        head_shopping.setOnClickListener(this);
        head_viewSpot.setOnClickListener(this);
        head_note.setOnClickListener(this);
        head_food.setOnClickListener(this);
        head_info.setOnClickListener(this);
        head_notice.setOnClickListener(this);
        traffic.setOnClickListener(this);
        foot.setOnClickListener(this);
        back.setOnClickListener(this);
        foot_iv.setOnClickListener(this);
//        hot_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                intent = new Intent(HotListActivity.this,ItemActivity.class);
//                intent.putExtra("id",list.get(i).getId());
//                intent.putExtra("name",list.get(i).get)
//            }
//        });
    }

    private void initView() {
        v = RelativeLayout.inflate(this,R.layout.list_head,null);
        head_image = (ImageView) v.findViewById(R.id.head_image);
        country_english_name = (TextView) v.findViewById(R.id.country_english_name);
        country_name = (TextView) v.findViewById(R.id.country_name);
        commodity_num = (TextView) v.findViewById(R.id.commodity_num);
        head_info = (LinearLayout) v.findViewById(R.id.head_info);
        head_notice = (LinearLayout) v.findViewById(R.id.head_notice);
        head_food = (LinearLayout) v.findViewById(R.id.head_food);
        head_note = (LinearLayout) v.findViewById(R.id.head_note);
        head_plan = (LinearLayout) v.findViewById(R.id.head_plan);
        head_viewSpot = (LinearLayout) v.findViewById(R.id.head_viewSpot);
        head_shopping = (LinearLayout) v.findViewById(R.id.head_shopping);
        traffic = (LinearLayout) v.findViewById(R.id.traffic);
        picture_list = (TextView) v.findViewById(R.id.picture_list);
        list_foot = RelativeLayout.inflate(this,R.layout.hot_list_foot_iv,null);
        foot_iv = (ImageView) list_foot.findViewById(R.id.foot_iv);

        drawable = (AnimationDrawable) load.getBackground();
        drawable.start();
        String id = getIntent().getStringExtra("id");
        String name = getIntent().getStringExtra("name");
        hot_list_title.setText(name);
        iHotListPresenter.getId(id);
    }

    @Override
    public void getData(List<ItemDataInfo.ResultBean> result) {//获取到数据
        hot_list.addHeaderView(v);
        list.addAll(result);
        if(list.size()!=0){
        hot_list.setAdapter(new HotListAdapter(this,list));
        foot.setVisibility(View.VISIBLE);
        }else{
//            foot.setVisibility(View.GONE);
            hot_list.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1));
            hot_list.addFooterView(list_foot);
        }
        load.setVisibility(View.GONE);
    }

    @Override
    public void getHeadData(ItemHeadDataInfo.ResultBean result) {
        itemInfo = result;
        Glide.with(this)
                .load(itemInfo.getImages().get(0).getUrl())
                .placeholder(R.mipmap.shadow_top)
                .error(R.mipmap.shadow_top)
                .crossFade()
                .into(head_image);
        country_name.setText(itemInfo.getZhName());
        country_english_name.setText(itemInfo.getEnName());
        commodity_num.setText(itemInfo.getCommoditiesCnt()+"");
    }

    @Override
    public void getNoteData(List<NoteDataInfo.ResultBean> result) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.head_food:

                break;
            case R.id.head_info:
                intent = new Intent(this,InfoActivity.class);
                intent.putExtra("desc",itemInfo.getDesc());
                intent.putExtra("name","城市简介");
                startActivity(intent);
                break;
            case R.id.head_note://游记
                intent = new Intent(this,NoteActivity.class);
                intent.putExtra("name","全部游记");
                intent.putExtra("id",itemInfo.getId());
                startActivity(intent);
                break;
            case R.id.head_notice:
                intent = new Intent(this,HomeHead2Activity.class);
                intent.putExtra("link",itemInfo.getPlayGuide());
                intent.putExtra("name","旅游指南");
                startActivity(intent);
                break;
            case R.id.head_viewSpot:
                intent = new Intent(this,ViewSpotActivity.class);
                intent.putExtra("name",itemInfo.getZhName());
                intent.putExtra("id",itemInfo.getId());
                startActivity(intent);
                break;
            case R.id.head_plan://行程
                break;
            case R.id.head_shopping:
                break;
            case R.id.traffic:
                intent=new Intent(this, HomeHead2Activity.class);
                intent.putExtra("link",itemInfo.getTrafficInfoUrl());
                intent.putExtra("name","交通指南");
                startActivity(intent);
                break;
            case R.id.foot:
                intent = new Intent(this,LookAllActivity.class);
                intent.putExtra("name",itemInfo.getZhName());
                intent.putExtra("id",itemInfo.getId());
                startActivity(intent);
                break;
            case R.id.foot_iv:
                intent = new Intent(this,HomeHead2Activity.class);
                intent.putExtra("name","旅行派各国商户招募计划");
                intent.putExtra("link","http://nluloh.epub360.com/v2/manage/book/pe3rs2/");
                startActivity(intent);
                break;
            case R.id.back:
                finish();
                break;
        }
    }
}
