-- ������������ ���� ����� ��� ��ȯ
SELECT id, name, passwd, email, regdate
FROM ( SELECT CEIL(rownum / 10) request_page, id, name, passwd, email, regdate
       FROM   ( SELECT id, name, passwd, email, TO_CHAR(regdate, 'YYYY-MM-DD DAY') regdate
                FROM users
                ORDER  BY regdate DESC))
WHERE  request_page = 1;

-- ����������, ��ȸ ��ϰ����� ���� ����� ��� ��ȯ
SELECT id, name, passwd, email, regdate
FROM ( SELECT CEIL(rownum / 5) request_page, id, name, passwd, email, regdate
       FROM   ( SELECT id, name, passwd, email, TO_CHAR(regdate, 'YYYY-MM-DD DAY') regdate
                FROM users
                ORDER  BY regdate DESC))
WHERE  request_page = 1;

-- ����������, ��ȸ ��ϰ���, �˻�����, �˻����� ���� ����� ��� ��ȯ
SELECT id, name, passwd, email, regdate
FROM ( SELECT CEIL(rownum / 5) request_page, id, name, passwd, email, regdate
       FROM   ( SELECT id, name, passwd, email, TO_CHAR(regdate, 'YYYY-MM-DD DAY') regdate
                FROM users
--                WHERE id = 'bangry'
                WHERE name like '%��%'
                ORDER  BY regdate DESC))
WHERE  request_page = 1;


-- �˻�����, �˻����� ���� ����� ���� ��ȯ - ����¡ ó�� �� �ʿ�
SELECT COUNT(id) count
FROM   users
--WHERE id = 'bangry';
--WHERE name like '%��%';

