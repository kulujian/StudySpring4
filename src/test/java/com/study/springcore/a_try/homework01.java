package com.study.springcore.a_try;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.util.StringUtils;

import com.google.gson.reflect.TypeToken;

public class homework01 {

	public static void main(String[] args) {
		

//		另外，java反射包中的TypeToken類是用來解決java運行時泛型類型被擦除的問題，有點不好理解，我們通過一個例子來認識什麼是泛型的運行時類型擦除。
		
		ArrayList<String> stringList = new ArrayList();
		ArrayList<Integer> intList = new ArrayList();
		/* 上面的代碼我們聲明了兩個泛型的ArrayList類型，
		 * 一個泛型的類型參數是String，另外一個是Integer；
		 * 然後我們輸出了兩個泛型的Class，並輸出兩個list的類型是否是同一個list。
		 * 
		 * 我們看下輸出的結果：
		 **/
		System.out.println("intList type is " + intList.getClass());
		System.out.println("stringList type is " + stringList.getClass());
		System.out.println(stringList.getClass().isAssignableFrom(intList.getClass()));

		/* 前兩個輸出都是java.util.ArrayList，而第三個輸出竟然是true，
		 * 也就是認為stringList和intList的類型是一樣的。這就是所謂的泛型類型擦除。
		 * 運行時我們不知道泛型類型的類型參數是什麼了。 
		 **/
		
		/* TypeToken可以解決這個問題，請看下面代碼：
		 **/
		TypeToken<ArrayList<String>> typeToken = new TypeToken<ArrayList<String>>() {};
//		TypeToken<?> genericTypeToken = typeToken.resolveType(ArrayList.class.getTypeParameters()[0]);
//		System.out.println(genericTypeToken.getType());
		/* 注意上面第一行代碼使用了一個空的匿名類。
		 * 第二行使用了resolveType方法解析出泛型類型。
		 * 第三行代碼列印出泛型類型，輸出是：
		 * 【class java.lang.String】
		 * 可以看出TypeToken解析出了泛型參數的具體類型。
		 * TypeToken的方法列表如下：
		 **/

		
	}

}
