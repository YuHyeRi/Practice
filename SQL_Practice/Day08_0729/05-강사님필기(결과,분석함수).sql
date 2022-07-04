-- 10장 그룹함수, 분석함수

-- rollup 

group by deptno, job
          rollup 결과집합의 갯수 : N+1
group by rollup( deptno, job ) => (deptno, job)  (deptno ) ()

group by rollup (a, b, c) => abc ab a ()

         cube 결과집합의 갯수 : 2의 N승
group by cube( deptno, job) => (deptno, job) (deptno) (job) ()

group by cube (a,b,c) => abc ab ac bc a b c ()

-- 부서별 직무별 급여합계, 인원수를 출력하세요.

select deptno, job, sum(sal), count(*)
from emp
group by deptno, job
order by 1,2;

-- 부서별 직무별 급여합계, 인원수를 출력하세요. rollup 까지 해보세요

select deptno, job, sum(sal), count(*)
from emp
group by rollup ( deptno, job )
order by 1,2;

-- 위의 결과에서 부서별 직무별 급여합계와 총계만 출력하세요.

select deptno, job, sum(sal), count(*)
from emp
group by rollup ( (deptno, job)  )
order by 1,2;

delete emp
where upper(ename) = 'JANE';
commit;

-- grouping sets 
select deptno, job, sum(sal)
from emp
group by grouping sets( (deptno, job), (job) )
order by 1,2;

-- grouping 함수 :  group by , rollup, cube 사용시에만 실행할 수 있는 함수
--                 rollup의 결과로 나온 컬럼이 값이 null이 아니면 0,
                                  null이면 1을 반환
                                  
-- grouping_id ( a, b )   00 => 0
                          01 => 1
                          10 => 2
                          11 => 3   1
                                  
select deptno,grouping(deptno), job, grouping(job), sum(sal) , grouping_id ( deptno, job)
from emp
group by  rollup (deptno, job )
order by 1,3;                                  

select deptno,grouping(deptno), job, grouping(job), sum(sal), count(*)
from emp
group by rollup ( deptno, job )
order by 1,2;

select decode ( grouping ( deptno) , 0, to_char(deptno),  'all dept') g_dept,
       decode ( grouping (job) , 1,'all job', job) g_job ,  sum(sal), count(*)
from emp
group by rollup ( deptno, job )
order by 1,2;

select decode ( grouping ( deptno) , 1 , 'all dept', deptno) g_dept,
       decode ( grouping (job) , 1,'all job', job) g_job ,  sum(sal), count(*)
from emp
group by rollup ( deptno, job )
order by 1,2;

-- CASE 
select CASE WHEN grouping ( deptno) = 1 THEN 'all dept' ELSE to_char (deptno ) END  g_dept,
       CASE WHEN  grouping (job) = 1 THEN 'all job' ELSE job END  g_job ,  sum(sal), count(*)
from emp
group by rollup ( deptno, job )
order by 1,2;

-- nvl ( to_char(deptno) ,  'all dept') g_dept 는 deptno  컬럼이 널값이 경우도 'all dept'로 뿌리게 된다.
select nvl ( to_char(deptno) ,  'all dept') g_dept,
       nvl ( job, 'all job' ),
       sum(sal), count(*)
from emp
group by rollup ( deptno, job )
order by 1,2;


-- 업무의 유형 
OLTP ( OnLine Transaction Processing ) :
     insert , update, delete    data -------
      인사업무 급여
      회계
      영업 sales
      생산

staging DB : 

OLAP ( OnLine Analytic Processing ) 
; 분석
     sales  데이터를 분석 어느 지역, 제품, 연령, 성별 , 계절별로 분석
     DW( DataWarehouse) 
     Data Mart
     Data Mining 


insert into dw_tab1
select deptno, sum(sal) from emp group by deptno;

-- 분석함수 : 분석업무를 수행하기 위한 함수 

  분석함수()  분석절 OVER ( partition by  order by 윈도우절 )
                   물리적 윈도우
                   논리적 윈도우 

-- 순위함수 : rank()  동등순위 처리, 다음순위를 동등순위만큼을 건너뛰고 순위가 매겨진다.
    dense_rank()  동등순위 처리, 다음순위를 연속적인 순위로 매기는 함수
    row_number()   동등순위 처리하지 않고 무조건 순위를 매기는 함수
select empno, ename, sal, rank() over ( order by sal desc) rank,
                dense_rank() over( order by sal desc ) dense_rank,
                row_number() over (order by sal desc ) row_number
from emp;


select empno, ename, deptno, sal,
          rank() over ( partition by deptno order by sal desc ) dept_rank,
          rank() over ( order by sal desc) rank
from emp;
 
select empno, ename, deptno, sal,
          rank() over ( order by sal desc) rank,
          rank() over ( partition by deptno order by sal desc ) dept_rank
from emp;

-- group 함수 
select sum(sal) , round(avg(sal)) , min(sal), max(sal)
from emp;

select empno, ename , sum(sal) , round(avg(sal)) , min(sal), max(sal)
from emp
group by empno, ename ;

-- 분석 함수 ( analytic function, window function )
   그룹함수는 그룹당 한 행을 반환하지만 분석함수는 행당 하나의 결과를 반환
select empno, ename , sal,
      sum(sal) over() sum, round( avg(sal) over()) avg
from emp ;

select ename, ename, deptno, sal, 
       sum(sal) over (partition by deptno) dept_sum
from emp;

select ename, ename, deptno, sal, 
       sum(sal) over ( order by sal) dept_sum
from emp;

select empno, ename, deptno, sal, 
       sum(sal) over ( partition by deptno order by sal) dept_sum
from emp;

  분석함수()  분석절 OVER ( partition by  order by 윈도우절 )
                   물리적 윈도우 rows between   and 
                   논리적 윈도우 range between  and 
  윈도우절은 일부 aggregation 함수와 함께 쓰일 수 있으며 
 행들의 그룹을 물리적으로, 논리적으로 함수가 적용될 윈도우를 정의합니다.
            
 select empno, ename, deptno, sal,
     sum(sal) over (order by deptno rows between 1 preceding and 
               1 following ) sum_sal
from emp;

 select empno, ename, deptno, sal,
     sum(sal) over (order by empno  
                    range between 100 preceding and 100 following ) AS sum_sal
from emp;

   7788    -100  7688 
           + 100 7888   
-- LEAD , LAG

select empno, ename, deptno, sal, lead ( sal, 1, 0) over ( order by deptno ) lead_col
from emp;

select empno, ename, hiredate, sal, lead ( sal, 1, 0) over ( order by hiredate ) lead_col,
                            lag( sal) over (order by hiredate) lag_sal
from emp;  

-- ratio_to_report : window 영역의 합계 내에서 현재 값이 차지하는 백분율
select empno, ename, sal , round(  ratio_to_report(sal) over ( ), 4)*100  ratio_pct
from emp;

select empno, ename, deptno, sal , round(  ratio_to_report(sal) over ( ), 4)*100  ratio_pct,
          round(  ratio_to_report(sal) over (partition by deptno ), 4)*100  dept_ratio_pct   
from emp;

--가정함수 
-- 급여순으로 순위를 출력하세요.
select empno, ename, sal , rank() over( order by sal desc) Rank
from emp;
-- 만약 급여가 2500이면 몇 등 정도일까?
select  rank(2000) within group ( order by sal desc) Rank
from emp;

-- LISTAGG
select  deptno , listagg( ename, ', ' ) within group  (order by ename ) as employee
from emp
group by deptno;