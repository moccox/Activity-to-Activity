package com.example.administrator.activity_to_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 注册界面
 * 实现功能：1.检测帐号、密码是否为空
 *           2.检测输入两遍密码是否一致
 *           3.界面跳转：注册符合条件将跳转到登录界面 //abstract：并将注册数据打包传送到后台
 */

public class ThirdActivity extends Activity {
    private EditText memail;
    private EditText mnewpassowrd1,mnewpassword2;
    private Button menrollsure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        //部件初始化
        memail= (EditText) this.findViewById(R.id.email);
        mnewpassowrd1= (EditText) this.findViewById(R.id.newPassword1);
        mnewpassword2= (EditText) this.findViewById(R.id.newPassword2);
        menrollsure= (Button) this.findViewById(R.id.enrollsure);

        //按钮监听
        menrollsure.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(TextUtils.isEmpty(memail.getText().toString().trim())
                        ||TextUtils.isEmpty(mnewpassowrd1.getText().toString().trim())
                        ||TextUtils.isEmpty(mnewpassword2.getText().toString().trim()))
                {
                    Toast.makeText(ThirdActivity.this,"请输入完整信息！",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(mnewpassowrd1.getText().toString().equals(mnewpassword2.getText().toString()))
                {
                    /**
                     * 将注册的E-mail和password打包发送到后台（待完善）
                     **/

                    Intent intent=new Intent(ThirdActivity.this,FirstActivity.class);
                    /**
                     * 打包并发送数据代码在此处完善
                     **/
                    ThirdActivity.this.startActivity(intent);

                }else{
                    Toast.makeText(ThirdActivity.this,"两次输入的密码不同！",Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });

    }
}
