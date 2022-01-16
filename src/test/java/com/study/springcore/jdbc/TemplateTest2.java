package com.study.springcore.jdbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.jdbc.entity.Emp;
import com.study.springcore.jdbc.template.EmpDao;

public class TemplateTest2 {
	
		public static void main(String[] args) {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
			EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
			int rowcount = 0;
			int[] rowcounts = null;
//			System.out.println(empDao.queryListEmps());

			// 測試單筆新增1		
//			System.out.println(empDao.queryListEmps());
			// 測試單筆新增2			
//			rowcount = empDao.addOne2("test2", 19);
//			System.out.println("測試單筆新2: " + rowcount);
			//測試多筆新增 1
//			List<Object[]> rows = new ArrayList<>();
//			rows.add(new Object[] {"jo", 20});
//			rows.add(new Object[] {"Mark", 21});
//			rows.add(new Object[] {"Vincent", 22});
//			rowcounts = empDao.multiAdd(rows);
//			System.out.println("測試多筆新增 1: " + Arrays.toString(rowcounts));
			
			// 測試多筆新增 2
//			List<Emp> emps = new ArrayList<Emp>();
//			emps.add( new Emp("Bobo2", 25));
//			emps.add( new Emp("Bob", 26));
//			emps.add( new Emp("Alice", 27));
//			rowcounts = empDao.mulitAdd2(emps);
//			System.out.println("測試多筆新增2: "+ rowcount);
//			
			// 測試修改
//			rowcount = empDao.updateByid(1, "TTom", 34);
//			System.out.println("測試修改: "+ rowcount);
			// 測試刪除
//			rowcount = empDao.deleteById(3);
//			System.out.println("測試刪除: "+ rowcount);
						
	}
}
