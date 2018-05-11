package com.example.administrator.activity_to_activity;
/**
 * 登录界面
 * 跳转界面：1.显示结果界面
 *           2.注册界面
 * 实现功能：1.检测帐号、密码是否为空
 *           2.按钮单击事件:a.登录按钮，如果符合登录条件将跳转到显示界面
 *                          b.注册按钮，跳转到注册界面
 **/

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class FirstActivity extends AppCompatActivity {

    private Button mlogin;
    private Button menroll;
    private EditText maccount;
    private EditText mpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        //添加组件
        mlogin = (Button) this.findViewById(R.id.loging);
        menroll = (Button) this.findViewById(R.id.enroll);
        maccount = (EditText) this.findViewById(R.id.account);
        mpassword = (EditText) this.findViewById(R.id.password);


        //添加按钮监听：

        //1.登录按钮监听
        mlogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (TextUtils.isEmpty(maccount.getText().toString().trim())) {
                    Toast.makeText(FirstActivity.this, "输入帐号为空！",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(mpassword.getText().toString().trim())){
                    Toast.makeText(FirstActivity.this,"输入密码为空！",Toast.LENGTH_SHORT).show();
                    return;
                }
                /**
                * 使用显式意图将界面跳转到SecondActivity
                 **/
                    Intent intent1=new Intent(FirstActivity.this,SecondActivity.class);
                   // Bundle bundle =new Bundle();
                 //   bundle.putString("account", maccount.getText().toString());
                  //  bundle.putString("password",mpassword.getText().toString());
                    intent1.putExtra("account",maccount.getText().toString().trim());
                    intent1.putExtra("password",mpassword.getText().toString().trim());
                    FirstActivity.this.startActivity(intent1);

            }
        });

        //2.注册按钮监听
        menroll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                /**
                 * 使用隐式意图将界面跳转到ThirdActivity
                 **/
                Intent intent2=new Intent();
                intent2.setAction("com.example.administrator.activity_to_activity.GoToThirdActivity");
                intent2.addCategory("android.intent.category.DEFAULT");
                startActivity(intent2);
            }
        });


    }

}
