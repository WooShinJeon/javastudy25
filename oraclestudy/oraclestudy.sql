desc emp;  -- emp 테이블 구조보기
select * from emp; -- emp 테이블 내용보기
select empno, ename, deptno from emp; -- emp내에서 원하는 열만 보기

select distinct deptno from emp; -- emp내의 deptno에서 중복제거하기

select distinct job, deptno from emp; -- 여러개의 열 중복제거하기

select all job, deptno from emp; -- 중복 열 제거없이 다 출력하기

select ename, sal, sal*12+comm, comm from emp; -- 열에 연산식을 사용하여 출력하기(comm값이 null이면 출력이 안됨)

select ename, sal, sal*12+comm as annsal, comm from emp; -- sal*12+comm의 별칭을 annsal로 설정

select * from emp order by sal; -- emp테이블의 모든 열을 sal오름차순으로 정렬(기본값)

select * from emp order by sal desc; -- sal내림차순으로 정렬

select * from emp order by deptno asc, sal desc; -- 먼저 명시된 deptno의 오름차순이 1순위,
--                                                  두번째에 명시된 sal의 내림차순이 2순위

select * from emp where deptno = 30; -- deptno가 30인 데이터만 촐력하기

select * from emp where deptno = 30 and job = 'SALESMAN'; -- deptno가 30이고 직책이 SALESMAN인 데이터만 출력하기

select * from emp where deptno = 30 or job = 'CLERK'; -- deptno가 30이거나 직책이 CLERK인 데이터를 모두 출력하기

select * from emp where sal*12 = 36000; -- sal*12의 값이 36000이 되는 데이터만 출력하기

select * from emp where sal >= 3000; -- sal가 3000이상인 데이터만 출력하기

select * from emp where ename >= 'F'; -- 사원이름의 첫문자가 F와 같거나 뒤쪽인 데이터만 출력

select * from emp where ename <= 'FORZ'; -- 문자열을 비교하기(FORD의 끝글자 D가 Z보다 앞이므로 출력)

select * from emp where sal != 3000; --
select * from emp where sal <> 3000; --  !=, <>, ^=  셋다 '같지않다' 는 의미로 사용가능
select * from emp where sal ^= 3000; --

select * from emp where not sal = 3000; -- sal이 3000인 데이터를 제외하고 출력 (위의 세가지와 같은 결과 출력)

select * from emp where job = 'MANAGER' or job = 'SALESMAN' or job = 'CLERK'; -- or 연산자를 사용해서 여러개의 조건을 만족하는 데이터 출력

select * from emp where job in ('MANAGER', 'SALESMAN', 'CLERK'); -- in연산자를 사용하여 출력 (위의 출력결과와 같음)

select * from emp where job != 'MANAGER' and job <> 'SALESMAN' and job ^= 'CLERK'; -- 등가비교연산자와 and연산자를 사용하여 출력

select * from emp where job not in ('MANAGER', 'SALESMAN', 'CLERK'); -- in연산자 사용

select * from emp where sal <= 3000 and sal >= 2000; -- 2000이상 3000이하의 데이터만 출력

select * from emp where sal between 2000 and 3000; -- between을 사용하여 위와 같은 결과 출력

select * from emp where sal not between 2000 and 3000; -- not을 사용하여 위와 다른 결과 출력

select * from emp where ename like 'S%'; -- ename열에서 S로 시작하는 데이터를 출력

select * from emp where ename like '_L%'; -- ename열에서 두번째 문자가 L인 데이터를 출력

select * from emp where ename like '%AM%'; -- ename열에 AM이 포함되어 있는 데이터만 출력하기

select * from emp where ename not like '%AM%'; -- AM이 포함되어 있지 않은 데이터만 출력하기


-- 데이터에 (_,%) 문자가 포함되어있는 경우에는 escape절을 사용한다.
-- 예를 들어서 emp의 ename열에서 A_A 라는 문자로 시작하는 데이터를 찾으려면,
-- select * from emp
-- where ename like 'A\_A%' escape '\';
-- 이런식으로 SQL문을 작성


select * from emp where comm = null; -- null은 산술연산자와 비교연산자로 비교해도 결과가 null이 된다.

select * from emp where comm is null; -- 특정열 또는 연산값이 null인지 여부를 확인하려면 is null연산자를 사용해야 함

select * from emp where mgr is not null; -- mgr값이 null이 아닌 데이터만 출력

select * from emp where sal > null and comm is null; -- sal>null 의 결과가 null이기 때문에 아무것도 출력되지않는다.

select * from emp where sal > null or comm is null; -- or연산자 사용으로 인해 comm이 null인 데이터가 촐력된다.

select empno, ename, sal, deptno from emp where deptno = 10 union select empno, ename, sal, deptno from emp where deptno = 20; -- deptno가 10인 데이터와 20인 데이터를 합쳐서 출력
-- union을 사용하여 출력값을 합치기 위해서는 출력 열 개수와, 열의 자료형이 같아야 한다.

select empno, ename, sal, deptno from emp where deptno = 10 union select empno, ename, sal, deptno from emp where deptno = 10; -- 연결하려는 두 select문의 결과값이 같은경우 중복데이터를 제외하고 출력

