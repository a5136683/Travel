package com.phone1000.admin.travel.presenter;

import com.phone1000.admin.travel.bean.Item2DataInfo;
import com.phone1000.admin.travel.model.IBaseData;
import com.phone1000.admin.travel.model.ItemData;
import com.phone1000.admin.travel.view.activity.BaseActivity;
import com.phone1000.admin.travel.view.activity.IView;

/**
 * Created by admin on 2016/11/24.
 */

public class ItemPresenter extends AllPresenter{

    private IView iItem = null;
    private IBaseData iItemData = new ItemData(this);

    public ItemPresenter(BaseActivity iItem) {
        this.iItem = iItem;
    }

    @Override
    public void getId(String id) {
        iItemData.getId(id);
    }

    @Override
    public void getData(Item2DataInfo.ResultBean result) {
        iItem.getData(result);
    }
}
