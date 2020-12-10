create user sia identified by 'sia';

drop database if exists sia;
create database sia;
use sia;

grant all on sia.* to sia;

create table master_akun (
    kode_akun varchar(5) not null,
    nama_akun varchar(20) not null,
    jenis_akun varchar(20) not null,
    saldo_normal varchar(20) not null,
    primary key(kode_akun)
);