select empno, ename, sal, deptno from emp where deptno = 10 union all select empno, ename, sal, deptno from emp where deptno = 10; -- union all을 사용하게 되면 중복데이터도 모두 출력한다.

select empno, ename, sal, deptno from emp minus select empno, ename, sal, deptno from emp where deptno = 10; -- deptno가 10인 데이터를 제외하고 출력(차집합)

select empno, ename, sal, deptno from emp intersect
select empno, ename, sal, deptno from emp where deptno = 10; -- 교집합

-- 연산자의 우선순위
--  *,/  >  +,-  >  대소비교  >  비교  >  between  >  not  >  and  >  or

select ename, upper(ename), lower(ename), initcap(ename) from emp; -- upper : 모두 대문자, lower : 모두 소문자,
--                                                                    initcap : 첫글자는 대문자, 나머지는 소문자

select * from emp where upper(ename) = upper('scott'); -- upper 함수를 이용해서 문자열 비교하기

select * from emp where upper(ename) like upper('%scott%'); -- upper와 like를 사용해서 문자열 비교

select ename, length(ename) from emp; -- length를 이용하여 뮨자열의 길이를 구함

select ename, length(ename) from emp where length(ename) >= 5; -- length를 이용하여 길이가 5이상인 데이터만 출력

select length('한글'), lengthb('한글') from dual; -- length는 문자열 길이, lengthb는 문자열의 바이트수
--                                                 데이터베이스 문자셋이 UTF-8 이라면 한글자 3바이트 -> 한글 = 6바이트

SELECT * FROM NLS_DATABASE_PARAMETERS WHERE PARAMETER = 'NLS_CHARACTERSET'; -- AL32UTF8이면 한글 1자 = 3바이트
--                                                                             KO16KSC5601이면 한글 1자 = 2바이트

select job, substr(job, 1, 2), substr(job, 3, 2), substr(job, 5) from emp; -- substr(문자열, 시작위치, 추출길이) 로 원하는 부분만 추출 가능
--           substr(문자열, 시작위치) 지정부분부터 끝까지 추출




desc dept; -- dept 테이블 구조보기
select * from dept; -- dept 테이블 내용보기

desc bonus; -- bonus 테이블 구조보기
select * from bonus; -- bonus 테이블 내용보기

desc salgrade; -- salgrade 테이블 구조보기
select * from salgrade; -- salgrade 테이블 내용보기




select * from emp, dept order by empno; -- from절에 여러 테이블 선언하기

select * from emp, dept where emp.deptno = dept.deptno order by empno; -- deptno 비교해서 같은거만 출력

select * from emp e, dept d where e.deptno = d.deptno order by empno; -- 각 테이블의 별칭 설정

select e.empno, e.ename, e.JOB, e.MGR, e.HIREDATE, e.SAL, e.DEPTNO, d.DNAME, d.LOC from emp e, dept d where e.DEPTNO = d.DEPTNO order by empno; -- 출력할 열을 *로 표현하면 여러가지 불편함이 생김. 하나하나 다 쓰는게 좋다.

select empno, ename, deptno, dname, loc from emp e, dept d where e.deptno = d.deptno; -- 두 테이블에서 이름이 같은 열이 있을때 오류
--                            어떤 테이블에 속해있는 열인지 반드시 명시해야 함.

select e.empno, e.ename, d.deptno, d.dname, d.loc from emp e, dept d where e.DEPTNO = d.DEPTNO order by d.DEPTNO, e.EMPNO; -- dept 테이블의 deptno열을 사용.

select e.empno, e.ename, e.sal, d.deptno, d.dname, d.loc from emp e, dept d where e.DEPTNO = d.DEPTNO and sal >= 3000; -- 조건식 추가

select * from emp e, salgrade s where e.SAL between s.LOSAL and s.HISAL; -- salgrade에서 나뉘어있는 급여등급대로
--                                          between을 사용하여 조인하기

select e1.empno, e1.ename, e1.mgr, e2.empno as MGR_EMPNO, e2.ename as MGR_ENAME from emp e1, emp e2 where e1.MGR = e2.EMPNO; -- 같은 테이블을 두번 사용해서 자체 조인하기
--                          별칭을 다르게 지정하여 사용가능

select e1.empno, e1.ename, e1.mgr, e2.empno as MGR_EMPNO, e2.ename as MGR_ENAME from emp e1, emp e2 where e1.MGR = e2.EMPNO(+) order by e1.EMPNO; -- 오른쪽에 (+)를 붙임 -> 왼쪽 외부 조인
--                    왼쪽 열을 기준으로 오른쪽 열의 데이터 존재 여부에 상관없이 출력
--                    본 의도대로(상사번호가 없는 데이터도 출력되게) 출력됨

select e1.empno, e1.ename, e1.mgr, e2.empno as MGR_EMPNO, e2.ename as MGR_ENAME from emp e1, emp e2 where e1.MGR(+) = e2.EMPNO order by e1.EMPNO; -- 왼쪽에 (+)를 붙임 -> 오른쪽 외부 조인
--                    오른쪽 열을 기준으로 왼쪽 열의 데이터 존재 여부에 상관없이 출력
--                    부하직원이 없는 데이터는 왼쪽 테이블 데이터가 모두 null로 출력

