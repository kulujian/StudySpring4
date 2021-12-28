package com.study.springcore.case02;

public class LifeCycle {
	public LifeCycle() {
		System.out.println("LifeCycle() 建構子: 檔案開啟前的預備作業, fileName=? path=?");
	}
	
	public void init() {
		System.out.println("init() 初始方法: 檔案開啟");
	}
	
	public void service() {
		System.out.println("service() 商業邏輯方法: 檔案內容讀取");
		System.out.println("service() 商業邏輯方法: 檔案內容分析");
		System.out.println("service() 商業邏輯方法: 檔案內容決策....");
		System.out.println("service() 商業邏輯方法: 寫入檔案...");
	}
	
	public void destroy() {
		System.out.println("destroy() 銷毀方法: 關閉檔案");
	}
}
