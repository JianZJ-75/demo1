package com.jianzj.test2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        username = findViewById(R.id.account_input);
        password = findViewById(R.id.password_input);
        Button getContentButton = findViewById(R.id.login_button);
        // 设置按钮点击事件监听器
        getContentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取输入框中的内容
                String usernameContent = username.getText().toString();
                String passwordContent = password.getText().toString();
                String content = "用户名: " + usernameContent + "\n密码: " + passwordContent;
                // 显示获取到的内容
                Toast.makeText(LoginActivity.this, "输入的内容是: " + content, Toast.LENGTH_SHORT).show();
            }
        });
    }
}