select e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, deptno, d.dname, d.loc from emp e natural join dept d order by deptno, e.EMPNO; -- 조인 대상이 되는 두 테이블에 이름과 자료형이 같은 열을 찾아 그 열을 기준으로 등가조인함 (여기선 deptno)
-- 조인에 필요한 열(deptno)에는 select절에서 테이블 이름을 붙이지 않음 (e.deptno -> X)
-- where절이 아닌 from절에서 조인을 선언

select e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, deptno, d.dname, d.loc from emp e join dept d using(deptno) where sal >= 3000 order by deptno, e.EMPNO; -- join ~ using 키워드에서는 조인 기준이 되는 열을 지정해줘야 함
--                           using 뒤에 (기준열)로 명시

select e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, e.deptno, d.dname, d.loc from emp e join dept d on (e.deptno = d.deptno) where sal <= 3000 order by e.deptno, e.empno; -- join ~ on 키워드에서는 조인기준조건식을 명시해야함.
--                           on 뒤에 (조인 조건식)으로 명시

select e1.empno, e1.ename, e1.mgr, e2.empno as MGR_EMPNO, e2.ename as MGR_ENAME from emp e1 left outer join emp e2 on (e1.mgr = e2.EMPNO) order by e1.EMPNO; -- SQL-99 방식의 왼쪽 외부 조인 left outer join (where t1.c1 = t2.c1(+))

select e1.empno, e1.ename, e1.mgr, e2.empno as MGR_EMPNO, e2.ename as MGR_ENAME from emp e1 right outer join emp e2 on (e1.mgr = e2.EMPNO) order by e1.EMPNO; -- SQL-99 방식의 오른쪽 외부 조인 right outer join (where t1.c1(+) = t2.c1)

select e1.empno, e1.ename, e1.mgr, e2.empno as MGR_EMPNO, e2.ename as MGR_ENAME from emp e1 full outer join emp e2 on (e1.mgr = e2.EMPNO) order by e1.EMPNO; -- 왼쪽, 오른쪽 외부 조인을 모두 적용한 full outer join






create table dept_temp as select * from dept; -- dept 테이블을 복사해서 dept_temp 테이블 만들기

select * from dept_temp; -- dept_temp 테이블 조회

-- 테이블을 삭제하고 싶으면
-- drop table 테이블 이름;

insert into dept_temp (deptno, dname, loc) values(50, 'database', 'seoul'); -- dept_temp 테이블에 데이터(deptno, dname, loc) 추가

select * from dept_temp;

insert into dept_temp values (60, 'network', 'busan'); -- 열 지정 없이 데이터 추가 (열 순서대로 추가됨)

insert into dept_temp (deptno, dname, loc) values (70, 'web', null); -- null을 사용해서 데이터를 안넣는것 가능

insert into dept_temp (deptno, dname, loc) values (80, 'mobile', ''); -- 비우고 싶은 열의 자료형이 문자열 혹은 날짜형일경우 공백문자열('')로도 null 입력가능

insert into dept_temp (deptno, loc) values (90, 'incheon'); -- null이 들어갈 열 이름(dname)을 아예 입력하지 않는것으로도 null처리 가능


create table emp_temp as select * from emp where 1<>1; -- where 1<>1의 조건을 사용해서 emp테이블과 같은 열을 가지지만 데이터는 없는 테이블을 복사

select * from emp_temp;

insert into emp_temp values (9999, '홍길동', 'president', null, '2001/01/01', 5000, 1000, 10); -- 날짜데이터를 넣을때는 / 사용 (년/월/일 순으로)

insert into emp_temp values (1111, '성춘향', 'manager', 9999, '2001-01-05', 4000, null, 20); -- 날짜 사이에 - 를 넣어도 됨 (년-월-일 순으로)

insert into emp_temp values (2111, '이순신', 'manager', 9999, to_date('07/01/2001', 'dd/mm/yyyy'), 4000, null, 20); -- 년/월/일 의 순서를 바꿔도 to_date 함수를 사용하면 입력 가능

insert into emp_temp values (3111, '심청이', 'manager', 9999, sysdate, 4000, null, 30); -- sysdate를 사용하여 현재 날짜데이터 입력

insert into emp_temp select e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, e.deptno from emp e, salgrade s where e.sal between s.losal and s.hisal and s.grade = 1; -- 서브쿼리를 사용하여 한번에 여러 행을 추가, salgrade 테이블을 참조하여 grade가 1인 데이터만 골라 입력


create table dept_temp2 as select * from dept;

select * from dept_temp2;

update dept_temp2 set loc = 'seoul'; -- dept_temp2의 loc열의 데이터를 모두 seoul로 변경

rollback; -- 수정한 내용 되돌리기

update dept_temp2 set dname = 'database', loc = 'seoul' where deptno = 40; -- 원하는 행의 데이터 수정하기 (where 사용)

update dept_temp2 set (dname, loc) = (select dname, loc from dept where deptno = 40) where deptno = 40; -- 서브쿼리를 사용하여 dept테이블의 40번 데이터를 dept_temp2의 40번자리에 넣음

