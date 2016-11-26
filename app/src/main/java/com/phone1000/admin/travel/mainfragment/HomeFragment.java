package com.phone1000.admin.travel.mainfragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.phone1000.admin.travel.R;
import com.phone1000.admin.travel.adapter.HomeListAdapter;
import com.phone1000.admin.travel.adapter.HomeRecyclerViewAdapter;
import com.phone1000.admin.travel.adapter.HomeViewPagerAdapter;
import com.phone1000.admin.travel.bean.HomeListDataInfo;
import com.phone1000.admin.travel.bean.HomeRecyclDataInfo;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Created by Administrator on 2016/11/17.
 */

public class HomeFragment extends Fragment {
    private View v = null;
    //http://api.lvxingpai.com/app/marketplace/commodities/recommendations
    private ListView home_lvList;
    private ViewPager home_ViewPager;
    private RecyclerView home_RecyclView;
    private SwipeRefreshLayout home_Swipe;
    private View home_head1_layout, home_head2_layout;
    private View home_foot = null;
    private HomeListAdapter adapter;
    private HomeRecyclerViewAdapter adapter2;
    private List<HomeListDataInfo.ResultBean> list = new ArrayList<>();
    private List<HomeRecyclDataInfo.ResultBean.ColumnsBean> list2 = new ArrayList<>();
    private List<HomeRecyclDataInfo.ResultBean.ColumnsBean> list1 = new ArrayList<>();
    private Boolean flag = false;
    private ImageView imageView = null;
    private HomeListDataInfo.ResultBean lists0=null;
    private HomeListDataInfo.ResultBean lists1=null;
//    private ImageView[] imageViews = null;
    private boolean isContinue = true;
    private AtomicInteger what = new AtomicInteger(0);
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    adapter.notifyDataSetChanged();
                case 2:
                    adapter2.notifyDataSetChanged();
                case 3:
                    adapter2.notifyDataSetChanged();
            }

        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = LayoutInflater.from(getActivity()).inflate(R.layout.home_fragment_layout, null);
        initView();
        setRecyclData();
        setLVData();
        adapter = new HomeListAdapter(list, getActivity());
        home_lvList.addHeaderView(home_head1_layout);
        home_lvList.addHeaderView(home_head2_layout);
        home_lvList.setAdapter(adapter);
        home_lvList.addFooterView(home_foot);
        home_Swipe.post(new Runnable() {
            @Override
            public void run() {
                home_Swipe.setRefreshing(true);
            }
        });
        setHeadData();
        initViewPager();
        setListener();
        return v;
    }

    private void setListener() {
        home_Swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list.clear();
            }
        });
        home_lvList.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (flag && i == SCROLL_STATE_IDLE) {
                    flag = false;
                    setLVData();
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                if (i + i1 == i2) {
                    flag = true;
                }
            }
        });
    }

    private void initView() {
        home_lvList = (ListView) v.findViewById(R.id.home_lvList);
        home_head1_layout = RelativeLayout.inflate(getActivity(), R.layout.home_head1_layout, null);
        home_ViewPager = (ViewPager) home_head1_layout.findViewById(R.id.home_ViewPager);
        home_head2_layout = RelativeLayout.inflate(getActivity(), R.layout.home_head2_layout, null);
        home_RecyclView = (RecyclerView) home_head2_layout.findViewById(R.id.home_rclView);
        home_RecyclView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        home_foot = RelativeLayout.inflate(getActivity(), R.layout.list_foot, null);
        home_Swipe = (SwipeRefreshLayout) v.findViewById(R.id.home_Swipe);
    }

    //实现水平滑动的方向
    private void setHeadData() {
        //http://api.lvxingpai.com/app/columns?userId=221596
//        home_RecyclView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
    }

    //    @Override
