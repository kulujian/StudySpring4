SELECT i2.id, i2.amount, i2.ipid, i2.invid,
	   i.id AS Invoice_id, i.invdate AS Invoice_invdate,
	   ip.id AS ItemProduct_id, ip.text AS ItemProduct_text, ip.price AS ItemProduct_price, ip.inventory AS ItemProduct_inventory
FROM Item i2 LEFT OUTER JOIN Invoice i ON i2.invid = i.id
             LEFT OUTER JOIN ItemProduct ip ON i2.ipid = ip.id ;

SELECT i.id, i.invdate,
       i2.id AS Item_id, i2.amount AS Item_amount, i2.ipid AS Item_ipid, i2.invid AS Item_invid,
	   ip.id AS ItemProduct_id, ip.text AS ItemProduct_text, ip.price AS ItemProduct_price, ip.inventory AS ItemProduct_inventory
FROM Invoice i LEFT OUTER JOIN Item i2 ON i.id = i2.invid
               LEFT OUTER JOIN ItemProduct ip ON i2.ipid = ip.id ;