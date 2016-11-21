package com.oynomak.web.controller;

import com.oynomak.model.*;

import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.client.RestTemplate;

@Controller
public class HelloController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView printWelcome() {

		ModelAndView model = new ModelAndView("hello");
		model.addObject("message", "Spring 4 MVC Hello World");
		model.addObject("usersList", UsersList.getAllUsers());
		
		return model;

	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView("hello");
		model.addObject("name", name);
		model.addObject("usersList", UsersList.getAllUsers());

		return model;

	}

}