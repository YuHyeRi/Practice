-- Q1.Smith의 급여는 800원이다.' 와 같이 출력하세요.  (emp 사용,  'Smith' 와 같이 출력되도록 주의)
select initcap(ename) || '의 급여는 ' || sal || '원이다.' as "사원별 급여"
from emp; 

-- Q2.50번 부서에 소속된 사원들 중 급여가 5000 미만이거나 직무에 'MAN'이 들어있는 사원을 조회하세요.(employees 사용)
select first_name || ' ' || last_name as 사원명, department_id as 부서, salary as 급여, job_id as 직무
from employees
where (salary < 5000 or job_id like '%MAN%') and department_id = 50;

-- Q3. 'New York' 에 위치한 부서를 조회하세요. 위치 정보의 대소문자 조합을 모른다고 가정하고 작성하세요(dept 사용)
select deptno, loc 
from dept
where upper(loc) = 'NEW YORK';

-- Q4. 부서별 급여 합산을 구하는 쿼리를 구하시오. (employees 사용)
select department_id, sum(salary)
from employees
group by department_id
order by department_id;

-- Q5. 부서별 급여 합산 값이 10만원 이상 부서를 금액이 높은 순으로 나열 하시오(employees 사용)
select department_id, sum(salary)
from employees
group by department_id
having sum(salary) >= 100000
order by 2 desc;
