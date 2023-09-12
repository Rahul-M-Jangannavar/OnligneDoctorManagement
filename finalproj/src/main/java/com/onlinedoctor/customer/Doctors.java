package com.onlinedoctor.customer;


import java.time.LocalDateTime;

public class Doctors extends Object{
	//Instance variables we will use
	private int mId;
	private int cId;
	private String emailId;
	private String City;
	private String appointmentDate;
	private String DoctorName;
	public int getcId() {
		return cId;
	}
	public void setcId(int cid) {
		cId = cid;
	}
	
	public String getDoctorName() {
		return DoctorName;
	}
	public void setDoctorName(String doctorName) {
		DoctorName = doctorName;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
//	public String getFirstName() {
//		return firstName;
//	}
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//	public String getLastName() {
//		return lastName;
//	}
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//	public String getPhoneNumber() {
//		return phoneNumber;
//	}
//	public void setPhoneNumber(String phoneNumber) {
//		this.phoneNumber = phoneNumber;
//	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailid) {
		this.emailId = emailid;
	}
	
//	@Override
	public String toString() {
		return "Doctors [Appointment id=" + mId + ",Customer id ="+ cId +", EmailId="+emailId
				+", City= "+City+" ,Doctor Name= "+DoctorName+" ,Appointment Date= "+ appointmentDate+"]";
	}
	
	

}
