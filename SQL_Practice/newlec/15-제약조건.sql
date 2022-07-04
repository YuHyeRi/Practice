-- 1. 도메인 제약조건 : 컬럼에 내가 원하는 내용이 입력될 수 있게
-- 속성이 도메인이 아닌 값이 올수 없도록 하는 제약조건
-- 1) not null  2) default  3) check

-- ★ NOT NULL
-- (1) 생성하기
create table example (
    id varchar2(50) not null,   -- 반드시 입력해야 하는 컬럼
    email varchar2(100) null,
    phone char(13) not null
);

-- (2) 값 입력하기
insert into example(id, phone) values ('abcd', '010-1234-1234');    -- NOT NULL인 id, phone 모두 입력해야함

-- (3) 값 수정하기
alter table example modify email varchar2(100) not null;

-- 그러나 요즘은 보통 도구를 씀

-- ★ DEFAULT
-- 사용자가 입력하지 않아도 디폴트값으로 값이 들어가게 설정하는 것

-- ★ CHECK
-- 정해진 패턴의 입력값이 들어왔는지 체크
create table test (
    phone varchar2(100) check (phone like '010-%-____') not null
    );