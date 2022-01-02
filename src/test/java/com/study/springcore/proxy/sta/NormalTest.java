package com.study.springcore.proxy.sta;

public class NormalTest {

	public static void main(String[] args) {
		// 不透過代理直接執行
		Person man = new Man();
		Person woman = new Woman();
		
		man.work();
		woman.work();
	}

}
