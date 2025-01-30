CREATE USER 'product_user'@'%' IDENTIFIED BY 'mysql';

CREATE DATABASE IF NOT EXISTS product;

GRANT ALL PRIVILEGES ON product.* TO 'product_user'@'%';

FLUSH PRIVILEGES;
