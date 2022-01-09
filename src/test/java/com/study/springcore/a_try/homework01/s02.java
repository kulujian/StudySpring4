package com.study.springcore.a_try.homework01;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.case05.Clazz;
import com.study.springcore.case05.Student;
import com.study.springcore.case05.Teacher;

public class s02 {

	public static void main(String[] args) {

		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext5.xml");
		Student john = ctx.getBean("s1", Student.class);
		System.out.println(john);
		
		Student mary = ctx.getBean("s2", Student.class);
		System.out.println(mary);
		
		
		// 請問 Mary 的老師有誰 ? 印出 name
		System.out.println(mary.getName() + " 的課程：" + mary.getClazzs());
		Teacher[] teachers = {ctx.getBean("t1", Teacher.class), ctx.getBean("t2", Teacher.class)};
		Set<Teacher> teachers2 = new LinkedHashSet<>();
		// 回家作業：改成 Java 8
		// -----------------------------------------------------------------
		mary.getClazzs().stream().forEach(e -> {
			Arrays.asList(teachers).stream()
					.forEach(e2 -> {
						e2.getClazzs().forEach(e3 -> {
							if(e3.getId() == e.getId()) {
								//System.out.println(e.getName());
								teachers2.add(e2);
							}
						});
					});
		});
		// -----------------------------------------------------------------
		// for (Teacher teacher : teachers) {
		//	clazz_loop:
		//	for (Clazz cla : teacher.getClazzs()) {
		//		for (Clazz cla2 : mary.getClazzs()) {
		//			if(cla.getId() == cla2.getId()) {
		//				// System.out.println("老師名稱：" + teacher.getName());
		//				teachers2.add(teacher);
		//				break clazz_loop;
		//			}
		//		}
		//	}
		//}
		System.out.println(mary.getName() + "的老師：" + teachers2);
		System.out.println(mary.getName() + "的老師：" + teachers2.stream()
																.map(Teacher::getName)
																.collect(Collectors.toSet()));
		
		System.out.println("");
		
		//java8
				System.out.println("Mary's teachers: "+
									Stream.of(teachers).filter(teacher ->{
										for(Clazz cla: mary.getClazzs()) {
											if(teacher.getClazzs().contains(cla))
												return true;
										}
										return false;
									}).map(Teacher::getName).collect(Collectors.toSet())
								);
		
				System.out.println("");
		//homework
		Stream<Teacher> teacherStream =  Stream.of(teachers);
		
	
		//first loop
		teacherStream.forEach(teacher -> {
			//second loop for teacher courses
			teacher.getClazzs().stream().forEach(course -> {
				//third loop for mary courses
				mary.getClazzs().stream().filter(c -> course.getId() == c.getId()).forEach(t -> {
					System.out.println("Mary`s teahcer :" + teacher.getName());
				});
			});
		});		
				
				
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
