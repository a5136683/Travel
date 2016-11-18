package com.phone1000.admin.travel.interf;

import com.phone1000.admin.travel.bean.HotDataInfo;
import com.phone1000.admin.travel.bean.SevenDataInfo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by admin on 2016/11/18.
 */

public interface HttpService {
    @GET("app/geo/localities/recommendations")
    Call<HotDataInfo> getHotDataInfo();//热门
    @GET("app/geo/countries?continentCode=AS")
    Call<SevenDataInfo> getAsiaDataInfo();//亚洲
    @GET("app/geo/countries?continentCode=NA")
    Call<SevenDataInfo> getNorthDataInfo();//北美洲
    @GET("app/geo/countries?continentCode=SA")
    Call<SevenDataInfo> getSouthDataInfo();//南美洲
    @GET("app/geo/countries?continentCode=EU")
    Call<SevenDataInfo> getEuropeDataInfo();//欧洲
    @GET("app/geo/countries?continentCode=AF")
    Call<SevenDataInfo> getAfricaDataInfo();//非洲
    @GET("app/geo/countries?continentCode=OC")
    Call<SevenDataInfo> getOceaniaDataInfo();//大洋洲
}
