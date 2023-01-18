package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.exception.courseException;
import com.modal.Course;
import com.utility.DBUTil;

public class CourseDaoImpl implements CourseDao{

	@Override
	public String addNewCourse(Course course) throws courseException {
		String cou=null;
		try (Connection conn=DBUTil.provideConnection()){
			PreparedStatement ps= conn.prepareStatement("insert into Course (cName,duration,fee) values(?,?,?)");
			ps.setString(1,course.getcName());
			ps.setString(2, course.getDuration());
			ps.setInt(3,course.getFee());
			int x=ps.executeUpdate();
			
			if(x>0) {
				cou=course.getcName()+":Is Inserted as a Course.";
			}
			else
			throw new courseException("Course Not Inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return cou;
	}
	

}