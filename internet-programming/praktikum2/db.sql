create user guestbook identified by 'guestbook';
drop database if exists dbguestbook;
create database dbguestbook;
use dbguestbook;
grant all on dbguestbook.* to guestbook;

create table GuestBook(
    id int not null auto_increment,
    name varchar(60) not null,
    address varchar(100) not null,
    company varchar(60) not null,
    email varchar(32) not null,
    primary key(id)
);