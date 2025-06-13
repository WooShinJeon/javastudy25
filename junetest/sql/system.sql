create user junetest identified by junetest
grant resource, connect to junetest
alter user junetest default tablespace users
alter user junetest temporary tablespace temp
