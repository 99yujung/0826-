package dept;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeptSelectServ
 * 단건조회 
 */
@WebServlet("/dept/DeptSelect")
public class DeptSelectServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//부서번호 파라미터로 조회한 결과를 select.jsp 로 포워드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 파라미터를 VO에 담기
		DeptVO paramVO = new DeptVO();
		deptVO.setDepartment_id( Integer.parseInt(request.getParameter("department_id")));
		deptVO.setDepartment_name(request.getParameter("department_id"));
		
		// int department_id = Integer.parseInt(request.getParameter("department_id"));
		// paramVO.setDepartment_id(department_id);
		
		//2. 등록 처리s
		DeptDAO dao = new DeptDAO();		
		dao.insert(deptVO);
		
		// DeptVO dept = dao.selectOne(paramVO);
		
		// 3. 결과 처리 (생략)
		response.sendRedirect("deptSelectAll");
		//4. 전체 조회 서블릿 페이지로 이동
		
		
		
		
		
		//조회결과 request 저장
		request.setAttribute("dept", dept);
		
		//view 페이지로 이동(포워드)
		request.getRequestDispatcher("deptSelect.jsp")
			   .forward(request, response);
	}

}
