create database jdbc_demo;

use jdbc_demo;

drop  table if exists employee;
create table employee (emp_id bigint auto_increment primary key ,emp_fn varchar(100) , emp_ln varchar(100));
insert into employee(emp_fn,emp_ln) values('anil','sharma');
#select * from employee;

drop table if exists employee_phone;
create table employee_phone(emp_id bigint ,emp_phone_cde varchar(5),emp_phone varchar(10));
ALTER TABLE employee_phone ADD constraint employee_phone_employee_pk primary key(emp_id);
ALTER TABLE employee_phone ADD constraint employee_phone_employee_fk  FOREIGN KEY (emp_id) REFERENCES employee(emp_id);
commit;


#select * from employee_phone;