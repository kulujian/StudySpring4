package com.study.springcore.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component	// 宣告接受管理
@Aspect		// 宣告為 切面程式
@Order(1)	// 數字越小越先執行(預設是 int 的最大值，【21億多...】)
public class MyLoggerAspect {

	// 前置通知
	@Before(value = "execution(* com.study.springcore.aop.CalcImpl.*(..))")
	public void befor(JoinPoint joinPoint) {
		// joinpoint
		System.out.println(joinPoint);
		System.out.printf("%s, %s, %s\n", "前置通知", 
				joinPoint.getSignature().getName(), 
				Arrays.toString(joinPoint.getArgs()));
	}
	
	// 後置通知
//	@After
//	public void after(JoinPoint joinPoint) {
//		
//	}
}
