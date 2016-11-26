package com.phone1000.admin.travel.model;

/**
 * Created by admin on 2016/11/26.
 */

public interface IBaseData {
    void getId(String id);
    void getUrl(String url);
    void getAllId(String id,String start);
    void getNoteId(String id, String start);
    void getAsiaUrl(String url);
    void getAfricaUrl(String url);
    void getEuropeUrl(String url);
    void getNorthUrl(String url);
    void getSouthUrl(String url);
    void getOceaniaUrl(String url);
    void getId(String id,String page);
}
