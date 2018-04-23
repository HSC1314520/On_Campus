package com.example.h.helloworld;

import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
import android.text.InputType;
import android.view.Window;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    private Button login_btn;
    EditText username,password;
    AutoCompleteTextView usn;
    ImageView login_eyeimageView,login_clearimageView;
    private final String LOG_TAG=getClass().getSimpleName();
    private Handler handler;

    OnClickActivity loginButtonActivity = new OnClickActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏

        login_btn = (Button) findViewById(R.id.login_button);
        login_btn.setOnClickListener(new Button_Listener(this));
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        //强制username输入框只能输入数字，并且自动跳转数字键盘
        username.setInputType(InputType.TYPE_CLASS_NUMBER);
        //绑定矢量图标并监听
        login_clearimageView = (ImageView) findViewById(R.id.login_clearimageView);  //X矢量图标
        login_clearimageView.setOnClickListener(new Login_ImageView(this));
        login_eyeimageView = (ImageView) findViewById(R.id.login_eyeimageView);//眼镜矢量图标
        login_eyeimageView.setImageResource(R.drawable.close_eyes);
        login_eyeimageView.setOnClickListener(new Login_ImageView(this));

    }

    @Override
    protected void onResume() {
        /*
            设置为强制竖屏
            SCREEN_ORIENTATION_LANDSCAPE  为横屏
            SCREEN_ORIENTATION_PORTRAIT   为竖屏
         */
        if(getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        super.onResume();
    }

    //提取账号密码
    public EditText getUsername() {
        return this.username;
    }

    public EditText getPassword() {
        return this.password;
    }

}