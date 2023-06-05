-- liquibase formatted sql

-- changeset elizaveta:3
CREATE TABLE hard_drive
(
    id            BIGSERIAL NOT NULL PRIMARY KEY,
    class         VARCHAR   NOT NULL,
    series_number VARCHAR   NOT NULL,
    manufacturer  VARCHAR   NOT NULL,
    price         BIGINT    NOT NULL,
    amount        BIGINT    NOT NULL,
    capacity      BIGINT    NOT NULL
);