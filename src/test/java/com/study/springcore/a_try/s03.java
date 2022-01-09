package com.study.springcore.a_try;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.case05.Student;
import com.study.springcore.case05.Teacher;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class s03 {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext5.xml");

        Student mary = ctx.getBean("s2", Student.class);

        Teacher t1 = ctx.getBean("t1", Teacher.class);
        Teacher t2 = ctx.getBean("t2", Teacher.class);
        Teacher[] teachers = {t1, t2};

        Set<Teacher> marysTeacher = getOnesTeachers(teachers, mary);
        System.out.println("Mary's teacher: " +
                marysTeacher.stream()
                        .map(Teacher::getName)
                        .collect(Collectors.toSet())
        );
    }

    private static Set<Teacher> getOnesTeachers(Teacher[] teachers, Student student) {
        return Arrays.stream(teachers)
                .filter(t -> t.getClazzs().stream()
                        .anyMatch(student.getClazzs()::contains))
                .collect(Collectors.toSet());
    }
}
