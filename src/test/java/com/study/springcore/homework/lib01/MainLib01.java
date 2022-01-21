package com.study.springcore.homework.lib01;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.homework.lab01.controllers.ItemInvidIpidController;
import com.study.springcore.homework.lab01.entity.Invoice;
import com.study.springcore.homework.lab01.entity.Item;
import com.study.springcore.homework.lab01.entity.ItemProduct;
import com.study.springcore.homework.lab01.template.ItemInvidIpidDao;

public class MainLib01 {
	private ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
	private ItemInvidIpidController itemInvidIpidController = ctx.getBean("itemInvidIpidController", ItemInvidIpidController.class);
	private boolean stop;
	public void menu() {
		itemInvidIpidController.showAllStream();
		stop = true;
	}
	
	public void start() {
		while (!stop) {
			menu();
		}
	}
	
	public static void main(String[] args) {
		
		new MainLib01().start();
		
		
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
//		ItemInvidIpidController itemInvidIpidController = ctx.getBean("itemInvidIpidController", ItemInvidIpidController.class);

//		itemInvIdIpidDao.queryInvoice().forEach(System.out::println);
				
//		itemInvIdIpidDao.queryItem().forEach(System.out::println);
		
		/* 回家作業 start
			System.out.println("每一張發票有哪些商品?");
			itemInvIdIpidDao.getProductByInvoice().forEach(System.out::println);
			System.out.println("==========================================================");
			System.out.println("==========================================================");
			System.out.println("每一張發票有幾件商品?");
			itemInvIdIpidDao.getAmountByInvoice().forEach(System.out::println);
			System.out.println("");
			System.out.println("每一張發票價值多少?");
			itemInvIdIpidDao.getPriceByInvoice().forEach(System.out::println);
			System.out.println("");
			System.out.println("每一樣商品各賣了多少數量？");
			itemInvIdIpidDao.getAmountByText().forEach(System.out::println);
			System.out.println("");
			System.out.println("哪一件商品賣得錢最多(銷售總金額最高)？");
			itemInvIdIpidDao.getMaxPriceByText().forEach(System.out::println);
			System.out.println("");
			System.out.println("哪一張發票價值最高(發票金額最高)？");
			itemInvIdIpidDao.getMaxPriceByInvoice().forEach(System.out::println);
//		*/// 回家作業 end
		
	}

}
