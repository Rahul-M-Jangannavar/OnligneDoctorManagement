package com.customermenu;
import com.onlinedoctor.exception.SystemException;
import java.util.List;
import com.customermenu.CustomerDetails;
import java.util.Scanner;

import com.onlinedoctor.App;
import com.onlinedoctor.customer.Customers;
import com.onlinedoctor.customer.dao.CustomerDao;
import com.onlinedoctor.customer.dao.impl.CustomerDaoImpl;
import com.onlinedoctor.exception.SystemException;
import java.sql.SQLException;
public class CustomerDetails {
private static Scanner scanner=new Scanner(System.in);

 public static void menu() {
	 System.out.println("CUSTOMER MENU");
	 try {
		 boolean flag =true;
			while(true) {
				System.out.println("\n 1. Customer registration.");
				System.out.println("\n 2. Modify Customer Details.");
				System.out.println("\n 3. Delete Customer record");
				System.out.println("\n 4. View Single Record");
				System.out.println("\n 5. View all Records");
				System.out.println("\n 0. Exit");
				System.out.println("\n 6. go to  first page");

				System.out.println("\n Enter your choice");
				
				int mp = Integer.parseInt(scanner.nextLine());
				
				switch(mp) {
				
				case 1:
					registerCustomer();
					break;
				case 2:
					modifyCustomerDetails();
					break;
					
				case 3:
					deleteCustomerRecord();

					
					break;
					
				case 4:
					viewSingleRecord();
					break;
				case 5:
					displayAll();
					break;
				case 6:
					App.main(null);
				case 0:
					flag = false;
				default:
					System.out.println("Try again");
				
				}
				
				
			}
			
		}catch (NumberFormatException e) {
			System.out.println("Number Format : " + e.getMessage());
		}
	 	catch (Exception e) {

			System.out.println("Error : " + e.getMessage());
		}
		
 }
 
 private static void modifyCustomerDetails() throws SQLException {
	// TODO Auto-generated method stub
	 System.out.println("Enter id to get update your details");
		int mid = Integer.parseInt(scanner.nextLine());
		dao.viewSingle(mid);
		dao.modify(mid);
	
}

private static void deleteCustomerRecord() throws SQLException {
	// TODO Auto-generated method stub
	 System.out.println("Enter your id to delete record");
	 int id=Integer.parseInt(scanner.nextLine());
	 dao.delete(id);
	
}

private static CustomerDao dao = new CustomerDaoImpl();
 private static void registerCustomer() throws SystemException, SQLException{
		// TODO Auto-generated method stub
		CustomerDaoImpl cs = new CustomerDaoImpl();
		Customers obj = new Customers();
		try {
			System.out.println("Enter The First Name: ");
			String firstName = scanner.nextLine();
			obj.setFirstName(firstName);
			firstName = obj.getFirstName();
			System.out.println("Enter The Last Name: ");
			String lastName = scanner.nextLine();
			obj.setLastName(lastName);
			lastName = obj.getLastName();
			System.out.println("Enter The mo_number: ");
			long mobile_number = Long.parseLong(scanner.nextLine());
			obj.setMn(mobile_number);
			mobile_number = obj.getMn();
			System.out.println("Enter the gender");
			String gender = scanner.nextLine();
			obj.setGender(gender);
			gender = obj.getFirstName();
			System.out.println("Your details are: firstName= " + firstName + ", lastName= " + lastName + ",MobileNumber= " + mobile_number  + ",Gender= " + gender );
		} catch (NumberFormatException e) {
			throw new SystemException("Please Provide a number value\n " + e.getMessage());
		}
		cs.add(obj);
	}
 
 
 private static void viewSingleRecord() throws SQLException{
	    System.out.println("Enter id to view your details");
	    int vid= Integer.parseInt(scanner.nextLine());
		dao.viewSingle(vid);
	}
 
 private static void displayAll() throws SQLException {
		// EmployeeDao dao=new EmployeeDaoImpl();
		List<Customers> allCustomers = dao.displayAll();
		for (Customers customer : allCustomers) {
			if (customer != null)
				System.out.println(customer);
		}
	}
}
