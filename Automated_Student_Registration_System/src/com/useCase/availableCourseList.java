package com.useCase;
import com.Color.Color;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.exception.courseException;
import com.main.Main;
import com.modal.availableCourse;

import java.util.*;
public class availableCourseList {

	public static void main(String[] args) {
		StudentDao dao=new StudentDaoImpl();
	Scanner sc=new Scanner(System.in);
			try {
				List<availableCourse> res1=dao.availableCourseList();
					res1.forEach(s->{
						System.out.println("Course id : "+s.getcId()+" , Course Name : "+s.getcName()+" , Batch : "+s.getbName()+" , Avalible Seats : "+s.getSeats());
					});

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
						Main.third();
					}	
			} catch (courseException e1) {
				
				System.out.println(e1.getMessage());
				Main.third();
				
			}

		}

	}
