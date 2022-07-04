drop table emp;     -- 기존 emp 테이블 삭제
select * from emp;
commit;

-- emp 테이블 생성
CREATE TABLE EMP ( 
  EMPNO     NUMBER(4, 0), 
  ENAME     VARCHAR2(10), 
  JOB       VARCHAR2(9), 
  MGR       NUMBER(4, 0), 
  HIREDATE  DATE, 
  SAL       NUMBER(7, 2),
  COMM      NUMBER(7, 2), 
  DEPTNO    NUMBER(2, 0));

insert into emp values (7369,'김철수','사원',7902,'2000-12-17',200,null,20);
insert into emp values (7499,'이찬수','주임',7698,'2001-02-20',260,300,30);
insert into emp values (7521,'박종수','주임',7698,'2002-02-22',325,500,30);
insert into emp values (7566,'임채호','과장',7839,'2001-04-02',497,null,20);
insert into emp values (7654,'나대호','주임',7698,'2001-09-28',325,1400,30);
insert into emp values (7698,'박지성','과장',7839,'2001-05-01',485,null,30);
insert into emp values (7782,'구자철','과장',7839,'2001-06-09',445,null,10);
insert into emp values (7788,'송기성','부장',7566,'1997-04-17',500,null,20);
insert into emp values (7839,'김철호','대표',null,'2001-11-17',800,null,10);
insert into emp values (7844,'성명준','주임',7698,'2001-09-08',350,0,30);
insert into emp values (7876,'황인태','사원',7788,'2007-05-23',210,null,20);
insert into emp values (7900,'박민성','사원',7698,'2001-12-03',295,null,30);
insert into emp values (7902,'박진성','부장',7566,'2001-12-03',600,null,20);
insert into emp values (7934,'최철호','사원',7782,'2012-01-23',230,null,10);

-- 테이블 복사(레코드제외)
create table test as select * from emp where 1=0;
-- PL/SQL
declare                 -- 선언부
 i number := 1;         -- := 대입연산자 (숫자형 변수 i에 1을 대입)
 begin      
    while i<=991 loop   -- 반복문
        insert into test (empno, ename) values(i, '사원'||i);     -- || 결합연산자
        i:=i+1;         -- i값을 1 증가
 end loop;
end;
/                       -- 이거 꼭 써줘야함! 오타가 아니다
-- 테이블 확인
select * from test;
select count(*) from test;
-- rownum : 레코드의 순번
select rownum, empno, ename from test;

-- 순번대로 뽑기
select A.*, rownum as rn
from (
    select empno, ename
    from test
    order by empno
    ) A;

-- 페이지 나누기 (MySQL에서의 limit)
select * 
from (select A.*, rownum as rn
        from (select empno, ename
                from test
                order by empno
            ) A
    )
where rn between 10 and 50;         -- 10번에서 50번까지 뽑겠다