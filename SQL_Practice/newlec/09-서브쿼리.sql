-- ★ 서브쿼리 : 구절의 순서를 바꾸거나, 먼저 계산해야 하는 경우 사용!
-- Q1. 상위 월급 5위까지인 사원을 뽑아 정렬하라
select empno, ename, sal
from (select * from emp order by sal desc)
where rownum between 1 and 5;

-- Q2. 평균 월급 이상을 받는 사원들을 출력하라
select ename, sal
from emp
where sal >(select round(avg(sal)) from emp);