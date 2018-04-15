package com.xz.farm;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 亮剑 on 2018/4/13.
 * Fragment200关联的布局文件为activity_farmthing
 * 即第二个-农事页面
 */

public class Fragment200 extends Fragment {

    public Fragment200(){
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_farmthing, container, false);
        Log.i("Fragment_test", "activity_farmthing connected");
        return view;
    }
}
