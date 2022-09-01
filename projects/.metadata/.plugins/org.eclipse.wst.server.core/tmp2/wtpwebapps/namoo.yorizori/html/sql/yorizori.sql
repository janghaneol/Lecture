-- users 테이블 변경
ALTER TABLE users 
    MODIFY (id      VARCHAR2(30),
            passwd  VARCHAR2(30),
            name    VARCHAR2(30));

desc users;


-- cookbook 테이블 생성
CREATE TABLE cookbook (
  book_id     NUMBER(7),
  book_name   VARCHAR2(30)  NOT NULL,
  book_desc   VARCHAR2(200),
  author_id   VARCHAR2(30)
);

-- recipe 테이블 생성
CREATE TABLE recipe (
  recipe_id      NUMBER(7),
  book_id        NUMBER(7),
  recipe_name    VARCHAR2(30)  NOT NULL,
  recipe_time    NUMBER(3),
  recipe_level   NUMBER(1),
  ingredients    VARCHAR2(300),
  img_cont_type  VARCHAR2(20),
  img_file_name  VARCHAR2(20),
  writer_id      VARCHAR2(20)  
);

-- recipe_procedure 테이블 생성
CREATE TABLE recipe_procedure (
  recipe_id      NUMBER(7),
  seq_num        NUMBER(2),
  procedure      VARCHAR2(200) NOT NULL 
);

-- 제약조건 추가
ALTER TABLE cookbook
  ADD ( CONSTRAINT cookbook_id_pk PRIMARY KEY(book_id),
        CONSTRAINT cookbook_author_id_fk FOREIGN KEY(author_id)  REFERENCES users(id));

ALTER TABLE recipe
  ADD ( CONSTRAINT recipe_id_pk          PRIMARY KEY(recipe_id),
        CONSTRAINT recipe_book_id_fk     FOREIGN KEY(book_id)    REFERENCES cookbook(book_id),
        CONSTRAINT recipe_writer_id_fk   FOREIGN KEY(writer_id)  REFERENCES users(id) );

ALTER TABLE recipe_procedure
  ADD ( CONSTRAINT recipe_id_seqnum_pk   PRIMARY KEY(recipe_id, seq_num) );

ALTER TABLE recipe_procedure
  ADD ( CONSTRAINT recipe_id_fk          FOREIGN KEY(recipe_id)  REFERENCES recipe(recipe_id));


SELECT * FROM user_constraints
WHERE table_name = 'RECIPE_PROCEDURE';
  


