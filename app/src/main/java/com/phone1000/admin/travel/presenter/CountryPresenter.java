package com.phone1000.admin.travel.presenter;

import com.phone1000.admin.travel.bean.CountryDataInfo;
import com.phone1000.admin.travel.model.CountryListData;
import com.phone1000.admin.travel.model.IBaseData;
import com.phone1000.admin.travel.view.activity.BaseActivity;
import com.phone1000.admin.travel.view.activity.CountryActivity;

import java.util.List;

/**
 * Created by admin on 2016/11/22.
 */

public class CountryPresenter extends AllPresenter {

    private BaseActivity countryActivity = null;
    private IBaseData iCountryData = new CountryListData(this);

    public CountryPresenter(CountryActivity countryActivity) {
        this.countryActivity = countryActivity;
    }

    @Override
    public void getId(String id) {
        iCountryData.getId(id);
    }

    @Override
    public void getCountryItemDataInfo(List<CountryDataInfo.ResultBean> result) {
        countryActivity.getCountryDataInfo(result);
    }

}
