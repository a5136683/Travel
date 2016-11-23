package com.phone1000.admin.travel.presenter;

import com.phone1000.admin.travel.bean.HotDataInfo;
import com.phone1000.admin.travel.model.HotData;
import com.phone1000.admin.travel.model.IDataHot;
import com.phone1000.admin.travel.view.IHotFragment;

import java.util.List;

/**
 * Created by admin on 2016/11/18.
 */

public class HotPresenter implements IPresenterHot {

    private IHotFragment iHotFragment = null;
    private IDataHot iDataHot = new HotData(this);

    public HotPresenter(IHotFragment iHotFragment) {
        this.iHotFragment = iHotFragment;
    }

    @Override
    public void getUrl(String url) {
        iDataHot.getUrl(url);
    }

    @Override
    public void getHotData(List<HotDataInfo.ResultBean> result) {
        iHotFragment.getHotData(result);
    }

}
