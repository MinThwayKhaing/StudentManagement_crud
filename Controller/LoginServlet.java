package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import DTO.UserResponseDTO;
import Model.LoginBean;
import Model.UserBean;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
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
		PrintWriter out=response.getWriter();
		LoginBean bean=new LoginBean();
		bean.setId(request.getParameter("userid"));
		bean.setPassword(request.getParameter("password"));
		
		if(bean.getId().equals("") || bean.getPassword().equals(""))
		{
			request.setAttribute("error", "Fill the blank");
			
			request.getRequestDispatcher("LGN001.jsp").forward(request, response);
			}
		else
		{
			UserDAO dao =new UserDAO();
			ArrayList<UserResponseDTO> list=dao.loginUser(bean);
			if(list.size()>0)
			{
				request.getRequestDispatcher("MNU001.jsp").forward(request, response);
			}
			else
			{
				out.println("<h1>Failed</h1>");
			}
		}
	}

}
