package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exception.administratortException;
import com.exception.batchException;
import com.exception.courseException;
import com.exception.studentException;
import com.modal.Batch;
import com.modal.Course;
import com.modal.Student;
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

	@Override
	public String updateCourseFee(String cName,String nFee) throws courseException {
		String fee=null;
		
		try (Connection conn=DBUTil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("update Course set fee=? where cName=?");
			ps.setString(1, nFee);
			ps.setString(2, cName);
			int x=ps.executeUpdate();
			if(x>0) {
				fee="Fee is Updated for Course : "+cName;
			}
			else 
				throw new courseException("Course fee not updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return fee;
	}

	@Override
	public String deleteCourse(String cName) throws courseException {
		
		String fee=null;
		
		try (Connection conn=DBUTil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("delete from Course where cName=?");
			ps.setString(1, cName);
			int x=ps.executeUpdate();
			if(x>0) {
				fee=cName+" is Deleted from CourseList : ";
			}
			else 
				throw new courseException("Invilade Course Name.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return fee;
	}

	@Override
	public Course informationAboutCourse(String cName) throws courseException {
		Course crs=null;
		try (Connection conn=DBUTil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from Course where cName=?");
			ps.setString(1, cName);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int i=rs.getInt("cId");
				String n=rs.getString("cName");
				String d=rs.getString("duration");
				int f=rs.getInt("fee");
				Course temp=new Course(i, n, d, f);
				crs=temp;
			}
			if(crs==null) {
				throw new courseException("Course not found with Course name :"+cName);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return crs;
	}

	@Override
	public String batchUnderCourse(Batch batch) throws batchException {
		String bt=null;
		try (Connection conn=DBUTil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("insert into Batch values(?,?,?,?)");
			ps.setString(1,batch.getbName());
			ps.setInt(2,batch.getcId());
			ps.setInt(3,batch.getSeats());
			ps.setInt(4,batch.getRoll());
			int x=ps.executeUpdate();
			
			if(x>0) {
				bt=batch.getbName()+" is successfully registered.";
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bt;
	}

	@Override
	public String registerAdministrator(Student student) throws administratortException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String loginAdministrator(String name, String pass) throws administratortException {
		String admin=null;
		try (Connection conn=DBUTil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("select * from Administrator where sEmail=? AND sPassword=?");
			ps.setString(1,name);
			ps.setString(2,pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				admin="Welcome "+rs.getString("sName");
			}else
				throw new administratortException("Invilade UserName or Password.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return admin;
	}
}