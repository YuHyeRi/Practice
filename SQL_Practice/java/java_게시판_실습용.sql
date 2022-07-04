-- 게시판 테이블 생성하기 ==> board
create table board (
num number not null primary key,        -- 게시물번호
writer varchar2(50) not null,           -- 작성자
subject varchar2(50) not null,          -- 제목
passwd varchar2(60) not null,           -- 수정/삭제 비번
reg_date date default sysdate,          -- 작성일자
readcount number default 0,             -- 조회수
ref number not null,                    -- 답변관련필드=>게시물그룹
re_step number not null,                -- 답변관련필드=>게시물그룹의 순번 
re_level number not null,               -- 답변관련필드=>답변 단계
content varchar2(4000) not null,        -- 본문
ip varchar2(30) not null,               -- 작성자 ip
filename varchar2(200),                 
filesize number default 0,
down number default 0                   -- 첨부파일 다운로드 횟수
);

select * from board;
commit;

-- 자료 데이터 입력
-- nvl(a,b) a가 null이면 b
insert into board (num, writer, subject, passwd, ref, re_step, re_level, content, ip) values
((select nvl(max(num)+1, 1) from board), 'kim', '제목', '1234', 
 (select nvl(max(num)+1, 1) from board), 1, 0, '내용', '59.26.59.4');

-----------------------------------------------------------------------------------------
-- 댓글 테이블 생성하기 ==> board_comment
create table board_comment(
comment_num number not null primary key,            -- 댓글 일련번호
board_num number not null references board(num),    -- 게시물 번호, Foreign Key설정, references board(num)
writer varchar2(50) not null,             -- 댓글쓴이
content clob not null,                    -- 댓글 내용, clob : 대용량 텍스트 자료형 가능 (cf. varchar2는 4000까지만 가능)
reg_date date default sysdate
);

select * from board_comment;
commit;

-----------------------------------------------------------------------------------------
select *
		from (
			  select rownum as rn, A.*
			  from (
			  		select num, writer, subject, reg_date, readcount,
			  		(select count(*) from board_comment where board_num=b.num) comment_count,
			  		filename, filesize, down, ref, re_step, re_level
			  		from board b
			  		order by ref desc, re_step asc
			  		) A
			  )
			  where rn between 1 and 10;

-----------------------------------------------------------------------------------------              

select * from board;
select * from board_comment;

select comment_num, board_num, writer, content, to_char(reg_date, 'yyyy-mm-dd HH:mi:ss') reg_date
from board_comment
where board_num=13
order by comment_num;

select passwd from board
where num=13 and passwd=1234;

delete from board
where num=8;