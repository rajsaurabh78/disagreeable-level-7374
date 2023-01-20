package com.useCase;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.exception.courseException;
import com.modal.availableCourse;

import java.util.*;
public class availableCourseList {

	public static void main(String[] args) {
		StudentDao dao=new StudentDaoImpl();
	
			try {
				List<availableCourse> res=dao.availableCourseList();
					res.forEach(s->{
						System.out.println("Course id : "+s.getcId()+" , Course Name : "+s.getcName()+" , Batch : "+s.getbName()+" , Avalible Seats : "+s.getSeats());
					});

			} catch (courseException e1) {
				
				System.out.println(e1.getMessage());
				
			}

		}

	}
