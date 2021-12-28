package com.study.springcore.case03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext3.xml");
		
		Product product = ctx.getBean("product", Product.class);
		product.setPrice(150.0);
		System.out.println(product);
		
		Product product2 = ctx.getBean("product2", Product.class);
		product2.setPrice(150.0);
		System.out.println(product2);
	}
}
