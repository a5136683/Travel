package com.phone1000.admin.travel.view.activity;

import com.phone1000.admin.travel.bean.CountryDataInfo;
import com.phone1000.admin.travel.bean.Item2DataInfo;
import com.phone1000.admin.travel.bean.ItemDataInfo;
import com.phone1000.admin.travel.bean.ItemHeadDataInfo;
import com.phone1000.admin.travel.bean.NoteDataInfo;
import com.phone1000.admin.travel.bean.ViewSpotDataInfo;

import java.util.List;

/**
 * Created by admin on 2016/11/26.
 */

public interface IView {
    void getCountryDataInfo(List<CountryDataInfo.ResultBean> result);
    void getData(List<ItemDataInfo.ResultBean> result);
    void getHeadData(ItemHeadDataInfo.ResultBean result);
    void getNoteData(List<NoteDataInfo.ResultBean> result);
    void getData(Item2DataInfo.ResultBean result);
    void getViewSoptData(List<ViewSpotDataInfo.ResultBean> result);
}
