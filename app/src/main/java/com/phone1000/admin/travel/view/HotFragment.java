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
import com.phone1000.admin.travel.adapter.HotFragmentAdapter;
import com.phone1000.admin.travel.bean.HotDataInfo;
import com.phone1000.admin.travel.presenter.HotPresenter;
import com.phone1000.admin.travel.presenter.IAllPresenter;
import com.phone1000.admin.travel.view.activity.HotListActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/11/18.
 */

public class HotFragment extends Fragment implements IHotFragment{

    private View v = null;
    private AnimationDrawable animationDrawable = null;
    private List<HotDataInfo.ResultBean> list = new ArrayList<>();
    private String url = "http://api.lvxingpai.com";
    private IAllPresenter iPresenterHot = new HotPresenter(this);
    @BindView(R.id.hot_lv)ListView hot_lv;
    @BindView(R.id.load)ImageView load;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = LayoutInflater.from(getActivity()).inflate(R.layout.hot_fragment_layout,container,false);

        ButterKnife.bind(this,v);

        animationDrawable = (AnimationDrawable) load.getBackground();
        animationDrawable.start();

        iPresenterHot.getUrl(url);

        setListener();
        return v;
    }

    private void setListener() {
        hot_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), HotListActivity.class);
                intent.putExtra("id",list.get(i).getId());
                intent.putExtra("name",list.get(i).getZhName());
                startActivity(intent);
            }
        });
    }

    @Override
    public void getHotData(List<HotDataInfo.ResultBean> result) {
        load.setVisibility(View.GONE);
        list.addAll(result);
        hot_lv.setAdapter(new HotFragmentAdapter(getActivity(),list));
    }
}
