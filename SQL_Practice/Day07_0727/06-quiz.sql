-- 문제1. 이름과 부서위치를 출력하시오
select ename, loc
from emp e, dept d
where e.deptno = d.deptno;

-- 문제5. 월급이 3000 이상인 사원들의 이름과 월급과 부서위치를 출력하시오
select ename, sal, loc
from emp e, dept d
where e.deptno = d.deptno
and sal >= 3000;

--문제9. 부서위치, 부서위치별 토탈월급을 출력하는데 가로로 출력하시오
--decode : 칼럼명, '찾을문자', '계산식'
select sum(decode(loc, 'NEW YORK', sal, 0)) "NEW YORK",
       sum(decode(loc, 'DALLSA', sal, 0)) "DALLSA",
       sum(decode(loc, 'CHICAGO', sal, 0)) "CHICAGO", 
       sum(decode(loc, 'BOSTON', sal, 0)) "BOSTON"
from emp e join dept d
on (e.deptno = d.deptno);

--문제13.  부서위치, 부서위치별 토탈월급을 출력하시오 (위와 중복)
select loc, sum(sal)
from emp e full outer join dept d
on (e.deptno = d.deptno)
group by loc;

--문제17. 사원이름, 관리자 이름을 출력하는데 관리자보다 먼저 입사한 사원들만 출력하시오
select w.ename 사원명, m.ename 관리자명
from emp w, emp m
where w.mgr = m.empno
and w.hiredate < m.hiredate ;

--문제21. 이름, 월급, 부서위치, 급여등급을 출력하는데 ON 절을 사용한 조인으로 수행하시오
--SELECT * FROM 테이블1 LEFT JOIN 테이블2 ON 조인할거 JOIN 테이블3 ON 조인할거;
select ename, sal, loc, grade
from emp e join dept d
on e.deptno = d.deptno
join salgrade
on e.sal between losal and hisal;

--문제6. SCOTT 과 같은 직업을 갖는 사원들의 이름과 직업을 출력하는데 SCOTT 은 제외하고 출력하시오
select ename, job
from emp
where job = (select job from emp where ename = 'SCOTT')
and ename not in ('SCOTT');

-- 문제10. 관리자인 사원들의 이름을 출력하시오 ! ( 자기 밑에 직속 부하 사원이 한명이라도 있는 사원 )
-- 이 사원들의 사원번호는 자기 부하 사원들의 MGR 번호이다.
-- "mgr 번호가 사원번호인 사원들이 관리자들이다"
-- 사원이 근무하는 부서와 부서정보를 출력하시오.
-- 부하직원이 있는 사원(관리자들 )들이 누구인지 출력하시오.

--문제14. 30번 부서번호인 사원들 중에서 가장 늦게 입사한 사원보다 더 늦게 입사한 사원들의 이름과 입사일을 출력하시오
select ename, hiredate
from emp
where hiredate > (select max(hiredate) from emp where deptno=30);
-- line view로 바꾼 ver.
select ename, hiredate, deptno
from emp e join (select max(hiredate) max_hire_30 from emp where deptno =30) max_hiredate
on e.hiredate > max_hire_30;
