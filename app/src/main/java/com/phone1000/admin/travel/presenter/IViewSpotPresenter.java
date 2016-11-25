package com.phone1000.admin.travel.presenter;

import com.phone1000.admin.travel.bean.ViewSpotDataInfo;

import java.util.List;

/**
 * Created by admin on 2016/11/23.
 */

public interface IViewSpotPresenter {
    void getId(String id,String page);
    void getData(List<ViewSpotDataInfo.ResultBean> result);
    void getNoteData();
}
