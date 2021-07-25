DROP TABLE IF EXISTS user;

create table user (
      id bigint not null,
      email varchar not null,
      password varchar not null,
      primary key (id)
);
