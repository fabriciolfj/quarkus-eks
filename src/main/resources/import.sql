BEGIN;

DROP SCHEMA IF EXISTS public CASCADE;

CREATE SCHEMA public;

CREATE SEQUENCE public.product_id_seq
    INCREMENT 1
    START 25
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

CREATE SEQUENCE public.category_id_seq
    INCREMENT 1
    START 25
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

create table public.category(
id          int8            not null default nextval('public.category_id_seq'::regclass)
describe    varchar(255)    not null,
constraint  pk_category     primary key (id))

create table public.product(
id          int8                not null default nextval('public.product_id_seq'::regclass),
code        varchar(255)        not null,
describe    varchar(255)        not null,
price       numeric(15,4)       not null,
category_id int8                not null,
constraint  pk_product          primary key (id),
constraint  uk_code             unique (code)
constraint fk_category_product  foreign key(category_id) references product (id) )