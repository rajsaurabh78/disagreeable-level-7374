package com.useCase;

import java.util.List;

import com.dao.CourseDao;
import com.dao.CourseDaoImpl;
import com.exception.studentException;
import com.modal.everyBatchStudentDetails;
public class everyBatchStudentDetailsUseCase {

	public static void main(String[] args) {
		
		CourseDao dao=new CourseDaoImpl();
		try {
			List<everyBatchStudentDetails> res=dao.everyBatchStudentDetails();
			res.forEach(s->{
				System.out.println("Name          : "+s.getsName());
				System.out.println("Roll No       : "+s.getRoll());
				System.out.println("Email         : "+s.getsEmail());
				System.out.println("Address       : "+s.getAddress());
				System.out.println("Phone No      : "+s.getPhone());
				System.out.println("Course Id     : "+s.getcId());
				System.out.println("Course Name   : "+s.getcName());
				System.out.println("Batch Id      : "+s.getbId());
				System.out.println("Batch Name    : "+s.getbName());
				System.out.println("=================================");
			});
		} catch (studentException e) {
			System.out.println(e.getMessage());
		}

	}

}
