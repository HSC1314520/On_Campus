package com.example.h.helloworld;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class OnClickActivity extends Activity{

    //private Button login_btn;
    private final String LOG_TAG=getClass().getSimpleName();

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*login_btn = (Button) findViewById(R.id.login_button);
        login_btn.setOnClickListener(new  Button.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.e(LOG_TAG,"单击事件!!");
                System.out.println("单机事件");
            }
        });*/

    }



    /*测试函数*/
    public void Demo() {
        System.out.println("函数调用测试语句");
    }

    public void goToLoginNULL(){
        //Toast.makeText(this,"学号密码不能为空！",Toast.LENGTH_LONG).show();
        System.out.println("密码为空测试");
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(LOG_TAG,"dendedewdedddddu恢复");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(LOG_TAG,"d嗷嗷的u恢复");
        return super.onTouchEvent(event);
    }
}

class Button_Listener extends Activity implements View.OnClickListener {
    private final String LOG_TAG=getClass().getSimpleName();
    private MainActivity activity;
    private OnClickActivity onClickActivity;

    public Button_Listener(MainActivity activity){
        this.activity=activity;
    }

    @Override
    public void onClick(View v) {
        Log.e(LOG_TAG,"登录点击1"); //测试语句
        System.out.println("密码传递测试语句1"+"账号："+activity.getUsername().getText().toString().trim()+"    密码："+activity.getPassword().getText().toString().trim());   //密码传递成功测试语句
        if (TextUtils.isEmpty(activity.getPassword().getText().toString().trim())){
            System.out.println("账号密码不能空1！！");//为空  测试语句
            Toast.makeText(activity,"账号密码不能空",Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(activity.getUsername().getText().toString().trim())){
            System.out.println("账号密码不能空2！！");//为空 测试语句
            Toast.makeText(activity,"账号密码不能空",Toast.LENGTH_SHORT).show();
        }
        else
            new UserOrpsd_process(activity.getUsername(), activity.getPassword());
    }
}