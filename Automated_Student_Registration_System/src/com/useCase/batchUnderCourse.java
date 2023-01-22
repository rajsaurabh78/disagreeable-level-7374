package com.useCase;
import java.util.Scanner;
import com.dao.CourseDao;
import com.dao.CourseDaoImpl;
import com.exception.batchException;
import com.modal.Batch;
public class batchUnderCourse {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CourseDao dao=new CourseDaoImpl();
		System.out.println("Fill following details to add a batch in Course");
		while(true) {
			System.out.println("Enter Batch Name");
			String n=sc.next();
			System.out.println("Enter Course Id");
			int cid=sc.nextInt();
			System.out.println("Enter Number of seats");
			int s=sc.nextInt();
			Batch temp =new Batch(n, cid, s, 0);
			
				
				try {
				String	bt = dao.batchUnderCourse(temp);
				System.out.println(bt);
				} catch (batchException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Do you want to add more Batch ?(Y/N)");
				String res=sc.next();
				if(res.equalsIgnoreCase("N")){
				System.out.println("Thanks For Using This System.");
				break;
			}
		}

	}

}
