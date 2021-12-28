package com.study.springcore.case08;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/*
 * 
 * 功能:
 * 1. 建立 Person 資料
 * 		-> 輸入 name, birth
 * 2. 取得 Person 全部資料
 * 		-> 不用輸入參數
 * 3. 根據姓名取得 Person
 * 		-> 輸入 name
 * 4. 取得今天生日的 Person
 * 		-> 輸入今天日期
 * 5. 取得某一歲數以上的 Person
 * 		-> 輸入 age
 * 6. 根據姓名來修改Person的生日
 * 		-> 輸入 name, birth
 * 7. 根據姓名來刪除Person
 * 		-> 輸入 name
 * */

@Controller
public class PersonController {
	
	@Autowired
	private PersonService personService;

	// 1. 建立 Person 資料
	public void addPerson(String name, int yyyy, int mm, int dd) {
		// 1. 判斷 name, yyyy, mm 與 dd 是否有資料?
		// 2. 將 yyyy/mm/dd 轉日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			Date birth = sdf.parse(yyyy + "/" + mm + "/" + dd);
			addPerson(name, birth);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void addPerson(String name, Date birth) {
		// 1. 判斷 name 與 birth 是否有資料?
		// 2. 建立 Person 資料
		boolean check = personService.append(name, birth);
		System.out.println("+--------------+---------+--------------+");
		System.out.printf("|          add person:   %-6b         |\n", check);
		System.out.println("+--------------+---------+--------------+");
	}
	// 2. 取得 Person 全部資料
	public void printAllPersons() {
		//System.out.println(personService.findAllPersons());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		// 資料呈現
		List<Person> people = personService.findAllPersons();
		System.out.println("+--------------+---------+--------------+");
		System.out.println("|     name     |   age   |   birthday   |"); // 12, 7, 12
		System.out.println("+--------------+---------+--------------+");
		for(Person p : people) {
			String birthday = sdf.format(p.getBirth());
			System.out.printf("| %-12s | %7d | %12s |\n", p.getName(), p.getAge(), birthday);
			System.out.println("+--------------+---------+--------------+");
		}
	}
	// 3. 根據姓名取得 Person
	public void getPersonByName(String name) {
		// 1. 判斷 name ?
		// 2. 根據姓名取得 Person
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		// 資料呈現
		Person person = personService.getPerson(name);
		if(person == null) {
			System.out.println("+--------------+---------+--------------+");
			System.out.printf("|   Name : %-10s Not found         |\n", name); // 12, 7, 12
			System.out.println("+--------------+---------+--------------+");
			
		}else {
			List<Person> pp2 = Stream.of(person).collect(Collectors.toList());
			System.out.println("+--------------+---------+--------------+");
			System.out.println("|     name     |   age   |   birthday   |"); // 12, 7, 12
			System.out.println("+--------------+---------+--------------+");
			for(Person p : pp2) {
				String birthday = sdf.format(p.getBirth());
				System.out.printf("| %-12s | %7d | %12s |\n", p.getName(), p.getAge(), birthday);
				System.out.println("+--------------+---------+--------------+");
			}
		}
	}
	// 4. 取得今天生日的 Person
	public void getPersonByBirth() {
		// 1. 取得今天生日的 Person
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date today = new Date();
		LocalDate todayLocalDate = today.toInstant()
									.atZone(ZoneId.systemDefault())
									.toLocalDate();
//		 資料呈現
		Person person = personService.getPerson(today);
		if(person == null) {
			System.out.println("+--------------+---------+--------------+");
			System.out.printf("|  Birthday in (%-10s) Not found   |\n", todayLocalDate); // 12, 7, 12
			System.out.println("+--------------+---------+--------------+");
			
		}else {
			List<Person> pp2 = Stream.of(person).collect(Collectors.toList());
			System.out.println("+--------------+---------+--------------+");
			System.out.println("|     name     |   age   |   birthday   |"); // 12, 7, 12
			System.out.println("+--------------+---------+--------------+");
			for(Person p : pp2) {
				String birthday = sdf.format(p.getBirth());
				System.out.printf("| %-12s | %7d | %12s |\n", p.getName(), p.getAge(), birthday);
				System.out.println("+--------------+---------+--------------+");
			}
		}
	}
	// 5. 取得某一歲數以上的 Person
	public void getPersonByAge(int age) {
		
	}
	// 6. 根據姓名來修改Person的生日
	
	// 7. 根據姓名來刪除Person
}
