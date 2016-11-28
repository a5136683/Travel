package com.phone1000.admin.travel.presenter;

import com.phone1000.admin.travel.bean.CountryDataInfo;
import com.phone1000.admin.travel.bean.HotDataInfo;
import com.phone1000.admin.travel.bean.Item2DataInfo;
import com.phone1000.admin.travel.bean.ItemDataInfo;
import com.phone1000.admin.travel.bean.ItemHeadDataInfo;
import com.phone1000.admin.travel.bean.NoteDataInfo;
import com.phone1000.admin.travel.bean.PhotoDataInfo;
import com.phone1000.admin.travel.bean.SevenDataInfo;
import com.phone1000.admin.travel.bean.ViewSpotDataInfo;

import java.util.List;

/**
 * Created by admin on 2016/11/26.
 */

public interface IAllPresenter {
    void getCountryItemDataInfo(List<CountryDataInfo.ResultBean> result);
    void getAllId(String id,String start);
    void getNoteId(String id,String start);
    void getNoteData(List<NoteDataInfo.ResultBean> result);
    void getData(List<ItemDataInfo.ResultBean> result);
    void getHeadData(ItemHeadDataInfo.ResultBean result);
    void getId(String id);
    void getData(Item2DataInfo.ResultBean result);
    void getUrl(String url);
    void getHotData(List<HotDataInfo.ResultBean> result);
    void getAsiaUrl(String url);
    void getAfricaUrl(String url);
    void getEuropeUrl(String url);
    void getNorthUrl(String url);
    void getSouthUrl(String url);
    void getOceaniaUrl(String url);
    void getSevenData(List<SevenDataInfo.ResultBean> list);
    void getId(String id,String page);
    void getViewSpotData(List<ViewSpotDataInfo.ResultBean> result);
    void getNoteData();
    void getPhotoData(List<PhotoDataInfo.ResultBean.AlbumBean> list);
}
