CREATE TABLE HS_STUDENTS (
    hs_stu_id		varchar2(10),
   	class_off_id 	varchar2(10) NOT NULL,
    hs_prof_id		varchar2(10) NOT NULL,
   	hs_stu_name		varchar2(15) NOT NULL,
   	hs_stu_jumin  	varchar2(14) NOT NULL,
   	hs_stu_addr		varchar2(100) NOT NULL,
   	hs_stu_phnum	varchar2(15) NOT NULL,
    hs_stu_email	varchar2(100) NOT NULL,
    hs_stu_image	long,
    hs_stu_sub		varchar2(3) NOT NULL
);

ALTER TABLE HS_STUDENTS ADD CONSTRAINT hs_stu_id_pk PRIMARY KEY(hs_stu_id);

ALTER TABLE HS_STUDENTS ADD CONSTRAINT class_off_id_fk FOREIGN KEY(class_off_id) REFERENCES HS_CLASS_OFFICE(class_off_id);


CREATE TABLE HS_CLASS_OFFICE (
    class_off_id    varchar2(10),
    class_off_name  varchar2(20) NOT NULL,
    class_off_phnum varchar2(15) NOT NULL
);
    
ALTER TABLE HS_CLASS_OFFICE ADD CONSTRAINT class_off_id_pk PRIMARY KEY(class_off_id);


CREATE TABLE HS_PROFESSOR (
    prof_id     varchar2(10),
    prof_name   varchar2(15) NOT NULL,
    prof_jumin  varchar2(14) NOT NULL UNIQUE,
    prof_addr   varchar2(100) NOT NULL,
    prof_phnum  varchar2(15) NOT NULL,
    prof_email  varchar2(100) NOT NULL,
    prof_image  long,
    class_off_id    varchar2(10) NOT NULL,
    hs_stu_id   varchar2(10) NOT NULL
);

ALTER TABLE HS_PROFESSOR ADD CONSTRAINT hs_prof_id_pk PRIMARY KEY (prof_id);

ALTER TABLE HS_PROFESSOR ADD CONSTRAINT hs_prof_class_off_id_fk2 FOREIGN KEY (class_off_id) REFERENCES HS_CLASS_OFFICE (class_off_id);





CREATE TABLE HS_LECTURE (
	lec_id			varchar2(10),
	lec_name		varchar2(15) NOT NULL,
	lec_arch_grade	char(1) NOT NULL, 
	lec_time		number(1) NOT NULL, 
	lec_room		varchar2(10) NOT NULL,
    prof_id			varchar2(10)
);

ALTER TABLE HS_LECTURE ADD CONSTRAINT hr_lec_id_pk PRIMARY KEY (lec_id);

ALTER TABLE HS_LECTURE ADD CONSTRAINT hs_lec_prof_id_fk FOREIGN KEY (prof_id) REFERENCES hs_professor (prof_id);


CREATE TABLE REGIS_COURSE (
	rc_atten_grade		number(2),
	rc_midterm_grade	number(2),
	rc_finalterm_grade	number(2),
	rc_else_grade		number(2),
	rc_total	    	number(3),
	rc_avg_grade		char(1),
	hs_stu_id	    	varchar2(10),
	lec_id		    	varchar2(10),
	prof_id		    	varchar2(10)
);

ALTER TABLE REGIS_COURSE ADD CONSTRAINT rc_stu_lec_prof_id PRIMARY KEY (hs_stu_id, lec_id, prof_id);

ALTER TABLE REGIS_COURSE ADD CONSTRAINT rc_lec_id_fk1 FOREIGN KEY (lec_id) REFERENCES HS_LECTURE (lec_id);

ALTER TABLE REGIS_COURSE ADD CONSTRAINT rc_stu_id_fk2 FOREIGN KEY (hs_stu_id) REFERENCES HS_STUDENTS (hs_stu_id);



SELECT * FROM HS_STUDENTS;
SELECT * FROM HS_CLASS_OFFICE;
SELECT * FROM HS_PROFESSOR;
SELECT * FROM HS_LECTURE;
SELECT * FROM REGIS_COURSE;

