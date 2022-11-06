package com.miniproject.Quiz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Result {
	String Mobile_Number;
	String Name;
	
	public static void result(Student student)
	{
		String Class=null;
		int marks = 0;
		String query="select student_name, marks from student where student_name=? AND mobile_number=?";
		try
		{
		Connection connection=DBConnection.connection();
		
		PreparedStatement pst=connection.prepareStatement(query);
		pst.setString(1,student.getStudentName());
		pst.setInt(2,Integer.parseInt(student.getMobileNumber()));
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			
			marks=rs.getInt(2);
			if(marks>8 && marks<=10)
				Class="A";
			else if(marks>6 && marks<=8)
				Class="B";
			else if(marks==5)
				Class="C";
			else
				Class="Fail";
			System.out.println(rs.getString(1)+" your Score is=");
			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			System.out.println("|                 "+marks+"                   |");
			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			System.out.println("|            "+Class+" Grade                  |");
			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		}
		query="update student SET marks=? where student_name=? AND mobile_number=?";
		PreparedStatement pst2=connection.prepareStatement(query);
		pst2.setInt(1,marks);
		pst2.setString(2, student.getStudentName());
		pst2.setInt(3,Integer.parseInt(student.getMobileNumber()));
		int rowsAffected=pst2.executeUpdate();
		if(rowsAffected!=0)
			System.out.println("Marks updated in table");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public static void resultOfAllStudent()
	{
		String query=null,stud_name,address,email_id;
		int stud_id,mobile_number,marks;
		try
		{
		query="select * from student ORDER BY Marks desc";
		Connection connection=DBConnection.connection();
		
		PreparedStatement pst=connection.prepareStatement(query);
		ResultSet rs=pst.executeQuery();
		
		System.out.println("________________________________________________________________________________________________________________________");
		System.out.println("|Student ID \t| Student Name \t| Student Address\t| Email_ID \t| Marks |");
		while(rs.next())
		{
			System.out.println("____________________________________________________________________________________________________________________");
			stud_id=rs.getInt("Stud_id");
			stud_name=rs.getString("student_name");
			address=rs.getString("Address");
			mobile_number=rs.getInt("Mobile_Number");
			email_id=rs.getString("Email_id");
			marks=rs.getInt("Marks");
			System.out.println("|"+stud_id+"\t\t| "+stud_name+"\t\t| "+address+"\t\t| "+mobile_number+"\t| "+email_id+"\t\t| "+marks+"|");
			
		}
		System.out.println("_________________________________________________________________________________________________________________________");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