update dept_temp2 set dname = (select dname from dept where deptno = 40), loc = (select loc from dept where deptno = 40) where deptno = 40; -- 위와 결과 는 같지만, 열을 따로따로 수정하는 것도 가능하다는것을 보여줌

update dept_temp2 set loc = 'seoul' where deptno = (select deptno from dept_temp2 where dname = 'OPERATIONS'); -- where절에 서브쿼리를 사용하여 수정


create table emp_temp2 as select * from emp;

select * from emp_temp2;

delete from emp_temp2 where job = 'MANAGER'; -- job열에서 manager 데이터를 가진 행을 삭제

delete from emp_temp2 where empno in (select e.empno from emp_temp2 e, salgrade s where e.sal between s.losal and s.hisal and s.grade = 3 and deptno = 30); -- sal테이블을 끌어와서 급여등급이 3인 데이터와, deptno가 30인 데이터 삭제

delete from emp_temp2; -- emp_temp2테이블에 있는 전체 데이터 삭제



create table dept_tcl as select * from dept;

select * from dept_tcl;

insert into dept_tcl values(50, 'DATABASE', 'SEOUL');

update dept_tcl set loc = 'BUSAN' where deptno = 40;

delete from dept_tcl where dname = 'RESEARCH';

select * from dept_tcl;

-- rollback; -> 현재 트랜잭션에 포함된 데이터 조작 관련 명령어의 수행을 모두 취소

-- commit; -> 변경된 데이터를 모두 데이터베이스에 영구히 저장

delete from dept_tcl where deptno = 50; -- commit을 하지 않았기 때문에 SQL*PLUS 에서 변경내용 확인 불가능

select * from dept_tcl;

commit; -- SQL*PLUS 에서 변경내용 확인 가능

update dept_tcl set loc = 'SEOUL' where deptno = 30; -- commit을 하지 않은 상태 -> lock이 걸려있음 (다른곳에서 접속, 수정이 불가능)

commit;





CREATE TABLE EMP_DDL(EMPNO NUMBER(4), ENAME VARCHAR2(10), JOB VARCHAR2(9), MGR NUMBER(4), HIREDATE DATE, SAL NUMBER(7,2), COMM NUMBER(7,2), DEPTNO NUMBER(2)); -- EMP_DDL 이라는 EMP테이블과 열 구조가 같은 테이블 생성

DESC EMP_DDL;

CREATE TABLE DEPT_DDL AS SELECT * FROM DEPT; -- DEPT와 같은 테이블 생성

DESC DEPT_DDL;

SELECT * FROM DEPT_DDL;

CREATE TABLE EMP_DDL_30 AS SELECT * FROM EMP WHERE DEPTNO = 30;

SELECT * FROM EMP_DDL_30;

CREATE TABLE EMPDEPT_DDL AS SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM, D.DEPTNO, D.DNAME, D.LOC FROM EMP E, DEPT D WHERE 1<>1; -- EMP 테이블과 DEPT테이블을 조인하고, 열 구조만 복사해서 새 테이블 생성

SELECT * FROM EMPDEPT_DDL;

CREATE TABLE EMP_ALTER AS SELECT * FROM EMP; -- EMP테이블을 복사하여 EMP_ALTER테이블 생성

SELECT * FROM EMP_ALTER;

ALTER TABLE EMP_ALTER ADD HP VARCHAR2(20); -- EMP_ALTER 테이블에 HP열 추가

ALTER TABLE EMP_ALTER RENAME COLUMN HP TO TEL; -- HP열의 이름을 TEL로 변경

ALTER TABLE EMP_ALTER MODIFY EMPNO NUMBER(5); -- EMPNO의 열 길이를 4에서 5로 변경

DESC EMP_ALTER;

ALTER TABLE EMP_ALTER DROP COLUMN TEL; -- TEL열 삭제

SELECT * FROM EMP_ALTER;


RENAME EMP_ALTER TO EMP_RENAME; -- 테이블 이름 변경 (ALTER에서 RENAME으로)

SELECT * FROM EMP_RENAME;


TRUNCATE TABLE EMP_RENAME; -- EMP_RENAME 테이블의 모든 데이터 삭제 (데이터만 삭제하므로, 테이블구조는 남아있음)

SELECT * FROM EMP_RENAME;


DROP TABLE EMP_RENAME; -- 테이블을 삭제

SELECT * FROM EMP_RENAME; -- 실행해도 존재하지 않는다고 표시됨




SELECT * FROM DICT;
SELECT * FROM DEICTIONARY; -- SCOTT계정에서 사용가능한 데이터 사전 (위의것과 결과가 같음)

SELECT TABLE_NAME FROM USER_TABLES; -- SCOTT계정에 있는 모든 테이블의 이름 출력

SELECT OWNER, TABLE_NAME FROM ALL_TABLES; -- ALL접두어를 붙여 사용가능한 모든 테이블이 출력

SELECT * FROM DBA_TABLES; -- DBA_접두어를 가진 데이터사전은 권한을 가진 사용자만 조회 가능


---------------------- SYSTEM 계정이랑 번갈아가며 사용----------------------------


