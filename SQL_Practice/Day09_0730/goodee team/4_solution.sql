-- 4-1. job_title에 'manager'가 들어가고, 부하직원이 있는 사원들의 이름과 월급, 근무도시를 출력하시오(employees 테이블 활용)

select first_name, salary, city
from employees e join departments d on d.manager_id = e.employee_id
                 join jobs j on e.job_id = j.job_id and job_title like '%Manager%'
                 join locations l on d.location_id = l.location_id;
출제자                 
                 select last_name, salary, city,job_title
from employees e, departments d, locations l,jobs j
where l.location_id=d.location_id and d.department_id=e.department_id 
and e.job_id=j.job_id 
and exists(select null from employees where manager_id=e.employee_id)
and lower(job_title) like '%manager%';


--4- 2. 'RESEARCH' 부서에 근무하는 사원들 이름, 부서번호, 급여를 조회하세요.

select ename, d.deptno, sal
from emp e join dept d on e.deptno = d.deptno
where d.dname = 'RESEARCH';

--4- 3. ADAMS 사원이 근무하는 부서이름과 지역이름을 출력하시오.

select dname, loc
from dept d join emp e on d.deptno = e.deptno
where e.ename = 'ADAMS';

-- 4-4. 직무를 옮긴 적이 있는 사람들의 사원번호, 이름(last_name)과 제일 처음 직무와 현재 직무를 사원번호 순으로 출력하세요
4. 부서를 옮긴 사람의 사원번호, 이름 (last_name)과 현재부서와 과거부서를 이름순으로 출력하세요. 
 출력 예시 
사원번호 이름     현재부서  부서이동 
??????????????
101  Kochhar AD_VP   AC_ACCOUNT -> AC_MGR
102 De Haan  AD_VP    IT_PROG
114 Raphaely PU_MAN   ST_CLERK
122 Kaufling St_MAN   ST_CLERK
176 Taylor   SA_REP   SA_REP -> SA_MAN
200 Whalen   AD_ASST  AD_ASST -> AC_ACCOUNT
201 Hartstein MK_MAN  MK_REP

select e.employee_id 사원번호, last_name 이름, e.job_id 현재직무, j.job_id 부서이동
from employees e join job_history j on e.employee_id = j.employee_id
where e.employee_id in(select employee_id from job_history 
group by employee_id having count(job_id) = 1)
UNION
select e.employee_id 사원번호, last_name 이름, e.job_id 현재직무, j1.job_id || ' -> ' || j2.job_id 부서이동
from employees e join job_history j1 on e.employee_id = j1.employee_id
                 join job_history j2 on e.employee_id = j2.employee_id and j1.start_date < j2.start_date
order by 1;

-- 출제자
select e.employee_id,e.last_name,e.job_id 현재부서, 
  (select (listagg(job_id, '-> ') within group (order by start_date))
            from job_history 
            where employee_id =e.employee_id 
            group by employee_id) as 부서이동
from employees e 
where exists (select h.employee_id 
              from job_history h 
              where h.employee_id = e.employee_id)
order by 1;


-- 2번 이상 옮긴 사람
select employee_id, last_name , job_id current_job
from employees M
where      2 <= ( select count(*) from job_history
                   where employee_id = M.employee_id);