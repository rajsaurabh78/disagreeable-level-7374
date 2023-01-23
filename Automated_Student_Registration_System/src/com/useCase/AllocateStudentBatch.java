package com.useCase;

import java.util.Scanner;

import com.Color.Color;
import com.dao.CourseDao;
import com.dao.CourseDaoImpl;
import com.exception.batchException;
import com.main.Main;

public class AllocateStudentBatch {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CourseDao dao=new CourseDaoImpl();
		System.out.println("Enter following Details for Allocate a Batch for a Student.");
		
	//	while(true) {
			System.out.println("Enter Roll No");
			int r=sc.nextInt();
			System.out.println("Enter Course Id");
			int c=sc.nextInt();
			System.out.println("Enter Batch Id");
			int b=sc.nextInt();
			
			try {
				String res2=dao.AllocateStudentBatch(r, c, b);
				System.out.println(res2);
				System.out.println();
				System.out.println(Color.ANSI_Red+Color.ANSI_black_BACKGROUND+"For Adding a new Courses Type : 0"+"\n"+"Update Fees of Course Type : 1"+"\n"+"Delete  a course Type : 2"+"\n"+"Information about a Course Type : 3"+"\n"+"Create Batch under a course Type : 4"+"\n"+"Allocate students in a Batch under a course Type : 5"+"\n"+"Update total seats of a batch Type : 6"+"\n"+"View the students of every batch Type : 7"+"\n"+"For Main Menu Type : 9"+Color.ANSI_RESET);
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
	
				}else {
					Main.main(args);
				}
			} catch (batchException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
//			System.out.println("Do you want to Allocate other Student tpp. ? (Y/N)");
//			String res1=sc.next();
//			if(res1.equalsIgnoreCase("N")) {
//				System.out.println("Thanks ");
//				break;
//			}
//		}

	}

}
