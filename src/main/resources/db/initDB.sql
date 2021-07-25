DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id bigint not null,
    age integer,
    dob date,
    email varchar(255),
    name varchar(255),
    primary key (id)
);
