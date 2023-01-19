package com.useCase;

import java.util.Scanner;

import com.dao.CourseDao;
import com.dao.CourseDaoImpl;
import com.exception.administratortException;

public class loginAdministrator {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CourseDao dao=new CourseDaoImpl();
		System.out.println("Fill following details for login");
			System.out.println("Enter Email");
			String e=sc.next();
			System.out.println("Enter Password");
			String p=sc.next();
			try {
				String stu=dao.loginAdministrator(e, p);
				System.out.println(stu);
			} catch (administratortException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}
				System.out.println("Thanks");
		}

	}
