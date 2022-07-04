-- Q1. 사원번호, 입사일, 입사일로부터경과개월수, 6개월후의 날짜를 review로 표시하고
-- 입사일로부터 첫번째 돌아오는 금요일과 입사일이 포함된 달의 시작일을 찾아라
select employee_id, hire_date, 
       round(months_between(sysdate, hire_date)) as "입사일+개월수",  -- round : 반올림
       add_months(hire_date, 6) review,     -- 날짜에 월을 더하거나(+) 빼줌(-)
       next_day(hire_date, '금요일') first_fri,    -- 돌아오는 요일의 날짜 계산하기
       trunc(hire_date, 'month') first_day      -- trunc : 소수점 절사(주로 날짜의 시간을 없앨때 씀)
from employees;

-- Q2. 60번 부서에 소속된 사원 중 manager가 있거나 직무에 'MAN'이 들어있지 않은 사원을 찾아라
select department_id, manager_id, job_id
from employees
where (manager_id is not null or job_id not like '%MAN%') and department_id= 60;

-- Q3. 부서별 인원수를 조회하라
select deptno, count(deptno)
from emp
group by deptno
order by deptno;

-- Q4. 부서별 인원수가 3명 이상인 부서만 조회하라
select deptno, count(deptno)
from emp
group by deptno
having count(deptno) > 3
order by deptno;
