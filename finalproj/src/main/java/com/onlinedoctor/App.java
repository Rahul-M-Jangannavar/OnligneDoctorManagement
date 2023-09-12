package com.onlinedoctor;
import java.util.List;
import com.customermenu.CustomerDetails;
import com.doctormenu.DoctorDetails;
import java.util.Scanner;


import com.onlinedoctor.customer.Customers;
import com.onlinedoctor.customer.dao.CustomerDao;
import com.onlinedoctor.customer.dao.impl.CustomerDaoImpl;
import com.onlinedoctor.exception.SystemException;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
	private static Scanner scanner = new Scanner(System.in);

    public static void main( String[] args )
    {
    	CustomerDetails cd = new CustomerDetails();
    	DoctorDetails cs=new DoctorDetails();
        try {
        	boolean flag =true;
        	while(true) {
        		System.out.println("\n 1. Customer.");
				System.out.println("\n 2. Doctor.");
				System.out.println("\n 0. Exit");
				System.out.println("\n Enter your choice");
				
				int ch = Integer.parseInt(scanner.nextLine());
				switch (ch) {
				case 1:
                    cd.menu();
					break;
				case 2:
					cs.menu();
					break;
				case 0:
					 flag = false;
					break;
				default:
					System.out.println("Try again");
					break;
				}

        	}
        
        }catch (NumberFormatException e) {
			System.out.println("Number Format : " + e.getMessage());
		} catch (Exception e) {

			System.out.println("Error : " + e.getMessage());
		}
    }
}