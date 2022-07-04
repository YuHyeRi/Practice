--★ 문자열 함수
-- 1. substr(문자열, 시작위치, 길이) ==> 문자열 자르기
select substr('hello', 1,3) from dual;
select substr('hello', 3) from dual;    -- 3번째 문자부터 잘라라
select substrb('헬로우',3) from dual;    -- 3byte 부터 잘라라
-- 모든 학생의 이름과 출생월만을 조회하라
select name, substr(birthday,6,2) from members; -- ex. 1991-09-23
-- 회원중 전화번호가 011로 시작하는 회원의 모든 정보를 출력하라
select * from members
where substr(phone,1,3) = '011';    -- but, 가능한 웨어절에 함수는 쓰지 않는다
select * from members
where phone like '011%';
-- 회원중 생년월일이 7,8,9월인 회원의 모든 정보를 출력하라
select * from members
where substr(birthday, 6, 2) in ('07','08','09');
-- 전화번호를 등록하지 않은 회원 중에서 생년월일이 7,8,9월인 회원의 정보를 출력하라
select * from members
where phone is null
and substr(birthday, 6, 2) in ('07','08','09');

-- 2. concat('홍','길동) ==> 문자열 합치기

-- 3. trim(디폴트값은 both, ltrim, rtrim) ==> 빈 공백 없애기 
select ltrim('    hello    ') from dual;

-- 4. 대소문자 변경
1) lower
2) upper
3) initcap
select initcap('the important 안녕 okay...') from dual;
-- 회원의 아이디가 'newlec'인 회원을 조회하라 (대/소문자를 가리지 않음)
select id from member where upper(id) = upeer('newlec');

-- 5. replace(문자열, 찾는문자열, 대치할 문자열) ==> 문자열 대치함수
select replace('where we are', 'we', 'you') from dual;
-- 5-1. translate ==> 글자 하나하나씩 바꿔줌
select translate('where we are', 'we', 'you') from dual;

-- 6. 문자열 패딩 함수 (lpad, rpad)
select lpad('hello','10','*') from dual;
select rpad('hello','10','*') from dual;

-- 7. instr (문자열, 검색문자열, 위치, 찾을수)
select instr('all we need to is just to', 'to', 15) from dual; -- 15부터 찾아라
select instr('all we need to is just to', 'to', 1, 2) from dual;
-- Q. 회원의 전화번호에서 첫번째 대시(-)와 두번째 대시(-) 문자 사이의 간격은?
select instr(phone,'-',1,2) - instr(phone,'-',1,1) - 1 from members; -- 두번째위치 - 첫번째위치

-- 8. length
-- 회원의 전화번호에 포함된 문자 '-'를 없앤 전화번호의 길이를 출력하라
select length(replace(phone,'-','') from members;