package com.study.springcore.proxy.sta;

// 靜態代理
public class PersonProxy implements Person{
	
	// 被代理物件
	private Person person;
	
	public PersonProxy(Person person) {
		this.person = person;
	}
	
	@Override
	public void work() {
		// 公用邏輯前 - 前
		System.out.println("戴上口罩");
		try {
			// 代理調用 person 的 work() 方法
			person.work();
		} catch (Exception e) {
			// 公用邏輯 -例外發生
			System.err.println("若沒口罩，要去買口罩");
			System.err.println("戴上口罩");
		}
		
		// 公用邏輯 - 後
		System.out.println("脫下口罩");
		
	}

}
