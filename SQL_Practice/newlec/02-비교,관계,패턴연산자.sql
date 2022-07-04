-- ★ 비교연산자
-- !=, ^=(몇몇에서만 써서 그리 호환성이 높진 않음), <>(ansi에서 정의한) : 같지않다
-- NULL의 경우 비교시 =를 쓰지 않고, IS NULL, IS NOT NULL로 비교한다

select * from member
where id = 'newlec';

-- ★ 관계연산자 : NOT, AND, OR, BETWEEN, IN(=or), NOT IN
-- 참고) regexp_like(phone, '01[016-9]-\d{3,4}-\d{4}');
select * from notice
where hit=0 or hit=2 or hit=7;
select * from notice
where hit in (0,2,7);
select * from notice
where hit not in (0,2,7);

-- ★ 패턴연산자 : like, not like(부정), %(한글자이상), _(하나에 한글자)