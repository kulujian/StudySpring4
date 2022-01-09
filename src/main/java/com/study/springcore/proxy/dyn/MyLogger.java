package com.study.springcore.proxy.dyn;

import java.util.Arrays;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// Aspect 切面程式
@Component
@Aspect
@Order(1)  // 數字越小越先執行 (預設是 Int 最大值)
public class MyLogger {

	// 前置通知 哪一個類，哪一個方法，哪個通知
	public static void befor(Class cls, String methodName, Object[] args) {
		System.out.printf("前置通知： %s %s %s \n", cls, methodName, Arrays.toString(args));
	}
	// 異常通知 哪一個類，哪一個方法，哪個異常
	public static void throwing(Class cls, String methodName, Exception e) {
		System.out.printf("異常通知： %s %s %s \n", cls, methodName, e);
		// 查詢更細部的錯誤原因
		e.printStackTrace(System.err);
	}
	// 後置通知 哪一個類，哪一個方法，哪個結果
	public static void end(Class cls, String methodName, Object result) {
		System.out.printf("後置通知： %s %s %s \n", cls, methodName, result);
		
	}
}
