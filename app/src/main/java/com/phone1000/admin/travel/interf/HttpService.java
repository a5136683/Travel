package com.phone1000.admin.travel.interf;

import com.phone1000.admin.travel.bean.CountryDataInfo;
import com.phone1000.admin.travel.bean.HotDataInfo;
import com.phone1000.admin.travel.bean.Item2DataInfo;
import com.phone1000.admin.travel.bean.ItemDataInfo;
import com.phone1000.admin.travel.bean.ItemHeadDataInfo;
import com.phone1000.admin.travel.bean.NoteDataInfo;
import com.phone1000.admin.travel.bean.PhotoDataInfo;
import com.phone1000.admin.travel.bean.SevenDataInfo;
import com.phone1000.admin.travel.bean.ViewSpotDataInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

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
    @GET("app/marketplace/commodities")//热门东京
    Call<ItemDataInfo> getItemDataInfo(@Query("count") String count,@Query("locality") String locality,@Query("start") String start);
    @GET("app/geo/localities/{id}")
    Call<ItemHeadDataInfo>getHeadDataInfo(@Path("id") String id);
    @GET("app/geo/localities")
    Call<CountryDataInfo>getCountryInfo(@Query("countryId")String countryId);
    @GET("app/poi/viewspots")
    Call<ViewSpotDataInfo>getViewInfo(@Query("locality")String id,@Query("page")String page,@Query("pageSize")String pageSize);
    @GET("app/travelnotes")
    Call<NoteDataInfo>getNoteInfo(@Query("locality")String id, @Query("page")String page, @Query("pageSize")String pageSize);
    @GET("app/poi/viewspots/{id}")
    Call<Item2DataInfo>getItemInfo(@Path("id")String id);
    //http://api.lvxingpai.com/app/geo/localities/546f2daab8ce0440eddb2acc/albums?pageSize=100
    @GET("app/geo/localities/{id}/albums")
    Call<PhotoDataInfo>getPhotoDataInfo(@Path("id")String id,@Query("pageSize")String size);
}
