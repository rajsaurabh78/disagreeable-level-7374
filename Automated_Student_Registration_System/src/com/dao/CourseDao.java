package com.dao;

import java.util.List;
import com.exception.administratortException;
import com.exception.batchException;
import com.exception.courseException;
import com.exception.studentException;
import com.modal.Administrator;
import com.modal.Batch;
import com.modal.Course;
import com.modal.everyBatchStudentDetails;
public interface CourseDao {
	public String registerAdministrator(Administrator administrator)throws administratortException;
	public String loginAdministrator(String name,String pass)throws administratortException;
	public String addNewCourse(Course course) throws courseException;
	public String updateCourseFee(String cName,String nFee) throws courseException;
	public String deleteCourse(String cName) throws courseException;
	public Course informationAboutCourse(String cName) throws courseException;
	public String batchUnderCourse(Batch batch) throws batchException;
	public String updateTotalSeatsInaBatch(int bId,int uSeat) throws batchException;
	public String AllocateStudentBatch(int roll,int cId,int bId)throws batchException;
	public List<everyBatchStudentDetails> everyBatchStudentDetails()throws studentException;
	
}
//registered
//login
//1. Add a new Courses DONE
//	2. Update Fees of course.Done
//	3. Delete  a course from any Training session.Done
//	4. Search information about a course.Done
//   5. Create Batch under a course.Done
//  6. Allocate students in a Batch under a course.Done
// 7. Update total seats of a batch.Done
// 8. View the students of every batch. 