SELECT * FROM USER_INDEXES; -- SCOTT계정이 소유한 인덱스 정보 조회

SELECT * FROM USER_IND_COLUMNS; -- SCOTT 계정이 소유한 인덱스 칼럼 정보 조회

CREATE INDEX IDX_EMP_SAL ON EMP(SAL);













CREATE TABLE TABLE_NOTNULL(LOGIN_ID VARCHAR2(20) NOT NULL, LOGIN_PW VARCHAR2(20) NOT NULL, TEL VARCHAR2(20));
-- NOT NULL -> NULL의 저장을 허용하지 않는 제약 조건

DESC TABLE_NOTNULL;

INSERT INTO TABLE_NOTNULL (LOGIN_ID, LOGIN_PW, TEL) VALUES ('TEST_ID_01', NULL, '010-1234-5678');
-- NOT NULL로 지정한 열에 NULL값을 입력하게되면 오류거 발생

INSERT INTO TABLE_NOTNULL (LOGIN_ID, LOGIN_PW) VALUES ('TEST_ID_01', '1234'); -- 제약조건이 없는 TEL열에는 NULL입력 가능

SELECT * FROM TABLE_NOTNULL;

UPDATE TABLE_NOTNULL SET LOGIN_PW = NULL WHERE LOGIN_ID = 'TEST_ID_01'; -- NOT NULL 로 지정하면 NULL로 업데이트도 불가능

SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS; -- 제약조건 확인

CREATE TABLE TABLE_NOTNULL2 (LOGIN_ID VARCHAR2(20) CONSTRAINT TBLNN2_LGNID_NN NOT NULL, LOGIN_PW VARCHAR2(20) CONSTRAINT TBLNN_LGNPW_NN NOT NULL, TEL VARCHAR2(20));
-- 제약조건에 이름을 붙여서 새로운 테이블 만들기

SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS;

ALTER TABLE TABLE_NOTNULL MODIFY(TEL NOT NULL); -- 이미 TEL열안에 NULL값이 들어가 있기 때문에 NOT NULL제약조건을 추가할 수 없음

UPDATE TABLE_NOTNULL SET TEL = '010-1234-5678' WHERE LOGIN_ID = 'TEST_ID_01'; -- 비어있는 TEL열에 데이터 추가

SELECT * FROM TABLE_NOTNULL;

ALTER TABLE TABLE_NOTNULL MODIFY (TEL NOT NULL); -- TEL열을 채웠으므로 NOT NULL 제약조건 추가 가능

SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS; -- 제약조건 확인

ALTER TABLE TABLE_NOTNULL2 MODIFY (TEL CONSTRAINT TBLNN_TEL_NN NOT NULL); -- 제약조건 이름 설정

SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS;

DESC TABLE_NOTNULL2;

ALTER TABLE TABLE_NOTNULL2 RENAME CONSTRAINT TBLNN_TEL_NN TO TBLNN2_TEL_NN; -- 제약조건의 이름 수정

SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS; -- 제약조건 확인

ALTER TABLE TABLE_NOTNULL2 DROP CONSTRAINT TBLNN2_TEL_NN; -- 제약조건(NOT NULL) 삭제

DESC TABLE_NOTNULL2;


CREATE TABLE TABLE_UNIQUE (LOGIN_ID VARCHAR2(20) UNIQUE, LOGIN_PWD VARCHAR2(20) NOT NULL, TEL VARCHAR2(20));

DESC TABLE_UNIQUE;

SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'TABLE_UNIQUE';
-- WHERE절을 통해 TABLE_UNIQUE의 제약조건만 조회

INSERT INTO TABLE_UNIQUE VALUES ('TEST_ID_01', 'PWD01', '010-2345-6789'); -- 데이터 입력

SELECT * FROM TABLE_UNIQUE;

INSERT INTO TABLE_UNIQUE VALUES ('TEST_ID_01', 'PWD01', '010-2345-6789'); -- 중복된 데이터 입력, UNIQUE 제약조건으로 인해 중복데이터는 입력 불가능

INSERT INTO TABLE_UNIQUE VALUES ('TEST_ID_02', 'PWD01', '010-1234-5678'); -- LOGIN_ID를 제외하고는 중복데이터 입력 가능

SELECT * FROM TABLE_UNIQUE;

INSERT INTO TABLE_UNIQUE VALUES (NULL, 'PWD01', '010-1234-5678'); -- NULL은 데이터 중복의 의미를 부여할수 없음 -> NULL 입력가능

SELECT * FROM TABLE_UNIQUE;

UPDATE TABLE_UNIQUE SET LOGIN_ID = 'TEST_ID_01' WHERE LOGIN_ID IS NULL; -- NULL자리에 중복 데이터를 넣으려고 해도 막힘

CREATE TABLE TABLE_UNIQUE2 (LOGIN_ID VARCHAR2(20) CONSTRAINT TBLUNQ2_LGNID_UNQ UNIQUE, LOGIN_PW VARCHAR2(20) CONSTRAINT TBLUNQ2_LGNPW_NN NOT NULL, TEL VARCHAR2(20));
-- 제약조건 이름을 지정하여 테이블 생성

SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME LIKE 'TABLE_UNIQUE%';

ALTER TABLE TABLE_UNIQUE MODIFY (TEL UNIQUE); -- 이미 중복된 데이터가 입력되어있어, UNIQUE 제약조건을 추가할 수 없음

UPDATE TABLE_UNIQUE SET TEL = NULL; -- TEL열의 데이터를 NULL처리

SELECT * FROM TABLE_UNIQUE;

ALTER TABLE TABLE_UNIQUE MODIFY (TEL UNIQUE); -- 모두 NULL처리를 했기 때문에, UNIQUE 제약조건 추가 가능

ALTER TABLE TABLE_UNIQUE2 MODIFY (TEL CONSTRAINT TBLUNQ_TEL_UNQ UNIQUE); -- TABLE_UNIQUE2 테이블에 제약조건 이름을 지정해서 추가

SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME LIKE 'TABLE_UNIQUE%';

ALTER TABLE TABLE_UNIQUE2 RENAME CONSTRAINT TBLUNQ_TEL_UNQ TO TBLUNQ2_TEL_UNQ; -- 제약조건 이름 수정

SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME LIKE 'TABLE_UNIQUE%';

ALTER TABLE TABLE_UNIQUE2 DROP CONSTRAINT TBLUNQ2_TEL_UNQ; -- TEL열의 UNIQUE 제약조건 삭제

SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME LIKE 'TABLE_UNIQUE%';

CREATE TABLE TABLE_PK (LOGIN_ID VARCHAR2(20) PRIMARY KEY, LOGIN_PW VARCHAR2(20) NOT NULL, TEL VARCHAR2(20));
-- PRIMARY KEY 설정

DESC TABLE_PK;

SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME LIKE 'TABLE_PK%'; -- 생성한 PK확인하기

SELECT INDEX_NAME, TABLE_OWNER, TABLE_NAME FROM USER_INDEXES WHERE TABLE_NAME LIKE 'TABLE_PK%'; -- PRIMARY KEY로 자동생성된 인덱스 확인

CREATE TABLE TABLE_PK2 (LOGIN_ID VARCHAR2(20) CONSTRAINT TBLPK2_LGNID_PK PRIMARY KEY, LOGIN_PWD VARCHAR2(20) CONSTRAINT TBLPK2_LGNPW_NN NOT NULL, TEL VARCHAR2(20));
-- 제약조건의 이름을 지정해서 테이블 생성

DESC TABLE_PK2;

INSERT INTO TABLE_PK VALUES ('TEST_ID_01', 'PWD01', '010-1234-5678'); -- 데이터 입력

SELECT * FROM TABLE_PK;

INSERT INTO TABLE_PK VALUES ('TEST_ID_01', 'PWD02', '010-2345-6789'); -- 중복데이터 입력, PRIMARY KEY 제약조건은 중복을 허용하지 않는다

INSERT INTO TABLE_PK VALUES (NULL, 'PWD02', '010-2345-6789'); -- NULL값의 입력도 안됨


SELECT OWNER, CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME, R_OWNER, R_CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME IN ('EMP', 'DEPT');

INSERT INTO EMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (9999, '홍길동', 'CLERK', 7788, TO_DATE('2017/04/30', 'YYYY/MM/DD'), 1200, NULL, 50);
-- 부모키가 없습니다 -> DEPT 테이블에 DEPTNO 열에 50이 존재하지 않는다

CREATE TABLE DEPT_FK(DEPTNO NUMBER(2) CONSTRAINT DEPTFK_DEPTNO_PK PRIMARY KEY, DNAME VARCHAR2(14), LOC VARCHAR2(13));
-- 참조대상이 될 DEPT_FK 테이블 생성

DESC DEPT_FK;

CREATE TABLE EMP_FK(EMPNO NUMBER(4) CONSTRAINT EMPFK_EMPNO_PK PRIMARY KEY, ENAME VARCHAR2(10), JOB VARCHAR2(9), MGR NUMBER(4), HIREDATE DATE, SAL NUMBER(7,2), COMM NUMBER(7,2), DEPTNO NUMBER(2) CONSTRAINT EMPFK_DEPTNO_FK REFERENCES DEPT_FK (DEPTNO));
-- DEPT_FK 테이블을 참조하는 EMP_FK 테이블 생성

DESC EMP_FK;

INSERT INTO EMP_FK VALUES (9999, 'TEST_NNAME', 'TEST_JOB', NULL, TO_DATE('2001/01/01', 'YYYY/MM/DD'), 3000, NULL, 10);
-- 부모키가 없습니다 -> DEPT 테이블에 DEPTNO 열에 10이 존재하지 않는다

INSERT INTO DEPT_FK VALUES(10, 'TEST_DNAME', 'TEST_LOC'); -- DEPT_FK 테이블에 10번 데이터 입력

INSERT INTO EMP_FK VALUES (9999, 'TEST_NNAME', 'TEST_JOB', NULL, TO_DATE('2001/01/01', 'YYYY/MM/DD'), 3000, NULL, 10);
-- DEPT_FK 테이블에 10번 데이터를 입력함으로써 EMP_DK 테이블에 10번의 데이터를 입력 가능

