package com.study.springcore.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

public class CglibTest {
	
	public static void main(String[] args) {
		
		// 1. 建立 cglib 的增強類 + 配置設定
		Enhancer enchancer = new Enhancer();
		 //   1.1 被增強的目標類
		 enchancer.setSuperclass(Customer.class);
		 //   1.2 實現攔截方法(簽章)
		 enchancer.setCallback(new MyMethodInterceptor());
				
		// 2. 通過 cblib 的增強類立目標實體
		Customer customer = (Customer)enchancer.create();
		System.out.println(customer.buy("麵包"));
	}
}
