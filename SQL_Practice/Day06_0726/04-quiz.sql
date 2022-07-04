-- Q1. 사원이 어느 부서에 근무하는지 사원정보와 부서명을 조회하세요
-- 1.일반적인 join 형태
select ename, d.deptno, dname
from emp e join dept d
on(e.deptno = d.deptno);

-- 2. using절에 사용된 컬럼만 join조건으로 생성하는 형태
select ename, deptno, dname     -- 'd.XX' 와 같이 쓰지 X
from emp e join dept d
using(deptno);

-- 3. 이름이 같은 모든 컬럼을 join조건으로 사용하는 syntax
select ename, deptno, dname
from emp e natural join dept d; 

-- Q2. 사원의 월급과 그 월급이 어느 grade에 속하는 조회하세요
select ename, sal, grade
from emp join salgrade
on (sal between losal and hisal);

-- Q3. 사원의 이름과 그 사원의 상사의 사원번호, 상사이름을 조회하세요
select w.empno as 사원번호, w.ename as 사원명, m.empno as 상사번호, m.ename as 상사명
from emp w join emp m
on w.mgr = m.empno;

-- Q4.1번의 정보를 출력하되 사원이 없는 부서에 대한 정보도 같이 출력되게 하세요.
select empno, ename, d.deptno, dname
from emp e, dept d
where e.deptno(+) = d.deptno;   -- (+) : outer join symbol

select empno, ename, d.deptno, dname
from emp2 e left OUTER JOIN dept d
ON (e.deptno = d.deptno);

-- Q5. 1번의 정보를 출력하되 사원의 직무(job)도 출력하고 직무순으로 출력하세요.
-- 단, 직무의 알파벳순이 아니라 'clerk, analyst, manager, president, salseman'
select empno,ename,e.deptno,dname,job
from emp e join dept d
on (e.deptno=d.deptno)
order by decode(job,'CLERK','1','ANALYST','2','MANAGER','3','PRESIDENT','4','SALESMAN','5');

-- start wiht : KING 부터 시작하게 정렬하게
select lpad('',2*level)||ename
from emp
start with ename = 'KING'
connect by prior empno = mgr;