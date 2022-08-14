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
import DAO.StudentDAO;
import DAO.UserDAO;
import DTO.CourseResponseDTO;
import DTO.StudentRequestDTO;
import DTO.UserRequestDTO;
import DTO.UserResponseDTO;
import Model.StudentBean;
import Model.UserBean;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentControllerServlet() {
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
			StudentBean bean=new StudentBean();
		
		bean.setStudentid(request.getParameter("studentid"));
		bean.setStudentname(request.getParameter("studentname"));
		bean.setDob(request.getParameter("dob"));
		bean.setGender(request.getParameter("gender"));
		bean.setPhone(request.getParameter("phone"));
		bean.setEducation(request.getParameter("education"));
		bean.setCourse(request.getParameter("course"));
		
		if(bean.getStudentid().equals("") || bean.getStudentname().equals("")|| bean.getDob().equals("")|| bean.getGender().equals("")|| bean.getPhone().equals("")||bean.getEducation().equals("")||bean.getCourse()==null)
		{
			request.setAttribute("error", "Fill the blank");
			
			request.getRequestDispatcher("STU001.jsp").forward(request, response);
		}
		else
		{
			StudentDAO dao=new StudentDAO();
			StudentRequestDTO dto=new StudentRequestDTO();
			dto.setStudentid(bean.getStudentid());
			dto.setStudentname(bean.getStudentname());
			dto.setDob(bean.getDob());
			dto.setGender(bean.getGender());
			dto.setPhone(bean.getPhone());
			dto.setEducation(bean.getEducation());
			dto.setCourse(bean.getCourse());
			int i=dao.insertData(dto);
			
			
			 			
				response.sendRedirect("StudentDisplayServlet");
				}
	}

	}

