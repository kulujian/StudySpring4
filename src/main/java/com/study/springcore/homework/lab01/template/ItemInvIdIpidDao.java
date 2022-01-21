package com.study.springcore.homework.lab01.template;

import java.util.Iterator;
import java.util.List;

import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.study.springcore.homework.lab01.entity.Invoice;
import com.study.springcore.homework.lab01.entity.Item;
import com.study.springcore.homework.lab01.entity.ItemProduct;

@Repository
public class ItemInvidIpidDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

//	/* 測試- 失敗 (推測：因為invoice 沒有與 itemproduct 有關聯key
	//ERROR CODE :Could not find Getter for ColumnKey [columnName=ItemProduct_id, columnIndex=7, sqlType=4] 
	public List<Invoice> queryInvoice(){
		String sql = "SELECT i.id, i.invdate,\r\n"
				+ "          i2.id AS Item_id, i2.amount AS Item_amount,\r\n"
				+ "          i2.ipid AS Item_ipid, i2.invid AS Item_invid,\r\n"
				+ "          ip.id AS ItemProduct_id, ip.text AS ItemProduct_text,\r\n"
				+ "          ip.price AS ItemProduct_price, ip.inventory AS ItemProduct_inventory\r\n"
				+ "FROM Invoice i LEFT OUTER JOIN Item i2 ON i.id = i2.invid\r\n"
				+ "               LEFT OUTER JOIN ItemProduct ip ON i2.ipid = ip.id";

		ResultSetExtractor<List<Invoice>> resultSetExtractor = JdbcTemplateMapperFactory.newInstance()
				.addKeys("id")
				.newResultSetExtractor(Invoice.class);
		
		return jdbcTemplate.query(sql, resultSetExtractor);
	}
