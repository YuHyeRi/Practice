-- 변환함수
-- 숫자 => 문자, 문자 => 숫자 : to_char
-- 문자 => 숫자 : to_number
-- 문자 => 날짜 : to_date

-- 문제1. 사원의 이름, 입사일 display하고 입사요일을 표시하라. 단, 화요일에 입사한 사원만 display
select ename, hiredate, to_char(hiredate, 'day') as 몇요일
from emp
where to_char(hiredate, 'day') = '화요일';

-- 문제2. 입사요일 순으로 sort하라
select ename, hiredate, to_char(hiredate, 'rr/fmmm/dd day d') as etc -- day:요일, d:몇번째요일인지, fm:0삭제후display
from emp
order by to_char(hiredate);

-- to_char(숫자형 => 문자형 바꾸기)
select ename, sal, to_char(sal, '$9,999')   -- 9의 자리수만큼 채움
from emp;

-- 기타함수
-- NVL(a,b) : a가 null이면 b를 반환
select ename, nvl(sal,1000), nvl(job, '※no job'), nvl(hiredate, null) from emp2;

-- NVL2(a,b,c) : a가 null이면 b를 반환, null이 아니면 c를 반환
select ename, sal, comm, nvl2(comm,sal+comm,sal) from emp2;

-- COALESCE(a,b,c,d,...) : 처음으로 만나는 null이 아닌 값을 반환
select ename, sal, comm, coalesce(sal+comm, sal, null) from emp2;

-- nullif(a,b) : a,b 두개의 값이 같을땐 null을 리턴, 서로 다르면 첫번째 값을 리턴함
-- greatest(a,b,...) : 주어진 값 중에 가장 큰 값을 리턴
-- least(a,b,...) : 주어진 값 중에 가장 작은 값을 리턴