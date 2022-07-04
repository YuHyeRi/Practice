-- outer join : 참조키를 기준으로 일치하지 않는 행도 포함시키는 조인

-- inner join ver
select *
from emp e join dept d
on e.deptno = d.deptno;

-- outer join ver
select *
from emp e left outer join dept d   -- 왼쪽에 있는 테이블에 outer를 포함시키겠다 (오른쪽에 있는 상관없는건 사라짐)
on e.deptno = d.deptno;             -- 왼쪽에 있는 상관없는 데이터는 null로 채워짐

select * from emp;
select * from dept;

select ename, dname, count(dname)
from emp e full join dept d
on e.deptno = d.deptno
group by ename, dname
order by dname;