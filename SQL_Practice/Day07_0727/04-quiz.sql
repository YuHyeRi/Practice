-- Q1. Adam에게 보고하는 모든 사원의 이름, 급여, 입사일자를 출력하라
select first_name, salary, hire_date
from employees
where manager_id = (select employee_id from employees where first_name = 'Adam');

-- Q2. 'ACCOUNTING' 부서에 근무하는 사원들의 정보를 출력하라
-- 서브쿼리 ver.
select ename, deptno, sal
from emp
where deptno = (select deptno from dept where dname = 'ACCOUNTING');
-- 조인 ver.
select ename, dname, sal
from emp e, dept d
where e.deptno = d.deptno
and d.dname = 'ACCOUNTING';

-- Q3. 평균급여보다 높은 급여를 받고, last name에 'u'가 포함된 사원과 동일부서에 근무하는 사원을 출력하라
select employee_id, last_name, salary
from employees
where salary > (select avg(salary) from employees)
and last_name like '%u%'
order by salary;

-- Q4. 사원이 없는 모든 모든 부서의 부서번호, 부서명을 출력하라
-- NOT EXISTS ver.
select department_id, department_name
from departments d
where not exists (select null from employees where department_id = d.department_id);
-- NOT IN ver : AND
select department_id, department_name 
from departments
where department_id NOT IN (select department_id from employees where department_id is not null);
-- RIGHT OUTER JOIN ver.
select d.department_id, department_name
from employees e right outer JOIN departments d
ON e.department_id = d.department_id
where e.department_id is null
order by 1;