INSERT INTO HS_STUDENTS
VALUES ('01000', '101', '145', '전우신', '000128-3213213', '경기도', '010-1234-5678', 'jws@asd.com', null, '2-2');
INSERT INTO HS_STUDENTS
VALUES ('04111', '202', '163', '이준영', '000402-4123123', '경기도', '010-4321-8765', 'ljw@asd.com', null, '2-2');
INSERT INTO HS_STUDENTS
VALUES ('02222', '303', '189', '호지수', '000111-3213213', '경기도', '010-2345-6789', 'hjs@asd.com', null, '2-2');
INSERT INTO HS_STUDENTS
VALUES ('04333', '101', '145', '김민석', '060604-3213213', '경기도', '010-5432-9876', 'kms@asd.com', null, '1-1');
INSERT INTO HS_STUDENTS
VALUES ('02333', '202', '163', '권정인', '041111-4123123', '경기도', '010-5432-9876', 'kji@asd.com', null, '1-2');
INSERT INTO HS_STUDENTS
VALUES ('04121', '303', '189', '오승환', '951111-1231231', '경기도', '010-5432-9876', 'osh@asd.com', null, '3-1');
INSERT INTO HS_STUDENTS
VALUES ('04412', '202', '163', '최준오', '931111-1231231', '경기도', '010-5432-9876', 'cjo@asd.com', null, '3-2');
INSERT INTO HS_STUDENTS
VALUES ('01333', '404', '189', '전민기', '991111-1231231', '경기도', '010-5432-9876', 'jmk@asd.com', null, '2-2');


INSERT INTO HS_CLASS_OFFICE VALUES
('101', '화학공학과', '010-xxxx-xxxx');
INSERT INTO HS_CLASS_OFFICE VALUES
('202', '컴퓨터공학과', '010-xxxx-xxxx');
INSERT INTO HS_CLASS_OFFICE VALUES
('303', '생명공학과', '010-xxxx-xxxx');
INSERT INTO HS_CLASS_OFFICE VALUES
('404', '시각디자인과', '010-xxxx-xxxx');


INSERT INTO HS_PROFESSOR VALUES
('1111', '짱구', '700101-xxxxxxx', '떡잎마을', '010-xxxx-xxxx', 'shinjjang@asd.com', null, '101', '01000');
INSERT INTO HS_PROFESSOR VALUES
('2222', '철수', '750101-xxxxxxx', '떡잎마을', '010-xxxx-xxxx', 'cheolsoo@asd.com', null, '202', '04111');
INSERT INTO HS_PROFESSOR VALUES
('3333', '맹구', '730101-xxxxxxx', '떡잎마을', '010-xxxx-xxxx', 'maenggu@asd.com', null, '303', '02222');
INSERT INTO HS_PROFESSOR VALUES
('4444', '훈이', '710101-xxxxxxx', '떡잎마을', '010-xxxx-xxxx', 'hoonE@asd.com', null, '404', '01333');


INSERT INTO HS_LECTURE VALUES
('1111', '화학의기초' , 'A', 3, '101', '1111');
INSERT INTO HS_LECTURE VALUES
('2222', '컴퓨터기초' , 'C', 1, '202', '2222');
INSERT INTO HS_LECTURE VALUES
('3333', '생명의기초' , 'B', 4, '303', '3333');
INSERT INTO HS_LECTURE VALUES
('4444', '시디의기초' , 'A', 2, '404', '4444');

INSERT INTO REGIS_COURSE VALUES
(20, 35, 35, 10, 100, 'A', '01000', '1111', '1111');
INSERT INTO REGIS_COURSE VALUES
(15, 30, 35, 5, 85, 'B', '04111', '2222', '2222');
INSERT INTO REGIS_COURSE VALUES
(5, 20, 30, 0, 55, 'F', '02222', '3333', '3333');
INSERT INTO REGIS_COURSE VALUES
(20, 30, 35, 5, 90, 'A', '04333', '1111', '1111');
INSERT INTO REGIS_COURSE VALUES
(10, 25, 30, 10, 75, 'C', '02333', '2222', '2222');
INSERT INTO REGIS_COURSE VALUES
(20, 35, 35, 10, 100, 'A', '04121', '3333', '3333');
INSERT INTO REGIS_COURSE VALUES
(10, 20, 25, 10, 65, 'D', '04412', '2222', '2222');
INSERT INTO REGIS_COURSE VALUES
(20, 25, 32, 10, 87, 'B', '01333', '4444', '4444');



--(1) 교수번호 145에게 수업을 받는 학생에 대한 정보를 출력하시오.
SELECT st.hs_stu_name, st.hs_stu_id, st.hs_stu_jumin, st.hs_stu_phnum, st.hs_stu_sub
from hs_class_office cl join hs_professor pro on (cl.class_off_id = pro.CLASS_OFF_ID)
join hs_students st on (cl.CLASS_OFF_ID = st.CLASS_OFF_ID)
where st.HS_PROF_ID = '145';