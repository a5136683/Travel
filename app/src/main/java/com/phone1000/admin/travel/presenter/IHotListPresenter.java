package com.phone1000.admin.travel.presenter;

import com.phone1000.admin.travel.bean.ItemDataInfo;
import com.phone1000.admin.travel.bean.ItemHeadDataInfo;

import java.util.List;

/**
 * Created by admin on 2016/11/19.
 */

public interface IHotListPresenter {
    void getId(String id);
    void getData(List<ItemDataInfo.ResultBean> result);
    void getHeadData(ItemHeadDataInfo.ResultBean result);
}
