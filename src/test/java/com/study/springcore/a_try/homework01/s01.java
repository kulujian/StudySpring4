package com.study.springcore.a_try.homework01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.case05.Clazz;
import com.study.springcore.case05.Student;
import com.study.springcore.case05.Teacher;

public class s01 {

	public static void main(String[] args) {

		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext5.xml");
		Student john = ctx.getBean("s1", Student.class);
		Student mary=ctx.getBean("s2",Student.class);	 
		  //System.out.println(mary);	 
		Teacher t1= ctx.getBean("t1",Teacher.class);
		Teacher t2= ctx.getBean("t2",Teacher.class);
		
			Stream.of(t1,t2).filter(
					t->{
						for(Clazz c:mary.getClazzs()) {
							if(t.getClazzs().contains(c)) {
								return true;
							}
						}
						return false;
					}									
					).map(Teacher::getName).forEach(System.out::println);
		System.out.println("============================================================");

		
		//建立一個Map綁定課程Id及teacher name
		Teacher[] teachers= {ctx.getBean("t1",Teacher.class),ctx.getBean("t2",Teacher.class)};
		Map<Integer,String> map=new HashMap<>();
		map.put(101,t1.getName());
		map.put(102,t2.getName());
		map.put(103,t1.getName());
		map.put(104,t1.getName());
		
		//用stream回傳mary修的所有課程id的List
		List<Integer> maryId=Stream.of(mary)
									.flatMap(a->a.getClazzs().stream())
									.map(a->a.getId())
									.collect(Collectors.toList());
		//用stream回傳teachers開的所有課程的List					
		Set<Clazz> teachersId=Arrays.stream(teachers)
										.flatMap(b->b.getClazzs().stream())
										.collect(Collectors.toSet());	
		//比對並回傳相同的課程Id
		List<Integer> sameId=teachersId.stream()
										.filter(c->maryId.contains(c.getId()))
										.map(c->c.getId())
										.collect(Collectors.toList());
		//用課程Id去比對Map中開對應課程的teacher name
		map.keySet().stream()
					.filter(d->sameId.contains(d))
					.map(d->map.get(d))
					.distinct() //以防有重複的值
					.forEach(d->System.out.println(d));
		System.out.println("============================================================");

		List<Teacher> teacherlist = new ArrayList<>();
		
		teacherlist.add(ctx.getBean("t1", Teacher.class));
		teacherlist.add(ctx.getBean("t2", Teacher.class));
	
		List<Clazz> maryclazzlist = new ArrayList<>();
		for(Clazz maryclazz : mary.getClazzs() ) {
			maryclazzlist.add(maryclazz);
		}
		
		List<String> teachernamelist = new ArrayList<>();
		for(int i=0;i<teacherlist.size();i++) {
			for(Clazz clazz:teacherlist.get(i).getClazzs()) {
				if(maryclazzlist.contains(clazz)) {					
					teachernamelist.add(teacherlist.get(i).getName());
				}
			}
		}
		teachernamelist.stream().distinct().forEach(System.out::println);
		
		System.out.println("============================================================");
		
		Teacher[] teachers1= {t1,t2};
		Set<Teacher> teachers2=new LinkedHashSet<>();
		  //目前想到這樣，但不知可否連這個for也省略
		 for(Clazz cx:mary.getClazzs()) {
			Arrays.stream(teachers1).filter(t->t.getClazzs().stream().map(c->c.getId()).collect(Collectors.toList())
					.contains(cx.getId())).forEach(t->teachers2.add(t));  
		 }
		 
		  
		  //System.out.println(mary.getName()+ "的老師:"+teachers2);
		  //Java8的寫法
		  System.out.println(mary.getName()+ "的老師:"+teachers2.stream()
		  .map(Teacher::getName)
				  .collect(Collectors.toSet()));
		
	
		//回家作業，上述全改用java8來寫

			System.out.println("============================================================");
		  

			Set<Teacher> teachers3 = new LinkedHashSet<>();
			// 回家作業：改成 Java 8
			// -----------------------------------------------------------------
			mary.getClazzs().stream().forEach(e -> {
				Arrays.asList(teachers).stream()
						.forEach(e2 -> {
							e2.getClazzs().forEach(e3 -> {
								if(e3.getId() == e.getId()) {
									//System.out.println(e.getName());
									teachers3.add(e2);
								}
							});
						});
			});
			System.out.println(mary.getName() + "的老師：" + teachers3);
			System.out.println(mary.getName() + "的老師：" + teachers3.stream()
																	.map(Teacher::getName)
																	.collect(Collectors.toSet()));
			System.out.println("");
			

//			Set<Teacher> teachers4 =Set.of(t1,t2);
			
			Stream.of(teachers).filter(
					t->t.getClazzs().stream().map(Clazz::getId).anyMatch(
							id->mary.getClazzs().stream().map(Clazz::getId).anyMatch(id2->id2==id)
							)
					).map(Teacher::getName).forEach(System.out::println);
			
			((ClassPathXmlApplicationContext) ctx).close();
	}

}
