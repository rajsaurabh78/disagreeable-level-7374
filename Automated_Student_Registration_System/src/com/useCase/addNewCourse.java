package com.useCase;

import java.util.Scanner;

import com.dao.CourseDao;
import com.dao.CourseDaoImpl;
import com.exception.courseException;
import com.modal.Course;

public class addNewCourse {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CourseDao dao=new CourseDaoImpl();
		System.out.println("Fill following details to add a new Course");
		while(true) {
			System.out.println("Enter Course Name");
			String n=sc.next();
			System.out.println("Enter Course Duration");
			String d=sc.next();
			System.out.println("Enter Course Fee");
			int f=sc.nextInt();
			Course temp=new Course(0, n, d, f);
			try {
				String cou=dao.addNewCourse(temp);
				System.out.println(cou);
			} catch (courseException e) {
				
				System.out.println(e.getMessage());
			}
				System.out.println("Do you want to add more Course ?(Y/N)");
				String res=sc.next();
				if(res.equalsIgnoreCase("N")){
				System.out.println("Thanks For Using This System.");
				break;
			}
		}
	}
}
