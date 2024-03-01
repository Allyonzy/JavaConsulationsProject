-- insert into user_test(id, age, confirm_code, email, first_name, last_name, password, state)
-- values
--     (1, 45, null, 'test@ya.ru', 'Петр', 'Решетов', 'qweasd10', 'NOT_CONFIRMED'),
--     (2, 23, null, 'test@ya.ru', 'Иван', 'Иванов', 'qweasd11', 'NOT_CONFIRMED'),
--     (3, 12, null, 'test@ya.ru', 'Кристина', 'Цветкова', 'qweasd12', 'NOT_CONFIRMED'),
--     (4, 34, null, 'test@ya.ru', 'Стивен', 'Кинг', 'qweasd13', 'NOT_CONFIRMED'),
--     (5, 54, null, 'test@ya.ru', 'Роберт', 'Земекис', 'qweasd14', 'NOT_CONFIRMED'),
--     (6, 67, null, 'test@ya.ru', 'Айгуль', 'Садыкова', 'qweasd15', 'NOT_CONFIRMED');

insert into user_test(id, age, confirm_code, email, first_name, last_name, password)
values
    (1, 45, null, 'test@ya.ru', 'Петр', 'Решетов', 'qweasd10'),
    (2, 23, null, 'test@ya.ru', 'Иван', 'Иванов', 'qweasd11'),
    (3, 12, null, 'test@ya.ru', 'Кристина', 'Цветкова', 'qweasd12'),
    (4, 34, null, 'test@ya.ru', 'Стивен', 'Кинг', 'qweasd13'),
    (5, 54, null, 'test@ya.ru', 'Роберт', 'Земекис', 'qweasd14'),
    (6, 67, null, 'test@ya.ru', 'Айгуль', 'Садыкова', 'qweasd15');

insert into order_test(id, user_id, order_date)
values
    (1, 2, CURRENT_DATE),
    (2, 3, CURRENT_DATE),
    (3, 1, CURRENT_DATE),
    (4, 1, CURRENT_DATE),
    (5, 4, CURRENT_DATE);
