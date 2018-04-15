package com.xz.farm;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * 此项目的入口，关联的布局文件为activity_main
 * 该布局文件采用viewpager + radioGroup的方式实现侧滑功能
 * 因为我们用的是V4和V7包，而没有使用app包，所以MainActivity最好继承于AppCompatActivity
 */

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    private RadioGroup rg_tab_bar;
    private RadioButton rb_farm;
    private RadioButton rb_farmthing;
    private RadioButton rb_find;
    private RadioButton rb_my;
    private ViewPager vpager;

    private fragementadapter_page fa_p;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        @SuppressLint("WrongConstant")
        SharedPreferences sp = getSharedPreferences("User", Context.MODE_APPEND);
        //如果没有FirstLoad标签，则使用default选项，为true
        boolean FirstLoad = sp.getBoolean("FirstLoad", true);
        if (FirstLoad) {
            //是第一次进入，则进入导引页，直到完成登录才能结束
            //todo 制作导引页、登录界面
            Intent intent=new Intent(this,GuidePageLogin.class);
            startActivity(intent);
            RequestPower();

            //todo 此处应注意，在登录完成后才能改变FirstLoad的值
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean("FirstLoad", false);
            editor.commit();
        } else {
            //不是第一次登录，读取本地文件、同步服务器端信息
            setContentView(R.layout.activity_main);
            RequestPower();
            bindViews();
        }
    }

    //权限获取方法,一次性获取多个权限
    private void RequestPower() {
        String[] permissions = new String[]{
                Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION};
        List<String> mPermissionList = new ArrayList<>();

        //判断哪些权限未授予
        mPermissionList.clear();
        for (int i = 0; i < permissions.length; i++) {
            if (ContextCompat.checkSelfPermission(this, permissions[i]) != PackageManager.PERMISSION_GRANTED) {
                mPermissionList.add(permissions[i]);
            }
        }

        //判断是否为空
        if (!mPermissionList.isEmpty()) {//请求权限方法
            Toast.makeText(MainActivity.this, "为了方便使用，请全部授予权限", Toast.LENGTH_LONG).show();
            String[] permission = mPermissionList.toArray(new String[mPermissionList.size()]);//将List转为数组
            ActivityCompat.requestPermissions(this, permission, 1);
        }
    }

    //绑定控件及初始化
    private void bindViews() {
        //getSupportFragmentManager方法是V4包中的方法，对应于app包中的方法是getFragmentManager
        fa_p = new fragementadapter_page(getSupportFragmentManager());

        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rb_farm = (RadioButton) findViewById(R.id.rb_farm);
        rb_farmthing = (RadioButton) findViewById(R.id.rb_farmthing);
        rb_find = (RadioButton) findViewById(R.id.rb_find);
        rb_my = (RadioButton) findViewById(R.id.rb_my);
        rg_tab_bar.setOnCheckedChangeListener(this);

        //初始化viewpager控件，选定适配器并设定当前界面
        vpager = (ViewPager) findViewById(R.id.vpager_contents);
        vpager.setAdapter(fa_p);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(this);

        rb_farm.setChecked(true);
    }

    @Override
    //重写onCheckedChanged方法用以监听底部RadioButton被选择情况
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId) {
            case R.id.rb_farm:
                vpager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rb_farmthing:
                vpager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.rb_find:
                vpager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.rb_my:
                vpager.setCurrentItem(PAGE_FOUR);
                break;
        }
    }

    /**
     * 因为MainActivity implements ViewPager.OnPageChangeListener
     * 所以需要重写以下三个方法：onPageScrolled，onPageSelected，onPageScrollStateChanged
     */
    @Override
    //This method will be invoked when the current page is scrolled，
    // either as part of a programmatically initiated smooth scroll or a user initiated touch scroll.
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    //This method will be invoked when a new page becomes selected.
    //注意是new page而不是every
    public void onPageSelected(int position) {
        Toast.makeText(getApplicationContext(), "已选择页面", Toast.LENGTH_LONG).show();
    }

    @Override
    //Called when the scroll state changes.
    //即滑动状态改变时才会调用
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            //改变下方radioGroup的状态
            switch (vpager.getCurrentItem()) {
                case PAGE_ONE:
                    rb_farm.setChecked(true);
                    break;
                case PAGE_TWO:
                    rb_farmthing.setChecked(true);
                    break;
                case PAGE_THREE:
                    rb_find.setChecked(true);
                    break;
                case PAGE_FOUR:
                    rb_my.setChecked(true);
                    break;
            }
        }
    }
}
