-- Q1. JONES 보다 더 많은 월급을 받는 사원들의 이름과 월급을 출력하라
select ename, sal from emp
where sal > (select sal from emp where ename = 'JONES');

-- Q2. 최대(MAX)월급을 받는 사원의 이름과 월급을 출력하라
select ename, sal from emp
where sal = (select max(sal) from emp);

-- Q3. 평균급여보다 높은 사원의 이름, 월급, 부서정보, 평균급여를 출력하라
-- ★ CROSS JOIN : 한 쪽 테이블의 모든 행들과 다른 테이블의 모든 행을 조인시킴
select ename, sal, dname, round(avg_sal)
from emp e join dept d
on e.deptno = d.deptno
cross join (select avg(sal) avg_sal from emp)
where sal > avg_sal;

-- Q4. 소속부서의 평균보다 급여를 많이 받는 사원들의 이름, 월급, 부서를 출력하라
select deptno, ename, sal
from emp e
where sal > (select avg(sal) from emp where deptno = e.deptno)
order by sal desc;

-- Q4. 소속부서의 평균보다 급여를 많이 받는 사원들의 이름, 월급, 부서를 부서별 평균 급여와 같이 출력하라
select a.deptno, ename, sal, avgsal
from emp e, (select deptno, round(avg(sal)) as avgsal from emp group by deptno) a
where e.deptno = a.deptno
and e.sal > a.avgsal
order by 3 desc;

-- Q5. SCOTT와 같은 월급을 받는 사원들의 이름과 월급을 출력하라 (SCOTT는 제외)
select ename, sal from emp
where sal = (select sal from emp where ename = 'SCOTT')
and ename != 'SCOTT';

-- Q6. ALLEN보다 늦게 입사한 사원들의 이름과 임사일을 출력하라
select ename, hiredate from emp
where hiredate > (select hiredate from emp where ename = 'ALLEN')
order by hiredate;

-- Q7. ALLEN과 같은 부서번호에서 근무하는 사원들의 이름과 부서번호를 출력하라
select ename, deptno from emp
where deptno = (select deptno from emp where ename = 'ALLEN');