--3-1.'New york'에 근무하는 사람들의 ename, job,loc, 연봉을 구하시오 (comm 포함)
select ename,job,loc,(sal+nvl(comm,0))*12 "YEAR SAL"
from emp e,dept d
where e.deptno=d.deptno and loc = 'NEW YORK';

--3-2 사원의 이름 급여 급여등급중 등급이 2등급인 사람만 보여주시오
select ename,sal,grade
from emp , salgrade
where (sal between losal and hisal) and grade =2;

--3-3 급여가 20번 부서의 평균보다 낮은 사원의 사원 번호, 이름 ,급여,직무 를 출력하라
select empno,ename,sal,job
from emp
where sal < (select avg(sal) from emp where deptno = 20);

--3-4 NEW YORK에서 근무하는 사원중 월급이 전체 평균 급여보다 높은 사원의 이름, 급여, 직무를 출력하고
--급여가 높은순으로 정렬하시오

select ename,sal,job
from emp e,dept d
where e.deptno = d.deptno and d.loc='NEW YORK' and sal > (select avg(sal) from emp)
order by 2 desc; 

--3-5 전 사원중 급여가 가장 높은 사원이 있는 부서의 위치는 어디인지 출력하라
select loc
from emp e,dept d,(select max(sal) max_sal from  emp) a
where a.max_sal = e.sal and e.deptno =d.deptno;

--3-6 부서번호, 사원번호, 사원의 이름, 급여, 부서내 급여등수, 전체 급여등수가 중복되지 않게 부서번호 순서로 출력하라 
select deptno,empno,ename,sal,
      row_number() over (partition by deptno order by sal) as "partitian rank",
      row_number() over (order by sal) "rank"
from emp
order by deptno;