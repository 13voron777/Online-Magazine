use onlinemagazine;

CREATE  TABLE users (
                        username VARCHAR(30) NOT NULL,
                        password VARCHAR(30) NOT NULL,
                        enabled TINYINT DEFAULT 1,
                        PRIMARY KEY (username)
);

CREATE TABLE user_roles (
                            role_id INT NOT NULL AUTO_INCREMENT,
                            username VARCHAR(30) NOT NULL,
                            role VARCHAR(30) NOT NULL,
                            PRIMARY KEY (role_id),
                            FOREIGN KEY (username) REFERENCES users (username)
                            ON DELETE CASCADE
);

create table journals (
                        journal_id INT auto_increment NOT NULL,
                        name VARCHAR(30) NOT NULL,
                        description VARCHAR(30) NOT NULL,
                        PRIMARY KEY(journal_id)
);

create table articles (
                        article_id INT auto_increment NOT NULL,
                        header VARCHAR(30) NOT NULL,
                        content VARCHAR(30) NOT NULL,
                        journal INT NOT NULL,
                        PRIMARY KEY(article_id),
                        FOREIGN KEY(journal) REFERENCES journals(journal_id)
                        ON DELETE CASCADE
);

create table users_journal (
                          username VARCHAR(30) NOT NULL,
                          journal_id INT NOT NULL,
                          PRIMARY KEY(username, journal_id),
                          FOREIGN KEY(username) REFERENCES users(username)
                          ON DELETE CASCADE,
                          FOREIGN KEY(journal_id) REFERENCES journals(journal_id)
                          ON DELETE CASCADE
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
