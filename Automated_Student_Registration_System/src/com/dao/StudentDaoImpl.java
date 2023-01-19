package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exception.studentException;
import com.modal.Student;
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

}
