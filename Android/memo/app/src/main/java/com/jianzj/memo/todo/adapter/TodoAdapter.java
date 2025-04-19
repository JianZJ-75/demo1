package com.jianzj.memo.todo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.jianzj.memo.R;
import com.jianzj.memo.todo.entity.TodoItem;
import com.jianzj.memo.todo.entity.helper.TodoItemDatabaseHelper;

import java.util.Date;
import java.util.List;

public class TodoAdapter extends BaseAdapter {

    private Context context;

    private List<TodoItem> todoList;

    private OnStatusChangeListener onStatusChangeListener;

    private TodoItemDatabaseHelper dbHelper;

    static class ViewHolder {
        CheckBox checkBox;
        TextView textView;
        CheckBox deleteBox;
    }

    public TodoAdapter(@NonNull Context context, @NonNull List<TodoItem> todoList, @NonNull TodoItemDatabaseHelper dbHelper) {
        this.context = context;
        this.todoList = todoList;
        this.dbHelper = dbHelper;
    }

    @Override
    public int getCount() {
        return todoList.size();
    }

    @Override
    public Object getItem(int i) {
        return todoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        // 获取当前项
        TodoItem todoItem = (TodoItem) getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_todo, parent, false);
            holder = new ViewHolder();
            holder.checkBox = convertView.findViewById(R.id.is_done_todo);
            holder.textView = convertView.findViewById(R.id.text_todo);
            holder.deleteBox = convertView.findViewById(R.id.delete_todo);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // 设置控件的值
        if (holder.checkBox != null) {
            holder.checkBox.setOnCheckedChangeListener(null);
            holder.checkBox.setChecked(todoItem.isDone());
            // 设置复选框监听器
            holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (todoItem != null) {
                    todoItem.setDone(isChecked);

                    // 更新数据库
                    dbHelper.updateTodoItem(todoItem);

                    // 回调外部刷新
                    if (onStatusChangeListener != null) {
                        onStatusChangeListener.onStatusChanged();
                    }
                }

                notifyDataSetChanged();
            });
        }
        if (holder.textView != null) {
            holder.textView.setText(todoItem.getContent());
        }

        return convertView;
    }

    public void setOnStatusChangeListener(OnStatusChangeListener listener) {
        this.onStatusChangeListener = listener;
    }
}
