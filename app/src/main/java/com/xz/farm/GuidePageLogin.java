package com.xz.farm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by 亮剑 on 2018/4/15.
 */

public class GuidePageLogin extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view){
        //todo 登陆后要做的事情,修改SharedPreferences，清空本地文件，同步服务器端，跳转MainActivity界面
    }

    public void jump_register(View view){
        Intent intent=new Intent(this,GuidePageRegister.class);
        startActivity(intent);
    }
}
