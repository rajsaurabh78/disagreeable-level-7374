package com.useCase;

import java.util.Scanner;

import com.Color.Color;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.exception.batchException;
import com.exception.courseException;
import com.exception.studentException;
import com.main.Main;

public class registerINaCourse {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StudentDao dao=new StudentDaoImpl();
		System.out.println("Fill following details to register in a Course.");
	//	while(true) {
			System.out.println("Enter Email");
			String e=sc.next();
			System.out.println("Enter Password");
			String p=sc.next();
			System.out.println("Enter Course Id");
			int ph=sc.nextInt();
			
			try {
				String res1=dao.registerINaCourse(e, p, ph);
				System.out.println(res1);
				System.out.println();
				System.out.println(Color.ANSI_Red+Color.ANSI_black_BACKGROUND+"Register Yourself in a Course Type : 0"+"\n"+"Update Your Details Type : 1"+"\n"+"See all available Course and Seats Type : 2"+"\n"+"For Main menu Press 9"+Color.ANSI_RESET);
				int res=sc.nextInt();
				if(res==0) {
					registerINaCourse.main(args);
					
				}else if(res==1) {
					updateStudentDetails.main(args);
					
				}else if(res==2) {
					availableCourseList.main(args);
					
				}else {
					System.out.println("Wrong Input");
					Main.third();;
				}
			} catch (batchException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Main.third();
			} catch (studentException e1) {
				// TODO Auto-generated catch block
				Main.third();
				e1.printStackTrace();
			} catch (courseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				Main.third();
			}
				
			
			
//				System.out.println("Do you want to inrolled in other Course ?(Y/N)");
//				String res=sc.next();
//				if(res.equalsIgnoreCase("N")) {
//					System.out.println("Thanks");
//					break;
//				}	
//				
//			}
		}
	}
