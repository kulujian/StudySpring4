package com.study.springcore.proxy.cglib;

/* 沒有使用 interface 也沒有 cglib 使用的老方法
 */

// Enhancer 增強型的 Customer
public class EnhancerCustomer extends Customer{

	@Override
	public String buy(String data) {
		return super.buy(data) + " 請先出示實聯";
	}
}
