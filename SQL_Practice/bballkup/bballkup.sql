SELECT COUNT(*) AS CNT
FROM FREE F INNER JOIN MEM M 
ON F.MEM_NO = M.MEM_NO
WHERE FREE_DEL = 1
AND F.FREE_TITLE LIKE '%' || 't' ||'%'
AND M.MEM_NM LIKE '%' || 'T' ||'%'
;

SELECT F.FREE_NO, F.CATEGORY_NO, F.FREE_TITLE, F.MEM_NM, F.FREE_DT, F.FREE_HIT
FROM (SELECT F.FREE_NO, C.CATEGORY_NO, F.FREE_TITLE, M.MEM_NM, 
        TO_CHAR(F.FREE_DT, 'YYYY-MM-DD') AS FREE_DT, F.FREE_HIT,
        ROW_NUMBER()OVER(ORDER BY F.FREE_NO DESC) AS RNUM
        FROM FREE F INNER JOIN CATEGORY C ON F.CATEGORY_NO = C.CATEGORY_NO
        INNER JOIN MEM M ON F.MEM_NO = M.MEM_NO
         WHERE F.FREE_DEL = 1
        ) F
        WHERE F.RNUM BETWEEN 1 AND 10
        ;
        
INSERT INTO MEM (MEM_NO, MEM_ID, MEM_PW, MEM_NM, MEM_PHONE, MEM_GEN, MEM_BD, MEM_PW_GBN, MEM_PWA, MEM_JOIN, MEM_DEL, LEVEL_NO)
VALUES (MEM_SEQ.NEXTVAL, 'TEST', '1234', 'TEST', '010-1234-1234', 'F', '19910101', 1, 'TEST', SYSDATE, 1, 0)
;

INSERT INTO M_LEVEL (LEVEL_NO, LEVEL_NM)
VALUES (0, '관리자')
;

INSERT INTO CATEGORY (CATEGORY_NO, CATEGORY_NM, CATEGORY_DEL)
VALUES (CATEGORY_SEQ.NEXTVAL, '자유게시판', 1)
;

INSERT INTO FREE (FREE_NO, MEM_NO, CATEGORY_NO, FREE_TITLE, FREE_CON, FREE_DT, FREE_HIT, FREE_DEL)
VALUES (FREE_SEQ.NEXTVAL, 4, 1, 'TEST', 'TEST', SYSDATE, 0, 1)
;

SELECT F.FREE_NO, F.CATEGORY_NO, F.FREE_TITLE, F.MEM_NO, F.FREE_DT, F.FREE_HIT
		FROM (SELECT F.FREE_NO, C.CATEGORY_NO, F.FREE_TITLE, M.MEM_NO, 
		       	TO_CHAR(F.FREE_DT, 'YYYY-MM-DD') AS FREE_DT, F.FREE_HIT,
		        ROW_NUMBER()OVER(ORDER BY F.FREE_NO DESC) AS RNUM
		        FROM FREE F INNER JOIN CATEGORY C 
		        ON F.CATEGORY_NO = C.CATEGORY_NO
		        INNER JOIN MEM M 
		        ON F.MEM_NO = M.MEM_NO
		        WHERE F.FREE_DEL = 1
		       
							AND FREE_TITLE LIKE '%' || 'T' || '%'
							AND M.MEM_NO LIKE '%' || 4 || '%'
        ) F
        WHERE F.RNUM BETWEEN 1 AND 5
;
SELECT * FROM CATEGORY;
DELETE FROM CATEGORY;
ROLLBACK;
COMMIT;

insert into free (free_no, mem_no, category_no, free_title, free_con)
values (free_seq.nextval, 4, 1, 'test', 'test')
;

SELECT * FROM FREE;

-- 카운트
SELECT COUNT(*) AS CNT
FROM FREE
WHERE FREE_DEL = 1
AND MEM_NO LIKE '%' || 4 || '%'
AND FREE_TITLE LIKE '%' || 't' || '%'
;

-- 리스트 뽑기
SELECT F.FREE_NO, F.CATEGORY_NO, F.FREE_TITLE, F.MEM_NM, F.FREE_DT, F.FREE_HIT
FROM (SELECT F.FREE_NO, C.CATEGORY_NO, F.FREE_TITLE, M.MEM_NM, 
TO_CHAR(F.FREE_DT, 'YYYY-MM-DD') AS FREE_DT, F.FREE_HIT,
ROW_NUMBER()OVER(ORDER BY F.FREE_NO DESC) AS RNUM
FROM FREE F INNER JOIN CATEGORY C ON F.CATEGORY_NO = C.CATEGORY_NO
INNER JOIN MEM M ON F.MEM_NO = M.MEM_NO
WHERE FREE_DEL = 1
) F
WHERE F.RNUM BETWEEN 1 AND 3
;

INSERT INTO FREE (FREE_NO, MEM_NO, CATEGORY_NO, FREE_TITLE, FREE_CON, FREE_FILE)
VALUES (FREE_SEQ.NEXTVAL, 4, 1, 'INSERT', 'INSERT', NULL)
;

update category set 
category_nm = '[용병구해요]'
;

INSERT INTO FREE (FREE_NO, MEM_NO, CATEGORY_NO, FREE_TITLE, FREE_CON, FREE_FILE)
VALUES (FREE_SEQ.NEXTVAL, 4, 1, 'INSERT', 'INSERT TEST', 'TEST')
;

update free set free_file = 1
where free_no = 5
;

UPDATE FREE SET FREE_HIT = FREE_HIT + 1
WHERE FREE_NO = 12
;

SELECT C.CATEGORY_NM, M.MEM_NM, TO_CHAR(FREE_DT, 'YYYY-MM-DD') AS FREE_DT, F.FREE_TITLE, F.FREE_CON, F.FREE_FILE
FROM FREE F INNER JOIN MEM M
ON F.MEM_NO = M.MEM_NO
INNER JOIN CATEGORY C
ON F.CATEGORY_NO = C.CATEGORY_NO
WHERE 1 = 1
AND F.FREE_NO = 5
;

UPDATE FREE SET FREE_DEL = 0
WHERE FREE_NO = 12
;

select * from free;
select * from mem;
select * from category;

insert into free(free_no, mem_no, category_no, free_title, free_con, free_file)
values (free_SEQ.nextval, 5, 0, '제목테스트', '내용테스트', '1234.png')
;

INSERT INTO FREE (FREE_NO, TO_NUMBER('MEM_NO'), CATEGORY_NO, FREE_TITLE, FREE_CON, FREE_FILE)
VALUES (FREE_SEQ.NEXTVAL, '5', 0, 'AB', 'AB CON', NULL)
;

commit;
