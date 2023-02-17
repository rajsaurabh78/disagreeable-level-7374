package com.useCase;

import java.util.Scanner;

import com.Color.Color;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.exception.studentException;
import com.main.Main;

public class loginStudent {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StudentDao dao=new StudentDaoImpl();
		System.out.println("Fill following details for login");
			System.out.println("Enter Email");
			String e=sc.next();
			System.out.println("Enter Password");
			String p=sc.next();
			try {
				String stu=dao.loginStudent(e, p);
				System.out.println(stu);
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
				System.out.println(e1.getMessage());
				Main.main(args);
			}catch (Exception e2) {
				System.out.println("Wrong Input");
				Main.third();;
			}
				
		}

	}
