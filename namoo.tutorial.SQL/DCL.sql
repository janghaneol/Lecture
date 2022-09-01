/* #1. HR 에게는 사용자 생성 권한이 없기 때문에 DBA 계정(sys or system)으로 연결 후 User 생성 */
-- sqlplus 사용시 : conn /as sysdba;
SELECT *
FROM hr.employees;

/* #2. User 생성 */
CREATE USER bangry IDENTIFIED BY bangry;

/* #3. 생성된 User에 시스템 권한 / 객체(테이블, 뷰 등)에 대한 권한 부여 */
-- 시스템 연결 권한 부여
GRANT CREATE SESSION TO bangry;

-- 객체에 대한 권한 부여(sys가 bangry에게 hr스키마의 employees 테이블에 대한 CRUD 권한을 부여)
GRANT SELECT, INSERT, UPDATE, DELETE ON hr.employees
TO bangry;

/* #4. 필요에 따라 User에게 부여된 권한 회수 */
REVOKE SELECT, INSERT, UPDATE, DELETE ON hr.employees
FROM bangry;