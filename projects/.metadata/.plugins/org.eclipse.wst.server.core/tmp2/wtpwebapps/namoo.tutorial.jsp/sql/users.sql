-- 선택페이지에 따른 사용자 목록 반환
SELECT id, name, passwd, email, regdate
FROM ( SELECT CEIL(rownum / 10) request_page, id, name, passwd, email, regdate
       FROM   ( SELECT id, name, passwd, email, TO_CHAR(regdate, 'YYYY-MM-DD DAY') regdate
                FROM users
                ORDER  BY regdate DESC))
WHERE  request_page = 1;

-- 선택페이지, 조회 목록개수에 따른 사용자 목록 반환
SELECT id, name, passwd, email, regdate
FROM ( SELECT CEIL(rownum / 5) request_page, id, name, passwd, email, regdate
       FROM   ( SELECT id, name, passwd, email, TO_CHAR(regdate, 'YYYY-MM-DD DAY') regdate
                FROM users
                ORDER  BY regdate DESC))
WHERE  request_page = 1;

-- 선택페이지, 조회 목록개수, 검색유형, 검색값에 따른 사용자 목록 반환
SELECT id, name, passwd, email, regdate
FROM ( SELECT CEIL(rownum / 5) request_page, id, name, passwd, email, regdate
       FROM   ( SELECT id, name, passwd, email, TO_CHAR(regdate, 'YYYY-MM-DD DAY') regdate
                FROM users
--                WHERE id = 'bangry'
                WHERE name like '%기%'
                ORDER  BY regdate DESC))
WHERE  request_page = 1;


-- 검색유형, 검색값에 따른 사용자 개수 반환 - 페이징 처리 시 필요
SELECT COUNT(id) count
FROM   users
--WHERE id = 'bangry';
--WHERE name like '%기%';

