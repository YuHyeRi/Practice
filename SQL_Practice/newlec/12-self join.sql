-- self join : inner & outer
-- ==> 자기(테이블)가 자기(테이블)을 참조한다
--Q1. 직원명과 그 매니저의 직원명을 출력하라
select e.employee_id, e.first_name 직원명 , e2.manager_id, e2.first_name 매니저명
from employees e left outer join employees e2
on e.employee_id = e2.manager_id;