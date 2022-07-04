-- 날짜함수 추가
select sysdate from dual;
select to_char(sysdate, 'YYYY/MM/DD HH24:MI:SS Q DDD/DD/D day') from dual;

-- 80년 2월 18일 이후 입사자 찾기
select ename, hiredate, to_char(hiredate, 'DAY') from emp
where hiredate > to_date('18, 80 2월', 'DD, RR MON');

-- 현재 셀렉트 문 안에서만 영문으로 보고 싶을때
select ename, hiredate, to_char(hiredate, 'DY', 'NLS_date_language=american') as 요일
from emp;

-- 기타함수 추가(nullif, decode, case)
-- 1. NULLIF(a,b) : if a=b, null 리턴, else a를 리턴
select first_name, length(first_name) as expr1,
        last_name, length(last_name) as expr2,
        nullif(length(first_name), length(last_name)) as result
from employees;

-- 2. decode(칼럼명, '찾을문자', '계산식')
select ename, deptno, sal, decode(deptno, 10, sal*1.1, 
                                          20, sal*1.2, 
                                              sal)      as inc_sal
from emp
order by deptno;

-- 3. case 컬럼명 when 조건 then실행문 else end
-- decode도 많이 쓰고 좋지만, 가독성과 범위조건이 더 좋음 ==> 'CASE Expression'
select ename, deptno, sal,
case deptno when 10 then sal*1.1
            when 20 then sal*1.2
                    else sal      
            end                     as inc_sal
from emp
order by deptno;

-- case문에 범위조건 주기
select ename, sal, case when sal>3000 then sal*0.1
                        when sal>2000 then sal*0.01
                        else 10
                        end                             as tax
from emp;

-- case문에 범위조건 주기 2
select last_name, salary, case when salary < 5000 then 'low'
                               when salary < 10000 then 'medium'
                               when salary < 20000 then 'good'
                               else 'Excellent' 
                               end                                  as q_salary
from employees
order by salary;

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
                and to_date ('21-07-22 23:59:59', 'rr-mm-dd HH24:MI:SS')
