--переключиться на работу со схемой по умолчанию
set search_path = 'college_db';

select * from college;

select
    s.id,
    s.name,
    s.city,
    s.telegram_contact,
    c.name as college_name
from student s
join college c on c.id = s.college_id;

select
    s.id,
    s.name,
    avg(sonc.student_rating),
    count(sonc.id),
    s.city,
    s.telegram_contact,
    c.name as college_name
from student s
join college c on c.id = s.college_id
join student_on_course sonc on sonc.student_id = s.id
group by s.id, s.name, s.city, s.telegram_contact, college_name;

with avg_rating as (
    select
        s.id,
        s.name,
        avg(sonc.student_rating) as avg_course_rating,
        count(sonc.id),
        s.city,
        s.telegram_contact,
        c.name as college_name
    from student s
             join college c on c.id = s.college_id
             join student_on_course sonc on sonc.student_id = s.id
    group by s.id, s.name, s.city, s.telegram_contact, college_name
)

select
    avgr.id,
    avgr.name,
    avgr.avg_course_rating,
    avgr.city,
    avgr.college_name,
--     soncr.course_id,
--     cour.name,
    string_agg(cour.name::text, ',') as couse_list,
--     cour.college_id,
    string_agg(c.name::text, ',') as courses_college_list
from avg_rating avgr
join student_on_course soncr on soncr.student_id = avgr.id
join course cour on cour.id = soncr.course_id
left join college c on c.id = cour.college_id
group by avgr.id, avgr.name,avgr.city, avgr.college_name, avgr.avg_course_rating;

with student_info as (
    select
        s.id as student_id,
        s.name as student_name,
        s.city,
        s.telegram_contact,
        c.id as college_id,
        c.name as college_name
    from student s
    join college c on s.college_id = c.id
)

select
    cour.id as course_id,
    cour.name as course_name,
    cour.is_online,
    cour.college_id as course_uni,
    c.name as course_ini_name,
    si.*
from course cour
join college c on c.id = cour.college_id
join student_on_course soc on soc.course_id = cour.id
join student_info si on si.student_id = soc.student_id
order by course_ini_name;


with student_full_rating as (
    select
        s.name,
        avg(sonc.student_rating) as avg_rating,
        count(sonc.id) as course_number,
        c.name as college_name
    from student s
             join college c on c.id = s.college_id
             join student_on_course sonc on sonc.student_id = s.id
    group by s.name, college_name
)

select *
from student_full_rating
where avg_rating > 60
order by avg_rating DESC;

select
    c.college_id,
    clg.name as college_name,
    count(soc.course_id)  as course_num
from student_on_course soc
join course c on c.id = soc.course_id
join college clg on clg.id = c.college_id
group by c.college_id, college_name
order by course_num DESC;


create view student_info as (
    select
        s.id as student_id,
        s.name as student_name,
        s.city,
        s.telegram_contact,
        c.id as college_id,
        c.name as college_name
    from student s
             join college c on s.college_id = c.id
);

select
    si.student_id,
    si.college_id,
    si.student_name,
    si.college_name,
    si.city
from student_info si
where city = 'Казань';
--todo дописать условие

select c.*
    from college c;

update college
set name = 'Казанский Федеральный'
where id = 10;

update college
set name = 'КФУ'
where id = 10;

update college
set size = size + 100
where id = 30;

select *
from course;

select *
from student_on_course;

delete from student_on_course
where course_id = 50;

delete from course
where id = 50;


