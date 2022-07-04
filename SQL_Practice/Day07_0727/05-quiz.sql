-- Q1. 과거에 근무했던 부서와 직무로 복귀한 사원을 출력하라
select employee_id, department_id, job_id from employees
intersect
select employee_id, department_id, job_id from job_history;

-- Q2. 입사이래 부서와 직무를 바꾸지 않은 사원을 출력하라
select employee_id, department_id, job_id from employees
minus
select employee_id, department_id, job_id from job_history;

-- Q3. ROLLUP
select deptno, job, sum(sal)
from emp
group by rollup (deptno, job)
order by 1, 2;

-- 위 rollup을 풀어써보자면..
select deptno, job, sum(sal)    -- 합칠 셀렉문의 갯수가 맞아야한다
from emp
group by deptno, job
union all
select deptno, null, sum(sal)   -- 뿌려줄게 없다면 'null'
from emp
group by deptno
union all
select null, null, sum(sal)
from emp
order by 1;
