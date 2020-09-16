package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Controller;
import common.HttpUtil;
import library.LibraryDAO;
import library.LibraryVO;


public class LibraryInsertController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
		// 파라미터 추출
		String ISBN = request.getParameter("ISBN");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		String published_date = request.getParameter("published_date");
		// Date -> String으로 넘기기
		
		//유효성 체크
		if (ISBN.isEmpty() || title.isEmpty() || author.isEmpty() || publisher.isEmpty() || published_date.isEmpty()) {
					request.setAttribute("error", "모든 항목을 빠짐없이 입력해주시기 바랍니다");
			HttpUtil.forward(request, response, "/libraryInsert.jsp");
			return;
		}
		
		// VO 객체에 데이터 바인딩
		LibraryVO library = new LibraryVO();
		library.setISBN(ISBN);
		library.setTitle(title);
		library.setAuthor(author);
		library.setPublisher(publisher);
		library.setPublished_date(published_date);
		
		// DAO 객체의 메소드 호출
		LibraryDAO dao = LibraryDAO.getInstance();
		dao.insert(library);
		
		// Output View 페이지로 이동
		request.setAttribute("ISBN", ISBN);
		HttpUtil.forward(request, response, "/library/libraryInsertOutput.jsp");
		
		
	}
}
