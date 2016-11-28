package com.phone1000.admin.travel.presenter;

import com.phone1000.admin.travel.bean.PhotoDataInfo;
import com.phone1000.admin.travel.model.IBaseData;
import com.phone1000.admin.travel.model.PhotoData;
import com.phone1000.admin.travel.view.activity.IView;

import java.util.List;

/**
 * Created by admin on 2016/11/28.
 */

public class PhotoPresenter extends AllPresenter {

    private IView iView = null;
    private IBaseData iBaseData = new PhotoData(this);

    public PhotoPresenter(IView iView) {
        this.iView = iView;
    }

    @Override
    public void getId(String id) {
        iBaseData.getId(id);
    }

    @Override
    public void getPhotoData(List<PhotoDataInfo.ResultBean.AlbumBean> list) {
        iView.getPhotoData(list);
    }
}
