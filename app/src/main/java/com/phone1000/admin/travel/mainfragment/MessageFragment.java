package com.phone1000.admin.travel.mainfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.phone1000.admin.travel.R;


/**
 * Created by Administrator on 2016/11/17.
 */

public class MessageFragment extends android.support.v4.app.Fragment {
    private View v=null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=LayoutInflater.from(getActivity()).inflate(R.layout.message_fragment_layout,null);
        return v;
    }
}
