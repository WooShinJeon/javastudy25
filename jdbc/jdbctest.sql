CREATE TABLE B_CUSTOMERS (
  cust_jumin varchar2(20),
  cust varchar2(100) NOT NULL,
  cust_bir_name varchar2(20) NOT NULL, 
  cust_addrth date,
  cust_email varchar2(50) NOT NULL UNIQUE,
  cust_phnum varchar2(25) NOT NULL,
  cust_job varchar2(30));
  
alter table b_customers add constraint cust_jumin_pk primary key(cust_jumin);

create table b_cards (
card_id varchar2(15),
card_register_date date,
card_limit_money number(10),
card_approve_date date,
card_type varchar2(10) not null,
cust_jumin varchar2(20),
acc_id varchar2(10));

alter table b_cards add constraint card_id_pk primary key(card_id);

alter table b_cards add constraint card_cust_jumin_fk1 foreign key(cust_jumin) references b_customers (cust_jumin);

alter table b_cards add constraint card_acc_id_fk2 foreign key(acc_id) references b_accounts (acc_id);

create table b_accounts (
acc_id varchar2(10),
acc_type varchar2(20) not null,
acc_balance number(10) not null,
card_ask varchar2(5) not null,
acc_register_date date,
acc_cust_name varchar2(20) not null,
acc_phnum varchar2(20),
acc_email varchar2(50) not null unique,
cust_jumin varchar2(20));

alter table b_accounts add constraint acc_id_pk primary key(acc_id);

alter table b_accounts add constraint acc_cust_jumin_fk foreign key(cust_jumin) references b_customers (cust_jumin);

create table b_acc_trades (
acc_id varchar2(10),
imp_exp_date date,
trade_id number,
acc_class varchar2(20),
acc_contents varchar2(50),
trade_money number,
acc_balance number(10) not null);

alter table b_acc_trades add constraint acc_trade_id_pk primary key(acc_id, imp_exp_date, trade_id);

alter table b_acc_trades add constraint acc_trade_id_fk foreign key(acc_id) references b_accounts (acc_id);

select * from b_customers;
select * from b_cards;
select * from b_accounts;
select * from b_acc_trades;


insert into b_customers values
('000128-3213213', '전우신', '수원시 영통구', '00-01-28', 'qwer@as.com', '010-1234-5678', '무직백수');

insert into b_customers values
('000402-4123123', '이준영', '경기도', '00-04-02', 'qwerq@qw.com', '010-2345-6789', '무직백수');

insert into b_customers values
('060604-3123123', '김민석', '경기도', '06-06-04', 'ewq@sa.com', '010-8765-4321', '무직백수');

insert into b_customers values
('001111-3xxxxxx', '호지수', '수원시', '00-11-11', 'wqwq@wqw.com', '010-9876-5432', '무직백수');

insert into b_customers values
('990101-1xxxxxx', '짱구', '떡잎마을', '99-01-01', 'wwww@ww.com', '010-1233-1233', '떡잎마을방범대');


insert into b_accounts values
('11111', '예금계좌종류', '10000000', 'YES', '2024-04-04', '전우신', '010-1234-5678', 'qwer@as.com', '000128-3213213');

insert into b_accounts values
('22222', '예금계좌종류', '5000000', 'YES', '2024-03-03', '이준영', '010-2345-6789', 'qwerq@qw.com', '000402-4123123');

insert into b_accounts values
('33333', '예금계좌종류', '3000000', 'YES', '2025-06-04', '김민석', '010-8765-4321', 'ewq@sa.com', '060604-3123123');

insert into b_accounts values
('44444', '예금계좌종류', '15000000', 'YES', '2024-01-01', '호지수', '010-9876-5432', 'wqwq@wqw.com', '001111-3xxxxxx');

insert into b_accounts values
('55555', '예금계좌종류', '50000000', 'NO', '2020-01-01', '짱구', '010-1233-1233', 'wwww@ww.com', '990101-1xxxxxx');


insert into b_cards values
('11111', '2024-04-04', '100000000', null, 'VISA', '000128-3213213', '11111');

insert into b_cards values
('22222', '2024-03-03', '100000000', null, 'MASTERCARD', '000402-4123123', '22222');

insert into b_cards values
('33333', '2025-06-04', '100000000', null, 'KB', '060604-3123123', '33333');

insert into b_cards values
('44444', '2024-01-01', '100000000', null, 'SHINHAN', '001111-3xxxxxx', '44444');


insert into b_acc_trades values
('11111', '2025-06-05', '12345', '예금구분', '예금내용', '1000000', '9000000');

insert into b_acc_trades values
('22222', '2025-05-20', '54321', '예금구분', '예금내용', '500000', '4500000');

insert into b_acc_trades values
('33333', '2025-06-05', '12345', '예금구분', '예금내용', '1000000', '4000000');

insert into b_acc_trades values
('44444', '2025-05-20', '54321', '예금구분', '예금내용', '500000', '15500000');






-- (1) 카드를 신청한 모든 고객에 대한 정보를 출력하시오.
select cust_jumin, c.cust_name, c.cust_addr, c.cust_birth, c.cust_email, c.cust_phnum, c.cust_job
from B_CUSTOMERS c join b_accounts a using (cust_jumin)
where a.card_ask = 'YES'
-- 카드신청을 안한 짱구를 제외한 모든 고객 정보 출력


--(2) 예금 잔고가 1,000,000 ~ 5,000,000 인 고객에 대한 정보를 출력하시오.
select c.cust_jumin, c.cust_name, c.cust_birth, c.cust_addr, c.cust_email, c.cust_phnum, c.cust_job
from b_accounts a join b_customers c on(c.cust_jumin = a.cust_jumin)
join b_acc_trades at on (a.acc_id = at.acc_id)
where at.acc_balance between 1000000 and 5000000
-- 예금계좌와 고객 조인, 예금계좌와 예금계좌거래내역 조인
-- 예금계좌거래내역 테이블에서 예금잔고 데이터를 between 함수를 이용해 비교, 조건에 맞는 데이터 출력


--(3) 카드종류가 VISA인 고객의 예금 잔고를 출력하시오.
select at.acc_balance
from b_accounts a join b_cards ca on (a.acc_id = ca.acc_id)
join b_acc_trades at on (a.acc_id = at.acc_id)
where ca.card_type = 'VISA'





