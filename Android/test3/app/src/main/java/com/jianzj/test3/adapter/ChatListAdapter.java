package com.jianzj.test3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jianzj.test3.R;
import com.jianzj.test3.entity.User;

import java.util.List;

public class ChatListAdapter extends BaseAdapter {

    private Context context;

    private List<User> userList;

    static class ViewHolder {
        ImageView imageView;
        TextView usernameText;
        TextView descText;
    }

    public ChatListAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int i) {
        return userList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.chat_item, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.chat_photo);
            holder.usernameText = convertView.findViewById(R.id.chat_username);
            holder.descText = convertView.findViewById(R.id.chat_desc);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // 获取当前项数据
        User user = userList.get(position);

        // 绑定数据
        if (holder.usernameText != null) {
            holder.usernameText.setText(user.getUsername());
        }
        if (holder.descText != null) {
            holder.descText.setText(user.getDescription());
        }

        if (holder.imageView != null) {
            // 设置头像（这里用默认图片，你可以使用 Glide 或 Picasso 加载网络图片）
            holder.imageView.setImageResource(R.drawable.default_photo);
        }

        return convertView;
    }

}
