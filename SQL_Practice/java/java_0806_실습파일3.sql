-- 기존 테이블 삭제
drop table member;

-- 테이블 새로 생성
create table member (
userid varchar2(50) not null primary key,
passwd varchar(64) not null,                --varchar2가 아닌 varchar로 설정
name varchar2(50) not null,
address varchar2(50),
tel varchar2(50),
zipcode varchar2(7),
address1 varchar2(200),
address2 varchar2(200),
join_date date default sysdate);

-- 레코드 입력
-- 패키지명.함수명
-- pack_encryption_decryption.func_encrypt : 암호화함수
insert into member (userid,passwd,name) values 
('kim',pack_encryption_decryption.func_encrypt('1234'),'김과장');
insert into member (userid,passwd,name) values 
('park',pack_encryption_decryption.func_encrypt('1234'),'최부장');
insert into member (userid,passwd,name) values 
('hong',pack_encryption_decryption.func_encrypt('1234'),'홍실장');

-- 로그인 테스트
select * from member 
where userid = 'kim' 
and passwd = pack_encryption_decryption.func_encrypt('1234');

-- 복호화 테스트
-- PACK_ENCRYPTION_DECRYPTION.FUNC_DECRYPT : 복호화 함수
select userid, PACK_ENCRYPTION_DECRYPTION.FUNC_DECRYPT(passwd)  as 원래암호
from member;

select * from member;
commit;
