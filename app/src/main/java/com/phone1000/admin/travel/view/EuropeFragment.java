package com.phone1000.admin.travel.view;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.phone1000.admin.travel.R;
import com.phone1000.admin.travel.adapter.SevenFragmentAdapter;
import com.phone1000.admin.travel.bean.SevenDataInfo;
import com.phone1000.admin.travel.presenter.ISevenPresenter;
import com.phone1000.admin.travel.presenter.SevenPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/11/18.
 */

public class EuropeFragment extends Fragment implements ISevenView{
    private ISevenPresenter iSevenPresenter = new SevenPresenter(this);
    private String url = "http://api.lvxingpai.com";
    private List<SevenDataInfo.ResultBean> list = new ArrayList<>();
    private AnimationDrawable animationDrawable = null;
    private View v = null;
    @BindView(R.id.europe_lv)ListView europe_lv;
    @BindView(R.id.load)ImageView load;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.europe_fragment_layout,container,false);
        ButterKnife.bind(this,v);
        iSevenPresenter.getEuropeUrl(url);
        animationDrawable = (AnimationDrawable) load.getBackground();
        animationDrawable.start();
        return v;
    }

    @Override
    public void getData(List<SevenDataInfo.ResultBean> list) {
        load.setVisibility(View.GONE);
        list.addAll(list);
        europe_lv.setAdapter(new SevenFragmentAdapter(getActivity(),list));
    }
}
