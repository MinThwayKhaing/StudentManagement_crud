package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.UserDAO;
import DTO.StudentRequestDTO;
import DTO.UserRequestDTO;
import Model.UserBean;

/**
 * Servlet implementation class UserControllerServlet
 */
@WebServlet("/UserControllerServlet")
public class UserControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		UserBean bean=new UserBean();
		
		bean.setUserid(request.getParameter("userid"));
		bean.setUsername(request.getParameter("username"));
		bean.setEmail(request.getParameter("email"));
		bean.setPassword(request.getParameter("password"));
		String Confirmpassword=request.getParameter("confirmpassword");
		bean.setUserrole(request.getParameter("userrole"));
		if(bean.getUserid().equals("") || bean.getUsername().equals("")|| bean.getEmail().equals("")|| bean.getPassword().equals("")|| bean.getUserrole().equals(""))
		{
			request.setAttribute("error", "Fill the blank");
			
			request.getRequestDispatcher("USR001.jsp").forward(request, response);
		}
		else {
			if(bean.getPassword().equals(Confirmpassword))
			{
				UserDAO dao=new UserDAO();
				UserRequestDTO dto=new UserRequestDTO();
				dto.setUserid(bean.getUserid());
				dto.setUsername(bean.getUsername());
				dto.setEmail(bean.getEmail());
				dto.setPassword(bean.getPassword());
				dto.setUserrole(bean.getUserrole());
				int i=dao.insertData(dto);
				
				
				 			
					response.sendRedirect("UserDisplayServlet");
				
			}
			else
			{
				request.setAttribute("error1", "Password doesn't match");
				
				request.getRequestDispatcher("USR001.jsp").forward(request, response);
			}
		
		}
			
	}

}


