package com.study.springcore.proxy.sta;

public class ProxyTest {
	
	//實現靜態代理模代
	public static void main(String[] args) {
		
		Person man = new PersonProxy(new Man());
		Person woman = new PersonProxy(new Woman());
		

		// 代理調用 person 的 work() 方法
		man.work();
		woman.work();
		
	}
}
