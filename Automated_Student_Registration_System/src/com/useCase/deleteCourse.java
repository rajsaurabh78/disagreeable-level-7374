package com.useCase;

import java.util.Scanner;

import com.dao.CourseDao;
import com.dao.CourseDaoImpl;
import com.exception.courseException;

public class deleteCourse {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CourseDao dao=new CourseDaoImpl();
		System.out.println("Enter following details to Delete a course.");
		while(true) {
			System.out.println("Enter Course Name");
			String n=sc.next();
			try {
				String res=dao.deleteCourse(n);
				System.out.println(res);
			} catch (courseException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Do you want to Delete more course?(Y/N)");
			String res=sc.next();
			if(res.equalsIgnoreCase("n")) {
				System.out.println("Thanks for Using this System.");
				break;
			}
		}

	}

}
