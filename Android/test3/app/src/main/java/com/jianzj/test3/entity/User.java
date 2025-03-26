package com.jianzj.test3.entity;

import java.io.Serializable;

public class User implements Serializable {

    private static final String DEFAULT_PHOTO = "@mipmap/default_photo";

    private Long id;

    private String username;

    private String password;

    private String description;

    private String photo;

    private String phone;

    public User() {
        this.username = "JianZJ";
        this.description = "hello!";
        this.photo = DEFAULT_PHOTO;
    }

    public User(String username, String description) {
        this.username = username;
        this.description = description;
        this.photo = DEFAULT_PHOTO;
    }

    public User(Long id, String username, String password, String description, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.description = description;
        this.phone = phone;
        this.photo = DEFAULT_PHOTO;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("User: {%s, %s}", this.username, this.description);
    }
}
