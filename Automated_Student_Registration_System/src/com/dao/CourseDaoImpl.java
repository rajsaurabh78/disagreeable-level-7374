package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.administratortException;
import com.exception.batchException;
import com.exception.courseException;
import com.exception.studentException;
import com.modal.Administrator;
import com.modal.Batch;
import com.modal.Course;
import com.modal.Student;
import com.utility.DBUTil;
import com.modal.*;
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
			PreparedStatement ps=conn.prepareStatement("insert into Batch(bName,cId,seats) values(?,?,?)");
			ps.setString(1,batch.getbName());
			ps.setInt(2,batch.getcId());
			ps.setInt(3,batch.getSeats());
			
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
	public String registerAdministrator(Administrator administrator) throws administratortException {
		String admin=null;
		try (Connection conn=DBUTil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("insert into Administrator (aName,aEmail,aPassword) values(?,?,?)");
			ps.setString(1, administrator.getaName());
			ps.setString(2, administrator.getaEmail());
			ps.setString(3, administrator.getaPassword());

			int x=ps.executeUpdate();
			if(x>0) {
				admin=administrator.getaName()+" is registered";
			}else
				throw new administratortException("Not Registered");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return admin;
	}

	@Override
	public String loginAdministrator(String name, String pass) throws administratortException {
		String admin=null;
		try (Connection conn=DBUTil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("select * from Administrator where aEmail=? AND aPassword=?");
			ps.setString(1,name);
			ps.setString(2,pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				admin="Welcome "+rs.getString("aName");
			}else
				throw new administratortException("Invilade UserName or Password.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return admin;
	}

	@Override
	public String updateTotalSeatsInaBatch(int bId,int uSeat) throws batchException {
		String res=null;
		
		try (Connection conn=DBUTil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("update Batch set seats=? where bId=?");
			ps.setInt(1, uSeat);
			ps.setInt(2, bId);
			int x=ps.executeUpdate();
			if(x>0) {
				res="Total Seats are Updated with Batch Id: "+bId;
			}
			else 
				throw new batchException("Invilade Batch Id");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return res;
	}

	@Override
	public String AllocateStudentBatch(int roll, int cId, int bId) throws batchException {
		String res=null;
		try (Connection conn=DBUTil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("select seats from Batch where cId=? AND bId=?");
			ps.setInt(1, cId);
			ps.setInt(2, bId);
			
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				int seats=rs.getInt("seats");
				if(seats>0) {
					PreparedStatement ps1=conn.prepareStatement("insert into student_course values(?,?,?)");
					ps1.setInt(1, roll);
					ps1.setInt(2, cId);
					ps1.setInt(3, bId);
					int x=ps1.executeUpdate();
					if(x>0) {
						PreparedStatement ps2= conn.prepareStatement("update Batch set seats=seats-1 where bId=? And cId=?");
						ps2.setInt(1, bId);
						ps2.setInt(2, cId);
						int e=ps2.executeUpdate();
						res="Sucessfully Allocate Roll "+roll+" in Batch with Id "+bId+" for Course Id "+cId;
					}
				}else
					throw new batchException("Seat full.");
				
			
			}
//			if(rs.next()==false) 
//				throw new batchException("Invilade Batch Id.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public List<everyBatchStudentDetails> everyBatchStudentDetails() throws studentException {
		List<everyBatchStudentDetails> res=new ArrayList<>();
		
		try(Connection conn=DBUTil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select s.sName,s.roll,s.sEmail,s.address,s.phone,b.bName,b.bId,c.cName,c.cId from Student s INNER JOIN Batch b INNER JOIN Course c INNER JOIN student_course sc where sc.roll=s.roll AND sc.cId=c.cId AND sc.bId=b.bId;");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				String sName=rs.getString("sName");
				int roll=rs.getInt("roll");
				String sEmail=rs.getString("sEmail");
				String address=rs.getString("address");
				String phone=rs.getString("phone");
				String bName=rs.getString("bName");
				int bId=rs.getInt("bId");
				String cName=rs.getString("cName");
				int cId =rs.getInt("cId");
				
				everyBatchStudentDetails temp=new everyBatchStudentDetails(sName, roll, sEmail, address, phone, bName, bId, cName, cId);
				res.add(temp);
			}
			if(res.isEmpty()) {
				throw new studentException("No Data Found.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

}