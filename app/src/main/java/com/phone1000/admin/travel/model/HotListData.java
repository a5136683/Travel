package com.phone1000.admin.travel.model;

import com.phone1000.admin.travel.bean.ItemDataInfo;
import com.phone1000.admin.travel.bean.ItemHeadDataInfo;
import com.phone1000.admin.travel.bean.NoteDataInfo;
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
 * Created by admin on 2016/11/19.
 */

public class HotListData extends BaseData{

    private IAllPresenter iHotListPresenter = null;
    private Retrofit retrofit = null;

    public HotListData(AllPresenter iHotListPresenter) {
        this.iHotListPresenter = iHotListPresenter;
    }

        @Override
        public void getId(String id) {
            Retrofit.Builder builder = new Retrofit.Builder();
            retrofit = builder.baseUrl(BaseUrl.baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
            HttpService httpService = retrofit.create(HttpService.class);
            httpService.getItemDataInfo("3", id, "0").enqueue(new Callback<ItemDataInfo>() {
                @Override
                public void onResponse(Call<ItemDataInfo> call, Response<ItemDataInfo> response) {
                    List<ItemDataInfo.ResultBean> result = response.body().getResult();
                    iHotListPresenter.getData(result);
                }

                @Override
                public void onFailure(Call<ItemDataInfo> call, Throwable t) {

                }
            });
            httpService.getHeadDataInfo(id).enqueue(new Callback<ItemHeadDataInfo>() {
                @Override
                public void onResponse(Call<ItemHeadDataInfo> call, Response<ItemHeadDataInfo> response) {
                    ItemHeadDataInfo.ResultBean result = response.body().getResult();
                    iHotListPresenter.getHeadData(result);
                }

                @Override
                public void onFailure(Call<ItemHeadDataInfo> call, Throwable t) {

                }
            });
    }

    @Override
    public void getAllId(String id,String start) {
        Retrofit.Builder builder = new Retrofit.Builder();
        retrofit = builder.baseUrl(BaseUrl.baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        HttpService httpService = retrofit.create(HttpService.class);
        httpService.getItemDataInfo("15", id, start).enqueue(new Callback<ItemDataInfo>() {
            @Override
            public void onResponse(Call<ItemDataInfo> call, Response<ItemDataInfo> response) {
                List<ItemDataInfo.ResultBean> result = response.body().getResult();
                iHotListPresenter.getData(result);
            }

            @Override
            public void onFailure(Call<ItemDataInfo> call, Throwable t) {

            }
        });
    }

    @Override
    public void getNoteId(String id, String start) {
        Retrofit.Builder builder = new Retrofit.Builder();
        retrofit = builder.baseUrl(BaseUrl.baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        HttpService httpService = retrofit.create(HttpService.class);
        httpService.getNoteInfo(id,start,"15").enqueue(new Callback<NoteDataInfo>() {
            @Override
            public void onResponse(Call<NoteDataInfo> call, Response<NoteDataInfo> response) {
                List<NoteDataInfo.ResultBean> result = response.body().getResult();
                iHotListPresenter.getNoteData(result);
            }

            @Override
            public void onFailure(Call<NoteDataInfo> call, Throwable t) {

            }
        });
    }
}
