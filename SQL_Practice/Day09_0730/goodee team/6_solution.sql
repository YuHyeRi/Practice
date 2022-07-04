6조 출제 문제 - 풀이 4조


-- 쉬운문제 

-- 1. countries 테이블에서 중복을 제거한 Country_id를 조회하세요.

풀이 

select distinct country_id from countries;



--2. location 테이블에서 영국(UK)에 있는 위치의 location_id, city, street_address를 조회하세요.

풀이

select location_id, city, street_address from locations where upper(country_id)='UK';



--3. job_history에서 직무가 ST_CLERK인 사람들의 부서와 start_date를 조회하라

풀이

select department_id,start_date from job_history where job_id='ST_CLERK';



--4. 자신의 관리자보다 급여을 많이 받는 사원의 이름과 급여와 근무지를 출력하세요

풀이

select w.last_name,w.salary,city
from employees m,employees w, departments d, locations l
where l.location_id=d.location_id and d.department_id=w.department_id 
and w.manager_id=m.employee_id
and w.salary>m.salary;


-- 어려운 문제

--1. 부서별 , 직무별  급여 합계를 출력하고, 부서별합계와, 직무별 합계, 전체합계를 하나의 쿼리로 만들어보세요.

deptno   job      sum(sal)      dept_sum   job_sum      total
10   PRESIDENT   5000      8750      5000      29025
20   ANALYST      6000      10875      6000      29025
20   CLERK      1900      10875      4150      29025
20   MANAGER   2975      10875      8275      29025
30   CLERK       950      9400      4150      29025
30   MANAGER   2850      9400      8275      29025
30   SALESMAN   5600      9400      5600      29025


풀이

select distinct deptno,job,sum(sal) over(partition by deptno,job) sum,sum(sal) over(partition by deptno) dept_sum,sum(sal) over(partition by job) job_sum,sum(sal) over() total
from emp
order by deptno;

select distinct deptno, job,sum(sal) over(partition by deptno,job) sum,
                          sum(sal) over(partition by deptno) dept_sum,
                          sum(sal) over(partition by job) job_sum,
                          sum(sal) over() total
from emp
order by deptno;

-- 출제자
with
dj as(select deptno , job, sum(sal) dj_sum
          from emp
          group by deptno, job
          order by 1),

d as (select deptno, sum(sal) d_sum 
             from emp
             group by deptno
             order by 1),

j as (select job, sum(sal) j_sum
            from emp
            group by job),

t as (select sum(sal) total
          from emp)

select dj.deptno , dj.job , dj_sum, d_sum , j_sum, total
from dj,d,j,t
where dj.deptno = d.deptno and dj.job = j.job
order by 1;



--2. 부서명 ,사원의 이름, 급여와 급여순위, 부서별 급여순위를 다음과 같은 결과로 출력하세요.

deptno   ename      sal     rank   dept_rank
10      KING        5000      1      3
10      MILLER       1300      9      3
10      CLARK     2450      6      3
20      ADAMS    1100     12      1
20      JONES     2975       4      1
20      SCOTT     3000     2      1
20      SMITH      800    14      1
20      FORD      3000       2      1
30      WARD     1250    10      2
30      TURNER   1500     8      2
30      MARTIN   1250    10      2
30      JAMES      950    13      2
30      BLAKE     2850     5      2
30      ALLEN     1600     7      2


풀이

select deptno,ename,sal,
       RANK() OVER (ORDER BY sal DESC) rank, 
       RANK() OVER (PARTITION BY deptno ORDER BY sal DESC) dept_rank
from emp
order by deptno;

-- 출제자
with
d as (select deptno, sum(sal) d_sum 
             from emp
             group by deptno
            )
select d.deptno,ename, sal,
        Rank() over (order by sal desc) rank,
        dense_rank() over (order by d_sum desc) dept_rank
from emp, d 
where d.deptno = emp.deptno
order by 1;