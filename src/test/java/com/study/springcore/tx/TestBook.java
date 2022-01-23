package com.study.springcore.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.study.springcore.tx.controller.BookController;

public class TestBook {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		BookController bookController = ctx.getBean(BookController.class);
		System.out.println(bookController);
		
		// case 1 買單本
		Integer wid = 1; // 買的數量
		Integer bid = 1; // 買的書號
		bookController.buyBook(wid, bid);
		// case 2 買多本
//		Integer wid = 1; // 買的數量
//		bookController.buyBooks(wid,1,1,2,2,2);

		((ConfigurableApplicationContext) ctx).close(); // 關閉ApplicationContext用，需要import) 放在最後
	}
}
