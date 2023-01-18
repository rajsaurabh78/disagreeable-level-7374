package com.dao;

import com.exception.courseException;
import com.modal.Course;

public interface CourseDao {
	public String addNewCourse(Course course) throws courseException;
}
