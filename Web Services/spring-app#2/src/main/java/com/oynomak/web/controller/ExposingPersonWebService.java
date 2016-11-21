package com.oynomak.web.controller;

import com.oynomak.model.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/*
 * http://stackoverflow.com/questions/30977189/restcontroller-throws-http-status-406
*/
@RestController
public class ExposingPersonWebService{

	private static final Log log = LogFactory.getLog(ExposingPersonWebService.class);

	@RequestMapping(value="/people", method = RequestMethod.GET, headers="Accept=application/json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<Person> getPeople(){

		return people;
	}

	/*
	 * This works really fine, and I am wondering if it's better to use PathVariable or RequestParam?
	*/
	/*@RequestMapping(value = "/person/view/{id}", headers="Accept=application/json", produces = "application/json;charset=UTF-8")
	public Person getPersonByIdVariable(@PathVariable("id") String id) {
		
		Person foundPerson = null;
		Integer personId = Integer.parseInt(id);

		for(Person person: people){
			if(person.getId() == personId)
				foundPerson = person;
		}

		return foundPerson;
	}*/

	/* This works as well, and all we need is to append the params when consuming this WS on the client side */
	@RequestMapping(value = "/person/view", method = RequestMethod.GET, headers="Accept=application/json", produces = "application/json;charset=UTF-8")
	public Person getPersonByIdParam(@RequestParam(required = true, value = "personId") String personId){

		Person foundPerson = null;
		Integer persId = Integer.parseInt(personId);

		for(Person person: people){
			if(person.getId() == persId)
				foundPerson = person;
		}

		return foundPerson;
	}

	@RequestMapping(value = "/person/{id}/{names}/{age}/{sex}", method = RequestMethod.POST, headers="Accept=application/json", produces = "application/json;charset=UTF-8")
	public ModelAndView savePerson(@PathVariable Integer id, @PathVariable String names, @PathVariable Integer age, @PathVariable String sex) throws Exception {
		
		people.add(new Person(id, names, age, sex));

		ModelAndView mav = new ModelAndView("hello");

		mav.addObject("people", people);
		
		return mav;
	}

	/* Creates a new Person from the Object sent by the Client side... */
	@RequestMapping(value = "/person/new", method = RequestMethod.POST, produces={"application/json"})
	public Person createPerson(@RequestBody Person person) {

		// ModelAndView mav = new ModelAndView("hello");
		log.info("\n\n************* <<<<<<<<< "+person.toString()+">>>>>>>>> *************\n");

		if(person != null)
			people.add(person);

		// mav.addObject("people", people);

		return person;
	}



	@RequestMapping(value = "/update-person/{id}/{names}/{age}/{sex}", method = RequestMethod.PUT, headers="Accept=application/json", produces = "application/json;charset=UTF-8")
	public ModelAndView updatePerson(@PathVariable Integer id, @PathVariable String names, 
		@PathVariable Integer age,  @PathVariable String sex) throws Exception {
	
		for(Person p: people){
			if(p.getId() == id){
				p.setNames(names);
				p.setAge(age);
				p.setSex(sex);
			}
		}

		ModelAndView mav = new ModelAndView("hello");

		mav.addObject("people", people);
		
		return mav;
	}

	@RequestMapping(value = "/edit-person/{id}", method = RequestMethod.PUT, headers="Accept=application/json", produces = "application/json;charset=UTF-8")
	public ModelAndView editPerson(@PathVariable Integer id, @RequestBody Person person) throws Exception{

		for(Person p: people){
			if(p.getId() == id){
				p.setNames(person.getNames());
				p.setAge(person.getAge());
				p.setSex(person.getSex());
			}
		}

		ModelAndView mav = new ModelAndView("hello");

		mav.addObject("people", people);
		
		return mav;
	}

	@RequestMapping(value = "/person/deletion/{id}", method = RequestMethod.DELETE, headers="Accept=application/json", produces = "application/json;charset=UTF-8")
	public ModelAndView deletePerson(@PathVariable Integer id) throws Exception {
		
		for (Iterator<Person> iter = people.listIterator(); iter.hasNext(); ) {
		    Person person = iter.next();
		    if (person.getId() == id) 
		        iter.remove();
		}

		ModelAndView mav = new ModelAndView("hello");

		mav.addObject("people", people);

		return mav;
	}

	public static List<Person> people = new ArrayList<Person>(){
				{
					add(new Person(1, "Kamonyo Mugabo", 38, "male"));
					add(new Person(2, "Neza Guillaine", 29, "female"));
					add(new Person(3, "Amaliza Nyankesha", 0, "female"));
					add(new Person(4, "Mugisha Aline Dior", 16, "female"));
					add(new Person(5, "Mukansanga Bonifride", 44, "female"));
					add(new Person(6, "Kamonyo Solal", 13, "male"));
				}
			};
	
}

// COMMAND: curl --header "Accept: application/json" http://localhost:8080/spring-app-2/records