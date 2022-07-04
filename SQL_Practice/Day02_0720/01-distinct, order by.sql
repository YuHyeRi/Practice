-- 대체 인용 연산자
-- 1. q'[ 내용 작성 ]' ==> []는 다른 특수문자를 써도 가능! (ex. (), #,...)
select q'(Mother's Day)'
from dual;

-- 2. 인용부호 안에서 ' 하나 더 쓰기 ==> 얘가 더 간단해서 많이 쓰임
select 'Mother''s Day'
from dual;

-- distinct : 중복행을 제거하고 unique하게 보여준다 (단, sort는 안된다)
-- select all(디폴트값) deptno from emp;
select distinct deptno 
from emp;

-- 관련문제
select distinct job
from emp;

-- order by : 정렬하라 (1순위 deptno, 2순위 job)
select distinct deptno, job
from emp
order by deptno, job;

-- 관련 예제
select distinct department_id
from employees
order by department_id;

select distinct job_id
from employees;