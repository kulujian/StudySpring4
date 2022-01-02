package com.study.springcore.case05;

import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.style.ToStringCreator;

import com.study.springcore.case01.Computer;

public class Test1 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext5.xml");
		
		Student john = ctx.getBean("s1", Student.class);
//		System.out.println(john);
		
		Student mary = ctx.getBean("s2", Student.class);
//		System.out.println(mary);
		Teacher t1 = ctx.getBean("t1", Teacher.class);
		 
		// 請問 mary 的老師有誰 ? 印出 name
//		System.out.println(mary.getName() + "的課程：" + mary.getClazzs());
		Teacher[] teachers = {ctx.getBean("t1", Teacher.class), ctx.getBean("t2", Teacher.class)};
		Set<Teacher> teachers2 = new LinkedHashSet<>();
		
//		Stream.of(teachers).filter(
//				p->p.getClazzs().stream().map(
//						c->c.getId().equals(
//										mary.getClazzs().stream().map(
//											c->c.getId()
//											)
//								)
//						)
//				);
//		Stream.of(t1).filter(t1.getClazzs().stream().filter(a -> a.getId().equals(mary.getClazzs().stream().map(s -> s.getId()))).equals(teachers2));
//		Stream.of(teachers).map(p->p.getName()).forEach(System.out::println);
		
//		mary.getClazzs().stream().map(
//				c->c.getId());           mary.getClazzs().stream().map(s -> s.getId())
//		mary.getClazzs().stream().mapToInt(s -> s.getId());
//		t1.getClazzs().stream().filter(a->a. == mary.getClazzs().stream().map(s -> s.getId()).toString()).forEach(System.out::println);
		
		
		
		
//		Set<Clazz> clazzs2 = new LinkedHashSet<>();
//		System.out.println(t1);
	
//		clazzs2 = (Set<Clazz>) Stream.of(teachers).flatMap(C->C.getClazzs().stream());
//		System.out.println(clazzs2);
//		Stream.of(mary).flatMap(T->T.getClazzs())
//		
		
//		(Stream.of(teachers).flatMap(t->t.getClazzs().stream())).map(t->t.getName()).iterator().forEachRemaining(System.out::println);
		
//		Stream.of(teachers).flatMap(t->t.getClazzs().stream()).filter(m->m.getName().equals("Java")).forEach(System.out::println);
		
		
//		for(Teacher teacher : teachers) {
//			clazz_loop:
//			for(Clazz cla1 : teacher.getClazzs()) {
//				for(Clazz cla2 : mary.getClazzs()) {
//					System.out.println(cla1+"1");
//					if(cla1.getId() == cla2.getId()) {
//						System.out.println(cla2.getId()+"2");
//						teachers2.add(teacher);
//						break clazz_loop;
//					}
//				}
//			}
//		}
//		System.out.println(mary.getName() + "的老師(物件)：" + teachers2);
//		System.out.println(mary.getName() + "的老師(名字)：" + teachers2.stream()
//														.map(Teacher::getName)
//														.collect(Collectors.toSet()));
		
	}
}
