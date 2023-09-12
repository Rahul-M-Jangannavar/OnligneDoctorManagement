package doctordaoimpl;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.onlinedoctor.util.DBUtil;
import doctordao.DoctorDao;
//import com.onlinedoctor.exception.;

import com.onlinedoctor.customer.Doctors;
public class DoctorDaoImpl implements DoctorDao {
	private static final String INSERT_APPOINT="insert into appointments(c_id,emailId,city,doctorName,appo_date )values(?,?,?,?,?)";
	private static final String SELECT_APPOINT="select * from appointments";
	//	private static final Strong DELETE_CUSTOMER="delete into employees()"
	private static final String DELETE_CUSTOMER="DELETE FROM appointments WHERE mid=?";
	private static final String SINGLE_RECORD="select * from appointments WHERE mid=?";
////	private static final String UPDATE_CUSTOMER="update customers set ";
	private static String UPDATE_APPOINTMENT = null;
	private static Scanner sc = new Scanner(System.in);
	private  Connection connection=DBUtil.getConnection(); 
	
	public boolean bookappoint(Doctors msEntity) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(INSERT_APPOINT);
//		ps.setString(1, msEntity.getFirstName());
//		ps.setString(2, msEntity.getLastName());
//		ps.setString(3,msEntity.getPhoneNumber());
		ps.setInt(1, msEntity.getcId());
		ps.setString(2, msEntity.getEmailId());
		ps.setString(3, msEntity.getCity());
		ps.setString(4, msEntity.getDoctorName());
		ps.setString(5, msEntity.getAppointmentDate());
		int excecuteUpdate = ps.executeUpdate();
		ps.close();
	//	System.out.println("your mid is : "+msEntity.setmId()); wanna do
		if(excecuteUpdate>0) {
			return true;
		}
		return false;
	}
	public void singleRecord(int id) throws SQLException{
	//	System.out.println("hii");
		PreparedStatement ps = connection.prepareStatement(SINGLE_RECORD);
		System.out.println(id);
		ps.setInt(1, id);
		ResultSet res = ps.executeQuery();
		if(res.next()) {

			Doctors ms = new Doctors();
			ms.setmId(res.getInt("mid"));
			ms.setcId(res.getInt("c_id"));
			ms.setEmailId(res.getString("emailId"));
			ms.setCity(res.getString("City"));
			ms.setDoctorName(res.getString("doctorName"));
			ms.setAppointmentDate(res.getString("appo_date"));
		System.out.println("Your details are: Id= "+ms.getmId()+",Customer id= " + ms.getcId() +",emailid= " + ms.getEmailId()+ ",city= " + ms.getCity()+",Doctor name ="+ms.getDoctorName()+",date of appointment"+ms.getAppointmentDate() );
		}
		else {
			System.out.println("Appointment not found with id: "+id);
		}
	}
	public List<Doctors>  selectAll() throws SQLException {
		List<Doctors> myList = new ArrayList<Doctors>();
	PreparedStatement ps = connection.prepareStatement(SELECT_APPOINT);
	ResultSet res = ps.executeQuery();
//	if(res.next()==true) {
	while(res.next()) {
		Doctors ms = new Doctors();
		ms.setmId(res.getInt("mid"));
		ms.setcId(res.getInt("c_id"));
//		ms.setFirstName(res.getString("First_name"));
//		ms.setLastName(res.getString("last_name"));
//		ms.setPhoneNumber(res.getString("phone_number"));
		ms.setEmailId(res.getString("emailId"));
		ms.setCity(res.getString("city"));
		ms.setDoctorName(res.getString("doctorName"));
		ms.setAppointmentDate(res.getString("appo_date"));
		myList.add(ms);
		
		}
//	}
//	else {
//		System.out.println("Records not found");
//	}
	return myList;
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
			return true;
		}
		return false;
	}
	
	public void modify(int id) throws SQLException{
		while(true) {
			System.out.println("Choose appointment update details");
			
			
			System.out.println("\n 1.emailid");
			System.out.println("\n 2.City");
			System.out.println("\n 3.Date");
			System.out.println("\n 4.Doctor Name");
			System.out.println("\n 0.Exit");
			
			int uid=Integer.parseInt(sc.nextLine());
			switch(uid) {
			
			case 1:
				System.out.println("Enter emailId");
				String newemailId = sc.nextLine();
				PreparedStatement ps1 = connection.prepareStatement("update appointments set emailId=? where mid=?");
				ps1.setString(1,newemailId);
				ps1.setInt(2,id);
				 int executeUpdate1 = ps1.executeUpdate();
				System.out.println("new updated details are ");
				singleRecord(id);
				break;
			case 2:
				System.out.println("Enter new city");
				String newcity = sc.nextLine();
				PreparedStatement ps2 = connection.prepareStatement("update appointments set city=? where mid=?");
				ps2.setString(1,newcity);
				ps2.setInt(2,id);
				 int executeUpdate2 = ps2.executeUpdate();
				System.out.println("new updated details are ");
				singleRecord(id);
				break;
			case 3:
				
				System.out.println("Enter new Date for your appointment");
				String newdate  = sc.nextLine();
				PreparedStatement ps3 = connection.prepareStatement("update appointments set appo_date=? where mid=?");
				ps3.setString(1,newdate);
				ps3.setInt(2,id);
				 int executeUpdate3 = ps3.executeUpdate();
				System.out.println("new updated details are ");
				singleRecord(id);
				break;
			case 4:
				System.out.println("Enter new Doctor name");
				String newDoctorName  = sc.nextLine();
				PreparedStatement ps4 = connection.prepareStatement("update appointments set doctorName=? where mid=?");
				ps4.setString(1,newDoctorName);
				ps4.setInt(2,id);
				int executeUpdate4 = ps4.executeUpdate();
				System.out.println("new updated details are ");
				singleRecord(id);
				break;
			case 0:
				System.exit(0);
				default:
					System.out.println("Try again");
			
			}
			
		}
		
		
	}
}