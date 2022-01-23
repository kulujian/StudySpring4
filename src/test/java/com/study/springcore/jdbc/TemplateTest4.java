package com.study.springcore.jdbc;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.jdbc.template.EmpDao;
import com.study.springcore.jdbc.template.EmpJobDao;

public class TemplateTest4 {
	
		public static void main(String[] args) {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
			EmpDao empDao = ctx.getBean("empDao", EmpDao.class);


			empDao.addOne1TX("Tetx2", 20);
			System.out.println("addoneTX OK !");

		}
}
			
