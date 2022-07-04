-- 집합연산자 (union all, union, intersect, minus)

-- ★ 1. union all (합집합, 중복허용, 정렬X)
select deptno from emp
union all
select deptno from dept;

-- ★ 2. union (합집합, 중복제거, 정렬O, 첫번째 sel문의 첫번째 컬럼기준으로 ASC 정렬)
select deptno from emp
union
select deptno from dept;

-- ★ 3. intersect (교집합, 중복제거, 정렬O)
select deptno from emp
intersect
select deptno from dept;

-- ★ 4. minus (차집합, 중복제거, 정렬O, 첫번째 select에서 두번째 select문 빼기)
select deptno from dept
minus
select deptno from emp;

-- ★ 기타 : 컬럼명 기준은 첫번째 select문
select ename 사원명 from emp
union all
select dname as 직업분류 from dept
union all
select 'KOREA' 나라이름 from dual;     -- 이런식으로 추가도 가능!