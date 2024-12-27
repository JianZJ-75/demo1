drop database if exists mcbbs;

create database mcbbs collate utf8_general_ci;

use mcbbs;

create table user (
                      id bigint primary key comment '用户id',
                      username varchar(32) comment '用户名',
                      password varchar(64) comment '密码',
                      photo varchar(255) comment '头像',
                      phone varchar(20) comment '手机号',
                      is_admin bit comment '身份: 1管理员 0普通用户',
                      register_time datetime comment '注册时间'
) comment '用户表';

create table message (
                         id bigint primary key comment '帖子id',
                         title varchar(50) comment '标题',
                         content text comment '内容',
                         user_id bigint comment '用户id',
                         plate_id bigint comment '版块id',
                         view_times bigint comment '查看次数',
                         create_time datetime comment '发布时间'
) comment '帖子表';

create table plate (
                       id bigint primary key comment '版块id',
                       preview varchar(255) comment '预览图',
                       intro_photo varchar(255) comment '版块介绍图',
                       name varchar(50) comment '版块名',
                       title varchar(50) comment '版块标题',
                       content text comment '版块内容',
                       user_id bigint comment '用户id',
                       create_time datetime comment '创建时间'
) comment '版块表(只能管理员创建)';

create table remark (
                        id bigint primary key comment '评论id',
                        content text comment '评论内容',
                        create_time datetime comment '发布时间',
                        message_id bigint comment '帖子id',
                        user_id bigint comment '用户id'
) comment '评论表';

create table log (
                     id bigint primary key comment '日志id',
                     class_name varchar(100) comment '类名',
                     method_name varchar(100) comment '方法名',
                     args_name text comment '参数名',
                     user_id bigint comment '用户id',
                     operate_time datetime comment '操作时间'
) comment '日志表';