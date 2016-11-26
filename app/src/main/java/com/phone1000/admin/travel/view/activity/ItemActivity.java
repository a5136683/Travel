package com.phone1000.admin.travel.view.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.phone1000.admin.travel.HomeHead2Activity;
import com.phone1000.admin.travel.MapActivity;
import com.phone1000.admin.travel.R;
import com.phone1000.admin.travel.adapter.ItemViewPagerAdapter;
import com.phone1000.admin.travel.bean.Item2DataInfo;
import com.phone1000.admin.travel.presenter.IAllPresenter;
import com.phone1000.admin.travel.presenter.ItemPresenter;
import com.phone1000.admin.travel.utils.IsAvailable;

import java.net.URISyntaxException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.item_vp)
    ViewPager item_vp;
    @BindView(R.id.ratingBar)
    RatingBar ratingBar;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.open_time)
    TextView open_time;
    @BindView(R.id.info_right)
    ImageView info_right;
    @BindView(R.id.desc)
    TextView desc;
    @BindView(R.id.traffic_right)
    ImageView traffic_right;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.address_iv)
    ImageView address_iv;
    @BindView(R.id.car_plan)
    TextView car_plan;
    @BindView(R.id.strategy_right)
    ImageView strategy_right;
    @BindView(R.id.strategy_desc)
    TextView strategy_desc;
    @BindView(R.id.tips_right)
    ImageView tips_right;
    @BindView(R.id.tips_desc)
    TextView tips_desc;
    @BindView(R.id.country_list_title)
    TextView title;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.load)
    ImageView load;
    @BindView(R.id.load_rl)
    RelativeLayout rl;

    private String id = null;
    private String name = null;
    private IAllPresenter iItemPresenter = new ItemPresenter(this);
    private Intent intent = null;
    private Item2DataInfo.ResultBean data = null;
    private AnimationDrawable drawable = null;
    private List<Item2DataInfo.ResultBean.ImagesBean> images = null;
    private AlertDialog dialog = null;

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
        address_iv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                intent = new Intent(ItemActivity.this, MapActivity.class);
                intent.putExtra("lon", data.getLocation().getCoordinates().get(0));
                intent.putExtra("lat", data.getLocation().getCoordinates().get(1));
                intent.putExtra("name", data.getZhName());
                startActivity(intent);
                return true;//拦截点击事件的消费
            }
        });
    }


    private void initView() {
        name = getIntent().getStringExtra("name");
        title.setText(name);
        id = getIntent().getStringExtra("id");
        drawable = (AnimationDrawable) load.getBackground();
        drawable.start();
        iItemPresenter.getId(id);
    }

    @Override
    public void getData(Item2DataInfo.ResultBean result) {
        data = result;
        if (data != null) {
            rl.setVisibility(View.GONE);
            load.setVisibility(View.GONE);//动画取消
            ratingBar.setRating((float) data.getRating() * 5);
            time.setText("建议游玩" + data.getTimeCostDesc());
            price.setText("费用:" + data.getPriceDesc());
            open_time.setText("开放时间:" + data.getOpenTime());
            desc.setText(data.getDesc());
            address.setText("地址:" + data.getAddress());
            car_plan.setText("乘车方案:" + data.getTrafficInfo());
            if ("".equals(data.getTips().get(0).getDesc())) {
                tips_desc.setText("小贴士:" + data.getTips().get(0).getDesc());
            } else {
                tips_desc.setText("无");
            }
            images = result.getImages();
            item_vp.setAdapter(new ItemViewPagerAdapter(images, this));
            if ("".equals(data.getVisitGuide())) {
                strategy_desc.setText("无");
            } else {
                strategy_desc.setText(data.getVisitGuide());
                strategy_right.setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.info_right:
                intent = new Intent(this, HomeHead2Activity.class);
                intent.putExtra("link", data.getDescUrl());
                intent.putExtra("name", name);
                startActivity(intent);
                break;
            case R.id.strategy_right:
                intent = new Intent(this, HomeHead2Activity.class);
                intent.putExtra("link", data.getVisitGuideUrl());
                intent.putExtra("name", name);
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
                intent.putExtra("link", data.getTrafficInfoUrl());
                intent.putExtra("name", name);
                startActivity(intent);
                break;
            case R.id.address_iv:

//                if(IsAvailable.isAvilible(this,"com.baidu.BaiduMap")){
//                    Toast.makeText(this, "即将用百度地图打开定位服务", Toast.LENGTH_SHORT).show();
//                    String uri = "geo="+data.getLocation().getCoordinates().get(0)+","+"data.getLocation().getCoordinates().get(1)";
//                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
//                    startActivity(intent);
//                }else if(IsAvailable.isAvilible(this,"com.autonavi.minimap")) {
//                    Toast.makeText(this, "即将用高德地图打开导航", Toast.LENGTH_SHORT).show();
//                    Uri mUri = Uri.parse("geo:" + data.getLocation().getCoordinates().get(0) + "," + data.getLocation().getCoordinates().get(1) + "?q=" + data.getZhName());
//                    Intent intent = new Intent("android.intent.action.VIEW", mUri);
//                    startActivity(intent);
//                }else{
//                    Toast.makeText(this, "请安装第三方地图软件即可定位", Toast.LENGTH_SHORT).show();
//                }


//                intent = new Intent(this, MapActivity.class);
//                intent.putExtra("lon", data.getLocation().getCoordinates().get(0));
//                intent.putExtra("lat", data.getLocation().getCoordinates().get(1));
//                intent.putExtra("name", data.getZhName());
//                intent = Intent.parseUri()

                if (IsAvailable.isAvilible(this, "com.baidu.BaiduMap")) {
                    try {
                        dialog = new AlertDialog.Builder(this).create();
                        dialog.setIcon(R.mipmap.chat_mylocation_entry_default);
                        dialog.setMessage("是否使用百度地图打开定位服务?");
                        intent = intent.getIntent("intent://map/marker?" +
                                "location=" + data.getLocation().getCoordinates().get(1) + "," + data.getLocation().getCoordinates().get(0) +
                                "&title=我的位置&radius=1000&region=" + data.getZhName() + "&src=yourCompanyName|yourAppName#Intent;scheme=bdapp;" +
                                "package=com.baidu.BaiduMap;end");
                        dialog.setButton(Dialog.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialog.cancel();
                            }
                        });
                        dialog.setButton(Dialog.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(intent);
                            }
                        });
                        dialog.show();
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(this, "请安装第三方地图软件即可定位", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.back:
                finish();
                break;
        }
    }
}
