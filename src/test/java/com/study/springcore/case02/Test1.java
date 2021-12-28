package com.study.springcore.case02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
		LifeCycle lifeCycle = ctx.getBean("lifeCycle", LifeCycle.class);
		lifeCycle.service();
		
		((ClassPathXmlApplicationContext)ctx).close();
		
	}
}
