-- 데이터 제한과 정렬
-- 데이터제한 : where, 조건의 평가가 참인 데이터만 화면에 display 해라

-- 부서번호가 10번인 사원의 이름과 급여를 조회하세요.
select ename, sal, deptno
from emp
where deptno = 10;  -- 화면에 뿌려주지만 않을뿐이지, 데이터는 emp 모든 데이터를 가져옴

-- 직무가 SALESMAN인 사원들을 조회하세요.
select ename, job, deptno, sal
from emp
where job = 'SALESMAN';

-- 입사일이 82/01/01 이후인 사원들 정보를 조회하세요.
select ename, hiredate
from emp
where hiredate > '82/01/01';

-- 날짜 파라미터 세션 바꾸기
alter session set NLS_DATE_FORMAT = 'DD-MON-RR';    -- 날짜 포맷을 이렇게 변경하겠다
select ename, hiredate
from emp
where hiredate > '01-1월-82';    -- 현재 korean으로 되어있어서 이렇게 가운데 한글로 써야함

alter session set NLS_LANGUAGE = 'AMERICAN';    -- korean -> american 으로 변경
select ename, hiredate
from emp
where hiredate > '01-JAN-82';
-- 그러나 재접속을 하면, 원래대로 변경됨

-- 비교연산자 사용하기 ==> 두 개 조건 모두 만족하기 'and' / 'or'
select ename, sal
from emp
where sal>=2000 and sal<=3000;
-- 위의 식은 아래처럼 바꿔쓸 수도 있음 ==> between A and B
select ename, sal
from emp
where sal between 2000 and 3000;

-- 급여가 2000원에서 3000원 사이가 아닌 사원을 조회하라 (not between a and b)
select ename, sal
from emp
where sal not between 2000 and 3000;

-- 부서가 10이거나 20인 사원들을 조회하라
select ename, sal, deptno
from emp
where deptno = 10 or deptno = 20;
-- 다른 방식으로 더 간단히 표현할 수 있음 ==> IN (A,B) ==> IN은 OR 연산이구나!★
select ename, sal, deptno
from emp
where deptno IN (10,20);

-- 10이 아니고, 20도 아닌 사람 ==> NOT이 붙으면 AND ==> NOT IN은 AND 연산이구나!★
select ename, sal, deptno
from emp
where deptno NOT IN (10,20);

-- LIKE : 특정한 패턴의 데이터를 찾을 때 사용 ==> 
-- '찾을문자%' (% : 0개 이상의 문자를 나타냄)
-- '_찾을문자' (_ : 1개의 임의의 문자를 나타냄)
select ename
from emp
--where ename like 'S%';      -- S로 시작하는 사람
where ename like '_C%';     -- 두번째 문자가 C인 사람

-- 사원 이름이 'S'로 시작하는 사람
select ename
from emp
where ename like 'S%';

-- 사원 이름이 'S'로 끝나는 사람
select ename
from emp
where ename like '%S';

-- 사원 이름에 'S'가 들어가는 사람
select ename 
from emp
where ename like '%S%';