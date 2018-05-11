package com.example.administrator.activity_to_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.administrator.activity_to_activity.R.id.account;
import static com.example.administrator.activity_to_activity.R.id.password;

/**
 * 结果显示界面
 * 跳转界面：无
 * 实现功能：将从登录界面获得的数据显示出来
 */

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //Bundle bundle=this.getIntent().getExtras();
       // String account=bundle.getString("account");
        //String password=bundle.getString("password");
        Intent intent=getIntent();
        String account=intent.getStringExtra("account");
        String password=intent.getStringExtra("password");
        TextView showtext= (TextView) findViewById(R.id.showtext);
        showtext.setText("您的帐号是："+account+"  您的密码是："+password);
    }
}


