create table survey (
survey_idx number not null primary key, 
question varchar2(4000) not null, 
ans1 varchar2(500) not null,
ans2 varchar2(500) not null,
ans3 varchar2(500) not null,
ans4 varchar2(500) not null,
status char(1) default '1'
);

create table survey_result(
answer_idx number not null primary key,
survey_idx number not null references survey(survey_idx), 
num number not null
);

select * from survey_result;
commit;

create or replace view survey_v as
select survey_idx, num, count(*) as sum_num,
round ((select count(*) from survey_result where survey_idx=s.survey_idx and num=s.num)*100.0/
        (select count(*) from survey_result where survey_idx=s.survey_idx), 1)as rate
from survey_result s
where survey_idx=1
group by survey_idx, num
order by num;

select * from survey_v;