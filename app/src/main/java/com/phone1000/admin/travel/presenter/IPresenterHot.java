package com.phone1000.admin.travel.presenter;

import com.phone1000.admin.travel.bean.HotDataInfo;

import java.util.List;

/**
 * Created by admin on 2016/11/18.
 */

public interface IPresenterHot {
    void getUrl(String url);
    void getHotData(List<HotDataInfo.ResultBean> result);
}
