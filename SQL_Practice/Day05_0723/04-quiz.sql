-- Q1. 사원의 이름과 부서명을 조회하세요
-- ver.1
select ename 이름, dname 부서명
from emp e, dept d
where e.deptno = d.deptno;
-- ver.2
select ename 이름, dname 부서명
from emp e natural join dept d;
-- ver.3
select ename 이름, dname 부서명
from emp e join dept d
using (deptno);
-- ver.4
select ename, dname
from emp e join dept d
on e.deptno = d.deptno;

-- Q2. 사원의 이름과 근무지를 조회하세요
select ename 이름, loc 근무지
from emp e, dept d
where e.deptno = d.deptno;

-- Q3. 사원의 급여가 어느등급에 해당하는지 사원이름과 급여, 등급을 조회하세요
-- ver.1
select ename, sal, grade
from emp, salgrade
where sal between losal and hisal;
-- ver.2
select ename, sal, grade
from emp join salgrade
on sal between losal and hisal;

-- Q4. 각 사원별로 사원의 이름과 상사의 이름을 조회하세요
-- ver.1
select w.ename 사원명, m.ename 상사명
from emp w, emp m
where w.mgr = m.empno;
-- ver.2
select w.ename 사원명, m.ename 상사명
from emp w join emp m
on w.mgr = m.empno;