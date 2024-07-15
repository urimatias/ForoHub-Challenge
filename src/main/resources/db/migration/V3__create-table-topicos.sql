create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje varchar(900) not null,
    fecha datetime not null,
    estatus boolean not null,
    autor_id bigint not null,
    curso_id bigint not null,

    primary key(id),

    constraint fk_topicos_autor_id foreign key(autor_id) references autores(id),
    constraint fk_topicos_curso_id foreign key(curso_id) references cursos(id)

);