//	*/
	
	public List<Item> queryItem(){
		String sql = "SELECT i2.id, i2.amount, i2.ipid, i2.invid,\r\n"
				+ "	   i.id AS Invoice_id, i.invdate AS Invoice_invdate,\r\n"
				+ "	   ip.id AS ItemProduct_id, ip.text AS ItemProduct_text, ip.price AS ItemProduct_price, ip.inventory AS ItemProduct_inventory\r\n"
				+ "FROM Item i2 LEFT OUTER JOIN Invoice i ON i2.invid = i.id\r\n"
				+ "             LEFT OUTER JOIN ItemProduct ip ON i2.ipid = ip.id";

		ResultSetExtractor<List<Item>> resultSetExtractor = JdbcTemplateMapperFactory.newInstance()
				.addKeys("id")
				.newResultSetExtractor(Item.class);
		
		return jdbcTemplate.query(sql, resultSetExtractor);
	}
	
	/*未測試
	public List<ItemProduct> queryItemProduct(){
		String sql = "SELECT i.id, i.invdate,\r\n"
				+ "	   i2.id AS Item_id, i2.amount AS Item_amount, i2.ipid AS Item_ipid, i2.invid AS Item_invid\r\n"
				+ "FROM Invoice i LEFT OUTER JOIN Item i2 ON i.id = i2.invid";

		ResultSetExtractor<List<ItemProduct>> resultSetExtractor = JdbcTemplateMapperFactory.newInstance()
				.addKeys("id")
				.newResultSetExtractor(ItemProduct.class);
		
		return jdbcTemplate.query(sql, resultSetExtractor);
	}
//	*/
	
	// 每一張發票有哪些商品?
	public List<Item> getProductByInvoice(){
		String sql = "SELECT i2.invid, i.invdate AS Invoice_invdate, ip.`text` AS 'ItemProduct_text'\r\n"
				+ "	FROM Invoice i INNER JOIN Item i2 ON i.id = i2.invid \r\n"
				+ "	               INNER JOIN ItemProduct ip ON i2.ipid = ip.id";

		ResultSetExtractor<List<Item>> resultSetExtractor = JdbcTemplateMapperFactory.newInstance()
				.addKeys("id")
				.newResultSetExtractor(Item.class);
		Iterator<Item> iter = jdbcTemplate.query(sql, resultSetExtractor).iterator();
		
		 while(iter.hasNext()){
			 Item str =  iter.next();
			 System.out.println(str.getItemProduct());
		 }
		return jdbcTemplate.query(sql, resultSetExtractor);
	}
	// 每一張發票有幾件商品?
	public List<Item> getAmountByInvoice(){
		String sql = "SELECT i2.invid, i.invdate AS Invoice_invdate, SUM(i2.amount) AS amount \r\n"
				+ "	FROM Invoice i INNER JOIN Item i2 ON i.id = i2.invid\r\n"
				+ "	GROUP BY 1";

		ResultSetExtractor<List<Item>> resultSetExtractor = JdbcTemplateMapperFactory.newInstance()
				.addKeys("id")
				.newResultSetExtractor(Item.class);
		
		return jdbcTemplate.query(sql, resultSetExtractor);
	}
	// 每一張發票價值多少?
	public List<Item> getPriceByInvoice(){
		String sql = "SELECT i2.invid, i.invdate AS Invoice_invdate, SUM(i2.amount * ip.price) AS ItemProduct_price\r\n"
				+ "	FROM Invoice i INNER JOIN Item i2 ON i.id =i2.invid \r\n"
				+ "	               INNER JOIN ItemProduct ip ON i2.ipid = ip.id \r\n"
				+ "	GROUP BY 1";

		ResultSetExtractor<List<Item>> resultSetExtractor = JdbcTemplateMapperFactory.newInstance()
				.addKeys("id")
				.newResultSetExtractor(Item.class);
		
		return jdbcTemplate.query(sql, resultSetExtractor);
	}
	// 每一樣商品各賣了多少數量？
	public List<Item> getAmountByText(){
		String sql = "SELECT ip.`text` AS ItemProduct_text, SUM(i.amount) AS amount\r\n"
				+ "	FROM Item i INNER JOIN ItemProduct ip ON i.ipid = ip.id \r\n"
				+ "	GROUP BY 1";

		ResultSetExtractor<List<Item>> resultSetExtractor = JdbcTemplateMapperFactory.newInstance()
				.addKeys("id")
				.newResultSetExtractor(Item.class);
		
		return jdbcTemplate.query(sql, resultSetExtractor);
	}
	// 哪一件商品賣得錢最多(銷售總金額最高)？
	public List<Item> getMaxPriceByText(){
		String sql = "SELECT M.text AS ItemProduct_text, MAX(SUM) AS ItemProduct_price\r\n"
				+ "	FROM (\r\n"
				+ "		SELECT ip.text, SUM(i.amount * ip.price) AS 'SUM'\r\n"
				+ "		FROM Item i INNER JOIN ItemProduct ip ON i.ipid = ip.id \r\n"
				+ "		GROUP BY 1 -- ORDER BY 2 DESC LIMIT 1; -- 子查詢異常時使用\r\n"
				+ "	) M";

		ResultSetExtractor<List<Item>> resultSetExtractor = JdbcTemplateMapperFactory.newInstance()
				.addKeys("id")
				.newResultSetExtractor(Item.class);
		
		return jdbcTemplate.query(sql, resultSetExtractor);
	}
	// 哪一張發票價值最高(發票金額最高)？
	public List<Item> getMaxPriceByInvoice(){
		String sql = "SELECT M.invid, M.invdate AS Invoice_invdate, MAX(Total) AS ItemProduct_price\r\n"
				+ "	FROM (\r\n"
				+ "	SELECT i2.invid, i.invdate , SUM(i2.amount * ip.price) AS Total\r\n"
				+ "	FROM Invoice i INNER JOIN Item i2 ON i.id =i2.invid \r\n"
				+ "	               INNER JOIN ItemProduct ip ON i2.ipid = ip.id\r\n"
				+ "	GROUP BY 1\r\n"
				+ "	-- ORDER BY 2 DESC LIMIT 1; -- 子查詢異常時使用\r\n"
				+ "	) M";

		ResultSetExtractor<List<Item>> resultSetExtractor = JdbcTemplateMapperFactory.newInstance()
				.addKeys("id")
				.newResultSetExtractor(Item.class);
		
		return jdbcTemplate.query(sql, resultSetExtractor);
	}
}
