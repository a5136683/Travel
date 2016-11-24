package com.phone1000.admin.travel.presenter;

import com.phone1000.admin.travel.bean.ItemDataInfo;
import com.phone1000.admin.travel.bean.ItemHeadDataInfo;
import com.phone1000.admin.travel.model.HotListData;
import com.phone1000.admin.travel.model.IHotListData;
import com.phone1000.admin.travel.view.activity.IHotList;

import java.util.List;

/**
 * Created by admin on 2016/11/19.
 */

public class HotListPresenter implements IHotListPresenter {

    private IHotListData iHotListData = new HotListData(this);
    private IHotList iHotList = null;

    public HotListPresenter(IHotList iHotList) {
        this.iHotList = iHotList;
    }

    @Override
    public void getId(String id) {
        iHotListData.getId(id);
    }

    @Override
    public void getAllId(String id, String start) {
        iHotListData.getAllId(id,start);
    }

    @Override
    public void getData(List<ItemDataInfo.ResultBean> result) {
        iHotList.getData(result);
    }

    @Override
    public void getHeadData(ItemHeadDataInfo.ResultBean result) {
        iHotList.getHeadData(result);
    }
}
