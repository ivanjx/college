create database dbinternetprogramminguts1;

create table tblKategori ( 
    id int not null auto_increment, 
    nama varchar(60) not null, 
    primary key(id)
);

create table tblBuku (
    id int not null auto_increment,
    idKategori int not null,
    judul varchar(100) not null,
    penulis varchar(100) not null,
    harga double not null,
    gambar varchar(200) not null,
    primary key(id),
    foreign key(idKategori) references tblKategori(id)
);

create table tblPembeli(
    id int not null auto_increment,
    nama varchar(60) not null,
    alamat varchar(100) not null,
    telp varchar(20) not null,
    primary key(id)
);

create table tblPesan(
    id int not null auto_increment,
    idPembeli int not null,
    idBuku int not null,
    jumlah int not null,
    tanggal bigint not null,
    primary key(id),
    foreign key(idPembeli) references tblPembeli(id),
    foreign key(idBuku) references tblBuku(id)
);