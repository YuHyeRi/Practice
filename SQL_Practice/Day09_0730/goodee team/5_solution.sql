5조 출제 문제 - 풀이 6조

1. location_id가 1800인 사원의 first_name과 location_id를 출력하시오. 

select first_name, location_id
from employees e join departments d on (e.department_id = d.department_id)
where location_id = 1800;

2. emp에서 월급이 제일 적은사람과 제일 많은사람의 평균값을 출력

1)
select avg(sal)
from emp
where sal = (select min(sal) from emp) or sal = (select max(sal) from emp);

2)
select min(sal) min_sal, max(sal) max_sal, (max(sal)+min(sal))/2 avg_minmax
from emp;