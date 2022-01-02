package com.study.springcore.aop;

import org.springframework.stereotype.Component;

@Component
public class CalcImpl implements Calc{

	@Override
	public Integer add(Integer x, Integer y) {
		Integer result = x + y;
		return result;
	}

}
