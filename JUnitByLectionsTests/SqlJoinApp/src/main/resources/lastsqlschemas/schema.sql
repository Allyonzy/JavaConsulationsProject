--создание схемы данных
create schema if not exists account;

show search_path;

set search_path = 'account';

-- создание таблицы
create table if not exists account
(
    id         serial primary key, -- идентификатор строки, всегда уникальный, генерируется базой данных
    -- определяем столбцы
    first_name varchar(20),        -- строка максимальной длины 20
    last_name  varchar(20),
    age        integer check (age > 0 and age < 120)
);

-- добавление информации
insert into account.account(first_name, last_name, age)
values ('Роман', 'Полански', 45);
insert into account(first_name, last_name, age)
values ('Виктор', 'Китчет', 23);
insert into account(first_name, last_name, age)
values ('Наташа', 'Романова', 12);
insert into account(first_name, last_name, age)
values ('Ваня', 'Миниахметов', 43);
insert into account(first_name, last_name, age)
values ('Тyмур', 'Неверов', 78);

-- Исправить опечатку через функцию обновления
update account set first_name = 'Тимур'
where id = 16;

select *
from account;

-- delete
delete from account
where id > 7;

-- обновление информации
update account
set age = 28
where id = 1;

-- получение всех данных из таблицы
select *
from account;

-- получить только имена
select distinct first_name
from account;

-- получить имя и возраст с сортировкой по возрастанию возраста
select first_name, age
from account
order by age;

-- получить имя и возраст с сортировкой по убиванию возраста
select first_name, age
from account
order by age desc;

-- получить всех, кто старше 24 лет
select *
from account
where age > 24;

-- сколько людей старше 24-х лет
select count(*)
from account
where age > 24;

-- какие возраста встречаются?
select distinct(age)
from account;

-- какие возраста и сколько раз встречаются
select age, count(*)
from account
group by age;

create table if not exists account.car
(
    id       serial primary key,
    model    varchar(20),
    color    varchar(20),
    owner_id integer,
    -- внешний ключ, ссылка на строку из другой таблицы
    foreign key (owner_id) references account (id)
);

set search_path = 'account';

insert into car(model, color, owner_id)
values ('BMW', 'Black', 5);
insert into car(model, color, owner_id)
values ('Lada', 'Green', 5);
insert into car(model, color, owner_id)
values ('Kia', 'White', 1);
insert into car(model, color, owner_id)
values ('Toyota', 'Black', 2);
insert into car(model, color, owner_id)
values ('Toyota', 'Aqa', 3);
insert into car(model, color)
values ('Bugatti', 'Blue');

insert into car(model, color, owner_id)
values ('BMW', 'Black', 5),
       ('Lada', 'Green', 5),
       ('Kia', 'White', 1),
       ('Toyota', 'Black', 2),
       ('Toyota', 'Aqa', 3);

insert into car(model, color)
values ('Bugatti', 'Blue');

-- получить имя пользователя с id 5 и количество его машин
select id, first_name,
       (select count(*) from car where owner_id = 5) as cars_count
from account
where id = 5;


select
    ac.id,
    ac.last_name,
    c.model,
    c.color
from account as ac
    left join car c on ac.id = c.owner_id;

select
    ac.id,
    ac.last_name,
    c.model,
    c.color

from account as ac
         inner join car c on ac.id = c.owner_id;

select
    ac.id,
    ac.last_name,
    c.model,
    c.color,
    count(c.owner_id) as count_cars,
    count(c.owner_id) as sum_cars
from car c
inner join account ac on c.owner_id = ac.id
group by ac.id, ac.last_name, c.model, c.color;

-- пример с подзапросами
with cars_with_owners as
    (
        select
            ac.id,
            ac.last_name,
            c.model,
            c.color,
            count(c.owner_id) as count_cars,
            count(c.owner_id) as sum_cars
        from car c
                 inner join account ac on c.owner_id = ac.id
        group by ac.id, ac.last_name, c.model, c.color
    )
SELECT
    cwow.id,
    cwow.last_name,
    string_agg(cwow.model::text, ',') as car_models,
    string_agg(cwow.color::text, ',') as car_models,
    count(cwow.count_cars),
    sum(cwow.sum_cars)
FROM cars_with_owners cwow
group by cwow.id, cwow.last_name;


select
    ac.id,
    ac.last_name,
    c.model,
    c.color
from account as ac
         left join car c on ac.id = c.owner_id
where c.owner_id is null;

select
    ac.id,
    ac.last_name,
    c.model,
    c.color
from account as ac
         right join car c on ac.id = c.owner_id;

select
    ac.id,
    ac.last_name,
    c.model,
    c.color
from account as ac
         full outer join car c on ac.id = c.owner_id;

-- получить имена пользователей  и количество его машин
select first_name, (select count(*) from car where owner_id = account.id) as cars_count
from account;

-- получить имена пользователей, у которых машины черного цвета
select first_name
from account
where account.id in
      (select owner_id from car where color = 'Black');

-- все владельцы, и машины у которых есть владелец
select *
from account a
         left join car c on a.id = c.owner_id;

-- все машины, и владельцы у которых есть машины
select *
from account a
         right join car c on a.id = c.owner_id;

-- только машины и владельцы, которые есть друг у друга
select *
from account a
         inner join car c on a.id = c.owner_id;

-- все владельцы, все машины
select *
from account a
         full join car c on a.id = c.owner_id;
