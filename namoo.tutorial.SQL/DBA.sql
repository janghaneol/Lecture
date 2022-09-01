/* #1. HR ���Դ� ����� ���� ������ ���� ������ DBA ����(sys or system)���� ���� �� User ���� */
-- sqlplus ���� : conn /as sysdba;
SELECT *
FROM hr.employees;

/* #2. User ���� */
CREATE USER bangry IDENTIFIED BY bangry;

/* #3. ������ User�� �ý��� ���� / ��ü(���̺�, �� ��)�� ���� ���� �ο� */
-- �ý��� ���� ���� �ο�
GRANT CREATE SESSION TO bangry;

-- ��ü�� ���� ���� �ο�(sys�� bangry���� hr��Ű���� employees ���̺� ���� CRUD ������ �ο�)
GRANT SELECT, INSERT, UPDATE, DELETE ON hr.employees
TO bangry;

/* #4. �ʿ信 ���� User���� �ο��� ���� ȸ�� */
REVOKE SELECT, INSERT, UPDATE, DELETE ON hr.employees
FROM bangry;

/* ��(ROLE) : ���� ���ѵ��� ����(���� �� / ����� ���� ��) */
/* #1. User�� ���� �� �ο� */
GRANT CONNECT, RESOURCE, DBA TO bangry;

/* #2. ����� ���� �� ���� */
CREATE ROLE some_role;
--DROP ROLE some_role;

/* #3. �ý��� ���Ѱ� ��ü ������ �ѿ� ��� */
GRANT CREATE SESSION TO some_role;
GRANT SELECT, INSERT, UPDATE, DELETE ON hr.employees TO some_role;

-- �� ��� ������ �ѿ� �ο�
GRANT ALL ON hr.employees TO some_role;

/* #4. User�� ����� ���� �� �ο� */
GRANT some_role TO bangry;

/* #5. User ��� �� ���� */
ALTER USER bangry ACCOUNT LOCK;
ALTER USER bangry ACCOUNT UNLOCK;

/* #6. User ��й�ȣ ���� */
--ALTER USER bangry IDENTIFIED BY bbangry;

/* #7. User ���� */
DROP USER bangry CASCADE;

/* #8. ������ ��ųʸ��κ��� ���� ��� ��ȸ */
SELECT * FROM dba_users;

/* #9. ����ڿ��� �ο��� �ý��� ���� ��ȸ */
SELECT *
FROM dba_sys_privs
WHERE grantee = 'BANGRY';

/* #10. �ѿ� �ο��� �ý��� ���� ��ȸ */
SELECT *
FROM dba_sys_privs
WHERE grantee = 'SOME_ROLE';