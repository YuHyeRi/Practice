-- 문자함수

-- upper, lower, initcap
-- 1. upper : 대문자로 변환
select * from emp2
where upper(ename) = 'SCOTT';
-- 2. lower : 소문자로 변환
select * from emp2
where lower(ename) = 'scott';
-- 3. initcap : 첫글자만 대문자, 나머지 소문자
select * from emp2
where initcap(ename) = 'Scott';
-- 예제
select last_name, upper(last_name) 대문자, lower(last_name) 소문자
       , initcap(last_name) 대소문자
from employees;

-- concat, substr, instr, length
-- 1. concat : 문자열을 합침
select ename, job, concat(ename,job)
from emp;
select ename||sal as "||연산자", concat(ename,sal) as "concat"
from emp;
-- 2. substr : 주어진 문자열에서 시작위치로부터 정해진 갯수만큼의 문자열을 추출
select ename, substr(ename,2,3) 양수, substr(ename,-2) 음수
from emp;
-- 3. instr : 주어진 문자열에서, 찾고자하는 문자, 시작위치에서, 몇번째 순서인지 ==> 숫자를 리턴
select instr('Oracle server version 11g', 'ver', 1, 2) as instr  -- ver 문자열의 위치 찾기
from dual;
-- 4. substr + instr 중첩
select substr('Oracle server version 11g', instr('Oracle server version 11g', 'ver', 1, 2), 7) as 중첩
from dual;
-- 5. length, lengthb(몇바이트인지)
select last_name, length(last_name) as "last name 길이", first_name, length(first_name) as "first name 길이"
from employees;
-- length 관련 문제 : 이름이 4글자인 사람 찾기
select ename from emp
where length(ename) = 4;

-- LPAD(왼쪽채움), RPAD(오른쪽채움)
select ename, lpad(ename,7,'*') as lpad    -- 총 7글자를 만드는데 왼쪽부터 공백은 *로 채워라 ('*'가 없다면 공백으로 처리됨)
            , rpad(ename,7,'*') as rpad
from emp;

-- trim : 문자열 잘라내기 (both:디폴트값, LTRIM, RTRIM)
select ename, trim('S' from ename) as both
            , trim(leading 'S' from ename) as left  -- 앞에 나오는 'S' 자르기
            , trim(trailing 'S' from ename) as right    -- 뒤에 나오는 'S' 자르기
from emp;

-- replace
select replace ('ababc', 'ab', 'xy')
from dual;