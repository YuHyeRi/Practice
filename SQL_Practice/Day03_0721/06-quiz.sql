-- 1. 월급이 3000 인 사원들의 이름과 월급 출력
select ename, sal from emp
where sal=3000;

-- 2. 직업이 SALESMAN 인 사원들의 이름과 직업을 출력
select ename, job from emp
where job='SALESMAN';

-- 3. 월급이 2500 이상인 사원들의 이름과 월급을 출력
select ename, sal from emp
where sal >= 2500;

-- 4. 직업이 SALESMAN 이 아닌 사원들의 이름과 직업을 출력
select ename, job from emp
where job != 'SALESMAN';

-- 5. 이름, 연봉 출력하는데 연봉은 월급*12, 컬럼명은 '연봉'으로 출력
select ename, sal, sal*12 as 연봉 from emp;

-- 6. 월급이 1000 에서 3000 사이인 사원들의 이름과 월급을 출력
select ename, sal from emp
where sal between 1000 and 3000;

-- 7. 월급이 1000 에서 3000 사이가 아닌 사원들의 이름과 월급을 출력
select ename, sal from emp
where sal not between 1000 and 3000;

-- 8. 1981 년도에 입사한 사원들의 이름과 입사일을 출력
select ename, hiredate from emp
where hiredate between '81-01-01' and '81-12-31';

-- 9. 이름이 'S'로 시작하는 사원들의 이름을 출력
select ename from emp
where ename like 'S%';

-- 10. 이름이 'T'로 끝나는 사원들의 이름 출력
select ename from emp
where ename like '%K';

-- 11. 이름 두번째 철자가 'M'인 사원들의 이름 출력
select ename from emp
where ename like '__M%';