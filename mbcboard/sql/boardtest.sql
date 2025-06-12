
---------------------------------------------------------------member 테이블을 부모로 생성---------------------------------------------------------------
create table member(
mno number(5) not null,
bwriter nvarchar2(10) not null,
id nvarchar2(10) primary key,
pw nvarchar2(10) not null,
regidate date default sysdate not null
)

insert into member (mno, bwriter, id, pw) values (BOARD_seq.nextval, '전우신', 'jws', '1357')
insert into member (mno, bwriter, id, pw) values (BOARD_seq.nextval, '이준영', 'ljy', '2468')
insert into member (mno, bwriter, id, pw) values (BOARD_seq.nextval, '호지수', 'hjs', '1470')
insert into member (mno, bwriter, id, pw) values (BOARD_seq.nextval, '김민석', 'kms', '2580')
insert into member (mno, bwriter, id, pw) values (BOARD_seq.nextval, '이채윤', 'lcy', '3690')
insert into member (mno, bwriter, id, pw) values (BOARD_seq.nextval, '권정인', 'kji', '1590')
insert into member (mno, bwriter, id, pw) values (BOARD_seq.nextval, '김수아', 'ksa', '3570')




select * from member



---------------------------------------------------------------member의 자식 board 외래키 생성 필수---------------------------------------------------------------



create table board(
bno number(5) primary key,
btitle nvarchar2(30) not null,
bcontent nvarchar2(1000) not null,
bwriter nvarchar2(10) not null,
bdate date not null
)

create sequence board_seq increment by 1 start with 1 nocycle nocache

alter table board add constraint board_member_fk foreign key (bwriter) references member (id)
-- board 테이블은 member의 자식 테이블로 member의 id와 board의 bwriter를 관계설정 (외래키)

insert into BOARD values
(board_seq.nextval, '덥네용~', '무더운데 등교하시느냐고 고생 하셨습니다.','jws', sysdate)
insert into BOARD values
(board_seq.nextval, '안녕하세용~', '무더운데 등교하시느냐고 고생 하셨습니다.','ljy', sysdate)
insert into BOARD values
(board_seq.nextval, '감사합니당~', '무더운데 등교하시느냐고 고생 하셨습니다.','hjs', sysdate)
insert into BOARD values
(board_seq.nextval, '수고용~', '무더운데 등교하시느냐고 고생 하셨습니다.','kms', sysdate)
insert into BOARD values
(board_seq.nextval, '화이팅이용~', '무더운데 등교하시느냐고 고생 하셨습니다.','lcy', sysdate)
insert into BOARD values
(board_seq.nextval, '반갑구만~', '무더운데 등교하시느냐고 고생 하셨습니다.','kji', sysdate)

select * from board

delete from board



-- 조인 : 2개 테이블을 연결하여 값을 가져온다.

select b.*, m.bwriter from member m inner join board b on m.id = b.bwriter where id='kkw'





---------------------------------------------------------------회원용 테이블 mboard 생성---------------------------------------------------------------



create table mboard(
mbno number(5) primary key,
mbtitle nvarchar2(30) not null,
mbcontent nvarchar2(1000) not null,
mbwriter nvarchar2(10) not null,
mbdate date default sysdate not null,
mbid nvarchar2(10) not null
)


insert into mboard (mbno, mbtitle, mbcontent, mbwriter, mbid) values
(board_seq.nextval, '아침에', '아침에는 밥을 안먹어', '전우신', 'jws')
insert into mboard (mbno, mbtitle, mbcontent, mbwriter, mbid) values
(board_seq.nextval, '점심에', '점심은 간단히 먹어', '이준영', 'ljy')
insert into mboard (mbno, mbtitle, mbcontent, mbwriter, mbid) values
(board_seq.nextval, '저녁에', '저녁은 배부르게 먹어', '호지수', 'hjs')


select * from mboard


alter table mboard add constraint mboard_member_fk foreign key (mbid) references member (id)


select * from mboard








