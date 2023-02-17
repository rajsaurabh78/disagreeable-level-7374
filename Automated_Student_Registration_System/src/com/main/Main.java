package com.main;

import java.util.Scanner;

import com.Color.Color;
import com.useCase.AdminMethod;
import com.useCase.AllocateStudentBatch;
import com.useCase.StudentMethod;
import com.useCase.addNewCourse;
import com.useCase.availableCourseList;
import com.useCase.batchUnderCourse;
import com.useCase.deleteCourse;
import com.useCase.everyBatchStudentDetailsUseCase;
import com.useCase.loginAdministrator;
import com.useCase.loginStudent;
import com.useCase.registerINaCourse;
import com.useCase.searchInformationAboutCourse;
import com.useCase.updateCourseFee;
import com.useCase.updateStudentDetails;
import com.useCase.updateTotalSeatsInaBatch;
public class Main {
	static {
		System.out.println("Welcome Student registration system");
		System.out.println();
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		try {
			System.out.println(Color.ANSI_Red+"Register as Administrator then Type : 0"+"\n"+"Register as Student then Type : 1"+"\n"+"Login as Administrator then Type : 2"+"\n"+"Login as Student then Type : 3"+"\n"+"For Exit Type : 9"+Color.ANSI_RESET);
		int res=sc.nextInt();
		if(res==0) {
			AdminMethod.registerAdministrator();
			
		}else if(res==1) {
			StudentMethod.registerStudent();
			
		}else if(res==2) {
			loginAdministrator.main(args);
			
		}else if(res==3) {
			loginStudent.main(args);
			
		}else if(res==9) {
			Exit();

		}else {
			System.out.println("Wrong Input");
			main(args);
		}
		} catch (Exception e) {
			System.out.println("Wrong Input");
			main(args);
		}
		
		
		
	}
	public static void second() {
		try {
			System.out.println(Color.ANSI_Red+Color.ANSI_black_BACKGROUND+"For Adding a new Courses Type : 0"+"\n"+"Update Fees of Course Type : 1"+"\n"+"Delete  a course Type : 2"+"\n"+"Information about a Course Type : 3"+"\n"+"Create Batch under a course Type : 4"+"\n"+"Allocate students in a Batch under a course Type : 5"+"\n"+"Update total seats of a batch Type : 6"+"\n"+"View the students of every batch Type : 7"+"\n"+"For Exit Type : 9"+Color.ANSI_RESET);
		Scanner sc=new Scanner(System.in);
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

		}
		else if(res==9) {
			main(null);

		}else {
			System.out.println("wrong input");
			
		}
		} catch (Exception e) {
			System.out.println("wrong input");
			second();
		}
		
	}
	public static void third() {
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println(Color.ANSI_Red+Color.ANSI_black_BACKGROUND+"Register Yourself in a Course Type : 0"+"\n"+"Update Your Details Type : 1"+"\n"+"See all available Course and Seats Type : 2"+"\n"+"For Exit Type : 9"+Color.ANSI_RESET);
			int res=sc.nextInt();
			if(res==0) {
				registerINaCourse.main(null);
				
			}else if(res==1) {
				updateStudentDetails.main(null);
				
			}else if(res==2) {
				availableCourseList.main(null);
				
			}else if(res==9) {
				main(null);

			}else {
				System.out.println("Wrong Input");
				third();
			}
			
		} catch (Exception e) {
			System.out.println("Wrong Input");
			third();
		}
		
	}
	
	public static void Exit() {
		
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("Thanks for using my application."+"\n"+" ");
			System.out.println(Color.ANSI_Red+Color.ANSI_black_BACKGROUND+"For Start app Press 1"+Color.ANSI_RESET);
			int res=sc.nextInt();
			if(res==1) {
				System.out.println(Color.ANSI_blue+"Welcome back"+"\n"+" "+Color.ANSI_RESET);
				main(null);
				
			}else {
				System.out.println("Wrong Input");
				Exit();;
			}
			
		} catch (Exception e) {
			System.out.println("Wrong Input");
			Exit();
		}
		
	}

}
