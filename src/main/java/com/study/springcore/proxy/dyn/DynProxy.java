package com.study.springcore.proxy.dyn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

// 動態代理 模式
public class DynProxy {
	
	// 被代理物件
	private Object obj; 
	
	public DynProxy(Object object) {
		this.obj = object;
	}
	
	// 取得代理物件 (JDK)
	public Object getProxy() {
		// 1. 類別載入器
		ClassLoader loader = obj.getClass().getClassLoader();		
		// 2. 目標所實作的介面
		Class[] interfaces = obj.getClass().getInterfaces();
		/* 3. 處理代理的實現 (InvocationHandler)
		 * 	  後面為Lambdas寫法，()內為 InvocationHandler方法標籤
		 **/
		InvocationHandler handler = (Object proxy, Method method, Object[] args) -> {
			Object result = null;
			// 前置通知
			//System.out.println("前置通知：寫入 Log : " + Arrays.toString(args));
			MyLogger.befor(obj.getClass(), method.getName(), args);
			try {
				// 代理調用被代理物件(目標)的業務方法
				result = method.invoke(obj, args);
			} catch (Exception e) {
				// 異常通知
				//System.err.println("前置通知：寫入 Log : " + e);
				MyLogger.throwing(obj.getClass(), method.getName(), e);
			} finally {
				// 後置通知
				//System.out.println("後置通知：寫入 Log : " + method.getName() + " 完成");
				MyLogger.end(obj.getClass(), method.getName(), result);
			}
			
			return result;
		};
		
		Object proxyObject = Proxy.newProxyInstance(loader, interfaces, handler);
		return proxyObject;
	}
}
