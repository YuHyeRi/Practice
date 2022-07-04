1번 문제
select ename, job, e.deptno, loc, rank () over(order by sal desc)
from emp e join dept d
on e.deptno=d.deptno and loc = 'CHICAGO';

-- 출제자 정답
select e.ename,e.job,e.deptno,d.deptno , d.loc,rank() over( order by sal desc)SAL_Rank
from emp e ,dept d
where e.deptno = d.deptno
    and d.loc = 'CHICAGO';

2번 문제
SELECT 학생테이블.* FROM ( 
    SELECT '001' as num, '권혁' AS 이름, '정보처리기사' as 과목 , 'O' as "1차", 'O' as "2차", 'O' as "3차", 3 as 시험횟수
    FROM DUAL 
    UNION ALL
    SELECT ' ' as num, ' ' AS 이름, '정보보안기사' as 과목 , 'O' as "1차", 'O' as "2차", ' ' as "3차", 2 as 시험횟수
    FROM DUAL 
    UNION ALL
    SELECT '002' , '김기' , '정보처리기사' as 과목 ,'O' as "1차", 'O' as "2차", 'O' as "3차", 3 as 시험횟수
    FROM DUAL 
    UNION ALL
    SELECT ' ' as num, ' ' AS 이름, '정보보안기사' as 과목 , ' ' as "1차", ' ' as "2차", ' ' as "3차", 0 as 시험횟수
    FROM DUAL 
    UNION ALL
    SELECT '003' , '권나', '정보처리기사' as 과목, 'O' as "1차", 'O' as "2차", '' as "3차", 2 as 시험횟수
    FROM DUAL
    UNION ALL
    SELECT ' ' as num, ' ' AS 이름, '정보보안기사' as 과목 , 'O' as "1차", ' ' as "2차", ' ' as "3차", 1 as 시험횟수
    FROM DUAL 
    UNION ALL
    SELECT '004' , '권용', '정보처리기사' as 과목, 'O' as "1차", '' as "2차", '' as "3차", 1 as 시험횟수
    FROM DUAL
    UNION ALL
    SELECT ' ' as num, ' ' AS 이름, '정보보안기사' as 과목 , ' ' as "1차", 'O' as "2차", 'O' as "3차", 2 as 시험횟수
    FROM DUAL) 
    학생테이블; 

-- 2 출제자 정답

정답2

WITH student AS
(
    SELECT '001' stu_id, '김기' stu_name FROM dual
    UNION ALL SELECT '002', '권나' FROM dual
    UNION ALL SELECT '003', '권혁' FROM dual
    UNION ALL SELECT '004', '권용' FROM dual
)
, course AS
(
    SELECT '001' sub_id, '정보처리기사' sub_name FROM dual
    UNION ALL SELECT '002', '정보보안기사' FROM dual
)
, study AS
(
    SELECT '001' stu_id, '001' sub_id, 1 Attempt FROM dual
    UNION ALL SELECT '001', '001', 2 FROM dual
    UNION ALL SELECT '001', '001', 3 FROM dual
    UNION ALL SELECT '001', '002', 1 FROM dual
    UNION ALL SELECT '001', '002', 2 FROM dual
    UNION ALL SELECT '002', '001', 1 FROM dual
    UNION ALL SELECT '002', '001', 2 FROM dual
    UNION ALL SELECT '002', '001', 3 FROM dual
    UNION ALL SELECT '003', '001', 1 FROM dual
    UNION ALL SELECT '003', '001', 2 FROM dual
    UNION ALL SELECT '003', '002', 1 FROM dual
    UNION ALL SELECT '004', '001', 1 FROM dual
    UNION ALL SELECT '004', '002', 2 FROM dual
    UNION ALL SELECT '004', '002', 3 FROM dual
)
SELECT CASE WHEN co.sub_id = '001' THEN st.stu_id END AS "ID"
     , CASE WHEN co.sub_id = '001' THEN st.stu_name END AS "성명"
     , co.sub_name AS "스터디"
     , MIN(CASE WHEN sd.Attempt = 1 THEN '○' END) AS "1차"
     , MIN(CASE WHEN sd.Attempt = 2 THEN '○' END) AS "2차"
     , MIN(CASE WHEN sd.Attempt = 3 THEN '○' END) AS "3차"
     , COUNT(sd.stu_id) AS "참여횟수"
 FROM student st
CROSS JOIN course co
 LEFT OUTER JOIN study sd
   ON st.stu_id = sd.stu_id
  AND co.sub_id = sd.sub_id
GROUP BY st.stu_id, st.stu_name, co.sub_id, co.sub_name
ORDER BY st.stu_id, co.sub_id;


3번 문제
select employee_id,first_name,last_name,
       hire_date,
substr((to_char(sysdate,'YYYY')-substr(ssn,1,2)),-2,2)+1 age,
to_date(substr(ssn,1,6),'RR-MM-DD') birth_day,
       case  when to_char(substr(ssn,3,2)) between 03 and 08 then add_months(add_months(last_day('01-08-01'),
             to_char(to_date(substr(ssn,1,6),'RR-MM-DD'),'RRRR')*12),61*12)
             when to_char(substr(ssn,3,2)) between 09 and 12 then add_months(add_months(last_day('01-02-01'),
             to_char(to_date(substr(ssn,1,6),'RR-MM-DD'),'RRRR')*12),62*12)
             when to_char(substr(ssn,3,2)) between 01 and 02 then add_months(add_months(last_day('01-02-01'),
             to_char(to_date(substr(ssn,1,6),'RR-MM-DD'),'RRRR')*12),62*12)
             end retire_day,to_char(salary+salary*nvl(commission_pct,0),'$999,999') salary,
            lpad(to_char(round((months_between(sysdate,hire_date))/12)*(salary+salary*nvl(commission_pct,0)),'$999,999,999'),13,' ') AS severance_pay
from employees;


--3 출제자 정답
select employee_id "사원 번호"
      ,ename "사원 명"
      ,ssn "주민 번호"
      ,hire_date "입사 일자"
      ,age "현재 나이"
      ,expireday "정년 퇴직일"
      ,monthsal 월급
      ,trunc( trunc(months_between(expireday,hire_date))/12)*monthsal AS 퇴직금

FROM
(
    select employee_id 
          ,ename
          ,ssn
          ,hire_date
          ,age
          ,last_day(
               case
                   when substr(SSN,3,2) between '03' and '08' 
                   then to_char(add_months(sysdate, (63 -person.age)*12), 'yyyy-')
                   else to_char(add_months(sysdate, (64 -person.age)*12), 'yyyy-')
               end 
               ||
               case
                   when substr(SSN,3,2) between '03' and '08'
                   then '08-01'
                   else '02-01'
               end
               )
               AS expireday
           ,monthsal
    FROM
    ( select employee_id
           , first_name || ' ' || last_name AS ename
           , hire_date
           , case
             when substr(SSN,7,1) in ('3','4') then substr(extract(year from sysdate), 3,4) - substr(SSN,1,2) + 1
             else extract(year from sysdate) - (1900 + substr(SSN,1,2)) + 1  
             end AS age
            ,SSN
            ,nvl( salary +(salary*commission_pct), salary ) AS monthsal
      from employees
    ) person
);

SELECT  TO_CHAR( ADD_MONTHS(SYSDATE, 1), 'YYYYmmDD') FROM DUAL;


