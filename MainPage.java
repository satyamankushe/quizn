package com.miniproject.Quiz;
import java.util.Scanner;
public class MainPage {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Student new_student=null;
		int choice;
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("|                   Core Java Quiz                    |");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("      Java Online Quiz – Test your knowledge in 5 min              ");
		System.out.println("----------------------------------------------------------");
		System.out.println("1) Examine Your skills in java by giving the test.");
		System.out.println("2) Test is based on Multiple-choice question(MCQs).");
		System.out.println("3) Before starting the quiz you need to register \n   so that we can track your progress.");
		do {
			System.out.println("----------------------------------------------------------");
		
		
			System.out.println("Enter your choice...");
			System.out.println("1.Student Registration");
			System.out.println("2.Start Quiz");
			System.out.println("3.Result");
			System.out.println("4.Exit");
			choice=sc.nextInt();
			switch(choice)
			{
				case 1:
					new_student=Student.getStudentInformation();	
					Student.studentRegistration(new_student);
					break;
				case 2:
					if(new_student!=null)
						Quiz.startQuiz();
					else
						System.out.println("Plz register before starting Quiz");
					break;
				case 3:
					System.out.println("Do you want to see result of all Student?(Y/N)");
					String answer=sc.next();
					if(answer.equals("Y") || answer.equals("y"))
					{
						Result.resultOfAllStudent();
					}
					else if(answer.equals("N")|| answer.equals("n"))
					{
						if(new_student!=null)
							Result.result(new_student);
						else
							System.out.println("Plz register before starting Quiz");
					}
					else
						System.out.println("Plz Enter valid input");
					break;
				case 4:
					System.exit(0);
				default:
					System.out.println("Plz Enter valid choice");
					break;
			}
		}while(choice<5 && choice>0);
			
	}

}
