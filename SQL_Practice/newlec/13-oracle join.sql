-- ★ INNER JOIN
-- ANSI inner join
select e.deptno, ename
from emp e join dept d
on e.deptno = d.deptno
where e.deptno = 10;

-- Oracle inner join
select e.deptno, ename
from emp e, dept d
where e.deptno = d.deptno
and e.deptno = 10;

-- ★ OUTER JOIN
-- ANSI outer join
select e.deptno, ename
from emp e left outer join dept d   -- outer를 포함하는 쪽
on e.deptno = d.deptno
where e.deptno = 10;

-- Oracle outer join
select e.deptno, ename
from emp e, dept d
where e.deptno = d.deptno(+)        -- outer를 포함하지 않는 쪽 (위와 반대)
and e.deptno = 10;                  -- left outer join이면 오른쪽에 (+)

-- Oracle full outer join
select e.deptno, ename
from emp e, dept d
where e.deptno(+) = d.deptno(+) 
and e.deptno = 10; 

-- ANSI CROSS JOIN
-- 두 개 테이블을 곱함
select e.deptno, ename
from emp e cross join dept d;

-- Oracle CROSS JOIN
select e.deptno, ename
from emp e, dept d;