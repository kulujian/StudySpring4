package com.study.springcore.case01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloTime helloTime = ctx.getBean(HelloTime.class);
		System.out.println(helloTime.sayHi());
		
		HelloTime helloTime2 = ctx.getBean(HelloTime.class);
		System.out.println(helloTime2.sayHi());
	}
}
