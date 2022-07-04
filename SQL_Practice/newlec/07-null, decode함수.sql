-- 1. NVL(NULL,대체값)
select nvl(age,0) from employees;

-- 2. NVL2(입력값, NOTNULL대체값, NULL대체값)

-- 3. NULLIF(값1, 값2) : 두 값이 같은 경우 null, 그렇지 않은 경우 첫번쨰 값 반환
-- null이 아닌 값을 null로 만드는 함수, age가 19인 경우 null로 바꾸겠다
select nullif(age, 19) from members;

-- 4. 조건에 따른 값 선택하기 decode(기준값, 비교값, 출력값, 비교값, 출력값,...)
select decode(substr(phone,1,3),'011','SKT','016','KT','019','LG','기타') from members;