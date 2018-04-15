package com.xz.farm;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

/**
 * Created by 亮剑 on 2018/4/13.
 * fragementadapter_page用以对viewpager进行适配
 * 因为我们viewpager中装的是fragment对象，所以选择使用FragmentPagerAdapter
 */

public class fragementadapter_page extends FragmentPagerAdapter {
    private final int PAGER_COUNT=4;
    private Fragment100 myFragment100=null;
    private Fragment200 myFragment200=null;
    private Fragment300 myFragment300=null;
    private Fragment400 myFragment400=null;

    public fragementadapter_page(FragmentManager fm) {
        super(fm);
        myFragment100= new Fragment100();
        myFragment200= new Fragment200();
        myFragment300= new Fragment300();
        myFragment400= new Fragment400();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    //根据position生成fragment，只会调用一次
    public Fragment getItem(int position) {
        Fragment fragment = null;
        Log.i("getItem", String.valueOf(position));
        switch (position) {
            case MainActivity.PAGE_ONE:
                fragment = myFragment100;
                break;
            case MainActivity.PAGE_TWO:
                fragment = myFragment200;
                break;
            case MainActivity.PAGE_THREE:
                fragment = myFragment300;
                break;
            case MainActivity.PAGE_FOUR:
                fragment = myFragment400;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }
}
