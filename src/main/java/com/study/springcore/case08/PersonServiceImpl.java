package com.study.springcore.case08;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDao personDao;
	
	@Override
	public boolean append(String name, Date birth) {
		Person person = new Person();
		person.setName(name);
		person.setAge(0);
		person.setBirth(birth);
		return append(person);
	}
	@Override
	public boolean append(Person person) {
		return personDao.create(person);
	}

	@Override
	public List<Person> findAllPersons() {
		return personDao.readAll();
	}

	@Override
	public Person getPerson(String name) {
		Optional<Person> optPerson = findAllPersons()
				.stream()
				.filter(p -> p.getName().equals(name))
				.findFirst();
		return optPerson.isPresent() ? optPerson.get() : null;
	}

	@Override
	public Person getPerson(Date birth) {
		Optional<Person> optPerson = findAllPersons()
				.stream()
				.filter(p -> p.getBirth().equals(birth))
				.findAny();
		return optPerson.isPresent() ? optPerson.get() : null;
	}

	@Override
	public List<Person> getPerson(int age) {
		List<Person> person =
		findAllPersons()
		.stream()
		.filter(p -> p.getAge() > age )
		.collect(Collectors.toList());
		return person;
	}

	@Override
	public boolean modify(String name, Date birth) {
		Person person = new Person();
		person.setName(name);
		person.setAge(0);
		person.setBirth(birth);
		return modify(person);
	}
	@Override
	public boolean modify(Person person) {
		return personDao.update(person);
	}

	@Override
	public boolean remove(String name, Date birth) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean remove(Person person) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
