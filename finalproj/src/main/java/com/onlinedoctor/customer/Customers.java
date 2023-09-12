package com.onlinedoctor.customer;
import java.util.List;
import java.util.Scanner;


import com.onlinedoctor.customer.Customers;
import com.onlinedoctor.customer.dao.CustomerDao;
import com.onlinedoctor.customer.dao.impl.CustomerDaoImpl;
import com.onlinedoctor.exception.SystemException;
import java.sql.SQLException;
public class Customers extends Object{
	private int customer_id;
	private String first_name;
	private String last_name;
	private long mo_number;
	private String gender;
	
	public int getId() {
		return customer_id;	
	}
	public void setId(int id) {
		this.customer_id = id;
	}
	public String getFirstName() {
		return first_name;
	}
	public void setFirstName(String firstName) {
		this.first_name = firstName;
	}
	public String getLastName() {
		return last_name;
	}
	public void setLastName(String lastName) {
		this.last_name = lastName;
	}
	public long getMn() {
		return mo_number;	
	}
	public void setMn(long mo_number) {
		this.mo_number = mo_number;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Customers [id=" + customer_id + ", firstName=" + first_name + ", lastName=" + last_name + ", mobile_number=" + mo_number +", gender=" + gender
				+ "]";
	}
	
	

}