package com.jianzj.test3.chat_list;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jianzj.test3.R;
import com.jianzj.test3.adapter.ChatListAdapter;
import com.jianzj.test3.entity.User;
import com.jianzj.test3.login.LoginActivity;
import com.jianzj.test3.sqlite.ChatListDB;

import java.util.ArrayList;
import java.util.List;

public class ChatListActivity extends AppCompatActivity {

    private static List<User> userList;

    private ListView listView;

    private ChatListAdapter adapter;

    private Button button;

    private ChatListDB chatListDB;

    static {
        userList = new ArrayList<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_list);
        chatListDB = new ChatListDB(this);
//        chatList();
        load();
        delete();
        addChat();
    }

    /**
     * 设置动态列表适配器
     */
    private void chatList() {
        listView = findViewById(R.id.chat_list);

        // 创建用户数据
//        userList.add(new User("张三", "张三的简介信息，超过一行会自动变成省略号..."));
//        userList.add(new User("李四", "李四的个人简介，他是一名Android开发工程师"));
//        userList.add(new User("王五", "王五喜欢编程和篮球"));
//        userList.add(new User("赵六", "赵六是个旅行爱好者，他去过很多国家"));

        // 设置适配器
        adapter = new ChatListAdapter(this, userList);
        listView.setAdapter(adapter);

        // 设置点击监听
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 获取当前点击项的姓名
                User user = userList.get(position);
                String name = user.getUsername();

                // 弹出 Toast 显示姓名
                Toast.makeText(ChatListActivity.this, "点击了: " + name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 设置长按删除
     */
    private void delete() {
        // 设置长按监听
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // 获取当前长按项的姓名
                User user = userList.get(position);
                String name = user.getUsername();

                // 弹出删除确认对话框
                new AlertDialog.Builder(ChatListActivity.this)
                        .setTitle("确认删除")
                        .setMessage("是否删除 " + name + "？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 删除当前项
                                chatListDB.deleteChatByName(name);
                                userList.remove(position);
                                adapter.notifyDataSetChanged();  // 通知适配器更新
                                Toast.makeText(ChatListActivity.this, name + " 已删除", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();

                return true;
            }
        });
    }

    /**
     * 添加聊天
     */
    private void addChat() {
        button = findViewById(R.id.add_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 弹出输入对话框
                showInputChatDialog();
            }
        });
    }

    /**
     * 添加聊天对话框
     */
    private void showInputChatDialog() {
        // 创建对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(ChatListActivity.this);
        builder.setTitle("输入姓名和简介");

        // 创建输入框布局
        View dialogView = getLayoutInflater().inflate(R.layout.add_chat, null);
        final EditText nameEditText = dialogView.findViewById(R.id.add_name);
        final EditText descEditText = dialogView.findViewById(R.id.add_desc);

        builder.setView(dialogView);

        // 设置确定按钮
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = nameEditText.getText().toString();
                String desc = descEditText.getText().toString();

                // TODO 去重等逻辑判断
                // 添加到列表中
                User add = new User(name, desc);

                // 先插入数据库
                ChatListDB dbHelper = new ChatListDB(ChatListActivity.this);
                dbHelper.insertChat(add);

                userList.add(add);  // 添加到数据源

                // 更新 ListView
                adapter.notifyDataSetChanged();

                // 显示Toast提示
                Toast.makeText(ChatListActivity.this, "输入的内容是: \n" + add, Toast.LENGTH_SHORT).show();
            }
        });

        // 设置取消按钮
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 取消时无需任何操作，直接关闭对话框
                dialog.dismiss();
            }
        });

        // 显示对话框
        builder.show();
    }

    /**
     * SQLite加载数据
     */
    private void load() {
        listView = findViewById(R.id.chat_list);

        // 加载数据
        SQLiteDatabase db = chatListDB.getReadableDatabase();
        Cursor cursor = db.query("chat", null, null, null, null, null, "time DESC");
        userList.clear();
        while (cursor.moveToNext()) {
            User tmp = new User(
                    cursor.getString(cursor.getColumnIndex("username")),
                    cursor.getString(cursor.getColumnIndex("description"))
            );
            userList.add(tmp);
        }
        cursor.close();

        adapter = new ChatListAdapter(this, userList);
        listView.setAdapter(adapter);
    }

}
