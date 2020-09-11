package library;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class LibraryInsertServ
 */
@WebServlet("/library/libraryInsert.do")
public class LibraryInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//등록 페이지 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("libraryInsert.jsp")
				.forward(request, response);
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//파라미터를 VO에 담기
		LibraryVO library = new LibraryVO();
		library.setISBN(request.getParameter("ISBN"));
		library.setTitle(request.getParameter("title"));
		library.setAuthor(request.getParameter("author"));
		library.setPublisher(request.getParameter("publisher"));
		library.setPublished_date(request.getParameter("publised_date")); //
		
		try {
			BeanUtils.copyProperties(library, request.getParameterMap()); // BeanUtils
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("============map==========="); // map
		Map<String, String[]> map = request.getParameterMap();
		System.out.println("ISBN=" + map.get("ISBN"));
		
		System.out.println("============names===========");
		Enumeration<String> pnames = request.getParameterNames();
		while(pnames.hasMoreElements()) {
			System.out.println(pnames.nextElement());
		}
		
		// values checkbox 항목 없을시
		// doGet(request, response);
		
		System.out.println(library);
		//DB 등록 처리
		LibraryDAO dao = new LibraryDAO();
		dao.insert(library);
		//목록으로 이동
		response.sendRedirect("librarySelectAll.do");
	}

}
