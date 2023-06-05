-- liquibase formatted sql

-- changeset elizaveta:2
CREATE TABLE laptops
(
    id            BIGSERIAL NOT NULL PRIMARY KEY,
    class         VARCHAR   NOT NULL,
    series_number VARCHAR   NOT NULL,
    manufacturer  VARCHAR   NOT NULL,
    price         BIGINT    NOT NULL,
    amount        BIGINT    NOT NULL,
    inches        VARCHAR   NOT NULL
);