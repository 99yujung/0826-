package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Controller;
import common.HttpUtil;
import library.LibraryDAO;
import library.LibraryVO;

public class LibrarySearchController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws
						ServletException, IOException {
		// Parameter 추출
		String ISBN = request.getParameter("ISBN");
		String title = request.getParameter("title");
		String path = null;
		if (title.equals("search"))
			path = "/library/librarySearch.jsp";
		else if (title.equals("update"))
			path = "/library/libraryUpdate.jsp";
		else if (title.equals("delete"))
			path = "/library/libraryDelete.jsp";
		// 유효성 체크
		if (ISBN.isEmpty()) {
			request.setAttribute("error", "ISBN을 입력해주시기 바랍니다.");
			HttpUtil.forward(request, response, path);
			return;
		}
		// Service 객체의 메소드 호출
		LibraryDAO dao = LibraryDAO.getInstance();
		LibraryVO library = dao.librarySearch(ISBN);
		// Output View 페이지로 이동
		if (library == null) request.setAttribute("result", "검색된 정보가 없습니다.");
		request.setAttribute("library", library);
		if(title.equals("search")) path="/result/librarySerachOutput.jsp";
		HttpUtil.forward(request, response, path);
	}
}
