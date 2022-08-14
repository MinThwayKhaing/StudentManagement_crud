package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.CourseRequestDTO;
import DTO.CourseResponseDTO;
import DTO.StudentRequestDTO;
import DTO.StudentResponseDTO;

public class StudentDAO 
{
	public static Connection con=null;
	static
	{
		con=MyConnection.getConnection();
	}
	public int  insertData(StudentRequestDTO dto)
	{
		int result=0;
		String sql="insert into studenttable(studentid,studentname,dob,gender,phone,education,course)"+
					"values(?,?,?,?,?,?,?)";
		try 
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString (1,dto.getStudentid());
			ps.setString (2,dto.getStudentname());
			ps.setString (3,dto.getDob());
			ps.setString (4,dto.getGender());
			ps.setString (5,dto.getPhone());
			ps.setString (6,dto.getEducation());
			ps.setString(7,dto.getCourse());
			
			result=ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<StudentResponseDTO>selectAll()
	{
		ArrayList<StudentResponseDTO>list=new ArrayList();
		String sql="select * from studenttable";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				StudentResponseDTO res=new StudentResponseDTO();
				
				res.setStudentid(rs.getString("studentid"));
				res.setStudentname(rs.getString("studentname"));
				res.setDob(rs.getString("dob"));
				res.setGender(rs.getString("gender"));
				res.setPhone(rs.getString("phone"));
				res.setEducation(rs.getString("education"));
				res.setCourse(rs.getString("course"));
				list.add(res);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}


}
