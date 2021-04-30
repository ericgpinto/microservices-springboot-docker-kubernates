 create schema if not exists products;

create table products.category(
    id bigserial primary key,
    name varcha(100) not null
);