--★ 분석함수
-- 업무의 유형 
OLTP (oline transaction processing)
OLAP (oline analytic processing)

select analytic_function(arguments)
over ( [partition by 컬럼] order by절
                         windowing절)
from 테이블명

-- ranking family
rank()
dense_rank()
cum_dist()
ntile()
row_number()

-- 순위함수 : rank 동등순위 처리, 다음순위를 동등순위만큼을 건너뛰고 순위를 매기는 방식
-- dense_rank() : 동등순위 처리, 다음순위를 연속적인 순위로 매기는 함수
-- row_number() : 동등순위 처리하지 않고 무조건 순위를 매기는 함수
select empno, ename, sal, rank() over (order by sal desc) rank,
dense_rank() over(order by sal desc) dense_rank,
row_number() over(order by sal desc) row_number
from emp;

select empno, ename, deptno, sal, 
rank() over (partition by deptno order by sal desc) rank1,
rank() over (order by sal desc) rank2
from emp;

-- 그룹함수

-- 분석함수 (analytic function, window function)
-- 그룹함수는 그룹당 한 행을 반환하지만, 분석함수는 행당 하나의 결과를 반환한다
select empno, ename, sal,
        sum(sal) over() sum, round(avg(sal) over()) avg
from emp;

select empno, ename, deptno, sal,
        sum(sal) over (partition by deptno) dept_sum
from emp;

select empno, ename, deptno, sal,
        sum(sal) over (order by sal) dept_sum
from emp;

select empno, ename, deptno, sal,
        sum(sal) over (partition by deptno order by sal) dept_sum
from emp;


-- 분석함수 : 분석엄부를 수행하기 위한 함수
분석함수() 분석절 over (partition by order by 윈도우절)

-- LEAD, LAG
-- lead : 나보다 하나 더 뒤에 있는 애를 찍어라 (맨 마지막은 뒤가 없으니까 null값이 나옴)
select empno, ename, hiredate, sal, lead(sal) over(order by hiredate) lead_color
from emp;
-- 나를 기준으로 두칸 뒤에 있는걸 찍어라
select empno, ename, hiredate, sal, lead(sal, 2) over(order by hiredate) lead_color
from emp;
-- 맨 뒤 값이 null이 되면 0을 찍어라
select empno, ename, hiredate, sal, lead(sal, 2, 0) over(order by hiredate) lead_color
from emp;


-- lag : 나보다 한칸 더 앞에 있는 애를 찍어라 (맨 앞이 null 값)
select empno, ename, hiredate, sal, lag(sal) over(order by hiredate) lag_color
from emp;

-- 통계함수 : ratio_to_report (전체에서 (내용)이 차지하는 비율)
-- window 영역의 합계 내에서 현재값이 차지하는 백분율
select empno, ename, sal, round(ratio_to_report(sal) over (), 4)*100 as 비율 -- round( ,4) : 소수점이하 넷째자리까지
from emp;

-- 부서내 월급퍼센트
select empno, ename, deptno, sal, round(ratio_to_report(sal) over (partition by deptno), 4)*100 as 비율
from emp;

-- 가정함수
-- 급여순으로 순위를 출력하세요
select empno, ename, sal, rank() over(order by sal desc) as rank
from emp;
-- 만약 급여가 2500원을 받는다면 회사에서 몇등이 될까? (ename등은 없으니까 쓸 수 없다)
select rank(2500) within group(order by sal desc) as rank
from emp;

-- LISTAGG
select deptno, listagg(ename||' '||sal, ', ') within group (order by ename) as employee 
from emp
group by deptno;