package com.miniproject.Quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {
	String studentName;
	String mobileNumber;
	String emailAddress;
	Address address;

	static Scanner sc=new Scanner(System.in);
	
	String getStudentName() {
		return studentName;
	}
	void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	String getMobileNumber() {
		return mobileNumber;
	}
	void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	String getEmailAddress() {
		return emailAddress;
	}
	void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	String getAddress() {
		return address.toString();
	}
	void setAddress(Address address) {
		this.address = address;
	}
	
	 public static Student getStudentInformation()
	 {
		 Student student=new Student();
		 System.out.println("Enter your full name");
		 student.setStudentName(sc.nextLine());
		 System.out.println("Enter mobile number");
		 //sc.next()
		 student.setMobileNumber(sc.nextLine());
		 System.out.println("Enter email id");
		 student.setEmailAddress(sc.nextLine());
		 System.out.println("Enter your Addres \ncity=");
		 String city=sc.nextLine();
		 System.out.println("Street=");
		 String street=sc.nextLine();
		 System.out.println("Pincode=");
		 int pincode=sc.nextInt();
		 student.setAddress(new Address(city,street,pincode)); 
		 return student;
	 }
	 public static void studentRegistration(Student student)
	 {
		 Connection connection=DBConnection.connection();
		 String query = "insert into student (Student_Name,Address,Mobile_Number,Email_id) values(?,?,?,?)";
		try {
			PreparedStatement pst=connection.prepareStatement(query);
			pst.setString(1,student.getStudentName());
			pst.setString(2,student.getAddress());
			pst.setInt(3,Integer.parseInt(student.getMobileNumber()));
			pst.setString(4,student.getEmailAddress());
			
			int rowsAffected=pst.executeUpdate();
			if(rowsAffected!=0)
				System.out.println("Register Successfully..");
			else
				System.out.println("Opps Network Error..");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
}
