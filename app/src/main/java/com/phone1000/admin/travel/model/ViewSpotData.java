package com.phone1000.admin.travel.model;

import com.phone1000.admin.travel.bean.ViewSpotDataInfo;
import com.phone1000.admin.travel.interf.BaseUrl;
import com.phone1000.admin.travel.interf.HttpService;
import com.phone1000.admin.travel.presenter.IViewSpotPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2016/11/23.
 */

public class ViewSpotData implements IViewSpotData{

    private Retrofit retrofit = null;
    private IViewSpotPresenter iViewSpotPresenter = null;

    public ViewSpotData(IViewSpotPresenter iViewSpotPresenter) {
        this.iViewSpotPresenter = iViewSpotPresenter;
    }

    @Override
    public void getId(String id, String page) {
        Retrofit.Builder builder = new Retrofit.Builder();
        retrofit = builder.baseUrl(BaseUrl.baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        HttpService httpService = retrofit.create(HttpService.class);
        httpService.getViewInfo(id, page, 15 + "").enqueue(new Callback<ViewSpotDataInfo>() {
            @Override
            public void onResponse(Call<ViewSpotDataInfo> call, Response<ViewSpotDataInfo> response) {
                List<ViewSpotDataInfo.ResultBean> result = response.body().getResult();
                iViewSpotPresenter.getData(result);
            }

            @Override
            public void onFailure(Call<ViewSpotDataInfo> call, Throwable t) {

            }
        });
    }
}
