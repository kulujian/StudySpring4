-- 每一張發票有哪些商品? --
	SELECT i.invdate , ip.`text` 
	FROM Invoice i INNER JOIN Item i2 ON i.id = i2.invid 
	               INNER JOIN ItemProduct ip ON i2.ipid = ip.id;
-- 每一張發票有哪些商品? --
              
-- 每一張發票有幾件商品? --
	SELECT i.invdate , SUM(i2.amount) AS Sum 
	FROM Invoice i INNER JOIN Item i2 ON i.id = i2.invid
	GROUP BY 1;
-- 每一張發票有幾件商品? --

-- 每一張發票價值多少? --
	SELECT i.invdate , SUM(i2.amount * ip.inventory) AS Total
	FROM Invoice i INNER JOIN Item i2 ON i.id =i2.invid 
	               INNER JOIN ItemProduct ip ON i2.ipid = ip.id 
	GROUP BY 1;
-- 每一張發票價值多少? --

-- 每一樣商品各賣了多少？ --
	SELECT ip.`text`, SUM(i.amount) AS SUM
	FROM Item i INNER JOIN ItemProduct ip ON i.ipid = ip.id 
	GROUP BY 1;
-- 每一樣商品各賣了多少？ --

-- 哪一件商品賣得錢最多(銷售總金額最高)？ --
	SELECT M.text, MAX(SUM) 
	FROM (
		SELECT ip.text, SUM(i.amount * ip.inventory) AS 'SUM'
		FROM Item i INNER JOIN ItemProduct ip ON i.ipid = ip.id 
		GROUP BY 1 -- ORDER BY 2 DESC LIMIT 1; -- 子查詢異常時使用
	) M;
-- 哪一件商品賣得錢最多(銷售總金額最高)？ --

-- 哪一張發票價值最高(發票金額最高)？ --
	SELECT M.invdate, MAX(Total) 
	FROM (
	SELECT i.invdate , SUM(i2.amount * ip.inventory) AS Total
	FROM Invoice i INNER JOIN Item i2 ON i.id =i2.invid 
	               INNER JOIN ItemProduct ip ON i2.ipid = ip.id
	GROUP BY 1
	-- ORDER BY 2 DESC LIMIT 1; -- 子查詢異常時使用
	) M;
-- 哪一張發票價值最高(發票金額最高)？ --





