package com.dao;
import com.exception.studentException;
import com.modal.Student;

public interface StudentDao {
	public String registerStudent(Student student)throws studentException;
	public String loginStudent(String name,String pass)throws studentException;
}
//1. Register himself in a course with a username and password 
//	(email should be the username)
//2. can update this details.
//3. can see all the available course list and their seat availability.