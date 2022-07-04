--★DDL : create, alter, drop (정의, 수정, 삭제)
--★DML : insert, select, update, delete (삽입, 선택, 수정, 삭제)
--★DCL : grant, revoke (권한주기)
-- 작성순서 : select / from / where / group by / having / order by


-- 1. create : 테이블 생성하기
-- 고정길이는 'char', 가변길이면 'varchar2' (cf. nchar, ncarchar2)
create table "member" (       -- 혹시 예약어일 경우, " "로 감싸준다
        ID varchar2(50),
        PW varchar2(50),
        name varchar2(50),
        gender nchar(2),
--      gender char(2)  : 2byte를 쓰겠다. 한글 2글자가 아님
--      gender char(6)  : 6byte를 쓰겠다. 한글 2글자가 6byte 
--      gender char(2 char) : char(문자)를 2개 쓰겠다
        age number(3), 
        birthday char(10),  -- ex) 1991-01-01
        phone char(13),     -- ex) 010-9194-7700
        redate timestamp  -- 시간까지 나옴 (cf. date 날짜만 나옴)
);

-- 2. drop : 테이블 삭제하기
drop table member;

-- 3. alter modify : 수정하기
alter table member modify id nvarchar2(50);

-- 4. alter drop : 삭제하기
alter table member drop column age;

-- 5. alter add : 추가하기
alter table member add email varchar2(200);

-- 추가. lengthb : 몇바이트인지 알려줌
ex) select lengthb('AB') from dual; -- 2byte
ex) select lengthb('한글') from dual; -- 6byte

-- 6. insert into : 데이터 입력하기
insert into member(id, pwd) values('newlec' ,'1111');
insert into member(id, pwd) values('dragon', '2222');
insert into member(id, pwd) values('test', '1234');

-- 7. update set (where 조건절을 꼭 포함한다!!!!)
update member set pwd = '1111' where id = 'newlec';
select * from member;

-- 8. delete (where 조건절을 꼭 포함한다!!!!)
delete member where id = 'test';