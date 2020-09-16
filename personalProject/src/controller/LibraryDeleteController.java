package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Controller;
import common.HttpUtil;
import library.LibraryDAO;

public class LibraryDeleteController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws
						ServletException, IOException {
		//파라미터 추출
		String ISBN = request.getParameter("ISBN");
		// DAO 객체의 메소드 호출
		LibraryDAO dao = LibraryDAO.getInstance();
		dao.libraryDelete(ISBN);
		// Output View 페이지로 이동
		HttpUtil.forward(request, response, "/result/libraryDeleteOutput.jsp");
	}
}
