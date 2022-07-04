-- 스키마(Schema) : 서로 연관된 표들을 그룹핑하는 일종의 디렉토리 같은 것
-- 사용자를 생성하는 그 사용자에 해당하는 스키마가 만들어진다

select * from emp;
select * from dept;

show user --sql명령어가 아니라 툴명령어라 세미콜론 생략 가능
select * from emp;
drop table emp;
select * from dept;
drop table dept;

-- describe emp;
desc emp;   -- 축약이 가능
desc dept;

-- select 컬럼1,컬럼2 from 테이블명; ==> 컬럼과 컬럼의 사이는 ,로 구분/테이블명의 마지막은 ;로 알려줌
-- select * from 테이블명; ==> 이 테이블 안에 있는 모든 컬럼을 다루겠다

select * from emp;

--emp 테이블에서 이름과 급여를 조회하라
select ENAME, SAL from emp;
select * from emp;

-- 사원의 이름과 월급 조회, 월급 200원 인상한다면 얼마가 될지 조회하라
select ename, sal, sal+200 from emp;

select * from emp;
select ename, sal, sal*12 
from emp;

select ename, sal, comm
from emp;

-- 이 문장의 문제점 : 결과가 null
-- null 값을 포함하는 모든 산술식은 null로 표시됨
select ename, sal, comm, (sal+comm)*12 as "연봉"
from emp;

-- NVL함수 : nvl(a,b) => a가 null이면 b를 반환해라 (a가 null이 아니면 a를 반환해라)
-- NVL(comm, 0) ==> comm이 null이면 0을 반환하라
select ename as "이름", sal as "월급", comm as "커미션", (sal+nvl(comm,0))*12 as "연봉"
from emp;

-- column alias를 대소문자 구분해서 표시하고자할때 "" 사용
select ename, sal, comm ,(sal+nvl(comm,0))*12 "Ann_Sal"
from emp;

-- 공백을 포함하고 싶을때도 "" 쓴다, as를 써주는게 더 명확하다
-- 컬럼별칭은 해당 select문 안에서만 유효함
select ename as "이름", sal as "급여", comm as "커미션" ,(sal+nvl(comm,0))*12 as"Ann Sal"
from emp;

-- 연결연산자 : ||
-- 데이터타입 : 문자, 숫자, 날짜
-- 문자열 || 문자열 ==> 문자열과 문자열을 더해준다
select ename, job, ename||job as detail
from emp;

-- 상수 : 리터럴(literal)
-- 문자상수, 날짜상수 : '문자', '날짜'
-- 숫자상수 : 100
-- SMITHCLERK를 'SMITH의 직무는 CLERK이다.' 라고 출력하라
select ename, job, ename||'의 직무는 '||job||' 이다.' as detail
from emp;

 -- dual 테이블 : 약간 1회성으로 보고싶을때?
 -- user, sysdate 등은 함수
 -- ''(문자열데이터)와 ""(객체의이름,생략도가능->대문자로만표시됨)의 차이점
select 'korea', user, sysdate, 'korea' as "country"
from dual;

-- 내가 소유한 테이블은 스키마명을 생략할 수 있다
-- 남의 테이블을 보려면 '스키마명.'을 써줘야 한다
desc dual
select * from sys.dual;