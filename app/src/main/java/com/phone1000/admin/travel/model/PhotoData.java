package com.phone1000.admin.travel.model;

import com.phone1000.admin.travel.bean.PhotoDataInfo;
import com.phone1000.admin.travel.interf.BaseUrl;
import com.phone1000.admin.travel.interf.HttpService;
import com.phone1000.admin.travel.presenter.IAllPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2016/11/28.
 */

public class PhotoData extends BaseData {

    private Retrofit retrofit = null;
    private IAllPresenter iAllPresenter = null;

    public PhotoData(IAllPresenter iAllPresenter) {
        this.iAllPresenter = iAllPresenter;
    }

    @Override
    public void getId(String id) {

        Retrofit.Builder builder = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BaseUrl.baseUrl);
        retrofit= builder.build();
        HttpService httpService = retrofit.create(HttpService.class);
        httpService.getPhotoDataInfo(id, "100").enqueue(new Callback<PhotoDataInfo>() {
            @Override
            public void onResponse(Call<PhotoDataInfo> call, Response<PhotoDataInfo> response) {
                List<PhotoDataInfo.ResultBean.AlbumBean> list = response.body().getResult().getAlbum();
                iAllPresenter.getPhotoData(list);
            }

            @Override
            public void onFailure(Call<PhotoDataInfo> call, Throwable t) {

            }
        });
    }
}
