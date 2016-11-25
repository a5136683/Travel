package com.phone1000.admin.travel.presenter;

import com.phone1000.admin.travel.bean.Item2DataInfo;
import com.phone1000.admin.travel.model.IItemData;
import com.phone1000.admin.travel.model.ItemData;
import com.phone1000.admin.travel.view.activity.IItem;

/**
 * Created by admin on 2016/11/24.
 */

public class ItemPresenter implements IItemPresenter {

    private IItem iItem = null;
    private IItemData iItemData = new ItemData(this);

    public ItemPresenter(IItem iItem) {
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
