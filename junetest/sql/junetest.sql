 -- 멤버 테이블 생성 --
create table member (
mno number(5) not null,
mname varchar2(15) not null,
mid varchar2(20) primary key,
mpw varchar2(20) not null,
mphone varchar2(15) not null,
memail varchar2(30) not null,
mdate date default sysdate not null
)

 -- 시퀀스 생성 --
create sequence m_seq increment by 1 start with 1 nocycle nocache

 -- 더미데이터 입력 --
insert into member (mno, mname, mid, mpw, mphone, memail) values
(m_seq.nextval, '전우신', 'jws', '1234', '010-1234-5678', 'jws@mbc.com')
insert into member (mno, mname, mid, mpw, mphone, memail) values
(m_seq.nextval, '이준영', 'ljy', '1234', '010-2345-6789', 'ljy@mbc.com')
insert into member (mno, mname, mid, mpw, mphone, memail) values
(m_seq.nextval, '호지수', 'hjs', '1234', '010-9876-5432', 'hjs@mbc.com')



select * from member




------------------------------------------------------------------------------------------------------------------------


 -- 비회원용 게시판 --
create table board(
bno number(5) primary key,
btitle nvarchar2(30) not null,
bcontent nvarchar2(1000) not null,
bwriter nvarchar2(10) not null,
bdate date default sysdate not null
)

 -- 시퀀스 --
create sequence b_seq increment by 1 start with 1 nocycle nocache

 -- 더미데이터 입력 --
insert into BOARD (bno, btitle, bcontent, bwriter) values
(b_seq.nextval, '덥네용~', '무더운데 등교하시느냐고 고생 하셨습니다.','김기원')
insert into BOARD (bno, btitle, bcontent, bwriter) values
(b_seq.nextval, '안녕하세용~', '무더운데 등교하시느냐고 고생 하셨습니다.','최준오')
insert into BOARD (bno, btitle, bcontent, bwriter) values
(b_seq.nextval, '감사합니당~', '무더운데 등교하시느냐고 고생 하셨습니다.','오승환')

select * from board


------------------------------------------------------------------------------------------------------------------------

 -- 회원용 게시판 --
create table mboard(
mbno number(5) primary key,
mbtitle nvarchar2(30) not null,
mbcontent nvarchar2(1000) not null,
mbwriter nvarchar2(10) not null,
mbid varchar2(20) not null,
mbdate date default sysdate not null
)


create sequence mb_seq increment by 1 start with 1 nocycle nocache

 -- 더미데이터 --
insert into mboard (mbno, mbtitle, mbcontent, mbwriter, mbid) values
(mb_seq.nextval, '덥네용~', '무더운데 등교하시느냐고 고생 하셨습니다.','전우신', 'jws')
insert into mboard (mbno, mbtitle, mbcontent, mbwriter, mbid) values
(mb_seq.nextval, '안녕용~', '무더운데 등교하시느냐고 고생 하셨습니다.','이준영', 'ljy')
insert into mboard (mbno, mbtitle, mbcontent, mbwriter, mbid) values
(mb_seq.nextval, '감사용~', '무더운데 등교하시느냐고 고생 하셨습니다.','호지수', 'hjs')

 -- 부모자식 연결 --
alter table mboard add constraint mboard_member_fk foreign key (mbid) references member (mid)


select * from mboard








