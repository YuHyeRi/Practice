-- union, union all, intersect, minus

-- view 만들기 ==> create view 테이블명 as
create view exam as
select deptno, ename from emp
union 
select deptno, dname from dept;

select * from exam;