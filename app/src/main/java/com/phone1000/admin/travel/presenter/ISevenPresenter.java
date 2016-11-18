package com.phone1000.admin.travel.presenter;

import com.phone1000.admin.travel.bean.SevenDataInfo;

import java.util.List;

/**
 * Created by admin on 2016/11/19.
 */

public interface ISevenPresenter {
    void getAsiaUrl(String url);
    void getAfricaUrl(String url);
    void getEuropeUrl(String url);
    void getNorthUrl(String url);
    void getSouthUrl(String url);
    void getOceaniaUrl(String url);
    void getData(List<SevenDataInfo.ResultBean> list);
}