//    public void getData(List<HomeRecyclDataInfo.ResultBean> list) {
//        home_RecyclView.setAdapter(new HomeRecyclerViewAdapter(list, getActivity()));
//    }
    public void setLVData() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                String uri = "http://api.lvxingpai.com/app/marketplace/commodities/recommendations";
                RequestParams entity = new RequestParams(uri);
                x.http().get(entity, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Log.d("test", "****" + result);
                        Gson gson = new Gson();
                        HomeListDataInfo homeListDataInfo = gson.fromJson(result, HomeListDataInfo.class);
                        list.addAll(homeListDataInfo.getResult());
                        lists0=list.get(0);
                        lists1=list.get(1);
//                        adapter.notifyDataSetChanged();

//                        Toast.makeText(getActivity(), "***LV****请求成功"+result, Toast.LENGTH_SHORT).show();
                        handler.sendEmptyMessage(1);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
//                        Log.d("test", "？？？？？？？？？？？？？？？？？？？？？？" + ex);
//                        Toast.makeText(getActivity(), "**********////////LV///////*************请求失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });
            }
        }.start();
    }

    public void setRecyclData() {
        Log.d("test",list1.size()+"");
        adapter2 = new HomeRecyclerViewAdapter(list1, getActivity());
        home_RecyclView.setAdapter(adapter2);
        new Thread() {
            @Override
            public void run() {
                super.run();
                String uri = "http://api.lvxingpai.com/app/columns?userId=221596";
                RequestParams entity = new RequestParams(uri);
                x.http().get(entity, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Gson gson = new Gson();
                        HomeRecyclDataInfo homeRecyclDataInfo = gson.fromJson(result, HomeRecyclDataInfo.class);
                        List<HomeRecyclDataInfo.ResultBean> result1 = homeRecyclDataInfo.getResult();
                        List<HomeRecyclDataInfo.ResultBean.ColumnsBean> columns = result1.get(1).getColumns();
                        list1.addAll(columns);
//                        Toast.makeText(getActivity(), "有数据了", Toast.LENGTH_SHORT).show();
                        handler.sendEmptyMessage(2);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
//                        Log.d("test", "//////////************//////////" + ex);
//                        Toast.makeText(getActivity(), "rv/========没看到数据", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });
            }
        }.start();
    }
    private void initViewPager() {
        ViewGroup group = (ViewGroup) v.findViewById(R.id.viewGroup);
        new Thread() {
            @Override
            public void run() {
                super.run();
                String uri = "http://api.lvxingpai.com/app/columns?userId=221596";
                RequestParams entity = new RequestParams(uri);
                x.http().get(entity, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Gson gson = new Gson();
                        HomeRecyclDataInfo homeRecyclDataInfo = gson.fromJson(result, HomeRecyclDataInfo.class);
                        List<HomeRecyclDataInfo.ResultBean> result1 = homeRecyclDataInfo.getResult();
                        List<HomeRecyclDataInfo.ResultBean.ColumnsBean> columns = result1.get(0).getColumns();
                        list2.addAll(columns);
//                        Toast.makeText(getActivity(), "有数据了", Toast.LENGTH_SHORT).show();
                        handler.sendEmptyMessage(3);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Log.d("test", "//////////************//////////" + ex);
//                        Toast.makeText(getActivity(), "没看到数据", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });
            }
        }.start();
//小图标
//        for (int i = 0; i < list2.size(); i++) {
//            imageView = new ImageView(getActivity());
//            imageView.setLayoutParams(new ViewGroup.LayoutParams(40,40));
//            imageView.setPadding(10, 10, 10, 10);
//            imageViews[i] = imageView;
//            if (i == 0) {
//                imageViews[i]
//                        .setBackgroundResource(R.mipmap.dot_enable);
//            } else {
//                imageViews[i]
//                        .setBackgroundResource(R.mipmap.dot_normal);
//            }
//            group.addView(imageViews[i]);
//        }
        home_head1_layout.setVisibility(View.VISIBLE);
        home_ViewPager.setAdapter(new HomeViewPagerAdapter(list2,getActivity()));
        home_ViewPager.setOnPageChangeListener(new GuidePageChangeListener());
        home_ViewPager.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE:
                        isContinue = false;
                        break;
                    case MotionEvent.ACTION_UP:
                        isContinue = true;
                        break;
                    default:
                        isContinue = true;
                        break;
                }
                return false;
            }
        });
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    if (isContinue) {

                        handler.sendEmptyMessage(what.get());
                        whatOption();
                    }
                }
            }

        }).start();
    }


    private void whatOption() {
        what.incrementAndGet();
        if (what.get() > list2.size() - 1) {
            what.getAndAdd(-4);
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {

        }
    }


    private final class GuidePageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
       public void onPageSelected(int arg0) {
//            what.getAndSet(arg0);
//            for (int i = 0; i < imageViews.length; i++) {
//                imageViews[arg0]
//                        .setBackgroundResource(R.mipmap.dot_enable);
//                if (arg0 != i) {
//                    imageViews[i]
//                            .setBackgroundResource(R.mipmap.dot_normal);
//                }
//            }

    }

    }

}
