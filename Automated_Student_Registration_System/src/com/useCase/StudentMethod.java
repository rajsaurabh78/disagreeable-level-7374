package com.useCase;

import java.util.Scanner;

import com.dao.CourseDao;
import com.dao.CourseDaoImpl;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.exception.studentException;
import com.modal.Student;

public class StudentMethod {
	public static void registerStudent() {
		
		Scanner sc=new Scanner(System.in);
		StudentDao dao=new StudentDaoImpl();
		System.out.println("Fill following details to register yourself");
			System.out.println("Enter Name");
			String n=sc.next();
			System.out.println("Enter Email");
			String e=sc.next();
			System.out.println("Enter Password");
			String p=sc.next();
			System.out.println("Enter Address");
			String a=sc.next();
			System.out.println("Enter Phone");
			String ph=sc.next();
			Student temp=new Student(0, n, e, p, a, ph, 0);
			try {
				String stu=dao.registerStudent(temp);
				System.out.println(stu);
			//	System.out.println("Thanks for Registering.");
				System.out.println();
				loginStudent.main(null);
			} catch (studentException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}
				
		}
	
}
