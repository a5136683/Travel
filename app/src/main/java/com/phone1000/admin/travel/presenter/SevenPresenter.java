package com.phone1000.admin.travel.presenter;

import com.phone1000.admin.travel.bean.SevenDataInfo;
import com.phone1000.admin.travel.model.ISevenData;
import com.phone1000.admin.travel.model.SevenData;
import com.phone1000.admin.travel.view.ISevenView;

import java.util.List;

/**
 * Created by admin on 2016/11/19.
 */

public class SevenPresenter implements ISevenPresenter{

    private ISevenData iSevenData = new SevenData(this);
    private ISevenView iSevenView = null;

    public SevenPresenter(ISevenView iSevenView) {
        this.iSevenView = iSevenView;
    }

    @Override
    public void getAsiaUrl(String url) {
        iSevenData.getAsiaUrl(url);
    }

    @Override
    public void getAfricaUrl(String url) {
        iSevenData.getAfricaUrl(url);
    }

    @Override
    public void getEuropeUrl(String url) {
        iSevenData.getEuropeUrl(url);
    }

    @Override
    public void getNorthUrl(String url) {
        iSevenData.getNorthUrl(url);
    }

    @Override
    public void getSouthUrl(String url) {
        iSevenData.getSouthUrl(url);
    }

    @Override
    public void getOceaniaUrl(String url) {
        iSevenData.getOceaniaUrl(url);
    }

    @Override
    public void getData(List<SevenDataInfo.ResultBean> list) {
        iSevenView.getData(list);
    }
}
