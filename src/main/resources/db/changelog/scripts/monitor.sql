-- liquibase formatted sql

-- changeset elizaveta:4
CREATE TABLE monitors
(
    id            BIGSERIAL        NOT NULL PRIMARY KEY,
    class         VARCHAR          NOT NULL,
    series_number VARCHAR          NOT NULL,
    manufacturer  VARCHAR          NOT NULL,
    price         BIGINT           NOT NULL,
    amount        BIGINT           NOT NULL,
    diagonal      DOUBLE PRECISION NOT NULL
);