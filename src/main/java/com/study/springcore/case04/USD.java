package com.study.springcore.case04;

public class USD extends CurrencyImpl {
	
	public void init() {
		System.out.println("USD init()");
	}
	
	@Override
	public double getValue() {
		return value;
	}

	@Override
	public void setValue(double value) {
		this.value = value;
	}
	
	public void destroy() {
		System.out.println("USD destroy()");
	}
	
}
