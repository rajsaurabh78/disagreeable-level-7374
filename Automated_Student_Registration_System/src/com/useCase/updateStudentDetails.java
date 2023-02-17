package com.useCase;

import java.util.Scanner;

import com.Color.Color;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.exception.studentException;
import com.main.Main;
import com.modal.Student;

public class updateStudentDetails {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StudentDao dao=new StudentDaoImpl();
		System.out.println("Fill following details to register in a Course.");

			System.out.println("Enter Roll");
			int r=sc.nextInt();
			System.out.println("Enter New Email");
			String e=sc.next();
			System.out.println("Enter New Password");
			String ps=sc.next();
			System.out.println("Enter New Address");
			String ad=sc.next();
			System.out.println("Enter New Phone");
			String ph=sc.next();
			Student stu=new Student(r, e, e, ps, ad, ph, r);
			try {
				String res1=dao.updateStudentDetails(stu);
				System.out.println(res1);
				System.out.println();
				System.out.println(Color.ANSI_Red+Color.ANSI_black_BACKGROUND+"Register Yourself in a Course Type : 0"+"\n"+"Update Your Details Type : 1"+"\n"+"See all available Course and Seats Type : 2"+"\n"+"For Exit Press 9"+Color.ANSI_RESET);
				int res=sc.nextInt();
				if(res==0) {
					registerINaCourse.main(args);
					
				}else if(res==1) {
					updateStudentDetails.main(args);
					
				}else if(res==2) {
					availableCourseList.main(args);
					
				}else if(res==9) {
					Main.Exit();
	
				}else {
					System.out.println("Wrong Input");
					Main.third();;
				}
			} catch (studentException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
				Main.third();
			}
	}

}
