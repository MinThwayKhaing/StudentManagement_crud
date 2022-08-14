package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.UserRequestDTO;
import DTO.UserResponseDTO;
import Model.LoginBean;
import Model.UserSearchBean;




public class UserDAO 
{
	public static Connection con=null;
	static
	{
		con=MyConnection.getConnection();
	}
	public int  insertData(UserRequestDTO dto)
	{
		int result=0;
		String sql="insert into usertable(userid,username,email,password,userrole)"+
					"values(?,?,?,?,?)";
		try 
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString (1,dto.getUserid());
			ps.setString (2,dto.getUsername());
			ps.setString (3,dto.getEmail());
			ps.setString (4,dto.getPassword());
			ps.setString (5,dto.getUserrole());
			
			result=ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	public int  updateData(UserRequestDTO dto)
	{
		int result=0;
		String sql="update usertable set username=?,email=?,password=?,userrole=?"+"where userid=?";
		try 
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString (5,dto.getUserid());
			ps.setString (1,dto.getUsername());
			ps.setString (2,dto.getEmail());
			ps.setString (3,dto.getPassword());
			ps.setString (4,dto.getUserrole());
			result=ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	public int  deleteData(UserRequestDTO dto)
	{
		int result=0;
		String sql="delete from usertable where userid=?";
		try 
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString (1,dto.getUserid());
			result=ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	public   UserResponseDTO selectOne(UserRequestDTO dto)
	{
		
		UserResponseDTO res=new UserResponseDTO();
		String sql="select * from usertable where userid=?";
		try 
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,dto.getUserid());
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				
				res.setUserid(rs.getString("userid"));
				res.setUsername(rs.getString("username"));
				res.setEmail(rs.getString("email"));
				res.setPassword(rs.getString("password"));
				res.setUserrole(rs.getString("userrole"));
				
				
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return res;
	}
	public   List<UserResponseDTO> search(UserRequestDTO dto)
	{
		
		
		List <UserResponseDTO>list=new ArrayList<>();
		String sql="select * from usertable where userid=? or username=?";
		try 
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,dto.getUserid());
			ps.setString(2,dto.getUsername());
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				
				UserResponseDTO res=new UserResponseDTO();
				res.setUserid(rs.getString("userid"));
				res.setUsername(rs.getString("username"));
				res.setEmail(rs.getString("email"));
				res.setPassword(rs.getString("password"));
				res.setUserrole(rs.getString("userrole"));
				list.add(res);
				
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return list;
	}
	
	
	public ArrayList<UserResponseDTO>selectAll()
	{
		ArrayList<UserResponseDTO>list=new ArrayList();
		String sql="select * from usertable";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				UserResponseDTO res=new UserResponseDTO();
				
				res.setUserid(rs.getString("userid"));
				res.setUsername(rs.getString("username"));
				res.setEmail(rs.getString("email"));
				res.setPassword(rs.getString("password"));
				res.setUserrole(rs.getString("userrole"));
			
				list.add(res);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<UserResponseDTO>loginUser(LoginBean bean)
	{
		ArrayList<UserResponseDTO>loginlist=new ArrayList();
		String sql="select * from usertable where userid='"+bean.getId()+"'and password='"+bean.getPassword()+"'";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery(sql);
			while(rs.next())
			{
				UserResponseDTO res=new UserResponseDTO();
				
				res.setUserid(rs.getString("userid"));
				res.setPassword(rs.getString("password"));
				
				
				
			
				loginlist.add(res);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginlist;
	}


}
