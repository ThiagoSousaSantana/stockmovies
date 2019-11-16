create table user
(
    id       bigint auto_increment
        primary key,
    email    varchar(255) null,
    name     varchar(255) null,
    password varchar(255) null
);

INSERT INTO stockmovies.user (id, email, name, password) VALUES (3, 'thiago91098@gmail.com', 'Thiago', '123');