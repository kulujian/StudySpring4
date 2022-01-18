-- 建立 Job 資料表
-- create table if not exists job (
-- 	jid int not null auto_increment,  -- 主鍵(會自動產生序號：1、2、3，過號不返回)
-- 	jname varchar(50) not null unique, -- 工作姓名
-- 	eid int, -- 員工 id
-- 	primary key(jid),
-- 	foreign key(eid) references emp(eid) -- 外鍵約束/關聯
-- );


insert into job(jname, eid) values ('report', 1);
insert into job(jname, eid) values ('coding', 3);
insert into job(jname, eid) values ('jobA', 3);
insert into job(jname, eid) values ('jobB', 4);
insert into job(jname, eid) values ('jobC', 7);
insert into job(jname, eid) values ('jobD', 12);
insert into job(jname, eid) values ('jobE', 13);
insert into job(jname, eid) values ('jobF', 1);
insert into job(jname, eid) values ('jobG', 1);
insert into job(jname, eid) values ('jobH', 3);
insert into job(jname, eid) values ('jobI', 12);
insert into job(jname, eid) values ('jobJ', 7);
insert into job(jname, eid) values ('jobK', 4);
insert into job(jname, eid) values ('jobL', 3);
insert into job(jname) values ('jobM');
insert into job(jname) values ('jobN');