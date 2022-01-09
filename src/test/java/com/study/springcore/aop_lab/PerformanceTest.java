package com.study.springcore.aop_lab;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PerformanceTest {

	public static void main(String[] args) {
		// Java 配置
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AOPConfig.class);
//		Performance performance = ctx.getBean("dancer", Performance.class);
//		try {
//			performance.perform();
//		} catch (Exception e) {
//			System.out.println(e);
//			// 轉換跑道
//			// 舞者去當歌者
//			System.out.println("舞者改行去當歌者");
//			Singer  singer = (Singer)performance;
//			singer.sing();
//		}
		
		// 舞者去表演脫口秀 (請同學自行撰寫)
		
		Performance performance1 = ctx.getBean("dancer", Performance.class);
		try {
			performance1.perform();
		} catch (Exception e) {
			System.out.println(e);
			// 轉換跑道
			// 舞者去當歌者
			System.out.println("舞者去表演脫口秀");
			Actor  actor = (Actor)performance1;
			actor.show();
		}
		

	}

}