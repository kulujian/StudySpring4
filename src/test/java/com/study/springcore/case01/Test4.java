package com.study.springcore.case01;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		CPU cpu3 = ctx.getBean("cpu3", CPU.class);
		CPU cpu4 = ctx.getBean("cpu4", CPU.class);
		CPU cpu5 = ctx.getBean("cpu5", CPU.class);
		CPU cpu6 = ctx.getBean("cpu6", CPU.class);
		
		RAM ram1 = ctx.getBean("ram1", RAM.class);
		RAM ram2 = ctx.getBean("ram2", RAM.class);
		RAM ram3 = ctx.getBean("ram3", RAM.class);
		RAM ram4 = ctx.getBean("ram4", RAM.class);
		
		HD hd1 = ctx.getBean("hd1", HD.class);
		HD hd2 = ctx.getBean("hd2", HD.class);
		HD hd3 = ctx.getBean("hd3", HD.class);
		
		// DIY 自組電腦
		Computer computer = ctx.getBean("computer", Computer.class);
		computer.setCpu(cpu6);
		computer.setRam(ram4);
		computer.setHd(hd3);
		System.out.println(computer);
		// 品牌電腦
		Computer acer = ctx.getBean("acer", Computer.class);
		System.out.println(acer);
		Computer ibm = ctx.getBean("ibm", Computer.class);
		System.out.println(ibm);
		
		// 電腦陣列
		Computer[] computers = {computer, acer, ibm};
		// 求總價 Java 7 (程式工程師「教」電腦如何進行資料加總)
		double total = 0;
		for(Computer c: computers) {
			total += c.getPrice();
		}
		System.out.println(total);
		
		// 求總價, 限用 Java 8 lambda/stream 語法 (程式工程師「命令」電腦進行資料加總)
		total = Arrays.stream(computers).mapToDouble(Computer::getPrice).sum();
		System.out.println(total);
		
	}
}
