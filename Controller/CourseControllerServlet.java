package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CourseDAO;
import DAO.UserDAO;
import DTO.CourseRequestDTO;
import DTO.UserRequestDTO;
import Model.CourseBean;


/**
 * Servlet implementation class CourseControllerServlet
 */
@WebServlet("/CourseControllerServlet")
public class CourseControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseControllerServlet() {
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
		CourseBean coursebean=new CourseBean();
		
		coursebean.setCourseid(request.getParameter("courseid"));
		coursebean.setCoursename(request.getParameter("coursename"));
		if(coursebean.getCourseid().equals("") || coursebean.getCoursename().equals(""))
		{
			request.setAttribute("error", "Fill the blank");
			
			request.getRequestDispatcher("BUD003.jsp").forward(request, response);
		}
		else
		{
		
			CourseDAO dao=new CourseDAO();
			CourseRequestDTO dto=new CourseRequestDTO();
			dto.setCourseid(coursebean.getCourseid());
			dto.setCoursename(coursebean.getCoursename());
			
			dao.insertCourseData(dto);
			
			
			 			
			response.sendRedirect("CourseDisplayServlet");

	}
	}

}
