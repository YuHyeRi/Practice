-- Q1. 'CLARK'보다 높은 급여를 받는 사원들의 이름과 월급을 출력하고 월급 오름차순으로 정렬하라
select ename, sal from emp
where sal > (select sal from emp where ename = 'CLARK')
order by 2;

-- Q2. 이름이 5글자인 사원 중 급여가 가장 적은 사원의 이름, 부서명, 급여를 출력하라
select ename, dname, sal
from emp e, dept d
where e.deptno = d.deptno
and sal = (select min(sal) from emp where length(ename) = 5)
and length(ename) = 5;
