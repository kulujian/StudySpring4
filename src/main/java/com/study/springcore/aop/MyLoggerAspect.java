package com.study.springcore.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	@Pointcut(value = "execution(* com.study.springcore.aop.CalcImpl.add(..))")
	public void pt() {}
	
	// PointCut 切入點，用來定義 Joinpoint 連接點
	@Pointcut(value = "execution(* com.study.springcore.aop.CalcImpl.div(..))")
	public void pt2() {}
		
	
//	// 前置通知：運行在目標方法執行之前，所以與例外發生沒有關係
//	@Before(value = "pt()") // 軔入點表達式支援： &&、||、! ， 例如："pt() && !pt2()"
//	public void befor(JoinPoint joinPoint) {
//		// joinpoint
//		System.out.println(joinPoint);
//		System.out.printf("%s, %s, %s\n", 
//				"前置通知", 
//				joinPoint.getSignature().getName(), 
//				Arrays.toString(joinPoint.getArgs()));
//	}
//	
//	// 後置通知：無論目標方法是否有例外發生都會執行(會放在【finally】中)
//	@After(value = "pt2()")
//	public void after(JoinPoint joinPoint) {
//		System.out.println("後置通知...");
//	}
//	
//	// 返回通知：可以在切面程式中得到目標方法的回傳值
//	@AfterReturning(value = "pt2()", returning = "result")
//	public void afterReturning (Object result) {
//		System.out.println("返回通知 - result = " + result);
//	}
//	
//	//  在金融業內(檢核、風控、條規)常用，很重要。
//	//	理論上在寫程式之前就應該先做好，但是這些東西難保未來不會改變、新增
//	//	因此AOP的出現就給這樣的管控有了更多的空間做修改或是 filter
//	
//	// 異常通知：可以知道目標方法所發生的錯誤為何
//	@AfterThrowing(value = "pt2()", throwing = "ex")
//	public void afterThorwing(Exception ex) {
//		System.out.println("異常通知 - ex = " + ex);
//	}
	
	// 環繞通知
	@Around(value = "pt2() || pt()")
	public Object around(ProceedingJoinPoint joinPoint) {
		Object result = null;
		// 1. 前置通知
		System.out.println("環繞通知：前置通知");
		try {
			// 2. 執行業務邏輯方法
			result = joinPoint.proceed(); 
			// 3. 返回通知
			System.out.println("環繞通知：返回通知 result = " + result);
		} catch (Throwable ex) {
			// 4. 異常通知
			System.out.println("環繞通知：異常通知 e = " + ex);
		} finally {
			// 5. 後置通知
			System.out.println("環繞通知：後置知知");
		}
		return result;
	}
	
}
