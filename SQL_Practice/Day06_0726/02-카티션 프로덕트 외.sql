-- ★ 카티션 프로덕트, Catesian product 
select ename, e.deptno, d.deptno, dname
from emp e, dept d; -- 조인조건의 생략

-- ★ 카티션 프로덕트 : ANSI ver.
select ename, e.deptno, d.deptno, dname
from emp e cross join dept d;

select empno, ename, mon_no
from emp, (select level mon_no from dual connect by level <= 12)
order by 1, 3;  -- 관련 없는 테이블을 조인
