-- 날짜 함수
-- 새로운 ttest 테이블 생성
create table ttest(a number, b date);
insert into ttest values(1, '95/01/01');
insert into ttest values(2, '49/01/01');
insert into ttest values(3, to_date('1949/01/01', 'YYYY/MM/DD'));
-- alter session : 현재 데이터베이스에 영향을 미치는 조건이나 parameter 설정 (session 종료시까지 유효)
alter session set nls_date_format = 'RRRR/MM/DD HH24:MI:SS';    -- HH24, HH12
select * from ttest;

select sysdate, sysdate+1 from dual;        -- sysdate + 1 : 1일 더하기
select sysdate, sysdate+1/24 from dual;     -- sysdate + 1/24 : 1시간 더하기
select sysdate, sysdate+1/1440 from dual;   -- sysdate+1/1440 : 1분 더하기

select ename, hiredate, trunc(sysdate-hiredate) as "work day" from emp;
select sysdate, localtimestamp, systimestamp from dual;
-- localtimestamp : timestamp 소수점 이하 9자리까지의 정밀초까지 표시
-- systimestamp : timestamp with timezone

-- months_between(dt1, dt2) : dt1과 dt2 사이의 개월수
-- add_month2(dt,n) : dt에 n개월을 더한 날짜
-- next_day(dt,n) : 주어진 dt이후의 해당 요일의 날짜 (n = 요일구분, 1~7, 1(일요일)~)
-- last_day(dt) : 해당날짜가 속한 월의 마지막 날짜
select employee_id, hire_date,
        round(months_between(sysdate, hire_date)) as tenure,
        add_months(hire_date, 6) as review,
        next_day(hire_date, '금요일') as nextDay,
        last_day(hire_date) as lastday
from employees;

select to_char(sysdate,'DAY') from dual;    -- day : 요일
select next_day(sysdate,'목요일') from dual;   -- 금일 날짜 이후에 가장 빠른 목요일의 날짜

-- round
select sysdate, round(sysdate, 'year') as year,     -- 금년 이후 내년 (단, 그 이후 모두 초기화)
                round(sysdate, 'month') as month,   -- 이번달 이후 다음달 (단, 그 이후 모두 초기화)
                round(sysdate, 'day') as day        -- 다음주의 첫날 (단, 그 이후 모두 초기화)
from dual;

-- etc
select to_char(sysdate+1) from dual;    -- 오늘날짜+1일
select to_char(sysdate+1/24) from dual; -- 현재시간+1시간
