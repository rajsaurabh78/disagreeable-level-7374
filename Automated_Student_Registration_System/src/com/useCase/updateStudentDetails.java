package com.useCase;

import java.util.Scanner;

import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.exception.studentException;
import com.modal.Student;

public class updateStudentDetails {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StudentDao dao=new StudentDaoImpl();
		System.out.println("Fill following details to register in a Course.");

			System.out.println("Enter Roll");
			int r=sc.nextInt();
			System.out.println("Enter New Email");
			String e=sc.next();
			System.out.println("Enter New Password");
			String ps=sc.next();
			System.out.println("Enter New Address");
			String ad=sc.next();
			System.out.println("Enter New Phone");
			String ph=sc.next();
			Student stu=new Student(r, e, e, ps, ad, ph, r);
			try {
				String res=dao.updateStudentDetails(stu);
				System.out.println(res);
			} catch (studentException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}
	}

}
