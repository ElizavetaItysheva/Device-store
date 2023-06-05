-- liquibase formatted sql

-- changeset elizaveta:1
CREATE TABLE desktops
(
    id            BIGSERIAL NOT NULL PRIMARY KEY,
    class         VARCHAR   NOT NULL,
    series_number VARCHAR   NOT NULL,
    manufacturer  VARCHAR   NOT NULL,
    price         BIGINT    NOT NULL,
    amount        BIGINT    NOT NULL,
    form_factor   VARCHAR   NOT NULL
);