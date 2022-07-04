-- 문제1
select last_name||' earns ' || to_char(salary,'fm$99,999') 
        || ' monthly but wants ' || to_char(salary*3,'fm$99,999') as "Dream Salaries"
from employees;

-- 문제2
select last_name, first_name, nvl(to_char(commission_pct), 'No Commission') COMM
from employees;

-- 문제3
select last_name, to_char(hire_date,'DD-MM-YY') as hiredate,
        to_char(hire_date,initcap('DAY'), 'NLS_date_language=english') as day
from employees
order by to_char(hire_date-1,'D');  -- 월요일부터 보길 원하니까 (ex.일요일-1 : 월요일)

-- 문제4
select last_name, hire_date
from employees
where to_char(hire_date, 'MM') = '01';
-- where to_char(hire_date,'MON') like '1월%'; 

update emp2 
set hiredate = sysdate  -- sysdate : 현재날짜 + 시분초까지 들어감
where empno = 9000;
rollback;               -- rollback 하면 원래대로 돌아감
commit;

-- 방법1. 정확히 시분초까지 입력하기 (현실적으로 별로)
select ename, to_char(hiredate, 'rr-mm-dd HH24:MI:SS')
from emp2
where hiredate = to_date('21-07-22 14:10:01', 'rr-mm-dd HH24:MI:SS');   -- 때문에 날짜와 시분초까지 일치해야함

-- 방법2. date 컬럼의 변형
select ename, to_char(hiredate, 'rr-mm-dd HH24:MI:SS')
from emp2
where to_char(hiredate, 'RR/MM/DD') = '21/07/22';

-- 방법3. between 하한 and 상한
select ename, to_char(hiredate, 'RR/MM/DD HH24:MI:SS')
from emp2
where hiredate between to_date('21-07-22 14:10:01', 'rr-mm-dd HH24:MI:SS')
                and to_date ('21-07-22 23:59:59', 'rr-mm-dd HH24:MI:SS');
                
-- 방법4. 데이터 입력시점에서 아예 정제해서 입력
update emp2
set hiredate = trunc(sysdate)
where to_char (hiredate, 'RR/MM/DD') = '21/07/22';

select ename, to_char(hiredate, 'RR/MM/DD HH24:MI:SS')
from emp
where hiredate = to_date('21/07/22', 'RR/MM/DD');

-- more detail
-- ==> index에 관한 인강 보기
create index emp_hiredate_idx on emp(hiredate);
select * from emp;
select hiredate, rowid from emp order by hiredate;

-- 날짜를 date로 지정하지 않고 char로 저장한다면 (ex.'20210722')
--  ==> date함수사용, to_char(date,'fmt') day, q, w, date cleansing 필요