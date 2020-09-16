package library;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Controller;
import controller.LibraryDeleteController;
import controller.LibraryInsertController;
import controller.LibraryListController;
import controller.LibrarySearchController;
import controller.LibraryUpdateController;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String charset = null;
	HashMap<String, Controller> list = null;
	
	@Override
	public void init(ServletConfig sc) throws ServletException {
		charset = sc.getInitParameter("charset");
		list = new HashMap<String, Controller>();
		list.put("/libraryInsert.do", new LibraryInsertController());
		list.put("/librarySearch.do", new LibrarySearchController());
		list.put("/libraryUpdate.do", new LibraryUpdateController());
		list.put("/libraryDelete.do", new LibraryDeleteController());
		list.put("/libraryList.do", new LibraryListController());
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws
						ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = url.substring(contextPath.length());
		Controller subController = list.get(path);
		subController.execute(request, response);
	}
}
