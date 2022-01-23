-- 交易 TX (Transcation) 所需要的資料表
-- book (書籍資料)、stock (庫存資料)、wallet (客戶雲端錢包)
-- 建立 book (書籍資料)
create table if not exists book(
	bid integer not null auto_increment,
	bname varchar(20) not null,
	price integer default 0,
	ct timestamp default current_timestamp,
	primary key(bid) -- 主鍵
);
-- 建立 stock (庫存資料)
create table if not exists stock(
	sid integer not null auto_increment,
	bid integer not null, -- book (書籍資料) 的 id
	amount integer default 0,
	primary key(sid), -- 主鍵
	foreign key(bid) references book (bid) -- 外鍵關聯()
);
-- 建立 wallet (客戶雲端錢包)
create table if not exists wallet(
	wid integer not null auto_increment,
	wname varchar(20) not null,
	money integer,
	primary key(wid)
);

-- HomeWork  建立交易紀錄  order_log  資料表(交易成功才會紀錄)
-- Vincent在2022/01/23 14:07:51 買了Java書2本共300元
-- Vincent在2022/01/23 14:08:51 買了Python書2本共200元
-- Vincent在2022/01/23 14:10:51 買了Java書4本共600元
-- ...
-- 注意：若 Book 的 price 欄位有變動，需要 order_log 不影響
--       若取銷交易，order_log 也需要回滾
-- 試問：資料表應如點創建？支援 TX



