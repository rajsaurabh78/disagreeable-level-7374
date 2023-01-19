package com.dao;

import com.exception.administratortException;
import com.exception.batchException;
import com.exception.courseException;
import com.exception.studentException;
import com.modal.Batch;
import com.modal.Course;
import com.modal.Student;

public interface CourseDao {
	public String registerAdministrator(Student student)throws administratortException;
	public String loginAdministrator(String name,String pass)throws administratortException;
	public String addNewCourse(Course course) throws courseException;
	public String updateCourseFee(String cName,String nFee) throws courseException;
	public String deleteCourse(String cName) throws courseException;
	public Course informationAboutCourse(String cName) throws courseException;
	public String batchUnderCourse(Batch batch) throws batchException;
	
}
//1. Add a new Courses
//	2. Update Fees of course.
//	3. Delete  a course from any Training session.
//	4. Search information about a course.
//   5. Create Batch under a course.
//  6. Allocate students in a Batch under a course.
// 7. Update total seats of a batch.
// 8. View the students of every batch. 