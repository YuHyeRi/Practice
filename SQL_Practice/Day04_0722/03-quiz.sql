-- 문제1. 이름에 'L'이 두번 이상 나오는 사원이름을 찾으시오
-- 참고) regexp_like
select ename from emp
where ename like '%L%L%';

-- 문제2. 81년도 입사자를 찾으시오 ==> between and 방법이 가장 좋다(성능이가장good)
select ename, hiredate from emp
where hiredate between '81-01-01' and '81-12-31';
-- 문제2-1 (to_char)
select ename, hiredate from emp
where to_char(hiredate, 'YYYY') = '1981';
-- 문제2-2 (to_char)
select ename, hiredate from emp
where to_char(hiredate, 'RR') = '81';
-- 문제2-3 (substr)
select ename, hiredate from emp
where substr(hiredate,1,2) = '81'; -- ==> substr(문자열,시작위치,길이) 만큼 자르기 ==> 1부터 1,2 잘라라

-- 문제3. 이름이 'T'로 끝나는 사원을 substr을 사용해서 조회하라
select ename, lpad(ename,10),substr(lpad(ename,10),10) from emp
where substr(lpad(ename,10),10) = 'T';
-- 문제3-1
select ename, substr(ename,-1,1) from emp   -- 끝에서부터 글자를 읽을 때는 '-'써주기
where substr(ename,-1,1) = 'T';

-- 문제4. 급여보다 커미션이 많은 사원 조회
select ename, sal, comm from emp
where sal < comm;