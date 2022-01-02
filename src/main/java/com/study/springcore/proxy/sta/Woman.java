package com.study.springcore.proxy.sta;

public class Woman implements Person{

	@Override
	public void work() {
		// 公用邏輯(之前要做的準備)
		//System.out.println("戴口罩");
		// 公用邏輯(例外)
		//System.out.println("若沒有口罩，要去買口罩");
		// 業務邏輯
		System.out.println("去市場買菜");
		// 公用邏輯(之後要做的處理)
		//System.out.println("脫下口罩");
	}

}
