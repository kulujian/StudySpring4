SELECT M.id, M.invdate, MAX(Total) AS ItemProduct_price
FROM (
	SELECT i.id, i.invdate , SUM(i2.amount * ip.price) AS Total
	FROM Invoice i INNER JOIN Item i2 ON i.id =i2.invid 
	               INNER JOIN ItemProduct ip ON i2.ipid = ip.id
	GROUP BY 1
-- ORDER BY 2 DESC LIMIT 1; -- 子查詢異常時使用
) M;