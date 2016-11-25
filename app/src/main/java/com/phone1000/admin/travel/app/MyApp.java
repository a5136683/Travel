package com.phone1000.admin.travel.app;

import android.app.Application;

import com.baidu.location.BDLocation;
import com.baidu.mapapi.SDKInitializer;

import org.xutils.x;


/**
 * Created by Administrator on 2016/11/18.
 */

public class MyApp extends Application {
    public static BDLocation bdLocation;
    @Override
    public void onCreate() {
        SDKInitializer.initialize(getApplicationContext());
        super.onCreate();
        x.Ext.init(this);
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
//        SDKInitializer.initialize(getApplicationContext());
//        SDKInitializer.initialize(this);
    }
}
