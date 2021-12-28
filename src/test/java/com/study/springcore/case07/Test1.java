package com.study.springcore.case07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext7.xml");
		User user = ctx.getBean("user", User.class);
		System.out.println(user);
	}
}
