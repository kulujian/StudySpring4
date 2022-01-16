package com.study.springcore.jdbc;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.jdbc.template.EmpDao;

public class TemplateTest1 {
	private ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
	private EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
	private boolean stop;
	
	
	// 又來一個選單
//	private void menu() {
//		System.out.println("=========================================");
//		System.out.println("1. 取得 Emp 全部資料");
//		System.out.println("2. 根據 eid 取得 Emp.ename");
//		System.out.println("3. 根據姓名來刪除Person");
//		System.out.println("0. 離開");
//		System.out.println("=========================================");
//		System.out.print("請選擇: ");
//		
//		Scanner sc = new Scanner(System.in);
//		int choice = sc.nextInt();
//		switch (choice) {
//			case 1:
//				printEmp();
//				break;
//			case 2:
//				searchPersonByName();
//				break;	
//			case 3:
////				searchPersonByName();
//				break;
//			case 0:
//				System.out.println("離開系統");
//				stop = true;
//				break;
//		}
//	}
	// 1. 取得 Person 全部資料
//	private void printEmp() {
//		empDao.queryAll();
//	}
	// 3. 根據姓名取得 Person
//	private void searchPersonByName() {
//		System.out.print("請輸入Eid: ");
//		// Ex: 1,2
//		Scanner sc = new Scanner(System.in);
//		String eid = sc.next();
//		empDao.searchNameById(eid);
//	}
	
//	public void start() {
//		while (!stop) {
//			menu();
//		}
//	}
//	
	
	
	
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
//		new TemplateTest1().start();
		
		
		System.out.println(empDao.queryListEmps());
		System.out.println(empDao.qreryListEmps2());
	}
}
