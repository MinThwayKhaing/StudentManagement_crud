package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.CourseRequestDTO;
import DTO.CourseResponseDTO;
import DTO.UserRequestDTO;
import DTO.UserResponseDTO;

public class CourseDAO 
{
	public static Connection con=null;
	static
	{
		con=MyConnection.getConnection();
	}
	public int  insertCourseData(CourseRequestDTO dto)
	{
		int result=0;
		String sql="insert into coursetable(courseid,coursename)"+
					"values(?,?)";
		try 
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString (1,dto.getCourseid());
			ps.setString (2,dto.getCoursename());
			
			
			result=ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<CourseResponseDTO>selectAll()
	{
		ArrayList<CourseResponseDTO>list=new ArrayList();
		String sql="select * from coursetable";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				CourseResponseDTO res=new CourseResponseDTO();
				
				res.setCourseid(rs.getString("courseid"));
				res.setCoursename(rs.getString("coursename"));
				
			
				list.add(res);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
