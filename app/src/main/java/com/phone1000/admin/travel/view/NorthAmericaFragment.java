package com.phone1000.admin.travel.view;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.phone1000.admin.travel.R;
import com.phone1000.admin.travel.adapter.SevenFragmentAdapter;
import com.phone1000.admin.travel.bean.SevenDataInfo;
import com.phone1000.admin.travel.presenter.IAllPresenter;
import com.phone1000.admin.travel.presenter.SevenPresenter;
import com.phone1000.admin.travel.view.activity.CountryActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/11/18.
 */

public class NorthAmericaFragment extends Fragment implements ISevenView{
    private IAllPresenter iSevenPresenter = new SevenPresenter(this);
    private String url = "http://api.lvxingpai.com";
    private List<SevenDataInfo.ResultBean> list = new ArrayList<>();
    private AnimationDrawable animationDrawable = null;
    private View v = null;
    @BindView(R.id.north_lv)ListView north_lv;
    @BindView(R.id.load)ImageView load;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.north_fragment_layout,container,false);
        ButterKnife.bind(this,v);
        iSevenPresenter.getNorthUrl(url);
        animationDrawable = (AnimationDrawable) load.getBackground();
        animationDrawable.start();
        setListener();
        return v;
    }

    private void setListener() {
        north_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), CountryActivity.class);
                intent.putExtra("id",list.get(i).getId());
                intent.putExtra("name",list.get(i).getZhName());
                startActivity(intent);
            }
        });
    }

    @Override
    public void getData(List<SevenDataInfo.ResultBean> list) {
        load.setVisibility(View.GONE);
        this.list.addAll(list);
        north_lv.setAdapter(new SevenFragmentAdapter(getActivity(),list));
    }
}
