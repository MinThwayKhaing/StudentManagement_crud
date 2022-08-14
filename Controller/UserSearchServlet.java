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
import DTO.UserRequestDTO;
import DTO.UserResponseDTO;
import Model.LoginBean;
import Model.UserBean;
import Model.UserSearchBean;

/**
 * Servlet implementation class UserSearchServlet
 */
@WebServlet("/UserSearchServlet")
public class UserSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		UserBean bean=new UserBean();

		if(request.getParameter("searchid").equals("")) {
		bean.setUserid("0");
		}else {
		bean.setUserid(request.getParameter("searchid"));
		}

		bean.setUsername(request.getParameter("searchname"));

		UserRequestDTO req = new UserRequestDTO();
		req.setUserid(bean.getUserid());
		req.setUsername(bean.getUsername());


		UserDAO dao = new UserDAO();
		if(dao.search(req).isEmpty()) {
		request.setAttribute("error","Data not found!!");
		request.getRequestDispatcher("USR003.jsp").include(request, response);
		}
		else {

		request.setAttribute("list",dao.search(req));
		List<UserResponseDTO> urs=dao.search(req);
		urs.forEach(m -> System.out.println(m));
		request.getRequestDispatcher("USR003.jsp").include(request, response);

		}


	}

}
