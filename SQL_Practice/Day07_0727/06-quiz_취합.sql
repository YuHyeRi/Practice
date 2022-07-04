--문제1. 이름과 부서위치를 출력하시오 -- 유혜리
select ename, loc
from emp e, dept d
where e.deptno = d.deptno;

--문제2. 위의 결과를 다시 출력하는데 부서위치가 DALLAS 인 사원들만 출력하시오  -- 임지혜
--1번 방법
select ename, loc
from emp , dept
where loc = 'DALLAS';

--2번 방법
select ename, loc
from emp join dept
on( loc = 'DALLAS');

--문제3. 직업이 SALESMAN 인 사원들의 이름과 월급과 직업과 부서위치를 출력하시오    -- 장종인
SELECT ename, sal, job, loc
FROM emp e JOIN dept d
ON e.deptno = d.deptno
WHERE job = 'SALESMAN';

--문제4. 위의 결과를 다시 출력하는데 이름과 월급과 직업과 부서위치, 부서번호를 출력하시오  -- 전성용
SELECT E.ENAME, E.SAL, E.JOB, E.DEPTNO, D.LOC
FROM EMP E JOIN DEPT D ON(D.DEPTNO=E.DEPTNO AND E.JOB='SALESMAN');

--문제5. 월급이 3000 이상인 사원들의 이름과 월급과 부서위치를 출력하시오   -- 유
select ename, sal, loc
from emp e, dept d
where e.deptno = d.deptno
and sal >= 3000;

--문제6. 직업이 SALESMAN 인 사원들의 이름과 직업과 월급과 부서위치를 출력하시오    -- 임
select ename, job, sal, loc
from emp, dept
where job = 'SALESMAN';

select ename, job, sal, loc
from emp join dept
on ( job = 'SALESMAN');

--문제7.  부서위치, 부서위치별 토탈월급을 출력하시오  -- 장
SELECT loc, sum(sal)
FROM emp e JOIN dept d
ON e.deptno = d.deptno
GROUP BY loc;

--문제8. 위의 결과를 다시 출력하는데 부서위치가 DALLAS는 제외하고 출력하시오  -- 전
SELECT LOC, SUM(SAL)
FROM DEPT D JOIN EMP E ON D.DEPTNO = E.DEPTNO
GROUP BY D.LOC
HAVING NOT D.LOC='DALLAS';

--문제9. 부서위치, 부서위치별 토탈월급을 출력하는데 가로로 출력하시오   -- 유
select loc, sum(sal)
from emp e full outer join dept d
on (e.deptno = d.deptno)
group by loc;

SELECT sum(decode(loc, 'NEW YORK', sal, 0)) "NEW YORK",
       sum(decode(loc, 'DALLAS', sal, 0)) "DALLAS",
       sum(decode(loc, 'CHICAGO', sal, 0)) "CHICAGO",
       sum(decode(loc, 'BOSTON', sal, 0)) "BOSTON"
FROM emp e JOIN dept d
ON e.deptno = d.deptno;

-- ■ outer  join
--문제10. 어느 부서위치에 사원이 배치 되지 않았는지 확인하시오  -- 임
select e.ename, d.loc
from emp e, dept d
where e.deptno(+) = d.deptno;

--문제11. 이름, 부서위치를 출력하는데 이름쪽에는 데이터가 나오는데 부서위치에는 데이터가 나오지않는 결과를 출력하시오 ㅡ -- 장
--실습을 위해 emp table 에 데이타 추가
insert into emp(empno, ename, sal, deptno)
values(1934, 'JANE', 4700, NULL);

SELECT ename, loc
FROM emp e LEFT OUTER JOIN dept d
ON e.deptno = d.deptno
WHERE loc is null;

--문제12. 양쪽에 다 아웃터 조인 사인을 써서 결과를 보게하려면 어떻게 해야하는가?  -- 전
SELECT E.ENAME, D.LOC
FROM EMP E FULL OUTER JOIN DEPT D ON (E.DEPTNO = D.DEPTNO)
ORDER BY E.ENAME;

--문제13.  부서위치, 부서위치별 토탈월급을 출력하시오   -- 유
-- 위 문제와 중복됨 --

--문제14. 부서위치, 부서위치별 인원수를 출력하는데 사원이 없는 부서위치는 인원수가 0 으로 출력되게 하라   -- 임
select d.loc, NVL(count(e.ename),0)   --사원(이름)을 카운트
from emp e, dept d
where e.deptno(+) = d.deptno
group by d.loc;

SELECT loc, COUNT(ename)
FROM emp e RIGHT OUTER JOIN dept d
ON e.deptno = d.deptno
GROUP BY loc;

-- ■ self  join  : 자기 자신의 테이블과 조인하는 조인 문법
--문제15. 사원이름, 관리자의 이름을 출력하시오   -- 장
SELECT w.ename as "사원", m.ename as "관리자"
FROM emp w, emp m
WHERE w.mgr = m.empno(+);

--문제16. 사원 이름, 관리자 이름을 출력하는데 관리자 보다 더 많은 월급을 받는 사원들만 출력하시오    -- 전
SELECT  B.ENAME "사원", A.ENAME "관리자", B.SAL
FROM EMP B, EMP A
WHERE B.MGR = A.EMPNO(+)
AND B.SAL > A.SAL;

