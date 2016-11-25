package com.phone1000.admin.travel.model;

import com.phone1000.admin.travel.bean.Item2DataInfo;
import com.phone1000.admin.travel.interf.BaseUrl;
import com.phone1000.admin.travel.interf.HttpService;
import com.phone1000.admin.travel.presenter.IItemPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2016/11/24.
 */

public class ItemData implements IItemData {

    private Retrofit retrofit = null;
    private IItemPresenter iItemPresenter = null;

    public ItemData(IItemPresenter iItemPresenter) {
        this.iItemPresenter = iItemPresenter;
    }

    @Override
    public void getId(String id) {

        Retrofit.Builder builder = new Retrofit.Builder();
        retrofit = builder.baseUrl(BaseUrl.baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        HttpService httpService = retrofit.create(HttpService.class);
        httpService.getItemInfo(id).enqueue(new Callback<Item2DataInfo>() {
            @Override
            public void onResponse(Call<Item2DataInfo> call, Response<Item2DataInfo> response) {
                Item2DataInfo.ResultBean result = response.body().getResult();
                iItemPresenter.getData(result);
            }

            @Override
            public void onFailure(Call<Item2DataInfo> call, Throwable t) {

            }
        });
    }
}
