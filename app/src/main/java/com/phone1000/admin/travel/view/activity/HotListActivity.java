package com.phone1000.admin.travel.view.activity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.phone1000.admin.travel.R;
import com.phone1000.admin.travel.adapter.HotListAdapter;
import com.phone1000.admin.travel.bean.ItemDataInfo;
import com.phone1000.admin.travel.bean.ItemHeadDataInfo;
import com.phone1000.admin.travel.presenter.HotListPresenter;
import com.phone1000.admin.travel.presenter.IHotListPresenter;

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
    @BindView(R.id.hot_list)ListView hot_list;
    @BindView(R.id.load)ImageView load;
    @BindView(R.id.hot_list_title)TextView hot_list_title;
    @BindView(R.id.foot)TextView foot;
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
        hot_list.setAdapter(new HotListAdapter(this,result));
        load.setVisibility(View.GONE);
        foot.setVisibility(View.VISIBLE);
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
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.head_food:

                break;
            case R.id.head_info:
                intent = new Intent(this,InfoActivity.class);
                intent.putExtra("desc",itemInfo.getDesc());
                intent.putExtra("name",itemInfo.getZhName());
                startActivity(intent);
                break;
            case R.id.head_note:
                break;
            case R.id.head_notice:
                break;
            case R.id.head_viewSpot:
                break;
            case R.id.head_plan:
                break;
            case R.id.head_shopping:
                break;
            case R.id.traffic:
                break;
        }
    }
}
