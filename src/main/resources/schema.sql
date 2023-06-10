CREATE TABLE books (
    id varchar(36) NOT NULL ,
    published_at varchar(100) NOT NULL,
    title varchar(100) DEFAULT NULL,
    language varchar(100) DEFAULT NULL,
    country_origin varchar(100) DEFAULT NULL,
    isbn varchar(100) DEFAULT NULL,
    PRIMARY KEY (id)
);