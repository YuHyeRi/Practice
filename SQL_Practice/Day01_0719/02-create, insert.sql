-- 1. 테이블 생성하기
create table topic(
id number not null,  -- id는 숫자만 들어와야하고 반드시 입력되어야한다
title varchar2(50) not null,      -- 50글자 이상이면 짤린다
description varchar2(4000) null,
created date not null
);

-- 2. 데이터 추가하기
insert into topic (id,title,description,created)
values(1,'ORACLE','oracle',sysdate);
commit;     -- 무조건 커밋한다

insert into topic (id,title,description,created)
values(2,'JAVA','java',sysdate);
commit;

insert into topic (id,title,description,created)
values(3,'SPRING','spring',sysdate);
commit;

-- 3. 전체 내용 보기
select * from topic;

-- 4. 특정 column 보기
select title, created from topic;

-- 5. id가 1인 행만 보고 싶다(where)
select * from topic where id=1;     -- >, <도 가능

-- 6. 정렬하기(order by) ==> 아이디를 기준으로 정렬하는데, 큰 숫자가 먼저 나오게 한다 (빤대:asc)
select * from topic order by id desc;

-- 7. 수정하기
update topic
set
title = 'nothing',
description = 'noting'
where id = 3;

select * from topic;
commit;

-- 8. 삭제하기
delete from topic
where id = 3;

select * from topic;
commit;

-- 9. 테이블 삭제하기
drop table topic;       -- 얘는 commit 할필 요는 X

-- 10. primary key (기본키), 테이블생성시 지정하거나(가급적) alter로 후에 추가하거나
create table topic(
id number not null, 
title varchar2(50) not null, 
description varchar2(4000) null,
created date not null,
constraint pk_topic primary key(id)
);

-- 다시 추가하기
insert into topic (id,title,description,created)
values(1,'ORACLE','oracle',sysdate);
commit;     -- 무조건 커밋한다
select * from topic;

insert into topic (id,title,description,created)
values(2,'JAVA','java',sysdate);
commit;
select * from topic;

-- 11. sequence
create sequence seq_topic;

insert into topic (id,title,description,created)
values (seq_topic.nextval,'mongoDB','mongDB',sysdate);

