package com.phone1000.admin.travel.presenter;

import com.phone1000.admin.travel.bean.ItemDataInfo;
import com.phone1000.admin.travel.bean.ItemHeadDataInfo;
import com.phone1000.admin.travel.bean.NoteDataInfo;
import com.phone1000.admin.travel.model.HotListData;
import com.phone1000.admin.travel.model.IBaseData;
import com.phone1000.admin.travel.view.activity.BaseActivity;
import com.phone1000.admin.travel.view.activity.IView;

import java.util.List;

/**
 * Created by admin on 2016/11/19.
 */

public class HotListPresenter extends AllPresenter {

    private IBaseData iHotListData = new HotListData(this);
    private IView iHotList = null;

    public HotListPresenter(BaseActivity iHotList) {
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
    public void getNoteId(String id, String start) {
        iHotListData.getNoteId(id,start);
    }

    @Override
    public void getNoteData(List<NoteDataInfo.ResultBean> result) {
        iHotList.getNoteData(result);
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
