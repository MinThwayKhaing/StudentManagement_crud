package Controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import Model.StudentBean;
import Model.UserBean;

/**
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentBean bean=new StudentBean();
		String code=request.getParameter("studentid");
		bean.setStudentid(code);
		bean.setStudentname(request.getParameter("studentname"));
		bean.setDob(request.getParameter("dob"));
		bean.setGender(request.getParameter("gender"));
		bean.setPhone(request.getParameter("phone"));
		bean.setEducation(request.getParameter("education"));
		
		bean.setCourse(request.getParameterValues("course"));
		if(bean.getStudentid().equals("") || bean.getStudentname().equals("")|| bean.getDob().equals("")|| bean.getPhone().equals("")||bean.getEducation().equals("")||bean.getCourse()==null)
		{
			request.setAttribute("error", "Fill the blank");
			
			request.getRequestDispatcher("STU002.jsp").forward(request, response);
		}
		else
		{
		//System.out.println("id"+code+bean.getPhone());
		List<StudentBean>list=(List<StudentBean>) request.getServletContext().getAttribute("list");
		//System.out.println("size"+list.size());
		Iterator<StudentBean>itr=list.iterator();
		while(itr.hasNext())
		{
			if(itr.next().getStudentid().equals(code))
			{
				itr.remove();
			}
		}
		
		list.add(bean);
		
		request.getServletContext().setAttribute("list",list);
		request.getRequestDispatcher("STU003.jsp").forward(request,response);
		}

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	}	
}
