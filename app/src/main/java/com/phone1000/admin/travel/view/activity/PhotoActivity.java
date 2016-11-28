package com.phone1000.admin.travel.view.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.phone1000.admin.travel.R;
import com.phone1000.admin.travel.adapter.PhotoAdapter;
import com.phone1000.admin.travel.bean.PhotoDataInfo;
import com.phone1000.admin.travel.presenter.IAllPresenter;
import com.phone1000.admin.travel.presenter.PhotoPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoActivity extends BaseActivity {

    @BindView(R.id.photo_rv)RecyclerView photo_rv;
    @BindView(R.id.country_list_title)TextView title;
    @BindView(R.id.back)ImageView back;
    private int size = 0;
    private IAllPresenter iAllPresenter = new PhotoPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        size = getWindowManager().getDefaultDisplay().getWidth();
        setContentView(R.layout.activity_photo);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        iAllPresenter.getId(getIntent().getStringExtra("id"));
        title.setText(getIntent().getStringExtra("name"));
    }


    @Override
    public void getPhotoData(List<PhotoDataInfo.ResultBean.AlbumBean> list) {
        photo_rv.setLayoutManager(new GridLayoutManager(this,3, GridLayout.VERTICAL,false));
        photo_rv.setAdapter(new PhotoAdapter(list,this,size));
    }
}
