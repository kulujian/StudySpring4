package com.study.springcore.jdbc;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.jdbc.template.EmpDao;

public class TemplateTest1 {
	
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
//		System.out.println(empDao.queryAll());
		
		// 如何取得 eid=2 的員工姓名？ (請使用 java 8 stream)
//		String ename = empDao.queryAll().stream()
//				.filter(e->(e.get("eid")+"").equals("2"))	//Map取得資料要使用get()。Map是Object要轉字串
//				.findFirst()
//				.get()		// 取得所有資料(eid、ename、age、createtime)之後還是 Map(Object)
//				.get("ename")+"";	// Map取得資料要使用get()。取得後要在轉成字串，才會正常顯示
//		System.out.println(ename);
		
		/*
		 *  HomeWork 利用 AOP 
		 *  在每次的 查詢中 都可以將查詢時間的 Log 記錄下來
		 *  +
		*/
		
//		 多筆查詢 1
		empDao.queryListEmps().forEach(System.out::println);
//		 多筆查詢 2
//		System.out.println(empDao.qreryListEmps2());
	}
}
