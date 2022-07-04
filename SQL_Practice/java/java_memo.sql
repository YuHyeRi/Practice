create table memo (
idx number not null primary key, 
writer varchar2(50) not null, 
memo varchar2(100) not null, 
post_date date default sysdate
);

insert into memo(idx,writer,memo) values ((select nvl(max(idx)+1, 1) from memo), 'kim', 'memo');

select * from memo
order by idx;

commit;
