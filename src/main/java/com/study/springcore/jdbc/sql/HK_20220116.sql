 -- 商品項目 --
CREATE TABLE ItemProduct (
	id INTEGER NOT NULL AUTO_INCREMENT, -- GENERATED ALWAYS AS IDENTITY, -- 商品項目序號(主鍵)
	text VARCHAR(50) NOT NULL, -- 商品項目名稱
	price INTEGER NOT NULL, -- 商品單價
	inventory INTEGER NOT NULL, -- 商品庫存
	PRIMARY KEY (id)
);

-- 發票 --
CREATE TABLE Invoice (
	id INTEGER NOT NULL AUTO_INCREMENT, -- GENERATED ALWAYS AS IDENTITY, -- 發票序號(主鍵)
	invdate Date NOT NULL, -- 發票日期
	PRIMARY KEY (id)
);

-- 發票項目 --
CREATE TABLE Item (
	id INTEGER NOT NULL AUTO_INCREMENT, -- GENERATED ALWAYS AS IDENTITY, -- 項目序號(主鍵)
	amount INTEGER NOT NULL, -- 數量
	ipid INTEGER NOT NULL, -- 商品項目序號
	invid INTEGER NOT NULL, -- 發票序號
	PRIMARY KEY (id),
	FOREIGN KEY (ipid) REFERENCES ItemProduct(id),
	FOREIGN KEY (invid) REFERENCES Invoice(id)
);

-- 建立 ItemProduct Source Data  (建立順序1，先有產品項/庫存)
INSERT INTO ItemProduct (text, price, inventory) values
("Pen", 10, 20),
("Pen", 15, 50),
("Toy", 20, 40);

-- 建立 Invoice Source Data (建立順序2，再有發票開立)
INSERT INTO Invoice (invdate) values
("2020-11-23"),
("2020-11-22"),
("2020-11-21");

-- 建立 Item Source Data (建立順序3，才會有發票項目)
INSERT INTO Item (amount, ipid, invid) values
(5, 1, 1),
(3, 2, 1),
(4, 1, 2),
(1, 3, 2),
(6, 2, 3);

-- 每一張發票有哪些商品? -- start
	SELECT i.invdate , ip.`text` 
	FROM Invoice i INNER JOIN Item i2 ON i.id = i2.invid 
	               INNER JOIN ItemProduct ip ON i2.ipid = ip.id;
-- 每一張發票有哪些商品? -- end
              
-- 每一張發票有幾件商品? -- start
	SELECT i.invdate , SUM(i2.amount) AS Sum 
	FROM Invoice i INNER JOIN Item i2 ON i.id = i2.invid
	GROUP BY 1;
-- 每一張發票有幾件商品? -- end

-- 每一張發票價值多少? -- start
	SELECT i.invdate , SUM(i2.amount * ip.price) AS Total
	FROM Invoice i INNER JOIN Item i2 ON i.id =i2.invid 
	               INNER JOIN ItemProduct ip ON i2.ipid = ip.id 
	GROUP BY 1;
-- 每一張發票價值多少? -- end

-- 每一樣商品各賣了多少數量？ -- start
	SELECT ip.`text`, SUM(i.amount) AS SUM
	FROM Item i INNER JOIN ItemProduct ip ON i.ipid = ip.id 
	GROUP BY 1;
-- 每一樣商品各賣了多少數量？ -- end

-- 哪一件商品賣得錢最多(銷售總金額最高)？ -- start
	SELECT M.text, MAX(SUM) 
	FROM (
		SELECT ip.text, SUM(i.amount * ip.price) AS 'SUM'
		FROM Item i INNER JOIN ItemProduct ip ON i.ipid = ip.id 
		GROUP BY 1 -- ORDER BY 2 DESC LIMIT 1; -- 子查詢異常時使用
	) M;
-- 哪一件商品賣得錢最多(銷售總金額最高)？ -- end

-- 哪一張發票價值最高(發票金額最高)？ --
	SELECT M.invdate, MAX(Total) 
	FROM (
	SELECT i.invdate , SUM(i2.amount * ip.price) AS Total
	FROM Invoice i INNER JOIN Item i2 ON i.id =i2.invid 
	               INNER JOIN ItemProduct ip ON i2.ipid = ip.id
	GROUP BY 1
	-- ORDER BY 2 DESC LIMIT 1; -- 子查詢異常時使用
	) M;
-- 哪一張發票價值最高(發票金額最高)？ --