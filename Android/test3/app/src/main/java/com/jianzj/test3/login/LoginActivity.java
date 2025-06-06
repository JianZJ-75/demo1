package com.jianzj.test3.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jianzj.test3.R;
import com.jianzj.test3.chat_list.ChatListActivity;
import com.jianzj.test3.entity.User;
import com.jianzj.test3.personal_info.PersonalInfoActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText phone;
    private EditText pwd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // 判断是否已经登录
        SharedPreferences preferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        boolean isLogin = preferences.getBoolean("isLogin", false);
        if (isLogin) {
            String phoneStr = preferences.getString("phone", "未登录");
            User user = new User();
            user.setPhone(phoneStr);
            Intent intent = new Intent(LoginActivity.this, ChatListActivity.class);
            intent.putExtra("personal_info", user);
            startActivity(intent);
            finish();
            return;
        }

        phone = findViewById(R.id.phone);
        pwd = findViewById(R.id.pwd);
        Button getContentButton = findViewById(R.id.login_button);
        // 设置按钮点击事件监听器
        getContentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                // 获取输入框中的内容
                user.setPhone(phone.getText().toString());
                user.setPassword(pwd.getText().toString());
                // 显示获取到的内容
                Toast.makeText(LoginActivity.this, "输入的内容是: " + user, Toast.LENGTH_SHORT).show();

                // 登录成功后保存状态
                SharedPreferences preferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("isLogin", true);
                editor.putString("username", user.getUsername());
                editor.apply();

                // 跳转页面
                Intent intent = new Intent(LoginActivity.this, PersonalInfoActivity.class);
                intent.putExtra("personal_info", user);
                startActivity(intent);

            }
        });
    }
}