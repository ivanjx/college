drop database if exists perkuliahan;
create database perkuliahan;
use perkuliahan;

create table dosen(
	id varchar(20) not null,
    nama varchar(100) not null,
    tgl_lahir date not null,
    no_telp varchar(20) not null,
    alamat varchar(200) not null,
    primary key(id)
);

create table mahasiswa(
	id varchar(20) not null,
    nama varchar(100) not null,
    tgl_lahir date not null,
    angkatan int not null,
    no_telp varchar(20) not null,
    alamat varchar(20) not null,
    primary key(id)
);

create table ruangan(
    id int not null AUTO_INCREMENT,
    nama varchar(30) not null UNIQUE,
    primary key(id)
);

create table kelas(
	id int not null AUTO_INCREMENT,
    nama varchar(50) not null UNIQUE,
    dosen_id varchar(20) not null,
    ruangan_id int not null,
    hari int not null,
    jam_mulai int not null,
    jam_akhir int not null,
    primary key(id),
    foreign key(dosen_id) references dosen(id),
    foreign key(ruangan_id) references ruangan(id)
);


create table kelas_mahasiswa(
    kelas_id int not null,
    mahasiswa_id varchar(20) not null,
    foreign key(kelas_id) references kelas(id),
    foreign key(mahasiswa_id) references mahasiswa(id)
);
