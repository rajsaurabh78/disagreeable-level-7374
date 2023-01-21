package com.useCase;

import java.util.Scanner;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.exception.batchException;
import com.exception.courseException;
import com.exception.studentException;
import com.modal.Student;
import com.modal.availableCourse;

public class registerINaCourse {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StudentDao dao=new StudentDaoImpl();
		System.out.println("Fill following details to register in a Course.");
		while(true) {
			System.out.println("Enter Email");
			String e=sc.next();
			System.out.println("Enter Password");
			String p=sc.next();
			System.out.println("Enter Course Id");
			int ph=sc.nextInt();
			
			try {
				String res=dao.registerINaCourse(e, p, ph);
				System.out.println(res);
			} catch (batchException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (studentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (courseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			
			
				System.out.println("Do you want to inrolled in other Course ?(Y/N)");
				String res=sc.next();
				if(res.equalsIgnoreCase("N")) {
					System.out.println("Thanks");
					break;
				}	
				
			}
		}
	}
