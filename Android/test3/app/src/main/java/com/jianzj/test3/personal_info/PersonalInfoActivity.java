package com.jianzj.test3.personal_info;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jianzj.test3.R;
import com.jianzj.test3.chat_list.ChatListActivity;
import com.jianzj.test3.entity.User;

public class PersonalInfoActivity extends AppCompatActivity {

    private EditText username;
    private EditText phone;
    private EditText desc;
    private EditText pwd;
    private ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_info);

        // 获取数据
        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("personal_info");

        photo = findViewById(R.id.personal_info_photo);
        username = findViewById(R.id.personal_info_username_text);
        phone = findViewById(R.id.personal_info_phone_text);
        desc = findViewById(R.id.personal_info_desc_text);
        pwd = findViewById(R.id.personal_info_phone_text);

        // TODO 修改头像
        photo.setImageResource(R.drawable.default_photo);
        username.setText(user.getUsername());
        phone.setText(user.getPhone());
        desc.setText(user.getDescription());
        pwd.setText(user.getPassword());

        Button getEnterButton = findViewById(R.id.personal_info_enter_button);
        // 设置按钮点击事件监听器
        getEnterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 跳转页面
                Intent intent = new Intent(PersonalInfoActivity.this, ChatListActivity.class);
                intent.putExtra("personal_info", user);
                startActivity(intent);

            }
        });

        Button getEditButton = findViewById(R.id.personal_info_edit_button);
        // 设置按钮点击事件监听器
        getEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 跳转页面
                Intent intent = new Intent(PersonalInfoActivity.this, PersonalInfoEditActivity.class);
                intent.putExtra("personal_info", user);
                startActivity(intent);

            }
        });

    }

}
