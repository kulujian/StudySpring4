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

public class TeacherExample {
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
		
		// 回家作業: 請問 mary 的老師有誰 ? 印出 name (請使用Java 8)
				// 從每個老師教授的課程去判斷學生是否有劃課
				// 1. 資料分析
				/*
				Set<Teacher> studentMaryTeachers = Arrays.stream(teachers)
						.filter(t -> t.getClazzs().stream().anyMatch(mary.getClazzs()::contains))
						//.peek(System.out::println)
						.collect(Collectors.toSet());
				*/
				// 2. 考慮到程式碼重用性, 轉換成方法
				Set<Teacher> studentMaryTeachers = getTeachersByStudentClazzs(teachers, mary);
				
				//System.out.println(studentMaryTeachers);
				System.out.printf(
						"學生 mary 的老師: %s\n", 
						studentMaryTeachers.stream()
										   .map(Teacher::getName)
										   .collect(Collectors.toSet())
				);
				System.out.println("--------------------------------------------");
				
				((ClassPathXmlApplicationContext) ctx).close();
			}
			
			/** 
			 * 從每個老師教授的課程去判斷學生是否有劃課
			 * @param teachers 授課老師集合
			 * @param student 劃課學生
			 * @return Set<Teacher>
			 */
			private static Set<Teacher> getTeachersByStudentClazzs(Teacher[] teachers, Student student) {
				return Arrays.stream(teachers)
							 //.filter(t -> t.getClazzs().stream().anyMatch(c -> student.getClazzs().contains(c)))
							 .filter(t -> t.getClazzs().stream().anyMatch(student.getClazzs()::contains))
							 .peek(System.out::println)
							 .collect(Collectors.toSet());
		
		
	}
}
