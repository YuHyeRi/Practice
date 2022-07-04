select sysdate, current_date(접속자의시간), systimestamp, current_timestamp(접속자의시간, 시분초까지)
from dual;

--1. 세션시간과 포맷 변경
alter session set time_zone = '-1:0'
alter session set nls_date_fromat = 'YYYY-MM-DD HH24:MI:SS'; -- 기본 sysdate 포맷을 바꾸는 것

--2. 날짜 추출함수 
select extract(year from sysdate) from dual;    -- year, month, day, minute, second
-- 가입한 회원 중 2,3,11,12월 가입한 회원을 추출하라
select * from members
where extract (month from regdate) in (2,3,11,12);

--3. 날짜 누적함수
select add_months(sysdate,1) from dual;
select add_months(sysdate,-1) from dual;
-- 가입한 회원 중에 가입한지 6개월이 안되는 회원을 조회하라
select * from members
where add_months(sysdate,-6) <  regdate;

--4. 날짜의 차이를 알아내는 함수 : months_between(날짜,날짜)
select round(months_between(sysdate, '2020-03-04')) from dual;

--5. 다음 요일을 알려주는 함수 : next_day(현재날짜, 다음요일) ==> 오늘이후 토요일은 몇일일까?
select next_day(sysdate, '토요일') from dual;
select next_day(sysdate, '토') from dual;
select next_day(sysdate, 7) from dual;

--6. 월의 마지막 일자를 알려주는 함수 : last_day(날짜)
select last_day(sysdate) from dual;