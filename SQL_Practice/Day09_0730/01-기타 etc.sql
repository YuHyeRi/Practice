-- 분석함수 사용시 주의사항
-- 1. 분석함수는 where절의 조건식 비교 후, 결과값을 생성한다
-- 2. 분석함수는 select, order by에서만 가능하다
-- +) 중요한 DATA DICTIONARY 조회하기 : dictionary

-- Q. 1981년 입사한 사원정보와 소속부서의 평균을 분석함수를 이용하여 검색하라
select empno, ename, sal, deptno, hiredate, round(avg(sal) over(partition by deptno)) dept_avg
from emp
where to_char( hiredate ,'YYYY')= '1981'
order by deptno;

select empno, ename, sal, deptno, hiredate, dept_avg
from (select empno, ename, sal, deptno, hiredate, round(avg(sal) over(partition by deptno)) dept_avg
      from emp)
where to_char( hiredate ,'YYYY')= '1981'
order by deptno;

-- insert : 테이블에 행을 삽입할 때
-- 1. INSERT ... VALUES  -- 1행씩 INSERT 
-- 2. INSERT ... SELECT  -- 대량의 데이터를 한번에 INSERT 

select * from dept;

insert into dept
values(50,'EDU',null);  -- null도 스트링

insert into dept (deptno, dname)
values(60,'ABCDE');     -- 입력을 생략한 컬럼의 디폴트값은 null


