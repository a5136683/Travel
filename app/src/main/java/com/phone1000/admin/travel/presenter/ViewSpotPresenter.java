package com.phone1000.admin.travel.presenter;

import com.phone1000.admin.travel.bean.ViewSpotDataInfo;
import com.phone1000.admin.travel.model.IBaseData;
import com.phone1000.admin.travel.model.ViewSpotData;
import com.phone1000.admin.travel.view.activity.BaseActivity;
import com.phone1000.admin.travel.view.activity.IView;

import java.util.List;

/**
 * Created by admin on 2016/11/23.
 */

public class ViewSpotPresenter extends AllPresenter{

    private IView iViewSpot = null;
    private IBaseData iViewSpotData = new ViewSpotData(this);

    public ViewSpotPresenter(BaseActivity iViewSpot) {
        this.iViewSpot = iViewSpot;
    }

    @Override
    public void getId(String id, String page) {
        iViewSpotData.getId(id,page);
    }

    @Override
    public void getViewSpotData(List<ViewSpotDataInfo.ResultBean> result) {
        iViewSpot.getViewSpotData(result);
    }

    @Override
    public void getNoteData() {

    }
}
