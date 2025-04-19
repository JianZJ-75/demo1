package com.jianzj.memo.todo.entity.helper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.jianzj.memo.todo.entity.TodoItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TodoItemDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "todo_db";
    private static final int DATABASE_VERSION = 1;

    // 表名
    private static final String TABLE_TODO = "todo_items";

    // 字段名
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_CONTENT = "content";
    private static final String COLUMN_DONE = "done";
    private static final String COLUMN_TIMESTAMP = "timestamp";

    public TodoItemDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * 创建表格
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_TODO + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_CONTENT + " TEXT, "
                + COLUMN_DONE + " INTEGER, "
                + COLUMN_TIMESTAMP + " INTEGER)";
        db.execSQL(CREATE_TABLE);
    }

    /**
     * 更新表
     * @param db The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO);
        onCreate(db);
    }

    /**
     * 删除表
     */
    public void drop() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO);
        onCreate(db);
    }

    /**
     * 插入数据
     * @param todoItem
     */
    public long insertTodoItem(TodoItem todoItem) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_CONTENT, todoItem.getContent());
        values.put(COLUMN_DONE, todoItem.isDone() ? 1 : 0);
        values.put(COLUMN_TIMESTAMP, todoItem.getTimestamp().getTime());

        long id = db.insert(TABLE_TODO, null, values);
        db.close();
        return id;
    }

    public List<TodoItem> getAllTodoItems() {
        List<TodoItem> todoItems = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // 查询所有行
        Cursor cursor = db.query(TABLE_TODO, new String[]{COLUMN_ID, COLUMN_CONTENT, COLUMN_DONE, COLUMN_TIMESTAMP},
                null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                @SuppressLint("Range")
                long id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID));
                @SuppressLint("Range")
                String content = cursor.getString(cursor.getColumnIndex(COLUMN_CONTENT));
                @SuppressLint("Range")
                boolean done = cursor.getInt(cursor.getColumnIndex(COLUMN_DONE)) == 1;
                @SuppressLint("Range")
                long timestampLong = cursor.getLong(cursor.getColumnIndex(COLUMN_TIMESTAMP));
                Date timestamp = new Date(timestampLong);

                TodoItem todoItem = new TodoItem(content, done, timestamp);
                todoItem.setId(id);
                todoItems.add(todoItem);
            } while (cursor.moveToNext());
            cursor.close();
        }

        db.close();
        return todoItems;
    }

    /**
     * 修改是否完成
     * @param item
     */
    public void updateTodoItem(TodoItem item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CONTENT, item.getContent());
        values.put(COLUMN_DONE, item.isDone() ? 1 : 0);
        values.put(COLUMN_TIMESTAMP, item.getTimestamp().getTime());

        db.update(TABLE_TODO, values, COLUMN_ID + " = ?", new String[]{String.valueOf(item.getId())});
        db.close();
    }
}
