package com.study.springcore.jdbc.template;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.study.springcore.jdbc.entity.Emp;

@Repository
public class EmpDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	// 多筆查詢 1
	public List<Map<String, Object>> queryAll(){
		
		String sql = "select eid, ename, age, createtime from emp";
		List<Map<String, Object>> emps = jdbcTemplate.queryForList(sql);
		return emps;
	}
	
	
	// 多筆查詢 2
	public List<Emp> queryListEmps(){
		String sql = "select eid, ename, age, createtime from emp";
		List<Emp> emps = jdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {
			Emp emp = new Emp();
			emp.setEid(rs.getInt("eid"));
			emp.setEname(rs.getString("ename"));
			emp.setAge(rs.getInt("age"));
			emp.setCreatetime(rs.getTimestamp("createtime"));
			return emp;
		});
		return emps;
	}
	
	// 多筆查詢 3
	public List<Emp> qreryListEmps2(){
		String sql = "select eid, ename, age, createtime from emp";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Emp.class));
	}
	
	// 單筆新增 1
	public int addOne1(String ename, Integer age) {
		String sql = "insert into emp(ename, age) values(?, ?)";
		int rowcount = jdbcTemplate.update(sql, ename, age);
		return rowcount;
	}
	// 單筆新增 2
	public int addOne2(String ename, Integer age) {
		String sql = "insert into emp(ename, age) values (:ename, :age)";
		MapSqlParameterSource params = new MapSqlParameterSource()
				.addValue("ename", ename)
				.addValue("age", age);
		int rowcount = namedParameterJdbcTemplate.update(sql, params);
		return rowcount;
	}
	
	
	// 多筆新增 1 (使用 Object 陣列)
	public int[] multiAdd(List<Object[]> rows) {
		String sql = "insert into emp(ename, age) value(?, ?)";
		return jdbcTemplate.batchUpdate(sql, rows);
	}
	
	// 多筆新增 2 (使用 Emp class)
	public int[] mulitAdd2(List<Emp> emps) {
		String sql = "insert into emp(ename, age) value(?, ?)";
		BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				// i = emps 的 index
				ps.setString(1, emps.get(i).getEname());
				ps.setInt(2, emps.get(i).getAge());
			}
			@Override
			public int getBatchSize() {
				return emps.size();
			}
		};
		return jdbcTemplate.batchUpdate(sql, setter);
	}
	
	// 修改
	public int updateByid(Integer eid, String ename, Integer age) {
		String sql = "update emp set ename=?, age=? where eid=?";
		return jdbcTemplate.update(sql,ename, age, eid);
	}
	
	// 刪除
	public int deleteById(Integer eid) {
		String sql = "delete from emp where eid=?";
		return jdbcTemplate.update(sql, eid);
	}
	

	
	// 單筆新增 1(不用SpringTemplate , JAVA手動設定交易管理版)
	
	@Autowired
	private ComboPooledDataSource datasource; // 在jdbc配置檔內確認 datasource是誰
	
	public int addOne1TX(String ename, Integer age) throws Exception{
		// 建立 TransactionManager，DataSorceTransactionManager(datasource)←datasource是被管理的對象
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(datasource);
		// 定義 TransactionDefinition，設定傳播模式
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus status =  transactionManager.getTransaction(def);
		
		int rowcount = 0;
		try {
			String sql = "insert into emp(ename, age) values(?, ?)";
			rowcount = jdbcTemplate.update(sql, ename, age);
//			System.out.println(10/0);	// 模擬發生錯誤，就不會發生交易
		} catch (Exception e) {
			transactionManager.rollback(status);
			throw e;
		}
		transactionManager.commit(status);
		return rowcount;
		
	}
	
}
