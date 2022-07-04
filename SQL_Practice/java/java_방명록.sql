-- guestbook(방명록) 테이블 생성
create table guestbook (
    idx number not null primary key,    -- 글번호
    name varchar2(50) not null,
    email varchar2(50) not null,
    passwd varchar2(50) not null,       -- 수정/삭제
    content varchar2(2000) not null,
    post_date date default SYSDATE
);

-- 시퀀스를 이용한 글번호
create sequence guestbook_seq
start with 1        -- 시작값
increment by 1;     -- 1씩 증가

-- 시퀀스.nextval : 다음 번호 계산
-- 시퀀스.currval : 현재 번호 계산
insert into guestbook(idx, name, email, passwd, content) values
(guestbook_seq.nextval, 'kim', 'kim@naver.com', '1234', '첫번째 게시물');

select * from guestbook;

commit;