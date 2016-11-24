package com.phone1000.admin.travel.app;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2016/11/18.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
