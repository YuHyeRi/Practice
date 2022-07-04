-- INNER join : 서로 관계가 있는 레코드들만 조인
-- OUTER join : 서로 관계가 없는 레코드들

-- outer join

-- Q1. 소속사원이 없는 부서도 나오게(모든부서가나오게)
--     기준이 되는 테이블의 반대쪽에 (+)을 써줌
select ename, d.deptno, dname
from emp e, dept d
where e.deptno(+) = d.deptno;

select ename, d.deptno, dname
from emp e RIGHT OUTER JOIN dept d
ON (e.deptno = d.deptno);

-- Q2.사원을 기준으로 소속부서가 없어(null) 안나오는 사원도 같이 나오게
select ename, d.deptno, dname
from emp e, dept d
where e.deptno = d.deptno(+);

select ename, d.deptno, dname
from emp e LEFT OUTER JOIN dept d
ON (e.deptno = d.deptno);

-- Q3. 소속사원이 없는 부서 + 소속부서가 없는 사원
select ename, d.deptno, dname
from emp2 e FULL OUTER JOIN dept d
ON ( e.deptno = d.deptno);

-- 그냥조인을 하면 소속사원이 없는 40번 부서가 안나온다(emp 테이블을 보면 40번 부서인 사람이 없음) 
-- 직원은 없어도 부서번호는 다 데려오고 싶으니까 OUTER JOIN으로 dept 테이블을 데려와서 부서번호 다 보여줌
-- 그래서 기준이 되는 테이블은(데려오고 싶은 테이블은) dept 테이블이기 때문에 
-- emp테이블에 (+)를 써주거나, 아니면 등호를 기준으로 dept 테이블이 있는 위치(LEFT 혹은 RIGHT)를 OUTER JOIN으로 데려온다