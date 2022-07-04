--Q1. job_id, department_id를 출력하고 부서를 10,50,20에 대한 직무목록을 이 순서대로 출력하라
-- ver.1
select distinct job_id, department_id 
from employees
where department_id in (10,50,20)
order by decode (department_id, 10,1, 50,2, 20,3);
-- ver.2 (집합연산자 이용, union all : 중복O, 정렬X)
select distinct job_id, department_id from employees
where department_id = 10
union all
select distinct job_id, department_id from employees
where department_id = 50
union all
select distinct job_id, department_id from employees
where department_id = 20;

-- Q2. 10, 20, 30번 부서에 대한 다음과 같은 보고서를 작성합니다.
-- >> 중복행이 없다면 union(중복X, 정렬O)보다는 union all을 선택하자
-- >> 정렬된 순서를 원한다면 문장 마지막에 order by절을 사용
-- ver.1 (집합연산자 이용, union : 중복X, 정렬O)
select department_id, job_id, sum(salary)
from employees
where department_id in (10,20,30)
group by department_id, job_id
union
select department_id, null, sum(salary)
from employees
where department_id in (10,20,30)
group by department_id, job_id
union
select null, null, sum(salary)
from employees
where department_id in (10,20,30);

-- ver.2 rollup
-- rollup과 집합연산의 차이 : rollup이 성능상 이점이 있다
select department_id, job_id, sum(salary)
from employees
where department_id in (10,20,30)
group by rollup(department_id, job_id);

-- Q3. 부서 테이블에 존재하는 소속부서가 있는 사원정보를 검색하라(서브쿼리)
select * from emp
where deptno in (select deptno from dept);
select * from dept
where deptno in (select deptno from emp);

select e.* from emp e, dept d
where e.deptno = d.deptno;
select d.* from emp e, dept d
where e.deptno = d.deptno;
-- 따라서 관리자들의 정보를 보려면 emp부하직원, emp관리자 다:1의 관계이므로 조인을 하면
-- '다'에 해당되는 행 건수가 출력됨을 주의

select distinct(e.empno), e.ename 
from emp e, emp2 e2
where e.empno = e2.mgr;
