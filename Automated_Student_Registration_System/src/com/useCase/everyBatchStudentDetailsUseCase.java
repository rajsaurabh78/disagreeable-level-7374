package com.useCase;

import java.util.List;
import java.util.Scanner;

import com.Color.Color;
import com.dao.CourseDao;
import com.dao.CourseDaoImpl;
import com.exception.studentException;
import com.main.Main;
import com.modal.everyBatchStudentDetails;
public class everyBatchStudentDetailsUseCase {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CourseDao dao=new CourseDaoImpl();
		try {
			List<everyBatchStudentDetails> res1=dao.everyBatchStudentDetails();
			res1.forEach(s->{
				System.out.println("Name          : "+s.getsName());
				System.out.println("Roll No       : "+s.getRoll());
				System.out.println("Email         : "+s.getsEmail());
				System.out.println("Address       : "+s.getAddress());
				System.out.println("Phone No      : "+s.getPhone());
				System.out.println("Course Id     : "+s.getcId());
				System.out.println("Course Name   : "+s.getcName());
				System.out.println("Batch Id      : "+s.getbId());
				System.out.println("Batch Name    : "+s.getbName());
				System.out.println("=================================");
				
			});
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
		} catch (studentException e) {
			System.out.println(e.getMessage());
		}

	}

}
