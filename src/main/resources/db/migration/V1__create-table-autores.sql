create table autores(

    id bigint not null auto_increment,
    nombre varchar(100) not null unique,
    email varchar(100) not null,
    contraseña varchar(300) not null,

    primary key(id)

);