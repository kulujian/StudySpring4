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
import org.springframework.stereotype.Repository;

import com.study.springcore.jdbc.entity.Emp;

@Repository
public class EmpDao_homework {

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
	
	public String searchNameById(String Id) {
		try {
			String ename = queryAll().stream()
					.filter(e->(e.get("eid")+"").equals(Id))	//Map取得資料要使用get()。Map是Object要轉字串
					.findFirst()
					.get()		// 取得所有資料(eid、ename、age、createtime)之後還是 Map(Object)
					.get("ename")+"";	// Map取得資料要使用get()。取得後要在轉成字串，才會正常顯示
			return ename;
		} catch (Exception e2) {
			return "undefine";
		}
	}
	
	// 多筆查詢 2
	public List<Emp> queryListEmps(){
		String sql = "select eid, ename, age, createtime from Emp";
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
	
	// HomeWork
		// 單筆新增 1
		public int addLog(String method_name) {
			String sql = "insert into log(method_name) values(?)";
			int rowcount = jdbcTemplate.update(sql, method_name);
			return rowcount;
		}
		// 多筆查詢 1
		public List<Map<String, Object>> showLog(){
			
			String sql = "select * from log";
			List<Map<String, Object>> logs = jdbcTemplate.queryForList(sql);
			return logs;
		}
	// HomeWork
	
	// 多筆新增 1
	public int[] multiAdd(List<Object[]> rows) {
		String sql = "insert into emp(ename, age) value(?, ?)";
		return jdbcTemplate.batchUpdate(sql, rows);
	}
	
	// 多筆新增 2
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
}
