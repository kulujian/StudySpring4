package com.study.springcore.proxy.dyn;

import com.study.springcore.proxy.sta.Man;
import com.study.springcore.proxy.sta.Person;
import com.study.springcore.proxy.sta.Woman;


// 實現動態代理模式 (DynProxy)
public class DynProxyTest1 {

	public static void main(String[] args) {
		// 拿【範例一】已有靜態代理(PersonProxy)做測試，是否也能夠動態代理
		Person woman = (Person)new DynProxy(new Woman()).getProxy();
//		Person man = (Person)new DynProxy(new Man()).getProxy();
// 		自行可以維護錯誤
//		try {
//			// 代理調用 person 的 work() 方法
//			man.work();
//		} catch (Exception e) {
//			// 公用邏輯 -例外發生
//			System.err.println("若沒口罩，要去買口罩");
//			System.err.println("戴上口罩");
//		}
		
		woman.work();
		
		// 【範列二】
		Calc calc = (Calc)new DynProxy(new CalcImpl()).getProxy();
		// 代理調用 Calc 的 add() 方法		
		System.out.println(calc.add(10, 20));
	}

}
