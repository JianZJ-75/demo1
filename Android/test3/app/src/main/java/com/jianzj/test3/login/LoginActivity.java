package com.jianzj.test3.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jianzj.test3.R;

public class LoginActivity extends AppCompatActivity {

    private EditText phone;
    private EditText pwd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        phone = findViewById(R.id.phone);
        pwd = findViewById(R.id.pwd);
        Button getContentButton = findViewById(R.id.login_button);
        // 设置按钮点击事件监听器
        getContentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取输入框中的内容
                String phoneContent = phone.getText().toString();
                String pwdContent = pwd.getText().toString();
                String content = "用户名: " + phoneContent + "\n密码: " + pwdContent;
                // 显示获取到的内容
                Toast.makeText(LoginActivity.this, "输入的内容是: " + content, Toast.LENGTH_SHORT).show();
            }
        });
    }
}