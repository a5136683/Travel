package com.phone1000.admin.travel.mainfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.phone1000.admin.travel.R;
import com.phone1000.admin.travel.view.AfricaFragment;
import com.phone1000.admin.travel.view.AsiaFragment;
import com.phone1000.admin.travel.view.EuropeFragment;
import com.phone1000.admin.travel.view.HotFragment;
import com.phone1000.admin.travel.view.NorthAmericaFragment;
import com.phone1000.admin.travel.view.OceaniaFragment;
import com.phone1000.admin.travel.view.SouthAmericaFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.phone1000.admin.travel.R.id.destination_Hot;


/**
 * Created by Administrator on 2016/11/17.
 */

public class DestinationFragment extends android.support.v4.app.Fragment implements View.OnClickListener {
    private View v = null;

    @BindView(R.id.dl)
    DrawerLayout dl;
    @BindView(R.id.destination_show)
    ImageView destination_show;
    @BindView(destination_Hot)
    TextView hot;
    @BindView(R.id.destination_Asia)
    TextView asia;
    @BindView(R.id.destination_North)
    TextView north;
    @BindView(R.id.destination_South)
    TextView south;
    @BindView(R.id.destination_Europe)
    TextView europe;
    @BindView(R.id.destination_Africa)
    TextView africa;
    @BindView(R.id.destination_Oceania)
    TextView oceania;
    @BindView(R.id.back)
    RelativeLayout back;

    private Fragment hotFragment, asiaFragment, northAmericaFragment, southAmericaFragment, europeFragment, africaFragment, oceaniaFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = LayoutInflater.from(getActivity()).inflate(R.layout.destination_fragment_layout, container, false);
        ButterKnife.bind(this, v);

        setData(0);

        setListener();
        dl.setScrimColor(Color.TRANSPARENT);//将滑出时的布局设置为透明
//        dl.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);//无法滑动打开菜单，只能通过代码打开
//        dl.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);//打开手势滑动
        dl.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN);//无法关闭菜单，只能通过代码进行关闭
        //不设置的话，会出现刚开始时，抽屉会处在打开状态
        dl.closeDrawer(Gravity.RIGHT);
        dl.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
//        dl.closeDrawer(GravityCompat.END);//设置drawerlayout的默认为关闭的

        return v;
    }

    private void setData(int select) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        hideFragment(transaction);
        switch (select) {
            case 0:
                if (hotFragment == null) {
                    hotFragment = new HotFragment();
                    transaction.add(R.id.destination_ll, hotFragment);
                } else {
                    transaction.show(hotFragment);
                }
                break;
            case 1:
                if (asiaFragment == null) {
                    asiaFragment = new AsiaFragment();
                    transaction.add(R.id.destination_ll, asiaFragment);
                } else {
                    transaction.show(asiaFragment);
                }
                break;
            case 2:
                if (northAmericaFragment == null) {
                    northAmericaFragment = new NorthAmericaFragment();
                    transaction.add(R.id.destination_ll, northAmericaFragment);
                } else {
                    transaction.show(northAmericaFragment);
                }
                break;
            case 3:
                if (southAmericaFragment == null) {
                    southAmericaFragment = new SouthAmericaFragment();
                    transaction.add(R.id.destination_ll, southAmericaFragment);
                } else {
                    transaction.show(southAmericaFragment);
                }
                break;
            case 4:
                if (europeFragment == null) {
                    europeFragment = new EuropeFragment();
                    transaction.add(R.id.destination_ll, europeFragment);
                } else {
                    transaction.show(europeFragment);
                }
                break;
            case 5:
                if (africaFragment == null) {
                    africaFragment = new AfricaFragment();
                    transaction.add(R.id.destination_ll, africaFragment);
                } else {
                    transaction.show(africaFragment);
                }
                break;
            case 6:
                if (oceaniaFragment == null) {
                    oceaniaFragment = new OceaniaFragment();
                    transaction.add(R.id.destination_ll, oceaniaFragment);
                } else {
                    transaction.show(oceaniaFragment);
                }
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (hotFragment != null) {
            transaction.hide(hotFragment);
        }
        if (asiaFragment != null) {
            transaction.hide(asiaFragment);
        }
        if (northAmericaFragment != null) {
            transaction.hide(northAmericaFragment);
        }
        if (southAmericaFragment != null) {
            transaction.hide(southAmericaFragment);
        }
        if (europeFragment != null) {
            transaction.hide(europeFragment);
        }
        if (africaFragment != null) {
            transaction.hide(africaFragment);
        }
        if (oceaniaFragment != null) {
            transaction.hide(oceaniaFragment);
        }
    }

    private void setListener() {
        destination_show.setOnClickListener(this);
        hot.setOnClickListener(this);
        asia.setOnClickListener(this);
        north.setOnClickListener(this);
        south.setOnClickListener(this);
        europe.setOnClickListener(this);
        africa.setOnClickListener(this);
        oceania.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.destination_Hot:
                setData(0);
                break;
            case R.id.destination_Asia:
                setData(1);
                break;
            case R.id.destination_North:
                setData(2);
                break;
            case R.id.destination_South:
                setData(3);
                break;
            case R.id.destination_Europe:
                setData(4);
                break;
            case R.id.destination_Africa:
                setData(5);
                break;
            case R.id.destination_Oceania:
                setData(6);
                break;
            case R.id.back:
                dl.closeDrawer(Gravity.RIGHT);
                destination_show.setVisibility(View.VISIBLE);
                break;
            case R.id.destination_show:
                dl.openDrawer(Gravity.RIGHT);
                destination_show.setVisibility(View.GONE);
                break;
        }
    }
}
