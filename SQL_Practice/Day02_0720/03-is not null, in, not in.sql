create table ltest ( c1 number , c2 varchar2(10) );
insert into ltest values (1, 'aX_Yb');
insert into ltest values (2, 'aXbYc');
insert into ltest values (3, 'X_Yb');

select *
from ltest
where c2 like '%X\_Y%' escape '\';  -- \ 대신 다른 문자를 써도 가능!

-- null인 데이터를 찾고 싶을때
select empno, sal, comm, deptno 
from emp
where comm is NULL;         -- = 를 쓸 수 없다. 비교가 아니기때문에(결과가 참,거짓이 아니기때문에)
                            -- NULL을 위해 만들어진 IS
-- null이 아닌 데이터만 찾고 싶을 때
select empno, sal, comm, deptno 
from emp
where comm is not null;

-- 10번 또는 20번 부서에 근무하는 사원의 이름,급여,부서번호 조회하세요.
select ename, sal, deptno
from emp
where deptno = 10 or deptno = 20;

-- 급여가 2000원 이상인 사원의 이름, 급여, 부서번호 조회하세요.
select ename, sal, deptno
from emp
where sal > 2000;

-- 위 합하라
select ename, sal, deptno
from emp
where (deptno = 10 or deptno = 20) and sal > 2000;

-- or 연산자 ==> in 으로 써보기
select last_name, job_id, salary
from employees
where job_id in('SA_REP','AD_PRES');

-- 오름차순 정렬하기 (sal을 오름차순(작->큰)으로 정렬하기) ==> order by
select ename, sal
from emp
order by sal;       -- ase(오름차순)이 디폴트값

-- 내림차순 정렬하기
select ename, sal
from emp
order by sal desc;  -- desc(내림차순)

-- 테이블 복제
create table EMP2
as select*from emp;
-- 구조 확인
desc emp2;
-- 데이터 삽입하기
insert into EMP2 (EMPNO, ENAME)
values(9000, 'SCOTT');
-- 정렬하기
select ename, sal
from emp2
order by sal asc;   -- null이 제일 마지막에 출력 (참고로, null의 순서는 DB마다 다를수있음)

select ename, sal
from emp2
order by sal desc;  -- null이 제일 처음에 출력

-- 1. null이 제일 처음에 안나오게 내림차순 정렬하기 (null 아예 안보이기)
select ename, sal
from emp2
where sal is not null   -- null이 아닌 애만 보여줘
order by sal desc;

-- 2. null이 제일 처음에 안나오게 내림차순 정렬하기 (null 보이기)\
select ename, sal
from emp2
order by nvl(sal,0) desc;   -- sal이 null이면 0으로 바꿔서 계산하라

-- 3. 가장 best인 방법
select ename, sal
from emp2
order by sal desc nulls last;   -- null값을 마지막에 뿌려라★

-- 사원의 이름,부서,급여,급여*12한 연봉을 조회하되 연봉순으로 조회하라
select ename, job, sal, sal*12 as 연봉
from emp
order by 4; -- 연봉, sal*12, 4
-- order by + 컬럼명, 컬럼별칭, 컬럼순서(몇번째 컬럼인지)

-- 사원의 이름,부서,급여,급여*12한 연봉을 조회하되 연봉순으로 조회하라
-- 단, 연봉이 30000원 이상인 사원만
select ename, job, sal, sal*12 as 연봉    -- 3
from emp                                 -- 1
where sal*12 >= 30000                    -- 2
order by 4;                              -- 4 (order by는 항상 마지막에 수행)

-- 사원의 급여순으로 정렬하되 사원의 이름만 조회하세요
select ename
from emp
order by sal;

-- 부서번호,사원,급여 조회하고 부서순 정렬 후 동일부서내 사원이름순으로 정렬하라
select deptno, ename, sal
from emp
order by deptno, ename;

-- sal 상위 5명만 출력하라 ==> rownum
select ename, sal
from emp
where rownum <= 5 
order by sal desc;

-- TOP-N query
-- where절이 수행되기 전에 sal 순으로 정렬하는 방법은?
select ename, sal
from (select * from emp order by sal desc)
where rownum <= 5;