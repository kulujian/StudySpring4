package com.study.springcore.aop;

import org.springframework.stereotype.Component;

@Component
public class CalcImpl implements Calc{

	@Override
	public Integer add(Integer x, Integer y) {
		System.out.println("執行add方法");
		Integer result = x + y;
		// IF發生一個例外
		return result;
	}

	@Override
	public Integer div(Integer x, Integer y) {
		System.out.println("執行div方法");
		Integer result = x / y;
		// IF發生一個例外
		return result;
	}

}
