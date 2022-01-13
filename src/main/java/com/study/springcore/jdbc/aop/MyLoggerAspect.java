package com.study.springcore.jdbc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component	// 宣告接受管理
@Aspect		// 宣告為 切面程式
@Order(1)	// 數字越小越先執行(預設是 int 的最大值，【21億多...】)
public class MyLoggerAspect {

	// PointCut 切入點，用來定義 Joinpoint 連接點
	@Pointcut(value = "execution(* com.study.springcore.jdbc.template.EmpDao.queryAll(..))")
	public void pt() {}


	// 前置通知：運行在目標方法執行之前，所以與例外發生沒有關係
	@Before(value = "pt()") // 軔入點表達式支援： &&、||、! ， 例如："pt() && !pt2()"
	public void befor(JoinPoint joinPoint) {
		// joinpoint
//		System.out.println(joinPoint);
		System.out.println("測試看看，是否成功");
	}

	// 返回通知：可以在切面程式中得到目標方法的回傳值
	@AfterReturning(value = "pt()", returning = "result")
	public void afterReturning (Object result) {
		System.out.println("返回通知 - result = " + result);
	}
}
