package com.study.springcore.proxy.dyn;

import com.study.springcore.proxy.sta.Man;
import com.study.springcore.proxy.sta.Person;
import com.study.springcore.proxy.sta.Woman;


// 實現動態代理模式 (DynProxy)
public class DynProxyTest2 {

	public static void main(String[] args) {
		// 【範列二】
		Calc calc = (Calc)new DynProxy(new CalcImpl()).getProxy();
		// 代理調用 Calc 的 add() 方法		
		System.out.println(calc.add(10, 20));
		System.out.println("------------------------------------");
		

		Calc calc2 = (Calc)new DynProxy(new CalcImpl()).getProxy();
		// 代理調用 Calc2 的 add() 方法		
		// 自行可以維護錯誤
		System.out.println(calc.div(10, 0));
	}

}
