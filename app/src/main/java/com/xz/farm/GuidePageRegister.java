package com.xz.farm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by 亮剑 on 2018/4/15.
 */

public class GuidePageRegister extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void register(View view){
        // TODO: 注册后要干的事情
    }

    public void jump_login(View view){
        Intent intent=new Intent(this,GuidePageLogin.class);
        startActivity(intent);
    }
}
