select * from employees
where employee_id = 200;


CREATE TABLE STUDENTS(
  NUM NUMBER NOT NULL,
  NAME VARCHAR2(10) NOT NULL,
  KOR NUMBER NOT NULL,
  ENG NUMBER NOT NULL,
  MATH NUMBER NOT NULL
);

SELECT  num,
        name,
        kor,
        eng,
        math
FROM    students
ORDER BY num;

insert INTO students VALUES(3, 'º’»ÔπŒ', 80, 80, 80);