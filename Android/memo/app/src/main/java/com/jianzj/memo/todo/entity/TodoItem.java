package com.jianzj.memo.todo.entity;

import androidx.annotation.NonNull;

import java.util.Date;

public class TodoItem {

    private long id;
    private String content;
    private boolean isDone;
    private Date timestamp;

    public TodoItem(String content, boolean isDone, Date timestamp) {
        this.content = content;
        this.isDone = isDone;
        this.timestamp = timestamp;
    }

    public TodoItem(String content, boolean isDone) {
        this.content = content;
        this.isDone = isDone;
        this.timestamp = new Date(); // 当前时间
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }

    public boolean isDone() {
        return isDone;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", isDone=" + isDone +
                ", timestamp=" + timestamp +
                '}';
    }
}


