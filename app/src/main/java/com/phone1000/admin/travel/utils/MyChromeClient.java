package com.phone1000.admin.travel.utils;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * Created by admin on 2016/11/21.
 */

public class MyChromeClient extends WebChromeClient {

    public interface ChromeCallBack{
        void onProgressChanged(int progress);
        void onReceivedTitle(String title);
    }

    private ChromeCallBack mCallBack = null;

    public void setChromeListener(ChromeCallBack mCallBack){
        this.mCallBack = mCallBack;
    }

    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);

        if(mCallBack!= null){
            mCallBack.onProgressChanged(newProgress);
        }
    }

    @Override
    public void onReceivedTitle(WebView view, String title) {
        super.onReceivedTitle(view, title);

        if(mCallBack!= null){
            mCallBack.onReceivedTitle(title);
        }
    }

}
