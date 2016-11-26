package com.phone1000.admin.travel.view.activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.phone1000.admin.travel.R;
import com.phone1000.admin.travel.adapter.CountryAdapter;
import com.phone1000.admin.travel.bean.CountryDataInfo;
import com.phone1000.admin.travel.presenter.CountryPresenter;
import com.phone1000.admin.travel.presenter.ICountryPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountryActivity extends AppCompatActivity implements ICountryList {

    @BindView(R.id.country_list)
    RecyclerView country_list;
    @BindView(R.id.country_list_title)
    TextView country_list_title;
    @BindView(R.id.load)
    ImageView load;
    @BindView(R.id.back)
    ImageView back;
    private AnimationDrawable drawable = null;

    private ICountryPresenter iCountryPresenter = new CountryPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        ButterKnife.bind(this);
        iCountryPresenter.getId(getIntent().getStringExtra("id"));
        country_list_title.setText(getIntent().getStringExtra("name"));
        drawable = (AnimationDrawable) load.getBackground();
        drawable.start();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void getCountryDataInfo(List<CountryDataInfo.ResultBean> result) {
        load.setVisibility(View.GONE);
        country_list.setLayoutManager(new GridLayoutManager(this, 2, GridLayout.VERTICAL, false));
        country_list.setAdapter(new CountryAdapter(this, result));

    }
}
