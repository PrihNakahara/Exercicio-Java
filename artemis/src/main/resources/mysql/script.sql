CREATE  DATABASE artemis;
USE artemis;

create table user(
    id integer primary key not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null,
    login varchar (20) not null,
    senha varchar (20) not null
);

drop table user;

INSERT INTO user (nome, email, login, senha) VALUES ("Priscila Nakahara", "pri@mail.com","pri@mail.com","xpxpxp");
INSERT INTO user (nome, email, login, senha) VALUES ("Jonathan Nakahara", "jonathan_o_j","jonathan_o_j","jojojo");

SELECT * FROM user;
