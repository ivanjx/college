drop database if exists sia;
create database sia;
use sia;

create table master_akun (
    kode varchar(20) not null,
    nama varchar(20) not null,
    jenis varchar(20) not null,
    saldo varchar(20) not null,
    primary key(kode)
);