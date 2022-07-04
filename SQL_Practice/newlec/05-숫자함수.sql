-- 이런게 있다 정도로 알고 있기
-- 1. 절대값을 구하는 함수 : abs
select abs(35), abs(-35) from dual;

-- 2. 음수,양수를 알려주는 함수 : sign
select sign(35), sign(-35), sign(0) from dual;

-- 3. 숫자의 반올림 값을 알려주는 함수 : round
select round(34.1234), round(34.1234,2) from dual;

-- 4-1. 숫자의 나누기 값을 반환하는 함수 : trunc
-- 4-2. 숫자의 나머지값을 반환하는 함수 : mod
select trunc(17/5) 몫, mod(17,5) 나머지 from dual;

-- 5. 숫자의 제곱을 구하는 함수와 제곱근을 구하는 함수 : power, sqrt
select power(5,2), sqrt(25) from dual;