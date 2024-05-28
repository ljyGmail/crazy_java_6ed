# Chapter 13 MySQL数据库与JDBC编程

* 创建表并插入一些数据

```
create table teacher_table
(
    teacher_id int auto_increment,
    teacher_name varchar(255),
    primary key (teacher_id)
);

create table student_table
(
    student_id int auto_increment primary key ,
    student_name varchar(255),
    java_teacher int references teacher_table(teacher_id)
);

insert into teacher_table values (null, "李刚");
insert into teacher_table values (null, "메타코딩");
insert into teacher_table values (null, "Zhang JiKe");

insert into student_table values (null, "One", 1);
insert into student_table values (null, "Two", 1);
insert into student_table values (null, "Three", 1);
insert into student_table values (null, "Four", 2);
insert into student_table values (null, "Five", 2);

select *
from teacher_table;

select *
from student_table;
```

* 创建存储过程

```
delimiter //
create procedure add_pro(a int, b int, out sum int)
begin
    set sum = a + b;
end;
//
```

* 创建带有blob列的表用来保存图片

```
create table img_table
(
    img_id int auto_increment primary key ,
    img_name varchar(255),
    img_data mediumblob
);

select *
from img_table;
```
