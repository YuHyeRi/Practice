--1조 (7조문제)
-- << 쉬운 문제 >>
-- EASY 1
/*
*** emp 테이블 사용 ***

사원번호, 이름, 급여, 급여 순위, 바로 위 사원과의 급여 차이를 조회하세요. (급여 기준 내림차순으로 조회하세요.)
중복 순위는 같은 순위로 표기하고, 중복 순위 뒤에 오는 등수는 중복된 수만큼 건너뛰고 표기하세요.
급여 차이는 양수로 표기하고, 비교할 대상이 없을 경우 자기자신과 비교하여 0으로 표기하세요.
( RANK, LAG )

정답 예시
================================
EMPNO   ENAME   SAL   RANK    GAP
 7839   KING    5000    1       0
 7902   FORD    3000    2    2000
 7788   SCOTT   3000    2       0
 7566   JONES   2975    4      25
 7698   BLAKE   2850    5     125
 7782   CLARK   2450    6     400
 7499   ALLEN   1600    7     850
 7844   TURNER  1500    8     100
 7934   MILLER  1300    9     200
 7521   WARD    1250   10      50
 7654   MARTIN  1250   10       0
 7876   ADAMS   1100   12     150
 7900   JAMES    950   13     150
 7369   SMITH    800   14     150

select empno, ename,sal, rank() over(order by sal) rank,  abs(sal-lag(sal,1,sal) over(order by sal desc)) sal_di  
from emp;


 
*/
select empno, ename,sal, rank() over(order by sal) rank,  abs(sal-lag(sal,1,sal) over(order by sal desc)) sal_di  
from emp;
-- EASY 2
-- 'CLARK'보다 높은 급여를 받는 사원들의 이름과 월급을 출력하고 월급 오름차순으로 정렬하라

select  empno
,ename
,sal
,RANK() OVER (ORDER BY sal DESC)
,abs((sal-(lag(sal,1,0) over(order by sal desc))))
from emp
where sal > (select sal from emp where upper(ename)='CLARK');


-- EASY 3
-- 이름의 길이가 4글자 또는 5글자인 사원의 이름과 급여를 조회하시오.

select ename, sal
from emp
where ename Like '____' or ename Like '_____'
order by sal;
    --  length ( ename ) in ( 4,5)
-- EASY 4
-- 부서번호, 사원이름, 급여와 커미션을 조회하시오. 

select deptno, ename, sal, comm
from emp;


-- << 어려운 문제 >>
-- HARD 1
/*
*** employees 테이블 사용 ***

몇 월에 가장 많은 사원들이 입사했는지 알아보려 합니다.
1월부터 12월까지, 각 달에 몇 명 입사했는지 조회하세요.
또한, 월 컬럼의 마지막행에는 '합계', 입사 사원수 컬럼의 마지막행에는 총 사원수를 출력하세요.
( 계층쿼리, 서브쿼리, 아우터조인, GROUPING, DECODE(CASE), 형변환 함수 )

정답 예시
================
월   입사 사원수
1            14
2            13
3            17
4             7
5             6
6            11
7             7
8             9
9             5
10            6
11            5
12            7
합계        107
*/

select 
decode(GROUPING(TO_CHAR(hire_date, 'MM') ), 1, '합계', to_number(TO_CHAR(hire_date, 'MM')) ) as 월
, COUNT(*) AS "입사 사원수"
from employees
GROUP BY rollup(TO_CHAR(hire_date, 'MM'))
order by TO_CHAR(hire_date, 'MM');


select 
decode(GROUPING(TO_CHAR(hire_date, 'MM') ), 1, '합계', to_number(TO_CHAR(hire_date, 'MM') )) as 월
, COUNT(*) AS "입사 사원수"
from employees
GROUP BY rollup(TO_CHAR(hire_date, 'MM'))
order by TO_CHAR(hire_date, 'MM');

-- 출제자
SELECT CASE GROUPING(month) WHEN 0 THEN to_char(month) ELSE '합계' END "월", count(*) "입사 사원수"
FROM (
      SELECT level month
      FROM dual
      CONNECT BY level <= 12
     ) LEFT OUTER JOIN employees
ON month = to_number(to_char(hire_date, 'MM'))
GROUP BY ROLLUP(month)
ORDER BY month;

-- HARD 2

--사원번호, 이름, 근무지, 급여를 조회하고 근무지가 CHICAGO와 NEWYORK인 사원들을 
--지역별로 급여 순위를 매기시오 (집합연산자 사용하기)
--(단, 급여랭킹 순위가 같을 경우 동등순위 처리하고 다음순위를 연속적으로 조회)
--(부서와 순위는 오름차순으로 정렬하라) 

select e.deptno ,e.ename, d.loc,e.sal, rank() over( order by sal desc)SAL_Rank
from emp e ,dept d
where e.deptno = d.deptno
    and (d.loc = 'CHICAGO' or d.loc = 'NEW YORK')
    order by 5;
    
    
    SELECT e.deptno, ename, loc, sal, dense_rank() over(order by sal desc) as 랭킹
FROM emp e JOIN dept d
ON (e.deptno = d.deptno and loc='CHICAGO')
UNION ALL
SELECT e.deptno, ename, loc, sal, dense_rank() over(order by sal desc) as 랭킹
FROM emp e JOIN dept d
ON (e.deptno = d.deptno and loc='NEW YORK')
ORDER BY 1, 5;