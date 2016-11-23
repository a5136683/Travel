package com.phone1000.admin.travel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class HomeHead2Activity extends AppCompatActivity {
    private Intent intent = null;
    private String url = null;

    private WebView teach_XianXia_web=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_head2);
        initView();
        setData();
    }
    private void setData() {
        //实现网络访问
        teach_XianXia_web.loadUrl(url);
        teach_XianXia_web.setWebChromeClient(new WebChromeClient());
        //设置两个孔客户端 为了实现打开网页  如果没有就打开的是浏览器 而不是网页
        teach_XianXia_web.setWebViewClient(new WebViewClient());
        teach_XianXia_web.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress<100){
                    Toast.makeText(HomeHead2Activity.this,"正在努力加载",Toast.LENGTH_SHORT).show();
                }
            }
        });
        //支持缩放
//		webShow.setSupportZoom(true);
//		webShow.setBuiltInZoomControls(true);
//        // 解决webview的适配屏幕问题
//		webShow.setUseWideViewPort(true);
//		webShow.setLoadWithOverviewMode(true);
    }

    private void initView() {
        intent = getIntent();
        url = intent.getStringExtra("link");
        teach_XianXia_web=(WebView) findViewById(R.id.homre_head_web);
    }
    public void luntanButton(View v){
        finish();
    }
}

