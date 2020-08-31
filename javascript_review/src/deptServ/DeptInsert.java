package deptServ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.DeptDAO;
import test.DeptVO;

/**
 * Servlet implementation class DeptInsert
 */
@WebServlet (urlPatterns = { "/DeptInsert"},
			loadOnStartup = 1
			)
public class DeptInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptDAO dao = new DeptDAO();
		
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartment_id( Integer.parseInt(request.getParameter("department_id") ) );
		deptVO.setDepartment_name( request.getParameter("department_name"));
		dao.insert(deptVO);
	
		
		//1.결과 출력
		/*
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print("alert('등록처리완료');");
		out.print("<script>");
	//	response.sendRedirect("deptSelect.jsp");
		*/
		//2.페이지 이동
	//	response.sendRedirect("deptSelect.jsp");
	
	//	3.페이지 이동(forward)
		request.getRequestDispatcher("deptSelect.jsp")
			   .forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
