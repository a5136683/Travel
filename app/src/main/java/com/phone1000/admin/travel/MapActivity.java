package com.phone1000.admin.travel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.phone1000.admin.travel.app.MyApp;
import com.phone1000.admin.travel.utils.MyLocationListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapActivity extends AppCompatActivity {

    @BindView(R.id.bmapView) MapView map;
    @BindView(R.id.map_info)TextView map_info;
    @BindView(R.id.location)ImageView location;
    private BaiduMap baiduMap = null;
    private Marker marker = null;
    private OverlayOptions options = null;
    private BitmapDescriptor bitmap = null;
    public LocationClient mLocationClient = null;
    public BDLocationListener myListener = new MyLocationListener();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);
        mLocationClient = new LocationClient(getApplicationContext());     //声明LocationClient类
        mLocationClient.registerLocationListener( myListener );    //注册监听函数
        initView();
        baiduMap = map.getMap();
        LatLng cent = new LatLng(getIntent().getDoubleExtra("lat",0),getIntent().getDoubleExtra("lon",0));
        options = new MarkerOptions().position(cent).icon(bitmap);
        marker = (Marker) baiduMap.addOverlay(options);
        MapStatus mapStatus = new MapStatus.Builder().zoom(15).target(cent).build();
        MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mapStatus);
        baiduMap.setMapStatus(mapStatusUpdate);
        initLocation();
        setListener();
        mLocationClient.start();
    }

    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span=1000;
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤GPS仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }


    private void setListener() {
        baiduMap.setOnMapTouchListener(new BaiduMap.OnMapTouchListener() {
            @Override
            public void onTouch(MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_MOVE:
                        map_info.setVisibility(View.GONE);
                        break;
                }
            }
        });
        baiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                map_info.setVisibility(View.VISIBLE);
                map_info.setText(getIntent().getStringExtra("name"));
                return false;
            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mLocationClient.start();
                LatLng cent = new LatLng(MyApp.bdLocation.getLatitude(),MyApp.bdLocation.getLongitude());
                options = new MarkerOptions().position(cent).icon(bitmap);
                marker = (Marker) baiduMap.addOverlay(options);
                MapStatus mapStatus = new MapStatus.Builder().zoom(20).target(cent).build();
                MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mapStatus);
                baiduMap.setMapStatus(mapStatusUpdate);
            }
        });
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                Log.d("test","---------ACTION_DOWN------------");
//                break;
//            case MotionEvent.ACTION_MOVE:
//                Log.d("test","---------------------");
//                map_info.setVisibility(View.GONE);
//                break;
//            case MotionEvent.ACTION_UP:
//                Log.d("test","---------ACTION_UP------------");
//                break;
//        }
//        return false;
//    }

    private void initView() {
        bitmap = BitmapDescriptorFactory.fromResource(R.mipmap.ico_mid_travel);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        map.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        map.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        map.onPause();
    }
}
