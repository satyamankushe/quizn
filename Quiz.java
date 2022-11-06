package com.miniproject.Quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Quiz {
 public static void startQuiz()
 {
	 	int question_id,Q_count=1,marks=0;
	 	String question, user_answer,option1,option2,option3,option4,correct_answer,explaination;
	 	Scanner sc=new Scanner(System.in);
		String query="select * from QuestionBank Order by RAND()";
		try
		{
			Connection connection=DBConnection.connection();
			
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				question_id=rs.getInt("id");
				question=rs.getString("Question");
				option1=rs.getString("Option_1");
				option2=rs.getString("Option_2");
				option3=rs.getString("Option_3");
				option4=rs.getString("Option_4");
				correct_answer=rs.getString("Answer");
				explaination=rs.getString("Explaination");
				System.out.println("----------------------------------------");
				System.out.println("Q "+(Q_count++)+"]"+question);
				System.out.println("A)"+option1);
				System.out.println("B)"+option2);
				System.out.println("C)"+option3);
				System.out.println("D)"+option4);
				System.out.println("SELECT YOUR ANSWER");
				user_answer=sc.next();
				if(user_answer.equals(correct_answer))
				{
					marks++;
					System.out.println("Your Answer is Correct");
					System.out.println("Your Score is : "+marks);
				}	
				else
				{
					System.out.println("Your Answer is Wrong");
					System.out.println("-------------------------------------");
					System.out.println("Correct Answer is: "+correct_answer);
					System.out.println("Explaination:"+explaination);
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
 }
}
