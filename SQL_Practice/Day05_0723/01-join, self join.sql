select count(*) from employees;
select DISTINCT department_id from employees;   -- DISTINCT : 조회하는 컬럼의 중복값 제거

-- JOIN 유형 : INNER, OUTER, CROSS

-- 1. Equi join : join 조건식에 '='를 사용
-- Q. 사원별의 부서별 직업(DNAME)을 조회하라
select * from emp;
select * from dept;

select ename, d.deptno, dname
from emp e, dept d
where e.deptno = d.deptno;

-- 2. Non-Equi Join : join 조건식에 '=' 이외의 비교 연산자를 사용
-- Q. 사원별 salary에 맞는 등급을 출력하라
select * from emp;
select * from salgrade;

select ename, sal, grade
from emp, salgrade
where sal between losal and hisal;

-- 위 식을 join on으로 바꿔써보기
select ename, sal, grade
from emp join salgrade
on (sal between losal and hisal);

-- 3. Self join : from절에 동일 테이블이 두번 이상 나타날 경우 (자기를 두번 join함)
select * from employees, employees;     -- parent, child
select * from employees;

select w.employee_id, w.last_name, m.employee_id, m.last_name
from employees w, employees m
where w.manager_id = m.employee_id;

-- 추가 : Hierachical Query
select LPAD('', 2* LEVEL) || ename from emp
start with ename = 'KING'   -- start with :시작점은?
connect by prior empno = mgr;