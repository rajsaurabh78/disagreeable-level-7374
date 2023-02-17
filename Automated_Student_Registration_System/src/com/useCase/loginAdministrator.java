package com.useCase;

import java.util.Scanner;

import com.Color.Color;
import com.dao.CourseDao;
import com.dao.CourseDaoImpl;
import com.exception.administratortException;
import com.main.Main;

public class loginAdministrator {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CourseDao dao=new CourseDaoImpl();
		System.out.println("Fill following details for login");
			System.out.println("Enter Email");
			String e=sc.next();
			System.out.println("Enter Password");
			String p=sc.next();
			try {
				String stu=dao.loginAdministrator(e, p);
				System.out.println(stu);
				System.out.println();
				System.out.println(Color.ANSI_Red+Color.ANSI_black_BACKGROUND+"For Adding a new Courses Type : 0"+"\n"+"Update Fees of Course Type : 1"+"\n"+"Delete  a course Type : 2"+"\n"+"Information about a Course Type : 3"+"\n"+"Create Batch under a course Type : 4"+"\n"+"Allocate students in a Batch under a course Type : 5"+"\n"+"Update total seats of a batch Type : 6"+"\n"+"View the students of every batch Type : 7"+"\n"+"For Exit Type : 9"+Color.ANSI_RESET);
				int res=sc.nextInt();
				if(res==0) {
					addNewCourse.main(null);
	
				}else if(res==1) {
					updateCourseFee.main(null);
	
				}else if(res==2) {
					deleteCourse.main(null);
	
				}else if(res==3) {
					searchInformationAboutCourse.main(null);
	
				}else if(res==4) {
					batchUnderCourse.main(null);
	
				}else if(res==5) {
					AllocateStudentBatch.main(null);
	
				}else if(res==6) {
					updateTotalSeatsInaBatch.main(null);
	
				}else if(res==7) {
					everyBatchStudentDetailsUseCase.main(null);
	
				}else if(res==9) {
					Main.Exit();
	
				}else {
					System.out.println("wrong input");
					Main.second();
				}
			} catch (administratortException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
				Main.main(args);
			} catch (Exception e2) {
				System.out.println("wrong input");
				Main.second();
			}
		}

	}

