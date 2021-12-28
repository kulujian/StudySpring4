package com.study.springcore.case06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext6.xml");
		RoundBean roundBean = ctx.getBean("roundBean", RoundBean.class);
		System.out.println(roundBean.getRoundArea());
	}
}
