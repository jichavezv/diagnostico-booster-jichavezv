create sequence tbl_usuario_seq start with 1 increment by 50;
create table tbl_usuario (id bigint not null, nombre_usuario varchar(255), password varchar(255), rol varchar(255), primary key (id));
