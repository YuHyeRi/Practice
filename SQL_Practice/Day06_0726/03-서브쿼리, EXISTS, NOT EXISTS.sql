-- ★ SUBQUERY (서브쿼리)
-- 1. 일반적인 서브쿼리 : 가장 안쪽의 서브쿼리가 수행되고 바깥쪽의 서브쿼리가 수행된다
-- example. 회사 평균보다 급여를 많이 받는 사원들의 정보를 조회하세요
SELECT * FROM EMP 
where sal > (select avg(sal) from emp)
ORDER BY DEPTNO;

-- 2. 상호연관된 서브쿼리 (COORELATED SUBQUERY) 
-- example. 소속부서의 평균보다 급여를 많이 받는 사원들의 정보를 조회하세요.

-- 1. M QUERY가 수행되서 한 행을 가져온다  
-- 2. 서브쿼리가 수행된다.
-- 3. 조건 비교한다. => 행 선택
-- 4. 반복

SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP M
where sal > (select avg(sal) from emp  WHERE DEPTNO = m.DEPTNO)
ORDER BY 4;

 -- ★ 3. EXISTS, NOT EXISTS(상호연관된 서브쿼리 (COORELATED SUBQUERY))
 -- example. 소속사원이 한명이라도 있는 부서정보를 조회하세요.
SELECT *
FROM DEPT  M          -- 10, 20, 30
WHERE EXISTS (SELECT NULL FROM EMP WHERE DEPTNO =M.DEPTNO);  

-- example. 소속 사원이 한 명도 없는 부서정보를 조회하세요.
SELECT *
FROM DEPT M           -- 10, 20, 30 ,NULL
WHERE NOT EXISTS (SELECT NULL FROM EMP2 WHERE DEPTNO = M.DEPTNO);  