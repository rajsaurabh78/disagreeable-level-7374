package com.useCase;

import java.util.Scanner;

import com.dao.CourseDao;
import com.dao.CourseDaoImpl;
import com.exception.batchException;

public class AllocateStudentBatch {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CourseDao dao=new CourseDaoImpl();
		System.out.println("Enter following Details for Allocate a Batch for a Student.");
		
		while(true) {
			System.out.println("Enter Roll No");
			int r=sc.nextInt();
			System.out.println("Enter Course Id");
			int c=sc.nextInt();
			System.out.println("Enter Batch Id");
			int b=sc.nextInt();
			
			try {
				String res=dao.AllocateStudentBatch(r, c, b);
				System.out.println(res);
			} catch (batchException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			System.out.println("Do you want to Allocate other Student tpp. ? (Y/N)");
			String res=sc.next();
			if(res.equalsIgnoreCase("N")) {
				System.out.println("Thanks ");
				break;
			}
		}

	}

}
