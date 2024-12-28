drop database web6;

create database web6 collate utf8_general_ci;
use web6;
create table blog(
                     blogId int primary key not null unique auto_increment,
                     title varchar(256) not null,
                     username varchar(20) not null,
                     content text not null,
                     postTime datetime not null
);

create table user(
                     id int primary key not null unique auto_increment,
                     username varchar(20) not null unique,
                     pwd varchar(50) not null,
                     photo blob not null
);