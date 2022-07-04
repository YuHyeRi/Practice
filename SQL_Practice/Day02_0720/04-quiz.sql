-- 1. 현재 사용자가 가지고 있는 table, view의 목록을 조회하세요. ==> tab
select * from tab;  

-- 2. 테이블의 구조 확인 ==> desc
desc emp;
desc dept;

-- 3. 테이블의 모든 컬럼의 데이터를 확인하세요.
select * from emp;
select * from dept;

-- 4. 테이블에서 특정 컬럼의 데이터를 검색하세요.
select deptno,dname from dept;
select empno, ename, sal, deptno from emp;

-- 5. 테이블에서 사원번호, 사원이름과 '구디아카데미'라는 리터럴을 화면에 표시하고, 칼럼명칭은 Company로 하세요.
-- 문자리터럴 : '' / 대소문자 섞어서 쓰려면 : ""
select empno, ename, '구디아카데미' as "Company"
from emp;
-- 추가1
select '구디아카데미' as "company"
from dual;
-- 추가2
select 'korea', sysdate, 10 
from dual;

-- 6. 연봉계산기
select empno, ename, sal, (sal+nvl(comm,0))*12 as "Annual_Salary" 
from emp;

-- 7. 'SMITH is a CLERK' 처럼 사원명과 직무를 조회하세요.
select ename || ' is a ' || job || '.' as "emp_info"
from emp;