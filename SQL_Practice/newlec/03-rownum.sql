select * from emp where rownum between 1 and 5;
select * from emp where rownum between 6 and 10;    -- ERROR!!

select * from(select rownum as num, emp.* from emp)
where num between 1 and 5;

select * from(select rownum as num, emp.* from emp)
where num between 6 and 10;
