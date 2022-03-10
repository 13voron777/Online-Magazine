use onlinemagazine;

CREATE  TABLE users (
                        username VARCHAR(30) NOT NULL,
                        password VARCHAR(30) NOT NULL,
                        enabled TINYINT DEFAULT 1,
                        PRIMARY KEY (username)
);

CREATE TABLE user_roles (
                            role_id int NOT NULL AUTO_INCREMENT,
                            username varchar(30) NOT NULL,
                            role varchar(30) NOT NULL,
                            PRIMARY KEY (role_id),
                            FOREIGN KEY (username) REFERENCES users (username)
);

create table journal(
                        journal_id int auto_increment not null,
                        name varchar(30) not null,
                        description varchar(30) not null,
                        primary key(journal_id)
);

create table article(
                        article_id int auto_increment not null,
                        header varchar(30) not null,
                        content varchar(30) not null,
                        journal int not null,
                        primary key(article_id),
                        foreign key (journal) references journal(journal_id)
);

/*insert into profile(first_name, last_name, email, phone)
values ('Ivan', 'Petrov', 'petrov@mail.ru', '+12345678'),
       ('Petr', 'Ivanov', 'ivanov@gmail.com', '+87654321');

insert into users(username, password, profile_id, enabled)
values ('Admin', '{noop}123', '1', true),
       ('User1', '{noop}123', '2', true);

insert into user_roles(username, role)
values  ('admin', 'ROLE_ADMIN'),
        ('user1', 'ROLE_USER');

insert into journal(journal_name, genre, periodicity, cost)
values ('Driver', 'Auto', 'Once a week', '3'),
       ('Garden', 'Gardening', 'Once a week', '2'),
       ('Gamer', 'Video games', 'Once a month', '5');

insert into users_journal(username, journal_id)
values ('Admin', '1'),
       ('Admin','3'),
       ('User1','2');*/
