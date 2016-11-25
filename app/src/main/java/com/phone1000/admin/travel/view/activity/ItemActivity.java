package com.phone1000.admin.travel.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.phone1000.admin.travel.HomeHead2Activity;
import com.phone1000.admin.travel.R;
import com.phone1000.admin.travel.adapter.ItemViewPagerAdapter;
import com.phone1000.admin.travel.bean.Item2DataInfo;
import com.phone1000.admin.travel.presenter.IItemPresenter;
import com.phone1000.admin.travel.presenter.ItemPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemActivity extends AppCompatActivity implements IItem,View.OnClickListener{

    @BindView(R.id.item_vp)ViewPager item_vp;
    @BindView(R.id.ratingBar)RatingBar ratingBar;
    @BindView(R.id.time)TextView time;
    @BindView(R.id.price)TextView price;
    @BindView(R.id.open_time)TextView open_time;
    @BindView(R.id.info_right)ImageView info_right;
    @BindView(R.id.desc)TextView desc;
    @BindView(R.id.traffic_right)ImageView traffic_right;
    @BindView(R.id.address)TextView address;
    @BindView(R.id.address_iv)ImageView address_iv;
    @BindView(R.id.car_plan)TextView car_plan;
    @BindView(R.id.strategy_right)ImageView strategy_right;
    @BindView(R.id.strategy_desc)TextView strategy_desc;
    @BindView(R.id.tips_right)ImageView tips_right;
    @BindView(R.id.tips_desc)TextView tips_desc;
    @BindView(R.id.country_list_title)TextView title;
    @BindView(R.id.back)ImageView back;

    private String id = null;
    private String name = null;
    private IItemPresenter iItemPresenter = new ItemPresenter(this);
    private Intent intent = null;
    private Item2DataInfo.ResultBean data = null;
    private List<Item2DataInfo.ResultBean.ImagesBean> images = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        ButterKnife.bind(this);

        initView();

        setListener();
    }

    private void setListener() {
        info_right.setOnClickListener(this);
//        strategy_right.setOnClickListener(this);
        tips_right.setOnClickListener(this);
        traffic_right.setOnClickListener(this);
        address_iv.setOnClickListener(this);
        back.setOnClickListener(this);
    }


    private void initView() {
        name = getIntent().getStringExtra("name");
        title.setText(name);
        id = getIntent().getStringExtra("id");
        iItemPresenter.getId(id);
    }

    @Override
    public void getData(Item2DataInfo.ResultBean result) {
        data= result;
        ratingBar.setRating((float) data.getRating()*5);
        time.setText("建议游玩"+data.getTimeCostDesc());
        price.setText("费用:"+data.getPriceDesc());
        open_time.setText("开放时间:"+data.getOpenTime());
        desc.setText(data.getDesc());
        address.setText("地址:"+data.getAddress());
        car_plan.setText("乘车方案:"+data.getTrafficInfo());
        tips_desc.setText("小贴士:"+data.getTips().get(0).getDesc());
        images = result.getImages();
        item_vp.setAdapter(new ItemViewPagerAdapter(images,this));
        if("".equals(data.getVisitGuide())){
            strategy_desc.setText("无");
        }else{
            strategy_desc.setText(data.getVisitGuide());
            strategy_right.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.info_right:
                intent = new Intent(this, HomeHead2Activity.class);
                intent.putExtra("link",data.getDescUrl());
                intent.putExtra("name",name);
                startActivity(intent);
                break;
            case R.id.strategy_right:
                intent = new Intent(this, HomeHead2Activity.class);
                intent.putExtra("link",data.getVisitGuideUrl());
                intent.putExtra("name",name);
                startActivity(intent);
                break;
            case R.id.tips_right:
//                intent = new Intent(this, HomeHead2Activity.class);
//                intent.putExtra("link",data.getDescUrl());
//                intent.putExtra("name",name);
//                startActivity(intent);
                Toast.makeText(this, "无效网址", Toast.LENGTH_SHORT).show();
                break;
            case R.id.traffic_right:
                intent = new Intent(this, HomeHead2Activity.class);
                intent.putExtra("link",data.getTrafficInfoUrl());
                intent.putExtra("name",name);
                startActivity(intent);
                break;
            case R.id.address_iv:
                break;
            case R.id.back:
                finish();
                break;
        }
    }
}
