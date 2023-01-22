package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.crypto.spec.RC2ParameterSpec;

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
	public String registerINaCourse(String username,String password,int cId) throws batchException,studentException,courseException {
		String stu=null;
		try (Connection conn=DBUTil.provideConnection()){

			PreparedStatement ps=conn.prepareStatement("select * from Student where sEmail=? AND sPassword=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				
				String name=rs.getString("sName");
				int roll=rs.getInt("roll");
				PreparedStatement ps1=conn.prepareStatement("select * from Batch where cId=?");
				ps1.setInt(1, cId);
				ResultSet rs1=ps1.executeQuery();
				if(rs1.next()) {
					int seat=rs1.getInt("seats");
					int bId=rs1.getInt("bId");
					if(seat>0) {
						PreparedStatement ps2=conn.prepareStatement("insert student_course(roll,cId) values(?,?)");
						ps2.setInt(1, roll);
						ps2.setInt(2, cId);
					//	ps2.setInt(3, bId);
						int x=ps2.executeUpdate();
						if(x>0) {
							
//							PreparedStatement ps3= conn.prepareStatement("update Batch set seats=seats-1 where cId=?");
//							ps3.setInt(1, cId);
//							int b=ps3.executeUpdate();
							stu="Sucessfull "+name+" Inrolled for Course Id : "+cId ;
							
						}else
							throw new courseException("Invilade Course Id");
						
					}else
						throw new batchException("Seat full");
						
				}
	
				
			}else
				throw new studentException("Invilade Username or Password");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stu;
	}
	@Override
	public String updateStudentDetails(Student student) throws studentException {
		String res=null;
		try(Connection conn=DBUTil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("update Student set sEmail=?,sPassword=?,address=?,phone=? where roll=?");
			ps.setString(1, student.getsEmail());
			ps.setString(2, student.getsPassword());
			ps.setString(3, student.getAddress());
			ps.setString(4, student.getPhone());
			ps.setInt(5, student.getRoll());
			int x=ps.executeUpdate();
			
			if(x>0) {
				res="Sucessfull Updated Details.";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
