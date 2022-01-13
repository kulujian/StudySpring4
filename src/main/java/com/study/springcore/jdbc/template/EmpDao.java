package com.study.springcore.jdbc.template;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 多筆查詢
	public List<Map<String, Object>> queryAll(){
		
		String sql = "select eid, ename, age, createtime from Emp";
		List<Map<String, Object>> emps = jdbcTemplate.queryForList(sql);
		return emps;
	}
	
	public void searchNameById(String Id) {
		String ename = queryAll().stream()
				.filter(e->(e.get("eid")+"").equals(Id))	//Map取得資料要使用get()。Map是Object要轉字串
				.findFirst()
				.get()		// 取得所有資料(eid、ename、age、createtime)之後還是 Map(Object)
				.get("ename")+"";	// Map取得資料要使用get()。取得後要在轉成字串，才會正常顯示
		System.out.println(ename);
	}
	
}
