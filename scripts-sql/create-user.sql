-- Execute with postgres user

CREATE ROLE product_user WITH LOGIN PASSWORD 'postgres';

CREATE DATABASE product WITH OWNER = product_user;

ALTER ROLE product_user SET search_path TO product;

GRANT CREATE ON DATABASE product TO product_user;
