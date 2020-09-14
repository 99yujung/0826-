package library;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Controller;
import common.HttpUtil;

public class LibraryListController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws
						ServletException, IOException {
		LibraryDAO dao = LibraryDAO.getInstance();
		ArrayList<LibraryVO> list = dao.libraryList();
		
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "/library/LibraryListOutput.jsp");
	}
}
