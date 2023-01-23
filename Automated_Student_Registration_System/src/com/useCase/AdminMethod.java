package com.useCase;
import java.util.Scanner;
import com.dao.CourseDao;
import com.dao.CourseDaoImpl;
import com.exception.administratortException;
import com.modal.Administrator;
public class AdminMethod {

	public static void registerAdministrator() {
	
			Scanner sc=new Scanner(System.in);
			CourseDao dao=new CourseDaoImpl();
			System.out.println("Fill following details to register yourself");
				System.out.println("Enter Name");
				String n=sc.next();
				System.out.println("Enter Email");
				String e=sc.next();
				System.out.println("Enter Password");
				String p=sc.next();

				Administrator temp=new Administrator(0, n, e, p);
				try {
					String stu=dao.registerAdministrator(temp);
					System.out.println(stu);
				} catch (administratortException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.getMessage());
				}
					System.out.println("Thanks for Registering.");
					System.out.println();
					loginAdministrator.main(null);
			
		
	}
}
