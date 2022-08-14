package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.StudentDAO;
import DAO.UserDAO;
import DTO.StudentRequestDTO;
import DTO.StudentResponseDTO;
import DTO.UserRequestDTO;
import DTO.UserResponseDTO;
import Model.StudentBean;
import Model.UserBean;

/**
 * Servlet implementation class StudentSearchServlet
 */
@WebServlet("/StudentSearchServlet")
public class StudentSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		StudentBean bean=new StudentBean();

		
		bean.setStudentid(request.getParameter("searchid"));

		bean.setStudentname(request.getParameter("searchname"));
		bean.setCourse(request.getParameter("course"));
		StudentRequestDTO req = new StudentRequestDTO();
		req.setStudentid(bean.getStudentid());
		req.setStudentname(bean.getStudentname());
		req.setCourse(bean.getCourse());


		StudentDAO dao = new StudentDAO();
		if(dao.search(req).isEmpty()) {
		request.setAttribute("error","Data not found!!");
		request.getRequestDispatcher("StudentDisplayServlet").include(request, response);
		}
		else {

		request.setAttribute("list",dao.search(req));
		List<StudentResponseDTO> urs=dao.search(req);
		urs.forEach(m -> System.out.println(m));
		request.getRequestDispatcher("STU003.jsp").include(request, response);

		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
