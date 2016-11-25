package com.phone1000.admin.travel.presenter;

import com.phone1000.admin.travel.bean.ViewSpotDataInfo;
import com.phone1000.admin.travel.model.IViewSpotData;
import com.phone1000.admin.travel.model.ViewSpotData;
import com.phone1000.admin.travel.view.activity.IViewSpot;

import java.util.List;

/**
 * Created by admin on 2016/11/23.
 */

public class ViewSpotPresenter implements IViewSpotPresenter {

    private IViewSpot iViewSpot = null;
    private IViewSpotData iViewSpotData = new ViewSpotData(this);

    public ViewSpotPresenter(IViewSpot iViewSpot) {
        this.iViewSpot = iViewSpot;
    }

    @Override
    public void getId(String id, String page) {
        iViewSpotData.getId(id,page);
    }

    @Override
    public void getData(List<ViewSpotDataInfo.ResultBean> result) {
        iViewSpot.getData(result);
    }

    @Override
    public void getNoteData() {

    }
}
