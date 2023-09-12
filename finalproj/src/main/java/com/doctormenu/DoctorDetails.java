package com.doctormenu;



import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import doctordaoimpl.DoctorDaoImpl;
import doctordao.DoctorDao;

import com.onlinedoctor.App;
import com.onlinedoctor.customer.Doctors;
import com.onlinedoctor.exception.SystemException;
//import com.onlinedoctor.exception.AppointmentNotFoundException;


public class DoctorDetails{
	private static Scanner sc = new Scanner(System.in);
	public static void menu() {
		System.out.println("APPOINTMENT MENU");
		try {
			while(true) {
				System.out.println("\n 1.Book an appointment");
				System.out.println("\n 2.Modify appointment details");
				System.out.println("\n 3.Delete an appointment");
				System.out.println("\n 4.View single record");
				System.out.println("\n 5.View all records");
				System.out.println("\n 6.go back to first page");
				System.out.println("\n 0.Exit");
				System.out.println("choose your option");
		int chs = Integer.parseInt(sc.nextLine());
		switch(chs) {
		case 1:
			bookAppointment();
			break;
		case 2:
			modifyCustomerDetails();
			break;
		case 3:
			deletecustomer();
			break;
		case 4:
			viewSingleRecord();
			break;
		case 5:
			viewAllRecords();
			break;
		case 6:
			App.main(null);
		case 0:
			System.exit(0);
		
			default:
				System.out.println("Try again");
		}
	}
}catch (NumberFormatException e) {
	System.out.println("Please enter range of integers from 0 to 5 : " + e.getMessage());
} catch (Exception e) {

	System.out.println("Error : " + e.getMessage());
}
}
	private static DoctorDao dao = new DoctorDaoImpl();
	
	private static void bookAppointment() throws SystemException, SQLException {
		// TODO Auto-generated method stub
		DoctorDaoImpl ms = new DoctorDaoImpl();
		Doctors obj = new Doctors();
		
		try {
			System.out.println("Enter The Customer id: ");
			int cid = Integer.parseInt(sc.nextLine());
			obj.setcId(cid );
//			System.out.println("Enter The Last Name: ");
//			String lastName = sc.nextLine();
//			obj.setLastName(lastName);
//			System.out.println("enter your phone number: ");
//			String phoneNumber = sc.nextLine();
//			obj.setPhoneNumber(phoneNumber);
			System.out.println("enter your emailId: ");
			String emailId = sc.nextLine();
			obj.setEmailId(emailId);
			System.out.println("enter your city");
			String city = sc.nextLine();
			obj.setCity(city);
			System.out.println("Enter your doctor Name");
			String doctorName =sc.nextLine();
			obj.setDoctorName(doctorName);
			System.out.println("enter your desired appointment date");
			String appointmentDate = sc.nextLine();
			obj.setAppointmentDate(appointmentDate);
			System.out.println(appointmentDate);
			System.out.println("Your details are: Customer id= " +cid  + ",EmailID= " + emailId + ", city= " + city+", Doctor Name is = "+ doctorName +",date of appointment is "+ appointmentDate );
			//System.out.println("your mId is : "+ a);
		} catch (NumberFormatException e) {
			throw new SystemException("Please Provide a number value\n " + e.getMessage());
		}
		ms.bookappoint(obj);
		
	}
	private static void modifyCustomerDetails() throws SQLException{
		// TODO Auto-generated method stub
		System.out.println("Enter id to get update your Doctor details");
		int moid=Integer.parseInt(sc.nextLine());
		dao.singleRecord(moid);
		dao.modify(moid);
	}
	private static void viewSingleRecord() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("enter id to be displayed");
		int sid = Integer.parseInt(sc.nextLine());
		dao.singleRecord(sid);
	}
	
	private static void viewAllRecords() throws SQLException {
		// TODO Auto-generated method stub
		List<Doctors> allAppointments = dao.selectAll();
		for (Doctors appoint : allAppointments) {
			if(appoint != null)
				System.out.println(appoint);
		}
	}
	
	private static void deletecustomer() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("enter id to be deleted");
		int dId = Integer.parseInt(sc.nextLine());
		dao.delete(dId);
	}

	
	
	
}