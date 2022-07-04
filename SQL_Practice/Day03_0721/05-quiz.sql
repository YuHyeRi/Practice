-- 문제1
select ename, sal
from emp
where sal = 3000;

-- 문제2
select ename, sal
from emp
where job = 'SALESMAN';

-- 문제16
select ename
from emp
where ename not like 'S%';

-- 문제17
select empno, ename
from emp
where empno=7788 or empno=7902 or empno=7369;
-- 문제17 다른 ver.
select empno, ename
from emp
where empno in('7782','7902','7369');

-- 문제24
select ename, hiredate
from emp
where deptno not in(10,20)
order by hiredate;

-- 문제25
select ename as 이름, sal as 월급, hiredate as 입사일
from emp
where hiredate not between '81/01/01' and '81/12/31'
order by sal desc;
-- 문제25 ver.2
select ename as "이름", sal as "월급" , hiredate as "입사일" 
from emp
where hiredate<'81/01/01' or hiredate>'81/12/31'
order by sal desc;