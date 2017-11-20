package com.spring.redis.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.redis.api.model.Person;
import com.spring.redis.api.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonService service;

	@RequestMapping("/add")
	public String addPerson(@RequestBody Person person) {
		return service.addPerson(person);
	}

	@RequestMapping("/get/{id}")
	public Person getPerson(@PathVariable("id") int id) {
		return service.getPersonById(id);
	}

	@RequestMapping("/getAll")
	public List<Person> getPersons() {
		return service.getPersons();
	}

	@RequestMapping("/update")
	public String updatePerson(@RequestBody Person person) {
		return service.updatePerson(person);
	}

	@RequestMapping("/delete")
	public String deletePerson(@RequestParam("id") int id) {
		return service.deletePerson(id);
	}

	@RequestMapping("/count")
	public String recordCount() {
		return "Total object available in redis server : " + service.totalCount();
	}

}
