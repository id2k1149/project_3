DROP TABLE IF EXISTS appUser;

create table appUser (
      id bigint not null,
      email varchar not null,
      password varchar not null,
      primary key (id)
);
