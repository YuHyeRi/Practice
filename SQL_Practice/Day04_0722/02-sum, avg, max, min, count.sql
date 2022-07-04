-- 그룹행 함수 :: 모든 그룹함수는 null값을 무시한다. (자동으로 null을 빼고 연산함)
--              단, count(*) 은 제외!! (null도 카운트함)
select min(sal), max(sal), sum(sal), avg(sal), count(*)
from emp;

-- count(*) : 모든 행을 카운트한다(중복,null값 모두 셈)
-- count(컬럼명) : 값이 null은 제외한다.
-- count(distinct 컬럼명) : 중복값을 제거한다
select count(*), count(commission_pct), count(distinct commission_pct)
from employees;

-- sum ==> null값에 대해 고려하지 않아도 됨
select sum(sal)
from emp;

-- avg ==> null값에 따라 의미가 달라짐
select avg(sal), avg(nvl(sal,0))
from emp2;

-- group by : 그룹으로 묶어라
-- having : group by의 결과를 제한하는 절 (group by에서는 where절이 아닌 having절을 씀)
-- 중요!!★ where절에 쓸수 있는건 where절에 써서 미리 걸러낸다. 그리고 where절에 못쓰는걸 having에 쓴다
select deptno, sum(sal)
from emp
group by deptno;      

-- 부서별 급여 합계가 9000원 이상인 부서만 조회
select deptno, sum(sal)     -- 4   
from emp                    -- 1
-- where sum(sal) > 9000    -- 2
group by deptno             -- 3
having sum(sal) > 9000      --having : group by의 where절이라고 생각
order by sum(sal);          -- 5

-- 방법1. 부서별 급여 합계가 9000원 이상이고, 그중에서 부서번호가 20번 보다 큰 부서만 조회
-- ==> 이렇게는 쓰지말자!!
select deptno, sum(sal)
from emp
group by deptno
having sum(sal) > 9000 and deptno > 20;

-- 방법2.  ==> 더 빠르게 처리됨
select deptno, sum(sal) as sum_sal    -- 4
from emp                              -- 1
where deptno > 10                     -- 2
group by deptno                       -- 3
having sum(sal)>9000  -- sum_sal은 쓸 수 없다(실행순서때문에)     -- 3
order by sum_sal; -- sum(sal), sum_sal, 2(순서)                -- 5

-- 부서별 급여합계
select deptno, sum(sal)
from emp
group by deptno;

-- 직무별 급여합계
select job, sum(sal)
from emp
group by job;

-- 부서별, 직무별 급여합계
-- select절에 그룹함수와 함께 등장하는 컬럼은 반드시 groupby절에 등장해야 함
select deptno, job, sum(sal)
from emp
group by deptno, job
order by 1,2;

-- 부서별 최고급여액을 조회하세요
-- select절에 있는 컬럼과 groupby절에 있는 컬럼은 동일해야함!! (그룹함수제외)
select deptno, ename, max(sal)
from emp
group by deptno, ename;

-- 부서별 max(sal)을 받는 사람을 조회하고자 한다면.. ==> subquery, join (내일 배움)

-- 1. group by rollup : 1) 2) 3)
-- 각 deptno별로 합계, 그 합계들의 합계, 그 모든 것들의 합계
select deptno, job, sum(sal)
from emp
group by rollup(deptno, job)
order by 1,2;

-- 2. group by cube : 가능한 모든 조합의 sum을 다 보여줌
-- rollup + job별로의 합계 + 그 모든 것들의 합계
select deptno, job, sum(sal)
from emp
group by cube(deptno, job)
order by 1,2;

-- 3. grouping sets : 내 입맛대로 원하는것만 보고 싶을때
select deptno, job, sum(sal)
from emp
group by grouping sets ((deptno, job), (job), ())   -- () : select sum(sal) from emp;
order by 1,2;

--
select deptno, sum(sal) 
from emp 
group by deptno;
