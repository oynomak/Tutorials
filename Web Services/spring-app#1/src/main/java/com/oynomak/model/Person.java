package com.oynomak.model;

import java.util.*;
//import com.fasterxml.jackson.annotation.JsonAnyGetter;
//import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//@JsonSerialize(using = ItemSerializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person{

	@JsonProperty
	private Integer id;
	@JsonProperty
	private String names;
	@JsonProperty
	private Integer age;
	@JsonProperty
	private String sex;

	/* 
	 * Introducing the dummy constructor
	 * 			If we don't the JSON thing will consider the other Constructor that has parameters...
	 * http://stackoverflow.com/questions/7625783/jsonmappingexception-no-suitable-constructor-found-for-type-simple-type-class
	 */
    public Person() {
    }

	public Person(Integer id, String names, Integer age, String sex){
		this.id = id;
		this.names = names;
		this.age = age;
		this.sex = sex;
	}

	public void setId(Integer id){
		this.id = id;
	}
	public void setNames(String names){
		this.names = names;
	}
	public void setAge(Integer age){
		this.age = age;
	}
	public void setSex(String sex){
		this.sex = sex;
	}
	public Integer getId(){
		return this.id;
	}
	public String getNames(){
		return this.names;
	}
	public Integer getAge(){
		return this.age;
	}
	public String getSex(){
		return this.sex;
	}

	@Override
	public String toString() {
	    return "- ID: " + id
	    		+ ", NAMES: " + names
	    		+ ", AGE: " + age
	    		+ ", SEX: " + sex;
	}

}