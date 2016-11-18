package com.phone1000.admin.travel.model;

import com.phone1000.admin.travel.bean.SevenDataInfo;
import com.phone1000.admin.travel.interf.HttpService;
import com.phone1000.admin.travel.presenter.ISevenPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2016/11/19.
 */

public class SevenData implements ISevenData {

    private Retrofit retrofit;
    private ISevenPresenter iSevenPresenter = null;

    public SevenData(ISevenPresenter iSevenPresenter) {
        this.iSevenPresenter = iSevenPresenter;
    }

    @Override
    public void getAsiaUrl(String url) {
        Retrofit.Builder builder = new Retrofit.Builder();
        retrofit = builder.baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        HttpService httpService = retrofit.create(HttpService.class);
        httpService.getAsiaDataInfo().enqueue(new Callback<SevenDataInfo>() {
            @Override
            public void onResponse(Call<SevenDataInfo> call, Response<SevenDataInfo> response) {
                List<SevenDataInfo.ResultBean> result = response.body().getResult();
                iSevenPresenter.getData(result);
            }

            @Override
            public void onFailure(Call<SevenDataInfo> call, Throwable t) {

            }
        });
    }

    @Override
    public void getAfricaUrl(String url) {
        Retrofit.Builder builder = new Retrofit.Builder();
        retrofit = builder.baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        HttpService httpService = retrofit.create(HttpService.class);
        httpService.getAfricaDataInfo().enqueue(new Callback<SevenDataInfo>() {
            @Override
            public void onResponse(Call<SevenDataInfo> call, Response<SevenDataInfo> response) {
                List<SevenDataInfo.ResultBean> result = response.body().getResult();
                iSevenPresenter.getData(result);
            }

            @Override
            public void onFailure(Call<SevenDataInfo> call, Throwable t) {

            }
        });
    }

    @Override
    public void getEuropeUrl(String url) {
        Retrofit.Builder builder = new Retrofit.Builder();
        retrofit = builder.baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        HttpService httpService = retrofit.create(HttpService.class);
        httpService.getEuropeDataInfo().enqueue(new Callback<SevenDataInfo>() {
            @Override
            public void onResponse(Call<SevenDataInfo> call, Response<SevenDataInfo> response) {
                List<SevenDataInfo.ResultBean> result = response.body().getResult();
                iSevenPresenter.getData(result);
            }

            @Override
            public void onFailure(Call<SevenDataInfo> call, Throwable t) {

            }
        });
    }

    @Override
    public void getNorthUrl(String url) {
        Retrofit.Builder builder = new Retrofit.Builder();
        retrofit = builder.baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        HttpService httpService = retrofit.create(HttpService.class);
        httpService.getNorthDataInfo().enqueue(new Callback<SevenDataInfo>() {
            @Override
            public void onResponse(Call<SevenDataInfo> call, Response<SevenDataInfo> response) {
                List<SevenDataInfo.ResultBean> result = response.body().getResult();
                iSevenPresenter.getData(result);
            }

            @Override
            public void onFailure(Call<SevenDataInfo> call, Throwable t) {

            }
        });
    }

    @Override
    public void getSouthUrl(String url) {
        Retrofit.Builder builder = new Retrofit.Builder();
        retrofit = builder.baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        HttpService httpService = retrofit.create(HttpService.class);
        httpService.getSouthDataInfo().enqueue(new Callback<SevenDataInfo>() {
            @Override
            public void onResponse(Call<SevenDataInfo> call, Response<SevenDataInfo> response) {
                List<SevenDataInfo.ResultBean> result = response.body().getResult();
                iSevenPresenter.getData(result);
            }

            @Override
            public void onFailure(Call<SevenDataInfo> call, Throwable t) {

            }
        });
    }

    @Override
    public void getOceaniaUrl(String url) {
        Retrofit.Builder builder = new Retrofit.Builder();
        retrofit = builder.baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        HttpService httpService = retrofit.create(HttpService.class);
        httpService.getOceaniaDataInfo().enqueue(new Callback<SevenDataInfo>() {
            @Override
            public void onResponse(Call<SevenDataInfo> call, Response<SevenDataInfo> response) {
                List<SevenDataInfo.ResultBean> result = response.body().getResult();
                iSevenPresenter.getData(result);
            }

            @Override
            public void onFailure(Call<SevenDataInfo> call, Throwable t) {

            }
        });
    }
}
