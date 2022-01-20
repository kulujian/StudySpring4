package com.study.springcore.homework.lab01.template;

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
public class ItemInvIdIpidDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Invoice> queryInvoice(){
		String sql = "SELECT i.id, i.invdate,\r\n"
				+ "       i2.id AS Item_id, i2.amount AS Item_amount, i2.ipid AS Item_ipid, i2.invid AS Item_invid,\r\n"
				+ "	   ip.id AS ItemProduct_id, ip.text AS ItemProduct_text, ip.price AS ItemProduct_price, ip.inventory AS ItemProduct_inventory\r\n"
				+ "FROM Invoice i RIGHT OUTER JOIN Item i2 ON i.id = i2.invid\r\n"
				+ "               LEFT OUTER JOIN ItemProduct ip ON i2.ipid = ip.id";

		ResultSetExtractor<List<Invoice>> resultSetExtractor = JdbcTemplateMapperFactory.newInstance()
				.addKeys("id")
				.newResultSetExtractor(Invoice.class);
		
		return jdbcTemplate.query(sql, resultSetExtractor);
	}

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

	public List<ItemProduct> queryItemProduct(){
		String sql = "SELECT i.id, i.invdate,\r\n"
				+ "	   i2.id AS Item_id, i2.amount AS Item_amount, i2.ipid AS Item_ipid, i2.invid AS Item_invid\r\n"
				+ "FROM Invoice i LEFT OUTER JOIN Item i2 ON i.id = i2.invid";

		ResultSetExtractor<List<ItemProduct>> resultSetExtractor = JdbcTemplateMapperFactory.newInstance()
				.addKeys("id")
				.newResultSetExtractor(ItemProduct.class);
		
		return jdbcTemplate.query(sql, resultSetExtractor);
	}
	
	
	
}
