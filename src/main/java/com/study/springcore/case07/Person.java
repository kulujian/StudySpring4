package com.study.springcore.case07;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:person.properties")
public class Person {
	
	@Value("${person.name}")
	private String name;
	
	@Value("${person.age}")
	private Integer age;
	
	@Value("${person.nicknames}")
	private String[] nicknames;
	
	@Value("${person.subjects}")
	private Set<String> subjects;
	
	@Value("#{'${person.scores}'.split(',')}")  // Spring EL
	private List<Integer> scores;
	
	@Value("#{${person.hobbies}}") // Spring EL
	private Map<Integer, String> hobbies;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String[] getNicknames() {
		return nicknames;
	}

	public void setNicknames(String[] nicknames) {
		this.nicknames = nicknames;
	}

	public Set<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<String> subjects) {
		this.subjects = subjects;
	}

	public List<Integer> getScores() {
		return scores;
	}

	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}

	public Map<Integer, String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Map<Integer, String> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", nicknames=" + Arrays.toString(nicknames) + ", subjects="
				+ subjects + ", scores=" + scores + ", hobbies=" + hobbies + "]";
	}
	
	
}
