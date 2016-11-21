package com.oynomak.web.controller;

import com.oynomak.model.Person;

import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HelloController {

	private List<String> records = new ArrayList<String>();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Spring 4 MVC Hello World");
		
		return "hello";

	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView("hello");
		model.addObject("message", "Spring 4 MVC Hello World");
		model.addObject("name", name);

		return model;

	}

	@RequestMapping(value = "/hello/save", method = RequestMethod.GET)
	public ModelAndView saveLoanPayment(
			@RequestParam(required = true, value = "id") Long id,
			@RequestParam(required = true, value = "name") String name,
			@RequestParam(required = true, value = "age") Integer age,
			@RequestParam(required = true, value = "salary") Double salary, HttpSession session) {

		ModelAndView mav = new ModelAndView("hello");

		String myRecord = "- ID: "+ id + ", NAME: " + name + ", AGE: " + age + ", SALARY: " + salary;
		records.add(myRecord);
		System.out.println("\n\n>>>> My String: - ID: "+ id + ", NAME: " 
			+ name + ", AGE: " + age + ", SALARY: " + salary);

		mav.addObject("message", "Spring 4 MVC Hello World");
		mav.addObject("records", records);
		mav.addObject("people", ExposingPersonWebService.people);

		return mav;
	}

}