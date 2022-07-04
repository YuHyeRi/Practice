-- ★ 3 way join
select first_name, department_name, city
from employees e, departments d, locations l
where e.department_id = d.department_id and d.location_id = l.location_id;

-- ★ 3 way join : ANSI syntax
select first_name, department_name, city
from employees e JOIN departments d ON (e.department_id = d.department_id)
                 JOIN locations l ON (d.location_id = l.location_id);

-- country ID 추가
-- 사원의 이름, 부서이름, city, 국가명, region
select first_name, department_name, city, country_name, region_name
from employees e, departments d, locations l, countries c, regions r
where e.department_id = d.department_id and d.location_id = l.location_id
and l.country_id = c.country_id and c.region_id = r.region_id;

-- ANSI syntax
select first_name, department_name, city, country_name, region_name
from employees e JOIN departments d ON (e.department_id = d.department_id)
                 JOIN locations l ON (d.location_id = l.location_id)
                 JOIN countries c ON (l.country_id = c.country_id)
                 JOIN regions r ON (c.region_id = r.region_id);
