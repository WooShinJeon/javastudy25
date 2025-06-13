 -- ��� ���̺� ���� --
create table member (
mno number(5) not null,
mname varchar2(15) not null,
mid varchar2(20) primary key,
mpw varchar2(20) not null,
mphone varchar2(15) not null,
memail varchar2(30) not null,
mdate date default sysdate not null
)

 -- ������ ���� --
create sequence m_seq increment by 1 start with 1 nocycle nocache

 -- ���̵����� �Է� --
insert into member (mno, mname, mid, mpw, mphone, memail) values
(m_seq.nextval, '�����', 'jws', '1234', '010-1234-5678', 'jws@mbc.com')
insert into member (mno, mname, mid, mpw, mphone, memail) values
(m_seq.nextval, '���ؿ�', 'ljy', '1234', '010-2345-6789', 'ljy@mbc.com')
insert into member (mno, mname, mid, mpw, mphone, memail) values
(m_seq.nextval, 'ȣ����', 'hjs', '1234', '010-9876-5432', 'hjs@mbc.com')



select * from member




------------------------------------------------------------------------------------------------------------------------


 -- ��ȸ���� �Խ��� --
create table board(
bno number(5) primary key,
btitle nvarchar2(30) not null,
bcontent nvarchar2(1000) not null,
bwriter nvarchar2(10) not null,
bdate date default sysdate not null
)

 -- ������ --
create sequence b_seq increment by 1 start with 1 nocycle nocache

 -- ���̵����� �Է� --
insert into BOARD (bno, btitle, bcontent, bwriter) values
(b_seq.nextval, '���׿�~', '����� ��Ͻô��İ� ��� �ϼ̽��ϴ�.','����')
insert into BOARD (bno, btitle, bcontent, bwriter) values
(b_seq.nextval, '�ȳ��ϼ���~', '����� ��Ͻô��İ� ��� �ϼ̽��ϴ�.','���ؿ�')
insert into BOARD (bno, btitle, bcontent, bwriter) values
(b_seq.nextval, '�����մϴ�~', '����� ��Ͻô��İ� ��� �ϼ̽��ϴ�.','����ȯ')

select * from board


------------------------------------------------------------------------------------------------------------------------

 -- ȸ���� �Խ��� --
create table mboard(
mbno number(5) primary key,
mbtitle nvarchar2(30) not null,
mbcontent nvarchar2(1000) not null,
mbwriter nvarchar2(10) not null,
mbid varchar2(20) not null,
mbdate date default sysdate not null
)


create sequence mb_seq increment by 1 start with 1 nocycle nocache

 -- ���̵����� --
insert into mboard (mbno, mbtitle, mbcontent, mbwriter, mbid) values
(mb_seq.nextval, '���׿�~', '����� ��Ͻô��İ� ��� �ϼ̽��ϴ�.','�����', 'jws')
insert into mboard (mbno, mbtitle, mbcontent, mbwriter, mbid) values
(mb_seq.nextval, '�ȳ��~', '����� ��Ͻô��İ� ��� �ϼ̽��ϴ�.','���ؿ�', 'ljy')
insert into mboard (mbno, mbtitle, mbcontent, mbwriter, mbid) values
(mb_seq.nextval, '�����~', '����� ��Ͻô��İ� ��� �ϼ̽��ϴ�.','ȣ����', 'hjs')

 -- �θ��ڽ� ���� --
alter table mboard add constraint mboard_member_fk foreign key (mbid) references member (mid)


select * from mboard








