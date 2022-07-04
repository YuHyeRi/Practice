-- 숫자함수

-- round : 소수점 이하 반올림
-- trunc : 소수점 이하 버림
-- ceil : 무조건 올림 / floor : 무조건 내림

select round(12.345, 2) from dual;  -- 소수점 이하 2번째 자리수 반올림
select round(12.345, -1) from dual; -- 소수점 이상 2번째 자리수 반올림
select trunc(12.345, 2) from dual;  -- 소수점 이하 2번째 자리까지만 display, 나머지 버림

-- mod : 앞의 숫자를 뒤의 숫자로 나눈 나머지값을 리턴
-- ABS : 절대값을 리턴
-- sign : 뺄셈의 결과가 0보다 작으면 -1을 리턴, 0보다 크면 +1을 리턴, 0이면 0을 리턴
-- power : m의 n승을 나타냄 (ex. POWER(10,2) ==> 10의 2승)
select ename, sal, mod(sal,1000) from emp;
select last_name, salary, sign(salary-3000) from employees;

select last_name, salary, sign(salary-3500) as over_3500 
from employees
where department_id = 30 and sign(salary-3500)=1;

-- select절에 정의한 컬럼별칭(ex. over_3500)을 where절에서 사용할 수 없다
-- 그치만 꼭 사용을 해야겠다면, from절에서 inline view(가상의테이블)로 정의한다면 가능!
select last_name, salary, sign(salary-3500) as over_3500
from(select last_name, salary, sign(salary-3500) as over_3500 from employees)
where over_3500 = 1;