SELECT * FROM EMP_FK;

DELETE FROM DEPT_FK WHERE DEPTNO = 10; -- 자식레코드가 발견되었습니다 -> 10번 값을 참조하는 데이터가 존재


CREATE TABLE TABLE_CHECK(LOGIN_ID VARCHAR2(20) CONSTRAINT TBLCK_LOGINID_PK PRIMARY KEY, LOGIN_PWD VARCHAR2(20) CONSTRAINT TBLCK_LOGINPW_CK CHECK (LENGTH(LOGIN_PWD) > 3), TEL VARCHAR2 (20));
-- 테이블 생성,  LENGTH(LOGIN_PWD) > 3은 LOGIN_PWD 열 길이가 3 이상인 데이터만 저장 가능하다는 뜻

DESC TABLE_CHECK;










CREATE USER ORCLSTUDY INDENTIFIED BY ORACLE; -- SCOTT계정은 사용자를 생성할 권한이 없음























-- 답안 --

select distinct job from emp; -- 92p Q2 답안

select empno as employee_no, ename as employee_name, mgr as manager, sal as salary, comm as commission, deptno as department_no from emp order by deptno desc, ename asc;
-- 92p Q3 답안

select * from emp where ename like '%S'; -- 125p Q1 답안

select empno, ename, job, sal, deptno from emp where deptno = 30 and job = 'SALESMAN'; -- 125p Q2 답안

select empno, ename, job, sal, deptno from emp where deptno = 20 and sal > 2000 or deptno = 30 and sal > 2000; -- 125p Q3 집합연산자를 사용하지 않은 답안

select empno, ename, job, sal, deptno from emp where deptno = 20 and sal > 2000 union select empno, ename, job, sal, deptno from emp where deptno = 30 and sal > 2000;
-- 125p Q3 집합연산자를 사용한 답안

select * from emp where sal < 2000 union select * from emp where sal > 3000; -- 126p Q4 답안

select ename, empno, sal, deptno from emp where deptno = 30 and ename like '%E%' and sal not between 1000 and 2000; -- 126p Q5 답안

select * from emp where comm is null and mgr is not null and job in ('MANAGER', 'CLERK') and ename not like '_L%'; -- 126p Q6 답안

select e.deptno, d.dname, e.empno, e.ename, e.sal from emp e, dept d where e.DEPTNO = d.DEPTNO and sal > 2000 order by e.DEPTNO; -- 239p Q1 SQL-99 이전 방식 답안

select deptno, d.dname, e.empno, e.ename, e.sal from emp e join dept d using (deptno) where sal > 2000 order by deptno; -- 239p Q1 SQL-99 방식 답안

select d.deptno, d.dname, trunc(avg(sal)) as AVG_SAL, max(sal) as MAX_SAL, min(sal) as MIN_SAL, count(*) as CNT from emp e, dept d where e.DEPTNO = d.deptno group by d.DEPTNO, d.DNAME;
-- 239p Q2 SQL-99 이전 방식 답안

select deptno, d.dname, trunc(avg(sal)) as AVG_SAL, max(sal) as MAX_SAL, min(sal) as MIN_SAL, count(*) as CNT from emp e join dept d using(deptno) group by DEPTNO, d.DNAME;
-- 239p Q2 SQL-99 방식 답안

select d.deptno, d.dname, e.empno, e.ename, e.job, e.sal from emp e, dept d where e.DEPTNO(+) = d.DEPTNO order by deptno, e.ename; -- 239p Q3 SQL-99 이전 방식 답안

select d.deptno, d.dname, e.empno, e.ename, e.job, e.sal from emp e right outer join dept d on (e.deptno = d.deptno) order by deptno, e.ename;
-- 239p Q3 SQL-99 방식 답안

select d.deptno, d.dname, e1.empno, e1.ename, e1.mgr, e1.sal, e1.deptno as DEPTNO_1, s.losal, s.hisal, s.grade, e2.empno as MGR_EMPNO, e2.ename as MGR_ENAME from emp e1, emp e2, dept d, salgrade s where e1.DEPTNO(+) = d.DEPTNO and e1.mgr = e2.empno(+) and e1.sal between s.losal(+) and s.hisal(+) order by d.deptno, e1.empno;
-- 240p Q4 SQL-99 이전 방식 답안

select d.deptno, d.dname, e1.empno, e1.ename, e1.mgr, e1.sal, e1.deptno as DEPTNO_1, s.losal, s.hisal, s.grade, e2.empno as MGR_EMPNO, e2.ename as MGR_ENAME from emp e1 right outer join dept d on (e1.deptno = d.deptno) left outer join emp e2 on (e1.mgr = e2.empno) left outer join salgrade s on (e1.sal between s.losal and s.hisal) order by d.deptno, e1.empno;
-- 240p Q4 SQL-99 방식 답안

CREATE TABLE CHAP10HW_EMP AS SELECT * FROM EMP;
CREATE TABLE CHAP10HW_DEPT AS SELECT * FROM DEPT;
CREATE TABLE CHAP10HW_SALGRADE AS SELECT * FROM SALGRADE; -- 287p용 복사데이터

