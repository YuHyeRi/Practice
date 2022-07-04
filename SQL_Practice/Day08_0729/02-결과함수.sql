--★ 그룹함수 ==> rollup, cube

--★ rollup
group by deptno, job
group by rollup (deptno, job) ==> (deptno, job) (deptno) ()
group by rollup (a,b,c) ==> (a,b,c) (a,b) (a) ()
-- 전체찍고, 오른쪽부터 하나씩 사라짐, rollup 결과집합의 갯수 : 'n + 1'

--★ cube
group by cube (deptno, job) ==> (deptno, job) (deptno) (job) ()
group by cube (a,b,c) ==> (a,b,c) (a,b) (a,c) (b,c) (a) (b) (c) ()
-- 전체찍고, 앞부터 두묶음씩 묵고 하나씩 묶음, (), cube 결과집합의 갯수 : '2의 n승'

--Q1. 부서별, 직무별 급여합계를 출력하라
select deptno, job, sum(sal)
from emp
group by rollup (deptno, job)
order by 1,2;

--Q2. 위의 결과에서 부서별 직무별 급여합계와 총계만 출력하세요
select deptno, job, sum(sal)
from emp
group by rollup ((deptno, job))
order by 1,2;

--Q3. grouping sets 내가 원하는 것만 보고싶다면..
select deptno, job, sum(sal)
from emp
group by grouping sets ((deptno,job), (job), 0)
order by 1, 2;

--★ grouping 함수 : group by, rollup, cube 사용시에만 실행할 수 있는 함수
--                  rollup의 결과로 나온 컬럼 값이 null이 아니면 0, null이면 1을 반환
select deptno, job, sum(sal), count(*)
from emp
group by rollup (deptno, job)
order by 1, 2;

select deptno, grouping(deptno), job, sum(sal), count(*)
from emp
group by rollup (deptno, job)
order by 1, 2;

-- decode 썼을 경우
select decode(grouping (deptno), 1, 'all dept', deptno) g_dept,
       decode(grouping (job), 1, 'all job', job) g_job, sum(sal), count(*)
from emp
group by rollup (deptno, job)
order by 1, 2;

-- case 썼을 경우
select case when grouping (deptno) = 1 then 'all dept' else to_char (deptno) end g_dept,
       case when grouping (job) = 1 then 'all job' else job end g_job, sum(sal), count(*)
from emp
group by rollup (deptno, job)
order by 1,2;
