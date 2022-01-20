package com.study.springcore.jdbc;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.jdbc.template.EmpJobDao;

public class TemplateTest3 {
	
		public static void main(String[] args) {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
			EmpJobDao empJobDao = ctx.getBean("empJobDao", EmpJobDao.class);
			
//			empJobDao.queryEmps().forEach(System.out::println);
			System.out.println();
//			empJobDao.queryJobs2().forEach(System.out::println);
			System.out.println();
			empJobDao.queryEmps2().forEach(System.out::println);

		}
}
			
