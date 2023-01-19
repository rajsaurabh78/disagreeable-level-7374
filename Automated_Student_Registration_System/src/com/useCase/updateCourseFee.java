package com.useCase;

import java.util.Scanner;

import com.dao.CourseDao;
import com.dao.CourseDaoImpl;
import com.exception.courseException;

public class updateCourseFee {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CourseDao dao=new CourseDaoImpl();
		System.out.println("Enter following details for update a coures fee");
		while(true) {
			System.out.println("Enter Course Name");
			String n=sc.next();
			System.out.println("Enter Updated Fee");
			String f=sc.next();
			try {
				String res=dao.updateCourseFee(n, f);
				System.out.println(res);
			} catch (courseException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Do you want to Update more course fee ?(Y/N)");
			String res=sc.next();
			if(res.equalsIgnoreCase("n")) {
				System.out.println("Thanks for Using this System");
				break;
			}
		}

	}

}
