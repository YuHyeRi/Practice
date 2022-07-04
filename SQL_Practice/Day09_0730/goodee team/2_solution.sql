
2조 문제 : 7조 발표

2-1
select d.loc, count(e.empno)
from emp e, dept d
where e.deptno(+)= d.deptno
group by d.loc
having count(e.empno) <= 5
order by count(e.empno);


2-2
select  department_id as 부서번호, count(*) as 사원수
from employees
group by department_id
having count(*) = (select max(count(*))from employees group by department_id);

2-3
SELECT ename, sal, loc
FROM emp e JOIN dept d
ON e.deptno = d.deptno
WHERE sal > ( SELECT avg(sal)
              FROM emp e JOIN dept d
              ON e.deptno = d.deptno
              AND loc = 'CHICAGO'
              GROUP BY loc );

select last_name, salary, city  
from employees e, departments d, locations  l
where e.department_id= d.department_id
and d.location_id = l.location_id 
and salary > ( select avg(salary) from employees e, departments d, locations l
               where e.department_id= d.department_id
                 and d.location_id = l.location_id 
               -- and initcap(l.city)='Chicago');
                and initcap(l.city)='Seattle')
and  initcap(l.city)<>'Seattle';                  
              
              
2-4
4. 각 부서 별 최대 급여자의 아이디(employee_id), 이름(first_name),근무부서(department_id), 급여(salary)를 출력하시오. 
--    단, 최대 급여자가 속한 부서의 평균급여를 같이 출력하여 평균급여와 비교할 수 있게 할 것.
select E.EMPLOYEE_ID AS 아이디, E.FIRST_NAME AS 이름, A.DEPARTMENT_ID AS 근무부서, A.SALARY AS 급여, A.AVG AS 부서평균
from EMPLOYEES E, (
                    SELECT E.DEPARTMENT_ID, MAX(E.SALARY) AS max_sal, ROUND(AVG(E.SALARY)) AS AVG
                    FROM EMPLOYEES E, DEPARTMENTS D
                    WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
                    GROUP BY E.DEPARTMENT_ID
                  ) A
where E.SALARY = A.max_sal AND E.DEPARTMENT_ID = A.DEPARTMENT_ID
order by A.DEPARTMENT_ID;