insert into chap10hw_dept values (50, 'ORACLE', 'BUSAN');
insert into chap10hw_dept values (60, 'SQL', 'ILSAN');
insert into chap10hw_dept values (70, 'SELECT', 'INCHEON');
insert into chap10hw_dept values (80, 'DML', 'BUNDANG'); -- 287p Q1 답안

select * from chap10hw_dept; -- 287p Q1 답안 출력

insert into chap10hw_emp values (7201, 'TEST_USER1', 'MANAGER', 7788, '2016-01-02', 4500, null, 50);
insert into chap10hw_emp values (7202, 'TEST_USER2', 'CLERK', 7201, '2016-02-21', 1800, null, 50);
insert into chap10hw_emp values (7203, 'TEST_USER3', 'ANALYST', 7201, '2016-04-11', 3400, null, 60);
insert into chap10hw_emp values (7204, 'TEST_USER4', 'SALESMAN', 7201, '2016-05-31', 2700, 300, 60);
insert into chap10hw_emp values (7205, 'TEST_USER5', 'CLERK', 7201, '2016-07-20', 2600, null, 70);
insert into chap10hw_emp values (7206, 'TEST_USER6', 'CLERK', 7201, '2016-09-08', 2600, null, 70);
insert into chap10hw_emp values (7207, 'TEST_USER7', 'LECTURER', 7201, '2016-10-28', 2300, null, 80);
insert into chap10hw_emp values (7208, 'TEST_USER8', 'STUDENT', 7201, '2018-03-09', 1200, null, 80); -- 287p Q2 답안

select * from chap10hw_emp; -- 287p Q2 답안 출력

update chap10hw_emp set deptno = 70 where sal > (select avg(sal) from chap10hw_emp where deptno = 50); -- 288p Q3 답안

select * from chap10hw_emp order by deptno; -- 288p Q3 답안 출력

update chap10hw_emp set sal = sal*110/100, deptno = 80 where hiredate > (select min(hiredate) from chap10hw_emp where deptno = 60); -- 288p Q4 답안

select * from chap10hw_emp order by deptno; -- 288p Q4 답안 출력

delete from chap10hw_emp where empno in ( select e.empno from chap10hw_emp e, chap10hw_salgrade s where e.sal between s.losal and s.hisal and s.grade = 5);
-- 289p Q5 답안

select * from chap10hw_emp; -- 289p Q5 답안 출력

CREATE TABLE EMP_HW (EMPNO NUMBER(4), ENAME VARCHAR2(10), JOB VARCHAR2(9), MGR NUMBER(4), HIREDATE DATE, SAL NUMBER(7,2), COMM NUMBER(7,2), DEPTNO NUMBER(2));
-- 324p Q1 답안

ALTER TABLE EMP_HW ADD BIGO VARCHAR2(20); -- 324p Q2 답안

ALTER TABLE EMP_HW MODIFY BIGO VARCHAR2(30); -- 324p Q3 답안

ALTER TABLE EMP_HW RENAME COLUMN BIGO TO REMARK; -- 324p Q4 답안

INSERT INTO EMP_HW VALUES (7369, 'SMITH', 'CLERK', 7902, '1980-12-17', 800, NULL, 20, NULL);
INSERT INTO EMP_HW VALUES (7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20', 1600, 300, 30, NULL);
INSERT INTO EMP_HW VALUES (7521, 'WARD', 'SALESMAN', 7698, '1981-02-22', 1250, 500, 30, NULL);
INSERT INTO EMP_HW VALUES (7566, 'JONES', 'MANAGER', 7839, '1981-04-02', 2975, NULL, 20, NULL);
INSERT INTO EMP_HW VALUES (7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28', 1250, 1400, 30, NULL);
INSERT INTO EMP_HW VALUES (7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01', 2850, NULL, 30, NULL);
INSERT INTO EMP_HW VALUES (7782, 'CLARK', 'MANAGER', 7839, '1981-06-09', 2450, NULL, 10, NULL);
INSERT INTO EMP_HW VALUES (7788, 'SCOTT', 'ANALYST', 7566, '1987-04-19', 3000, NULL, 20, NULL);
INSERT INTO EMP_HW VALUES (7839, 'KING', 'PRESIDENT', NULL, '1981-11-17', 5000, NULL, 10, NULL);
INSERT INTO EMP_HW VALUES (7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08', 1500, 0, 30, NULL);
INSERT INTO EMP_HW VALUES (7876, 'ADAMS', 'CLERK', 7788, '1987-05-23', 1100, NULL, 20, NULL);
INSERT INTO EMP_HW VALUES (7900, 'JAMES', 'CLERK', 7698, '1981-12-03', 950, NULL, 30, NULL);
INSERT INTO EMP_HW VALUES (7902, 'FORD', 'ANALYST', 7566, '1981-12-03', 3000, NULL, 20, NULL);
INSERT INTO EMP_HW VALUES (7934, 'MILLER', 'CLERK', 7782, '1982-01-23', 1300, NULL, 10, NULL); -- 325p Q5 답안

DROP TABLE EMP_HW; -- 325p Q6 답안
SELECT * FROM EMP_HW -- 삭제완료