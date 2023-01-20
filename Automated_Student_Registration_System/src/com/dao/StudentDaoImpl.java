package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.exception.batchException;
import com.exception.courseException;
import com.exception.studentException;
import com.modal.Course;
import com.modal.Student;
import com.modal.availableCourse;
import com.utility.DBUTil;

public class StudentDaoImpl implements StudentDao{

	@Override
	public String registerStudent(Student student) throws studentException {
		String stu=null;
		try (Connection conn=DBUTil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("insert into Student (sName,sEmail,sPassword,address,phone) values(?,?,?,?,?)");
			ps.setString(1, student.getsName());
			ps.setString(2, student.getsEmail());
			ps.setString(3, student.getsPassword());
			ps.setString(4, student.getAddress());
			ps.setString(5, student.getPhone());
			int x=ps.executeUpdate();
			if(x>0) {
				stu=student.getsName()+"is registered";
			}else
				throw new studentException("Not Registered");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return stu;
	}
	@Override
	public String loginStudent(String name, String pass) throws studentException {
		String stu=null;
		try (Connection conn=DBUTil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("select * from Student where sEmail=? AND sPassword=?");
			ps.setString(1,name);
			ps.setString(2,pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				stu="Welcome "+rs.getString("sName");
			}else
				throw new studentException("Invilade UserName or Password.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return stu;
	}
	@Override
	public List<availableCourse> availableCourseList() throws courseException {
		List<availableCourse> res=new ArrayList<>();
		try(Connection conn=DBUTil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select c.cId,c.cName,b.bName,b.seats from Course c INNER JOIN Batch b ON c.cId=b.cId");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("cId");
				String cn=rs.getString("cName");
				String bn=rs.getString("bName");
				String s=rs.getString("seats");
				availableCourse temp=new availableCourse(id, cn, bn, s);
			
				res.add(temp);
			}
			if(res.isEmpty()) {
				throw new courseException("No any Course found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	@Override
	public String registerINaCourse(String username,String password,int cId) throws batchException {
		String stu=null;
		try (Connection conn=DBUTil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("update Student set cId=? where sEmail=? AND sPassword=?");
			ps.setInt(1, cId);
			ps.setString(2, username);
			ps.setString(3, password);
			int x=ps.executeUpdate();
			if(x>0) {
				conn.prepareStatement("update Batch set seats=count(seats)-1 where cId=?");
				stu="Sucessfull x Inrolled for Course cgg";
			}else
				throw new batchException("No Seats Avaleable");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stu;
	}

}
