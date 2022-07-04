-- ★ 작성순서 : select > from > where > group by > having > order by
-- ★ 실행순서 : from > connect by > where > group by > having > select > order by
-- 해당 절에서 정의한 명칭(?)은 그 뒤의 절에서만 쓸 수 있다
select deptno 부서번호, round(avg(sal)) 평균연봉 
from emp
group by deptno
order by 1;

select deptno 부서번호, round(avg(sal)) 평균연봉 
from emp
group by deptno
having deptno > 10;

-- 1. row_number() over (order by 정렬하고싶은 칼럼명)
-- 번호를 매기고 싶을때 'ROWNUM'를 쓰지만 order by 된 정보에서는 섞여버린다
-- 때문에 order by 후에 그 순서대로 번호를 매기고 싶을때는 row_number() over (order by 정렬하고싶은 칼럼명)을 쓴다
-- ==> 정렬된 상태(order by)에서 일련번호를 붙이고 싶을때 쓴다!
select ROW_NUMBER() OVER (order by deptno) no, deptno, ename, sal
from emp;

-- 2. rank() OVER (order by 정렬하고싶은 칼럼명)
-- 정렬된 상태(order by)에서 등수를 매기고 싶을때 쓴다! ==> 공동 등수 다음에 +2(동등점수인 숫자의 갯수?!)
select rank() OVER (order by sal) rank, deptno, ename, sal
from emp;

-- 2-1. dense_rank() OVER (order by 정렬하고싶은 칼럼명)
-- 정렬된 상태(order by)에서 등수를 매기고 싶을때 쓴다! ==> 공동 등수 다음에 +1
select dense_rank() OVER (order by sal) rank, deptno, ename, sal
from emp;

-- 3. rank() OVER (partition by 묶고싶은 컬럼 order by 등수매기고 싶은 컬럼명)
-- partition으로 묶은 컬럼내에서 order의 순위(등수) 매긴다
select rank() OVER (partition by deptno order by sal) rank, deptno, ename, sal
from emp;