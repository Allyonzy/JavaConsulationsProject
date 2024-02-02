
-- create database shop
--     with owner postgres;

-- comment on database shop is 'База данных магазина';

-- \connect shop;

-- создание таблиц
create table if not exists account
(
    id         serial primary key,
    first_name varchar(20),
    last_name  varchar(20),
    age        integer
        constraint account_age_check
            check ((age > 0) AND (age < 120))
);

-- таблица продуктов
create table if not exists product
(
    id         serial primary key, -- идентификатор строки, всегда уникальный, генерируется базой данных
    -- определяем столбцы
    name varchar(20),        -- строка максимальной длины 20
    cost integer check (cost > 0)
);

-- таблица корзины покупателей
create table if not exists basket
(
    id         serial primary key, -- идентификатор строки, всегда уникальный, генерируется базой данных
    account_id integer references account(id),
    product_id integer references product(id),
    order_date timestamp
    -- foreign key (account_id) references account(id)
);

-- insert таблиц
insert into account(first_name, last_name, age)
VALUES
    ('Павел', 'Петров', 15),
    ('Светлана', 'Арзамасова', 45),
    ('Виктор', 'Логинов', 43),
    ('Айгуль', 'Садыкова', 25),
    ('Дмитрий', 'Петров', 88);

-- insert таблиц
insert into product(name, cost)
VALUES
    ('книга', 500),
    ('мяч', 1500),
    ('шкаф', 5000);

-- insert таблиц
insert into basket(account_id, product_id, order_date)
VALUES
    (3, 2, CURRENT_DATE),
    (1, 2, now()),
    (5, 3, now()),
    (4, 1, CURRENT_DATE);

select *
from basket;

SELECT now();
SELECT CURRENT_DATE;
SELECT now()::timestamp;

show timezone;
select '2021-10-01 12:34:56 Europe/Moscow' :: timestamptz;
select '2021-10-01 12:34:56' :: timestamp;

select * from pg_timezone_names
where abbrev='MSK';


-- запрос к таблице
SELECT *
FROM product;

SELECT *
FROM account
WHERE age > 40
ORDER BY last_name DESC;