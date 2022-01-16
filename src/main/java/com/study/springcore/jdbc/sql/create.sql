-- 建立 Emp 資料表
create table if not exists emp (
	eid int not null auto_increment,  -- 主鍵(會自動產生序號：1、2、3，過號不返回)
	ename varchar(50) not null unique, -- 員工姓名
	age int, -- 員工年齡
	createtime timestamp default current_timestamp, -- 建檔時間
	primary key(eid)
	
)

-- 建立 Job 資料表
create table if not exists job (
	jid int not null auto_increment,  -- 主鍵(會自動產生序號：1、2、3，過號不返回)
	jname varchar(50) not null unique, -- 工作姓名
	eid int, -- 員工 id
	primary key(jid),
	foreign key(eid) references emp(eid) -- 外鍵約束/關聯
)

-- 由上述可知，一個 emp 對應多個 job，一個 job 對應一個 emp


-- 新增 Emp 範例資料
insert into emp(ename, age) values ('john', 28);
insert into emp(ename, age) values ('mary', 30);
insert into emp(ename, age) values ('bobo', 29);

-- 查詢 Emp 資料
select * from emp;