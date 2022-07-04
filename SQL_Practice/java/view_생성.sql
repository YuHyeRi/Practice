select * from employees;
select * from departments;

-- view (가상테이블) 생성
-- 복잡한 sql문을 짧게 내가 원하는 것만 쓸 수 있다
create or replace view emp_v
as 
select employee_id, first_name, salary, department_name
from employees e, departments d
where e.department_id = d.department_id;