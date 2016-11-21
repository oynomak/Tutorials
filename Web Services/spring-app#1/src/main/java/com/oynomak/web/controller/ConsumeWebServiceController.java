package com.oynomak.web.controller;

import com.oynomak.model.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumeWebServiceController {

	private static final Log log = LogFactory.getLog(ConsumeWebServiceController.class);

	/*
	 * Getting all People in the DB of the << spring-app-2 >> rendered through REST-WS:
	 * http://localhost:8080/spring-app-2/people/
	*/
	@RequestMapping("/people/view")
    public ModelAndView listPeople() {

	    final String url="http://localhost:8080/spring-app-2/people/";
		ModelAndView mav = new ModelAndView("hello");

		mav.addObject("message", "Spring MVC 4.0 - Consuming RESTFul Web Services using RestTemplate");
	    
	    RestTemplate restTemplate = new RestTemplate();
	    List<Person> people=restTemplate.getForObject(url, List.class);

	    mav.addObject("people", people);

        return mav;
    }
    
    /* 
     * Getting a specific Person from the list of People in << spring-app-2 >> DB rendered through REST-WS:
     * http://localhost:8080/spring-app-2/people/{id}
     *
     * http://www.programming-free.com/2014/04/spring-mvc-consuming-restful-web-services.html 
    */
    @RequestMapping(value = "/person/view", headers = {"content-type=application/x-www-form-urlencoded"})
    public ModelAndView choosePerson(@RequestParam("personId") String id) {

    	/* we need to append the params from the UI to the url: */
	    String url="http://localhost:8080/spring-app-2/person/view?personId=" + id;
	    //Map<String, String> params = new HashMap<String, String>(1);
        //params.put("personId", id);
	    //log.info("\n************* <<<<<<<<< "+params.get("personId")+" >>>>>>>>> *************\n");

		ModelAndView mav = new ModelAndView("personView");
		mav.addObject("message", "Spring MVC 4.0 - Consuming RESTFul Web Services using RestTemplate");
	
        RestTemplate restTemplate = new RestTemplate();
		Person person = restTemplate.getForObject(url, Person.class, id);

	    mav.addObject("person", person);

        return mav;
    }

    @RequestMapping(value = "/person/new", method = RequestMethod.GET)
    public ModelAndView createPersonForm(@RequestParam(required = false, value = "personToEdit") String id) {

		ModelAndView mav = new ModelAndView("personView");

    	if(id != null){
			String url="http://localhost:8080/spring-app-2/person/view?personId=" + id;
			RestTemplate restTemplate = new RestTemplate();
			Person person = restTemplate.getForObject(url, Person.class, id);
	   		mav.addObject("personToEdit", person);
		}
	   
	   	mav.addObject("person", null);

		return mav;
	}

	@RequestMapping(value = "/person/add", method = RequestMethod.POST)
    public ModelAndView createPerson(@RequestParam("personId") Integer id, 
    									@RequestParam("names") String names,
    									@RequestParam("age") Integer age,
    									@RequestParam("sex") String sex) {

		final String url="http://localhost:8080/spring-app-2/person/new";
		ModelAndView mav = new ModelAndView("hello");

		RestTemplate restTemplate = new RestTemplate();
		Person person = new Person(id, names, age, sex);
		Person personToBe = restTemplate.postForObject(url, person, Person.class);		
	   
	   	mav.addObject("person", personToBe);

		return mav;
	}

	@RequestMapping(value = "person/edit/{id}", method = RequestMethod.POST)
    public Person updateCustomer(@PathVariable("id") Integer id, @RequestBody Person person) {

        return new Person(10, "NEW123 NEW SMITH", 23, "male");

    }

    @InitBinder
	public void initBinder(WebDataBinder binder) {
	    //SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    //sdf.setLenient(true);
	    //binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	    /* binder.registerCustomEditor(Person.class, new PropertyEditorSupport() {

                    @Override
                    public void setAsText(String text) {
                        // replace the dao with your appropriate repository call
                        Person category = dao.find(Person.class,
                                Integer.parseInt(text));
                        setValue(category);
                    }
                }); */
	}

}