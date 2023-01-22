package com.useCase;

import java.util.Scanner;

import com.dao.CourseDao;
import com.dao.CourseDaoImpl;
import com.exception.batchException;
import com.exception.courseException;

public class updateTotalSeatsInaBatch {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CourseDao dao=new CourseDaoImpl();
		System.out.println("Enter following details for update Total Seats in a Batch");
		while(true) {
			System.out.println("Enter Batch Id");
			int i=sc.nextInt();
			System.out.println("Enter Updated Seats");
			int s=sc.nextInt();
			try {
				String res=dao.updateTotalSeatsInaBatch(i, s);
				System.out.println(res);
			} catch (batchException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Do you want to Update other Batch seats also. ?(Y/N)");
			String res=sc.next();
			if(res.equalsIgnoreCase("n")) {
				System.out.println("Thanks for Using this System");
				break;
			}
		}

	}

}
