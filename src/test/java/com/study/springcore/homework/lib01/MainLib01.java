package com.study.springcore.homework.lib01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.homework.lab01.template.ItemInvIdIpidDao;

public class MainLib01 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		ItemInvIdIpidDao itemInvIdIpidDao = ctx.getBean("itemInvIdIpidDao", ItemInvIdIpidDao.class);

//		itemInvIdIpidDao.queryInvoice().forEach(System.out::println);
		System.out.println("");
		itemInvIdIpidDao.queryItem().forEach(System.out::println);
		System.out.println("");
//		itemInvIdIpidDao.queryItemProduct().forEach(System.out::println);
	}

}
