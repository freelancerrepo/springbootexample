create table department
(
   department_id integer not null,
   name varchar(255) not null,
   description varchar(255) not null,
   primary key(department_id)
);

create table employee
(
   id integer not null,
   firstname varchar(255) not null,
   lastname varchar(255) not null,
   city varchar(255) not null,
   primary key(id),
   department_id integer,
   CONSTRAINT fk_employee FOREIGN KEY (department_id) REFERENCES DEPARTMENT(department_id)
);
