package com.phone1000.admin.travel.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.phone1000.admin.travel.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebActivity extends AppCompatActivity {

    @BindView(R.id.web)WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        ButterKnife.bind(this);
    }
}
