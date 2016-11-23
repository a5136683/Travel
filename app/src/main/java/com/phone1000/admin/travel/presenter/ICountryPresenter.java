package com.phone1000.admin.travel.presenter;

import com.phone1000.admin.travel.bean.CountryDataInfo;

import java.util.List;

/**
 * Created by admin on 2016/11/22.
 */

public interface ICountryPresenter {
    void getId(String id);
    void getCountryItemDataInfo(List<CountryDataInfo.ResultBean> result);
}
