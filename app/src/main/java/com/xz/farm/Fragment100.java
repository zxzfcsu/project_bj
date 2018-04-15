package com.xz.farm;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by 亮剑 on 2018/4/13.
 * 关联的为V4包中的fragment
 * Fragment100类关联的布局文件为activity_farm
 * 即第一个页面-农场页面
 * fragment的生命周期请参看：http://www.runoob.com/w3cnote/android-tutorial-fragment-base.html
 */

public class Fragment100 extends Fragment {

    private Button button;

    public Fragment100() {
    }

    //重写onCreateView方法用以关联布局文件
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_farm, container, false);

        //todo 在此处添加按钮事件的处理程序，如下例
        button = view.findViewById(R.id.makeReport_100);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("buttonInFragment", "was clicked");
            }
        });

        return view;
    }
}
