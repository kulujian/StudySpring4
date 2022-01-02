package com.study.springcore.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-config.xml");
		Calc calc = ctx.getBean("calcImpl", Calc.class);
		System.out.println(calc.add(10, 20));
		
		
	}
}
