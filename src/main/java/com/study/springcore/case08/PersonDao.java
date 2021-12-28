package com.study.springcore.case08;

import java.util.List;

public interface PersonDao {
	// 建立 Person 資料
	public boolean create(Person person);
	// 取得 Person 全部資料
	public List<Person> readAll();
	
	public boolean update(Person person);

	public boolean delete(Person person);
}
