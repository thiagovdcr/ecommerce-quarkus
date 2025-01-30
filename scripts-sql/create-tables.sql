DROP DATABASE IF EXISTS product;

CREATE DATABASE IF NOT EXISTS product;

CREATE TABLE `product_category` (
  `id_product_category` BIGINT AUTO_INCREMENT UNIQUE PRIMARY KEY,
  `description` varchar(1),
  `code` integer
);

CREATE TABLE `product` (
  `id_product` BIGINT AUTO_INCREMENT UNIQUE PRIMARY KEY,
  `name` varchar(255),
  `description` varchar(500),
  `price` double,
  `product_stock` integer,
  `id_product_category` BIGINT,
  `product_image` bytea,
  `created_at` datetime DEFAULT (now()),
  `update_at` datetime
);

CREATE TABLE `customer` (
  `id_customer` BIGINT AUTO_INCREMENT UNIQUE PRIMARY KEY,
  `document_number` varchar(1),
  `email` varchar(1),
  `phone_number` varchar(1),
  `created_at` datetime DEFAULT (now()),
  `update_at` datetime
);

CREATE TABLE `customer_address` (
  `id_customer_address` BIGINT AUTO_INCREMENT UNIQUE PRIMARY KEY,
  `id_address` BIGINT,
  `id_customer` BIGINT,
  `created_at` datetime DEFAULT (now()),
  `update_at` datetime
);

CREATE TABLE `user_profile` (
  `id_user_profile` BIGINT AUTO_INCREMENT UNIQUE PRIMARY KEY,
  `description` varchar(1),
  `value` integer
);

CREATE TABLE `customer_autentication` (
  `id_customer_autentication` BIGINT AUTO_INCREMENT UNIQUE PRIMARY KEY,
  `id_customer` BIGINT,
  `id_user_profile` BIGINT,
  `password` varchar(1),
  `created_at` datetime DEFAULT (now()),
  `update_at` datetime
);

CREATE TABLE `address` (
  `id_address` BIGINT AUTO_INCREMENT UNIQUE PRIMARY KEY,
  `street_address` varchar(1),
  `id_city` integer,
  `zip_code` varchar(1),
  `created_at` datetime DEFAULT (now()),
  `update_at` datetime
);

CREATE TABLE `state` (
  `id_state` BIGINT AUTO_INCREMENT UNIQUE PRIMARY KEY,
  `uf_code` integer,
  `name` varchar(50),
  `uf` char(2),
  `region` integer
);

CREATE TABLE `city` (
  `id_city` BIGINT AUTO_INCREMENT UNIQUE PRIMARY KEY,
  `id_state` BIGINT,
  `name` varchar(255)
);

CREATE TABLE `sale_order` (
  `id_sale_order` BIGINT AUTO_INCREMENT UNIQUE PRIMARY KEY,
  `id_costumer` BIGINT,
  `id_customer_address` BIGINT,
  `total_amount` double,
  `order_date` datetime DEFAULT (now()),
  `created_at` datetime DEFAULT (now()),
  `update_at` datetime DEFAULT (now())
);

CREATE TABLE `sale_order_item` (
  `id_sale_order_item` BIGINT AUTO_INCREMENT UNIQUE PRIMARY KEY,
  `id_sale_order` BIGINT,
  `id_product` BIGINT,
  `quantity` integer,
  `created_at` datetime DEFAULT (now()),
  `update_at` datetime DEFAULT (now())
);

ALTER TABLE `product` ADD FOREIGN KEY ("id_product_category") REFERENCES `product_category`(`id_product_category`);

ALTER TABLE `customer_address` ADD FOREIGN KEY ("id_address") REFERENCES `address`(`id_address`);

ALTER TABLE `customer_address` ADD FOREIGN KEY ("id_customer") REFERENCES `customer`(`id_customer`);

ALTER TABLE `customer_autentication` ADD FOREIGN KEY ("id_customer") REFERENCES `customer`(`id_customer`);

ALTER TABLE `customer_autentication` ADD FOREIGN KEY ("id_user_profile") REFERENCES `user_profile`(`id_user_profile`);

ALTER TABLE `address` ADD FOREIGN KEY ("id_city") REFERENCES `city`(`id_city`);

ALTER TABLE `city` ADD FOREIGN KEY ("id_state") REFERENCES `state`(`id_state`);

ALTER TABLE `sale_order` ADD FOREIGN KEY ("id_costumer") REFERENCES `customer`(`id_customer`);

ALTER TABLE `sale_order` ADD FOREIGN KEY ("id_customer_address") REFERENCES `customer_address`(`id_customer_address`);

ALTER TABLE `sale_order_item` ADD FOREIGN KEY ("id_sale_order") REFERENCES `sale_order`(`id_sale_order`);

ALTER TABLE `sale_order_item` ADD FOREIGN KEY ("id_product") REFERENCES `product`(`id_product`);

