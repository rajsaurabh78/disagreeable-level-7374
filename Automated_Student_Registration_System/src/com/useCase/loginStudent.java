package com.useCase;

import java.util.Scanner;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.exception.studentException;
import com.modal.Student;

public class loginStudent {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StudentDao dao=new StudentDaoImpl();
		System.out.println("Fill following details for login");
			System.out.println("Enter Email");
			String e=sc.next();
			System.out.println("Enter Password");
			String p=sc.next();
			try {
				String stu=dao.loginStudent(e, p);
				System.out.println(stu);
			} catch (studentException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}
				System.out.println("Thanks");
		}

	}
