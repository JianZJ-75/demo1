package com.jianzj.test3.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jianzj.test3.entity.User;

public class ChatListDB extends SQLiteOpenHelper {

    public ChatListDB(Context context) {
        super(context, "ChatListDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserTable = "CREATE TABLE user (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT," +
                "password TEXT," +
                "description TEXT," +
                "phone TEXT," +
                "photo TEXT)";
        db.execSQL(createUserTable);

        // 创建聊天表（用于聊天列表）
        String createChatTable = "CREATE TABLE chat (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT," +
                "description TEXT," +
                "time DATETIME DEFAULT CURRENT_TIMESTAMP)";
        db.execSQL(createChatTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL("DROP TABLE IF EXISTS chat");
        onCreate(db);
    }

    /**
     * 插入
     * @param user
     */
    public void insertChat(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", user.getUsername());
        values.put("description", user.getDescription());
        db.insert("chat", null, values);
        db.close();
    }

    /**
     *  删除聊天
     * @param username
     */
    public void deleteChatByName(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("chat", "username = ?", new String[]{username});
        db.close();
    }

}
