package board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class BoardSelectAllServ
 */
@WebServlet("/board/boardSelectAll.do")
public class BoardSelectAllServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> datas = dao.selectAll();
		request.setAttribute("datas", datas);
		request.getRequestDispatcher("boardAll.jsp").forward(request, response);

	}


}
