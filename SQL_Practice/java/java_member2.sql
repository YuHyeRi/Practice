create table member (
userid varchar2(50) not null primary key,
passwd varchar2(50) not null,
name varchar2(50) not null,
reg_date date default sysdate,
address varchar2(500),
tel varchar2(50)
);

insert into member (userid, passwd, name) values ('kim', '1234', '김철수');
insert into member (userid, passwd, name) values ('park', '1234', '박철수');

select * from member;

commit;

select userid, passwd, name, to_char(reg_date,'yyyy-mm-dd') reg_date, address, tel		
from member
order by name;
