package com.phone1000.admin.travel.model;

import com.phone1000.admin.travel.bean.HotDataInfo;
import com.phone1000.admin.travel.interf.HttpService;
import com.phone1000.admin.travel.presenter.IPresenterHot;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2016/11/18.
 */

public class HotData implements IDataHot {

    private IPresenterHot iPresenterHot = null;
    private Retrofit retrofit;
    private String baseUrl = "http://api.lvxingpai.com";

    public HotData(IPresenterHot iPresenterHot) {
        this.iPresenterHot = iPresenterHot;
    }

    @Override
    public void getUrl(String url) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(url).addConverterFactory(GsonConverterFactory.create());//设定域名
        retrofit = builder.build();
        HttpService httpService = retrofit.create(HttpService.class);
        Call<HotDataInfo> call = httpService.getHotDataInfo();
        call.enqueue(new Callback<HotDataInfo>() {
            @Override
            public void onResponse(Call<HotDataInfo> call, Response<HotDataInfo> response) {
                List<HotDataInfo.ResultBean> result = response.body().getResult();
                iPresenterHot.getHotData(result);
            }

            @Override
            public void onFailure(Call<HotDataInfo> call, Throwable t) {

            }
        });
    }

}
