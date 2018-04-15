package com.xz.farm;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 亮剑 on 2018/4/13.
 * Fragment400关联的布局文件是activity_my
 * 即打第四个页面-我的页面
 */

public class Fragment400 extends Fragment {

    public Fragment400(){
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my, container, false);
        Log.i("Fragment_test", "activity_my connected");
        return view;
    }
}
