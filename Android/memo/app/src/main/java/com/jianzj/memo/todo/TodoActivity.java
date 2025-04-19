package com.jianzj.memo.todo;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.jianzj.memo.R;
import com.jianzj.memo.todo.adapter.TodoAdapter;
import com.jianzj.memo.todo.entity.TodoItem;
import com.jianzj.memo.todo.entity.helper.TodoItemDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class TodoActivity extends AppCompatActivity {

    private ListView listView;
    private TodoAdapter adapter;
    private TodoItemDatabaseHelper dbHelper;
    private List<TodoItem> todoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo);
        dbHelper = new TodoItemDatabaseHelper(this);

//        init();

        loadTodoItems();

        addButton();
        settingButton();
    }

    /**
     * 模拟数据
     */
    private void init() {
        listView = findViewById(R.id.listView_todos);

        // 创建一些待办事项数据
        todoList.add(new TodoItem("学习安卓开发", false));
        todoList.add(new TodoItem("完成作业111111111111111111111111111111111111111111111111111111111111111111111111111111111", false));
        todoList.add(new TodoItem("去健身房", true));
        todoList.add(new TodoItem("学习安卓开发", false));
        todoList.add(new TodoItem("完成作业", false));
        todoList.add(new TodoItem("去健身房", true));
        todoList.add(new TodoItem("学习安卓开发", false));
        todoList.add(new TodoItem("完成作业", false));
        todoList.add(new TodoItem("去健身房", true));
        todoList.add(new TodoItem("学习安卓开发", false));
        todoList.add(new TodoItem("完成作业", false));
        todoList.add(new TodoItem("去健身房", true));
        todoList.add(new TodoItem("学习安卓开发", false));
        todoList.add(new TodoItem("完成作业", false));
        todoList.add(new TodoItem("去健身房", true));
        todoList.add(new TodoItem("学习安卓开发", false));
        todoList.add(new TodoItem("完成作业", false));
        todoList.add(new TodoItem("去健身房", true));
        todoList.add(new TodoItem("学习安卓开发", false));
        todoList.add(new TodoItem("完成作业", false));
        todoList.add(new TodoItem("去健身房", true));
        todoList.add(new TodoItem("学习安卓开发", false));
        todoList.add(new TodoItem("完成作业", false));
        todoList.add(new TodoItem("去健身房", true));
        todoList.add(new TodoItem("学习安卓开发", false));
        todoList.add(new TodoItem("完成作业", false));
        todoList.add(new TodoItem("去健身房", true));
        todoList.add(new TodoItem("学习安卓开发", false));
        todoList.add(new TodoItem("完成作业", false));
        todoList.add(new TodoItem("去健身房", true));

        // 设置适配器
        adapter = new TodoAdapter(this, todoList, dbHelper);
        listView.setAdapter(adapter);
    }

    /**
     * 加载数据
     */
    private void loadTodoItems() {
        listView = findViewById(R.id.listView_todos);

        // 从数据库获取所有待办事项
        todoList = dbHelper.getAllTodoItems();

        sortTodoList();

        // 创建适配器并设置到 ListView
        adapter = new TodoAdapter(this, todoList, dbHelper);
        adapter.setOnStatusChangeListener(() -> {
            // 直接从数据库加载所有待办事项
            List<TodoItem> updatedTodoList = dbHelper.getAllTodoItems();
            // 更新数据源
            todoList.clear();
            todoList.addAll(updatedTodoList);
            sortTodoList();
            adapter.notifyDataSetChanged();
        });
        listView.setAdapter(adapter);
    }


    /**
     * 添加待办事件
     */
    private void addButton() {
        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddTodoDialog();
            }
        });
    }

    /**
     * 待办事件弹窗输入
     */
    private void showAddTodoDialog() {
        // 使用自定义布局
        final View dialogView = getLayoutInflater().inflate(R.layout.dialog_todo, null);
        final EditText editText = dialogView.findViewById(R.id.edit_todo);
        final CheckBox checkBox = dialogView.findViewById(R.id.is_done_todo);
        final Button btnDone = dialogView.findViewById(R.id.btn_done);

        // 创建对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView)
                .setCancelable(true);  // 使对话框可以通过点击外部关闭

        // 创建对话框
        AlertDialog dialog = builder.create();

        // 显示对话框
        dialog.show();

        // 设置完成按钮在输入框为空时不能点击
        // 初始设置按钮不可点击
        btnDone.setEnabled(false);

        // 添加输入监听器
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btnDone.setEnabled(s.toString().trim().length() > 0);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        btnDone.setOnClickListener(v -> {
            String content = editText.getText().toString().trim();

            // 获取复选框状态
            boolean isDone = checkBox.isChecked();

            TodoItem add = new TodoItem(content, isDone);
            long id = dbHelper.insertTodoItem(add);
            add.setId(id);
            todoList.add(add);

            sortTodoList();
            adapter.notifyDataSetChanged();

            // 关闭对话框
            dialog.dismiss();
        });

        // 设置圆角背景
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.todo_item_bg);

        // 设置弹窗的高度
        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        // 设置宽度为屏幕宽度百分比
        params.width = (int) (getResources().getDisplayMetrics().widthPixels * 0.95);
        params.height = 500;
        // 设置显示在底部
        params.gravity = Gravity.BOTTOM;
        dialog.getWindow().setAttributes(params);
    }

    /**
     * 设置按钮
     */
    private void settingButton() {
        findViewById(R.id.btn_setting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TodoActivity.this, "该功能待开发中...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * todoList排序逻辑
     */
    private void sortTodoList() {
        todoList.sort((o1, o2) -> {
            if (o1.isDone() != o2.isDone()) {
                return o1.isDone() ? 1 : -1;
            }
            return Long.compare(o2.getTimestamp().getTime(), o1.getTimestamp().getTime());
        });
    }
}
