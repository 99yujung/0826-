package dept;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dept/deptSelectAll")
public class DeptSelectAllServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeptSelectAllServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DeptDAO dao = new DeptDAO();
		ArrayList<DeptVO> list = dao.selectAll(null);
		request.setAttribute("list", list);
		request.getRequestDispatcher("deptSelectAll.jsp")
				.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
