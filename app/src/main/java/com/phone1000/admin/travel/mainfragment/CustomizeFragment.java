package com.phone1000.admin.travel.mainfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.phone1000.admin.travel.CutmRelease1Activity;
import com.phone1000.admin.travel.R;


/**
 * Created by Administrator on 2016/11/17.
 */

public class CustomizeFragment extends android.support.v4.app.Fragment {
    private View v = null;
    private Button btn_cutm;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = LayoutInflater.from(getActivity()).inflate(R.layout.customize_fragment_layout, null);
        initView();
        return v;
    }

    private void initView() {
        btn_cutm = (Button) v.findViewById(R.id.btn_cutm);
        btn_cutm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CutmRelease1Activity.class);
                startActivity(intent);
            }
        });
    }
}