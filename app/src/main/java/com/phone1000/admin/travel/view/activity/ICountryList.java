package com.phone1000.admin.travel.view.activity;

import com.phone1000.admin.travel.bean.CountryDataInfo;

import java.util.List;

/**
 * Created by admin on 2016/11/22.
 */

public interface ICountryList {
    void getCountryDataInfo(List<CountryDataInfo.ResultBean> result);
}
