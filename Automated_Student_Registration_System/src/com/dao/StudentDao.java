package com.dao;
import java.util.List;

import com.exception.batchException;
import com.exception.courseException;
import com.exception.studentException;
import com.modal.Student;
import com.modal.availableCourse;

public interface StudentDao {
	public String registerStudent(Student student)throws studentException;
	public String loginStudent(String name,String pass)throws studentException;
	public List<availableCourse> availableCourseList()throws courseException;
	public String registerINaCourse(String username,String password,int cId)throws batchException;
}	
//1. Register himself in a course with a username and password
//	(email should be the username)
//2. can update this details.
//3. can see all the available course list and their seat availability.