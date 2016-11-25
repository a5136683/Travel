package com.phone1000.admin.travel.presenter;

import com.phone1000.admin.travel.bean.ItemDataInfo;
import com.phone1000.admin.travel.bean.ItemHeadDataInfo;
import com.phone1000.admin.travel.bean.NoteDataInfo;

import java.util.List;

/**
 * Created by admin on 2016/11/19.
 */

public interface IHotListPresenter {
    void getId(String id);
    void getAllId(String id,String start);
    void getNoteId(String id,String start);
    void getNoteData(List<NoteDataInfo.ResultBean> result);
    void getData(List<ItemDataInfo.ResultBean> result);
    void getHeadData(ItemHeadDataInfo.ResultBean result);
}
