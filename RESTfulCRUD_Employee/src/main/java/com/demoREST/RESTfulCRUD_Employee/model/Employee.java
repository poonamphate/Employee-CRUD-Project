package com.demoREST.RESTfulCRUD_Employee.model;

import javax.xml.bind.annotation.XmlAccessorType;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

	//define attributes for employee entity :- id, first_name, last_name, email, phone and skill_set
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private int phone;
	private List<String> skill_set;

	public Employee() {

	}
	
	//parameterized constructor to initialize employee objects
	public Employee(int id, String first_name, String last_name, String email, int phone, List<String> skillSet) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
		this.skill_set = skillSet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public List<String> getSkillSet() {
		return (skill_set);
	}

	public void setSkillSet(List<String> l) {
		skill_set = l;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(1024);
		sb.append("[");
		sb.append("id=").append(id).append(",");
		sb.append("first_name=").append(first_name).append(",");
		sb.append("last_name==").append(last_name).append(",");
		sb.append("email=").append(email).append(",");
		sb.append("phone=").append(phone).append(",");
		sb.append("skill_set=").append(skill_set.toString());
		sb.append("]");
		return (sb.toString());
	}
}