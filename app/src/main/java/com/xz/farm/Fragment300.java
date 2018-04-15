package com.xz.farm;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 亮剑 on 2018/4/13.
 * Fragment300关联的布局文件是activity_find
 * 即打第三个页面-发现页面
 */

public class Fragment300 extends Fragment {

    public Fragment300(){
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_find, container, false);
        Log.i("Fragment_test", "activity_find connected");
        return view;
    }
}