--문제17. 사원이름, 관리자 이름을 출력하는데 관리자보다 먼저 입사한 사원들만 출력하시오   -- 유
select w.ename 사원명, m.ename 관리자명
from emp w, emp m
where w.mgr = m.empno
and w.hiredate < m.hiredate ;

-- ■ 3개 이상의 테이블 조인
--문제18. 사원이름, 부서위치, 월급, 급여등급(grade) 를 출력하시오   -- 임
SELECT ename, loc, sal, grade
FROM emp e, dept d, salgrade
WHERE e.deptno = d.deptno
AND sal BETWEEN losal and hisal;

-- ■ 1999 ansi 조인 문법

-- 1. on 절을 사용한 조인 문법
--문제19. 이름과 부서위치를 출력하는데 on 절을 사용한 조인으로 구현하시오   -- 장
SELECT ename, loc
FROM emp e JOIN dept d
ON e.deptno = d.deptno;

--문제20. 직업이 SALESMAN 인 사원들의 이름과 부서위치와 직업을 출력하시오 (ON 절을 사용한 조인으로 수행)  -- 전
SELECT E.ENAME, E.SAL, E.JOB, E.DEPTNO, D.LOC
FROM EMP E JOIN DEPT D ON(D.DEPTNO=E.DEPTNO AND E.JOB='SALESMAN');

--문제21. 이름, 월급, 부서위치, 급여등급을 출력하는데 ON 절을 사용한 조인으로 수행하시오   -- 유
select ename, sal, loc, grade
from emp e join dept d
on e.deptno = d.deptno
join salgrade
on e.sal between losal and hisal;

-- 2. using 절을 사용한 조인
--문제22. 이름과 부서위치를 출력하는데  using 절을 사용한 조인으로 출력하시오  -- 임
select ename, loc
from emp join dept
using (deptno);

-- 3. natural  join
--문제23. 이름과 부서위치를 출력하는데  naturual 조인으로 출력하시오  -- 장
SELECT ename, loc
FROM emp NATURAL JOIN dept;

-- 4. cross join

--문제24. 이름과 부서위치를 출력하는데 cross join 하시오   -- 전
SELECT E.ENAME, D.LOC
FROM EMP E CROSS JOIN DEPT D;

--=======================
--서브쿼리 연습문제  14문제
--=======================
--문제6. SCOTT 과 같은  직업을 갖는 사원들의 이름과 직업을 출력하는데 SCOTT 은 제외하고 출력하시오   -- 유
select ename, job
from emp
where job = (select job from emp where ename = 'SCOTT')
and ename not in ('SCOTT');

--문제7. KING 에게 보고하는 사원들의 이름을 출력하시오(KING 의 직속부하 사원들을 출력하시오)   -- 임
select ename
from emp
where mgr = (select EMPNO from emp where ename = 'KING');

--문제8. 직업이 SALESMAN 인 사원들과 월급이 같은 사원들의 이름과 월급을 출력하시오   -- 장
SELECT ename, sal
FROM emp
WHERE sal IN (SELECT sal FROM emp WHERE job = 'SALESMAN');

--문제9. 직업이 SALESMAN 인 사원들과 급여가 동일하지 않은 사원들의 이름과 월급을 출력하시오   -- 전
SELECT ename, sal
FROM emp
WHERE sal NOT IN (SELECT sal FROM emp WHERE job = 'SALESMAN');

--문제10.  관리자인 사원들의 이름을 출력하시오        -- 유
-- ( 자기 밑에 직속 부하 사원이 한명이라도 있는 사원 )
-- 이 사원들의 사원번호는 자기 부하 사원들의 MGR 번호이다.
-- "mgr 번호가 사원번호인 사원들이 관리자들이다"
SELECT ename "관리자"
FROM emp
WHERE empno IN (SELECT mgr FROM emp);

-- 문제10. 사원이 근무하는 부서와 부서정보를 출력하시오
SELECT * FROM dept
WHERE deptno IN (SELECT deptno FROM emp);

--문제11. 관리자가 아닌 사원들의 이름을 출력하시오(즉 부하직원을 거느리지 않은 사원(말단사원)들을 출력하시오.) -- 임
SELECT ename "관리자"
FROM emp m
WHERE NOT EXISTS (SELECT null FROM emp WHERE mgr = m.empno);

SELECT ename "관리자"
FROM emp
WHERE empno NOT IN (SELECT mgr FROM emp WHERE mgr is not null);

--★ 서브쿼리에서 not  in  을 사용할때는 반드시 null 처리를 해줘야 결과를 볼 수 있다.

--문제12. 직업이 SALESMAN 인 사원들중에서의 최대월급보다 더 많은 월급을 받는 사원들의 이름과 월급을 출력하시오  -- 장
SELECT ename, sal
FROM emp
WHERE sal > (SELECT max(sal) FROM emp WHERE job = 'SALESMAN');

--문제13. 직업이 SALESMAN 인 사원들중에서 가장 작은 월급을 받는 사원보다 더 큰 월급을 받는 사원들의 이름과 월급을 출력하시오  -- 전
SELECT ENAME, SAL
FROM EMP
WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE job = 'SALESMAN');

--문제14. 30번 부서번호인 사원들 중에서 가장 늦게 입사한 사원보다 더 늦게 입사한 사원들의 이름과 입사일을 출력하시오 -- 유
select ename, hiredate
from emp
where hiredate > (select max(hiredate) from emp where deptno=30);