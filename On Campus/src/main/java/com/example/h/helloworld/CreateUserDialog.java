package com.hsc.h.niftydialogeffect;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class CreateUserDialog extends Dialog {

    /**
     * 第二个按钮 自定义弹出窗口
     */
    Activity context;

    private Button exitBtn0,exitBtn1;

    private View.OnClickListener mClickListener;

    public CreateUserDialog(Activity context) {
        super(context);
        this.context = context;
    }

    public CreateUserDialog(Activity context, int theme, View.OnClickListener clickListener) {
        super(context, theme);
        this.context = context;
        this.mClickListener = clickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 指定布局
        this.setContentView(R.layout.exit_dialog);

        /*
         * 获取圣诞框的窗口对象及参数对象以修改对话框的布局设置, 可以直接调用getWindow(),表示获得这个Activity的Window
         * 对象,这样这可以以同样的方式改变这个Activity的属性.
         */
        Window dialogWindow = this.getWindow();

        WindowManager m = context.getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.height = (int) (d.getHeight() * 0.3); // 高度设置为屏幕的0.6
        p.width = (int) (d.getWidth() * 0.8); // 宽度设置为屏幕的0.8
        dialogWindow.setAttributes(p);

        // 根据id在布局中找到控件对象
        exitBtn0 = (Button) findViewById(R.id.exitBtn0);
        exitBtn1 = (Button) findViewById(R.id.exitBtn1);
        // 为按钮绑定点击事件监听器
        exitBtn0.setOnClickListener(mClickListener);
        exitBtn1.setOnClickListener(mClickListener);

        this.setCancelable(true);
    }
   @Override
    public boolean onTouchEvent(android.view.MotionEvent event){
        //设置点击窗口外部关闭窗口
        context.finish();
        return true;
    }
}


