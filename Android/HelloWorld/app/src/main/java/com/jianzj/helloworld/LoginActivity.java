package com.jianzj.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText userName;
    private EditText password;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        userName = findViewById(R.id.edit_user);
        password = findViewById(R.id.edit_password);
        Button getContentButton = findViewById(R.id.get_content_button);
        // 设置按钮点击事件监听器
        getContentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取输入框中的内容
                String userContent = userName.getText().toString();
                String passwordContent = password.getText().toString();
                String content = "用户名：" + userContent + "\n密码：" + passwordContent;
                // 显示获取到的内容
                Toast.makeText(LoginActivity.this, "输入的内容是: " + content, Toast.LENGTH_SHORT).show();
            }
        });
    }
}