-- ★ 조인의 종류 : inner join, outer join, self join, cross join(cartesian product)
select * from emp;  -- 15개 데이터
select * from dept; -- 4개 데이터

-- ★ INNER JOIN : 관계가 있는 레코드들만 합침
-- ==> 14개 데이터만 나옴 (1개 데이터는 deptno가 null 값이라)
-- join on : ANSI 방법
select *
from emp join dept
on emp.deptno = dept.deptno
order by emp.deptno;

select *
from emp join dept
on emp.deptno = dept.deptno
and job = 'CLERK'
order by ename;