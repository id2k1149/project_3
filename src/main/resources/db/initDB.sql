DROP TABLE IF EXISTS student;

CREATE TABLE student
(
    id bigint not null,
    age integer,
    dob date,
    email varchar(255),
    name varchar(255),
    primary key (id)
);
