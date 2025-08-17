CREATE TABLE usuarios(
            id BIGINT NOT NULL PRIMARY KEY auto_increment,
            login VARCHAR(100) NOT NULL,
            senha  VARCHAR(255) NOT NULL
);