CREATE TABLE "employee" (
	"emp_id"	NUMBER		NOT NULL,
	"name"	VARCHAR2(30)		NULL,
	"salary"	NUMBER		NULL,
	"dept_id"	NUMBER		NOT NULL
);

CREATE TABLE "department" (
	"dept_id"	NUMBER		NOT NULL,
	"dept_name"	VARCHAR2(30)		NULL
);

CREATE TABLE "Customer" (
	"cus_id"	NUMBER		NOT NULL,
	"cus_name"	VARCHAR2(30)		NULL,
	"Field"	VARCHAR(255)		NULL
);

