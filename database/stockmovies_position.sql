create table position
(
    id           bigint auto_increment
        primary key,
    medium_price decimal(19, 2) null,
    quantity     bigint         not null,
    movie_id     int            null,
    user_id      bigint         null,
    constraint FKjmw29eckwum6dcll6sknilc6u
        foreign key (user_id) references user (id),
    constraint FKmsg3ik4atvpoagwmf4br5y90w
        foreign key (movie_id) references movie (id)
);

