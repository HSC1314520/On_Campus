package com.example.h.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;

public class Login_Success_Main extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  //隐藏标题栏
        setContentView(R.layout.login_successful);
        setTranslucent.setTranslucent(this);
    }
}
