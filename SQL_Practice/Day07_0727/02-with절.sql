--★ WITH ==> 1.가독성  2.성능향상

-- 원래 ver.
select *
from (select deptno, sum(sal) as dept_total from emp group by deptno)
where dept_total > (select sum(dept_total)/count(*) as dept_avg
from(select deptno, sum(sal) dept_total from emp group by deptno))
order by deptno;

-- with절
with
dept_costs AS (select deptno, sum(sal) dept_total from emp group by deptno),
avg_cost AS (select sum(dept_total)/count(*) as dept_avg from dept_costs)
select * from dept_costs
where dept_total > (select dept_avg from avg_cost)
order by deptno;

-- with절 예제
with
dept_costs as (select d.department_name, sum(e.salary) as dept_total
from employees e join departments d
on e.department_id = d.department_id
group by d.department_name),
avg_cost as (select sum(dept_total)/count(*) as dept_avg from dept_costs)
select * from dept_costs
where dept_total > (select dept_avg from avg_cost)
order by department_name;