package com.useCase;

import java.util.List;

import com.dao.CourseDao;
import com.dao.CourseDaoImpl;
import com.exception.studentException;
public class everyBatchStudentDetails {

	public static void main(String[] args) {
		
		CourseDao dao=new CourseDaoImpl();
		try {
			List<everyBatchStudentDetails> res=dao.everyBatchStudentDetails();
			res.forEach(s->{
				System.out.println(s);
			});
		} catch (studentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
