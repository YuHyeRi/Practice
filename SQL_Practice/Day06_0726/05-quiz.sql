-- Q1. 토론토에서 근무하는 모든 사원의 성, 직무, 부서, 부서이름을 출력하라
select last_name, job_id, d.department_id, department_name, city
from employees e join departments d on(e.department_id = d.department_id)
                 join locations l on(d.location_id = l.location_id)
where initcap(city) = 'Toronto';

-- Q2. 사원번호, 사원명, 해당 사원의 관리자번호, 관리자명을 출력하라
select w.employee_id, w.last_name 사원명, w.manager_id, m.last_name as 관리자명
from employees w, employees m
where w.manager_id=m.employee_id;

-- Q3. KING을 비롯하여 해당 관리자가 지정되지 않은 모든 사원을 표시하고(2번문제수정), 사원번호순으로 정렬하시오
select w.employee_id, w.last_name 사원명, w.manager_id, m.last_name as 관리자명
from employees w LEFT OUTER JOIN employees m
ON w.manager_id = m.employee_id
order by 1;

-- Q4. 사원명과 부서명을 조회하는데 사원이 없는 부서정보도 같이 출력하고, 사원의 급여가 2000원 이상인 경우만 출력하세요.
-- 잘못된 예
select ename, sal, e.deptno, d.deptno, dname
from emp e right outer join dept d
on (e.deptno = d.deptno)
where sal >= 2000;  -- wrong!! 추가조건으로 인해 40번부서(outer join의 결과)가 사라짐

-- 옳은 예
select ename, sal, e.deptno, d.deptno, dname
from emp e right outer join dept d
on (e.deptno = d.deptno and sal >= 2000);   -- correct!! join조건 안으로 넣어라

-- 또 다른 방법
select ename, sal, e.deptno, d.deptno, dname
from emp e right outer join dept d
on (e.deptno = d.deptno)
where sal >= 2000 or sal is null;

-- oracle syntax VER.
-- 잘못된 예
select ename, sal, e.deptno, d.deptno, dname
from emp e, dept d
where e.deptno(+) = d.deptno
and sal >= 2000;    -- wrong! 추가조건으로 인해 40번부서(outer join의 결과)가 사라짐

-- 옳은 예
select ename, sal, e.deptno, d.deptno, dname
from emp e, dept d
where e.deptno(+) = d.deptno
and e.sal(+) >= 2000;    -- correct! join조건 안으로 넣어라