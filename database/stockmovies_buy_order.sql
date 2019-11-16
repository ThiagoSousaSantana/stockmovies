create table buy_order
(
    id       bigint auto_increment
        primary key,
    date     datetime       null,
    price    decimal(19, 2) null,
    quantity bigint         not null,
    movie_id int            not null,
    user_id  bigint         null,
    constraint FKhvhit9b5mch45haltxjsnx71d
        foreign key (movie_id) references movie (id),
    constraint FKji22wht1pt1shs9nv11y2rw28
        foreign key (user_id) references user (id)
);

