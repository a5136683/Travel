package com.phone1000.admin.travel.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

import com.phone1000.admin.travel.CutmRelease1Activity;

/**
 * Created by Administrator on 2016/11/27.
 */
public class MyScrollView extends ScrollView {
    private ScrollViewListener scrollViewListener = null;
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (scrollViewListener != null) {
            scrollViewListener.onScrollChanged(this,l,  t, oldl, oldt);
        }
    }

    public void setScrollViewListener(CutmRelease1Activity scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }
}
