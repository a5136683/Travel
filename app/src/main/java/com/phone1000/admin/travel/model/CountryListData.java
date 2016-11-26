package com.phone1000.admin.travel.model;

import com.phone1000.admin.travel.bean.CountryDataInfo;
import com.phone1000.admin.travel.interf.BaseUrl;
import com.phone1000.admin.travel.interf.HttpService;
import com.phone1000.admin.travel.presenter.AllPresenter;
import com.phone1000.admin.travel.presenter.IAllPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2016/11/22.
 */

public class CountryListData extends BaseData{

    private Retrofit retrofit = null;
    private IAllPresenter iCountryPresenter = null;

    public CountryListData(AllPresenter iCountryPresenter) {
        this.iCountryPresenter = iCountryPresenter;
    }

    @Override
    public void getId(String id) {
        Retrofit.Builder builder = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create());
        retrofit = builder.baseUrl(BaseUrl.baseUrl).build();
        HttpService httpService = retrofit.create(HttpService.class);
        Call<CountryDataInfo> call = httpService.getCountryInfo(id);
        call.enqueue(new Callback<CountryDataInfo>() {
            @Override
            public void onResponse(Call<CountryDataInfo> call, Response<CountryDataInfo> response) {
                List<CountryDataInfo.ResultBean> result = response.body().getResult();
                iCountryPresenter.getCountryItemDataInfo(result);
            }

            @Override
            public void onFailure(Call<CountryDataInfo> call, Throwable t) {

            }
        });
    }
}
