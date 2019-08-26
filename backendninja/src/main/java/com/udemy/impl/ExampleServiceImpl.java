package com.udemy.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.model.Person;
import com.udemy.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {
	
	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);

	@Override
	public List<Person> getListPeople(){
		LOG.info("ExampleService/getListPeople");
		List<Person> people = new ArrayList<>();
		people.add(new Person("Juan",10));
		people.add(new Person("Ana",11));
		people.add(new Person("Nacho",12));
		people.add(new Person("Carlos",13));
		people.add(new Person("Nati",14));
		return people;
	}
}
