package com.onlinedoctor.customer.dao;

import com.onlinedoctor.customer.Customers;

import java.sql.SQLException;
import java.util.*;

public interface CustomerDao  {
	boolean add(Customers customer) throws SQLException ;

	void modify(int id) throws SQLException;
	
    void viewSingle(int id) throws SQLException;
    boolean delete(int id)throws SQLException;

	List<Customers> displayAll() throws SQLException;

	


}
