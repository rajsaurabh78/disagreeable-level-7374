package com.main;

import java.util.Scanner;

import com.Color.Color;
import com.useCase.AdminMethod;
import com.useCase.StudentMethod;
import com.useCase.loginAdministrator;
import com.useCase.loginStudent;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println(Color.ANSI_Red+"Register as Administrator then Type : 0"+"\n"+"Register as Student then Type : 1"+"\n"+"Login as Administrator then Type : 2"+"\n"+"Login as Student then Type : 3"+Color.ANSI_RESET);
		int res=sc.nextInt();
		if(res==0) {
			AdminMethod.registerAdministrator();
			
		}else if(res==1) {
			StudentMethod.registerStudent();
			
		}else if(res==2) {
			loginAdministrator.main(args);
			
		}else if(res==3) {
			loginStudent.main(args);
			
		}else {
			System.out.println("Wrong Input");
		}
	}
	
	

}
