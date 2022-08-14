package Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.UserDAO;
import DTO.StudentRequestDTO;
import DTO.StudentResponseDTO;
import DTO.UserRequestDTO;
import DTO.UserResponseDTO;
import Model.UserBean;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		UserRequestDTO dto = new UserRequestDTO();
		dto.setUserid(request.getParameter("userid"));
		UserDAO dao = new UserDAO();
		UserResponseDTO res = dao.selectOne(dto);
		request.setAttribute("res", res);
			
		request.getRequestDispatcher("USR002.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		UserBean bean=new UserBean();
		String code=request.getParameter("userid");
		bean.setUserid(code);
		bean.setUsername(request.getParameter("username"));
		bean.setEmail(request.getParameter("email"));
		bean.setPassword(request.getParameter("password"));
		bean.setUserrole(request.getParameter("userrole"));
		UserDAO dao = new UserDAO();
		UserRequestDTO dto = new UserRequestDTO();
		
		dto.setUserid(bean.getUserid());
		dto.setUsername(bean.getUsername());
		dto.setEmail(bean.getEmail());
		dto.setPassword(bean.getPassword());
		dto.setUserrole(bean.getUserrole());
		int i = dao.updateData(dto);
	

			response.sendRedirect("UserDisplayServlet");
	


	}

}
