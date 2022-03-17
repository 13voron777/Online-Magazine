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
                        description VARCHAR(200) NOT NULL,
                        PRIMARY KEY(journal_id)
);

create table articles (
                        article_id INT auto_increment NOT NULL,
                        header VARCHAR(30) NOT NULL,
                        content VARCHAR(300) NOT NULL,
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

INSERT INTO users (username, password, enabled)
VALUES ('admin', '{noop}admin', 1),
       ('user', '{noop}user', 1);

INSERT INTO user_roles(username, role)
VALUES ('admin', 'ROLE_ADMIN'),
       ('admin', 'ROLE_USER'),
       ('user', 'ROLE_USER');
