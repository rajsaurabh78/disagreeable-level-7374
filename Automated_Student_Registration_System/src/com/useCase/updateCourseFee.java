package com.useCase;

import java.util.Scanner;

import com.Color.Color;
import com.dao.CourseDao;
import com.dao.CourseDaoImpl;
import com.exception.courseException;
import com.main.Main;

public class updateCourseFee {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CourseDao dao=new CourseDaoImpl();
		System.out.println("Enter following details for update a coures fee");
	//	while(true) {
			System.out.println("Enter Course Name");
			String n=sc.next();
			System.out.println("Enter Updated Fee");
			String f=sc.next();
			try {
				String res1=dao.updateCourseFee(n, f);
				System.out.println(res1);
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
					Main.second();;
				}
			} catch (courseException e) {
				System.out.println(e.getMessage());
				Main.second();
			}
//			System.out.println("Do you want to Update more course fee ?(Y/N)");
//			String res2=sc.next();
//			if(res2.equalsIgnoreCase("n")) {
//				System.out.println("Thanks for Using this System");
//				break;
//			}
//		}

	}

}
