package com.phone1000.admin.travel.view.activity;

import android.support.v7.app.AppCompatActivity;

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

public class BaseActivity extends AppCompatActivity implements IView{


    @Override
    public void getCountryDataInfo(List<CountryDataInfo.ResultBean> result) {

    }

    @Override
    public void getData(List<ItemDataInfo.ResultBean> result) {

    }

    @Override
    public void getHeadData(ItemHeadDataInfo.ResultBean result) {

    }

    @Override
    public void getNoteData(List<NoteDataInfo.ResultBean> result) {

    }

    @Override
    public void getData(Item2DataInfo.ResultBean result) {

    }

    @Override
    public void getViewSoptData(List<ViewSpotDataInfo.ResultBean> result) {

    }
}
