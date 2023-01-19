package com.useCase;

import java.util.Scanner;

import com.dao.CourseDao;
import com.dao.CourseDaoImpl;
import com.exception.courseException;
import com.modal.Course;

public class searchInformationAboutCourse {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CourseDao dao=new CourseDaoImpl();
		System.out.println("Enter following details for get information about Course");
		while(true) {
			System.out.println("Enter Course Name");
			String n=sc.next();
			try {
				Course res=dao.informationAboutCourse(n);
				System.out.println("Course Id is: "+res.getcId());
				System.out.println("Course Name is: "+res.getcName());
				System.out.println("Course Duration is: "+res.getDuration());
				System.out.println("Course Fee is: "+res.getFee());
			} catch (courseException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Do you want to know any other course details?(Y/N)");
			String res=sc.next();
			if(res.equalsIgnoreCase("n")) {
				System.out.println("Thanks for Using this System.");
				break;
			}
		}

	}

}
