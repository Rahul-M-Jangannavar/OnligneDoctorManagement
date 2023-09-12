package com.onlinedoctor.customer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.onlinedoctor.customer.dao.CustomerDao;
import com.onlinedoctor.customer.Customers;
//import com.onlinedoc.App;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import com.onlinedoctor.util.DBUtil;


public  class CustomerDaoImpl implements CustomerDao {
	private static final String INSERT_CUSTOMER="insert into customer(customer_first_name, customer_last_name, mo_number,gender) values(?,?,?,?)";
	private static final String SELECT_CUSTOMER="select * from customer";
	private static  String UPDATE_CUSTOMER=null;
	private static final String SINGLE_RECORD="select * from customer where id =?";
	private static final String DELETE_CUSTOMER="DELETE FROM customer WHERE id=?";
//	private static final String ASC_EMPLOYEE ="select * from employees order by salary asc";
	private  Connection connection=DBUtil.getConnection();
	private static Scanner scanner=new Scanner(System.in);
	
	@Override
	public boolean add(Customers customer) throws SQLException {
		PreparedStatement ps=connection.prepareStatement(INSERT_CUSTOMER);
		// Set The value
//		ps.setInt(1, customer.getId());
		ps.setString(1, customer.getFirstName());
		ps.setString(2, customer.getLastName());
		ps.setLong(3, customer.getMn());
		ps.setString(4,customer.getGender());
		//Execute Statement
		int executeUpdate = ps.executeUpdate();
		ps.close();
		if(executeUpdate>0) {
			return true;
		}
		return false;
	}
	public boolean delete(int id) throws SQLException{
		PreparedStatement ps = connection.prepareStatement(DELETE_CUSTOMER);
		
		ps.setInt(1,id);
		int executeUpdate = ps.executeUpdate();
//		int numberAffectedRows = ps.executeUpdate();
		System.out.println("Rows effected "+ executeUpdate);
		System.out.println("DELETE COMPLETE");
				ps.close();
		if(executeUpdate>0) {
			return true ;
		}
		return false;
	}
	public void modify(int id)throws SQLException{
		while(true) {
			System.out.println("Choose option to update");
			System.out.println("\n 1.FirstName");
			System.out.println("\n 2.LastName");
			System.out.println("\n 3.PhoneNumber");
			System.out.println("\n 4.Gender");
			System.out.println("\n 0.Exit");
			
			int uid=Integer.parseInt(scanner.nextLine());
			switch(uid) {
			case 1:

			System.out.println("Enter new first name");
			String newName = scanner.nextLine();
			UPDATE_CUSTOMER="update customer set customer_first_name=? where id=?";
			PreparedStatement ps = connection.prepareStatement(UPDATE_CUSTOMER);
			ps.setString(1,newName);
			ps.setInt(2,id);
			int executeUpdate = ps.executeUpdate();
			System.out.println("new updated details are ");
			viewSingle(id);
			break;
			case 2:
//				int sdid = id;
				System.out.println("Enter new last name");
				String newLastName = scanner.nextLine();
				PreparedStatement ps1 = connection.prepareStatement("update customer set customer_last_name=? where id=?");
				ps1.setString(1,newLastName);
				ps1.setInt(2,id);
				 int executeUpdate1 = ps1.executeUpdate();
				System.out.println("new updated details are ");
				viewSingle(id);
				break;
			case 3:
				System.out.println("Enter new phone number");
				String newphonenumber  = scanner.nextLine();
				PreparedStatement ps3 = connection.prepareStatement("update customer set mo_number=? where id=?");
				ps3.setString(1,newphonenumber);
				ps3.setInt(2,id);
				 int executeUpdate3 = ps3.executeUpdate();
				System.out.println("new updated details are ");
				viewSingle(id);
				break;
			case 4:
				System.out.println("Enter Gender");
				String newGender  = scanner.nextLine();
				PreparedStatement ps4 = connection.prepareStatement("update customer set gender=? where id=?");
				ps4.setString(1,newGender);
				ps4.setInt(2,id);
				int executeUpdate4 = ps4.executeUpdate();
				System.out.println("new updated details are ");
				viewSingle(id);
				break;
			case 0:
				System.exit(0);
				default:
					System.out.println("Try again");
			
			}
			
		}
	}
	

		
		
	@Override
	public void viewSingle(int id) throws SQLException{
//		Customers cs =new Customers();
		PreparedStatement ps=connection.prepareStatement(SINGLE_RECORD);
		ps.setInt(1,id);
		ResultSet res = ps.executeQuery();
		if(res.next()) {
			Customers e = new Customers();
			e.setId(res.getInt("id"));
			e.setFirstName(res.getString("customer_first_name"));
			e.setLastName(res.getString("customer_last_name"));
			e.setMn(res.getLong("mo_number"));
			e.setGender(res.getString("gender"));
			System.out.println("Your details are "+"Id:"+ e.getId()+"First Name: "+e.getFirstName()+"Last Name : "+e.getLastName()+"Mobile Number: "+e.getMn()+"Gender: "+e.getGender());

			
		}else{
			System.out.println("Id not found please try again");
		}
		

	}
	@Override
	public List<Customers> displayAll() throws SQLException  {
		List<Customers> myList = new ArrayList<Customers>();
		
		
		// execute select
		PreparedStatement ps=connection.prepareStatement(SELECT_CUSTOMER);
		ResultSet res = ps.executeQuery();
		while(res.next()) {
			Customers e = new Customers();
			e.setId(res.getInt(1));
			e.setFirstName(res.getString(2));
			e.setLastName(res.getString(3));
			e.setMn(res.getLong(4));
			e.setGender(res.getString(5));
			myList.add(e);
		}
return myList;
	}
		
	}