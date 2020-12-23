create user ecommerce identified by 'ecommerce';
drop database if exists dbecommerce;
create database dbecommerce;
use dbecommerce;
grant all on dbecommerce.* to ecommerce;

create table categories (
    category_id varchar(5) not null,
    category_name varchar(30) not null,
    category_description varchar(100) not null,
    primary key(category_id)
);

create table products (
    product_id varchar(5) not null,
    sku varchar(30) not null,
    name varchar(60) not null,
    brand varchar(60) not null,
    description varchar(100) not null,
    price int not null,
    category_id varchar(5) not null,
    image varchar(256) not null,
    primary key(product_id),
    foreign key(category_id) references categories(category_id)
);

create table promotion (
    promotion_id varchar(5) not null,
    product_id varchar(5) not null,
    primary key(promotion_id),
    foreign key(product_id) references products(product_id)
);