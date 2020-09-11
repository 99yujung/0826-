package board;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//파라미터 스트림 값을 바운드리(구분기호)로 잘라서 part배열로 만들어줌
@MultipartConfig(location = "c:/upload", maxRequestSize = 1024 * 1024 * 10)
@WebServlet("/board/boardInsert.do")
public class BoardInsertServ extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파라미터 인코딩
		request.setCharacterEncoding("utf-8");

		// 파라미터 받기
		BoardVO vo = new BoardVO();
		vo.setPoster(request.getParameter("poster"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContents(request.getParameter("contents"));

		// 첨부파일처리
		Part part = request.getPart("filename");
		String fileName = getFileName(part);
		String path = request.getServletContext().getRealPath("/images");
		System.out.println(path);
		
		part.write(fileName);
		vo.setFilename(fileName);

		BoardDAO dao = new BoardDAO();
		dao.insert(vo);

		// 목록으로 페이지 이동
		response.sendRedirect("boardSelectAll.do");
	}

	private String getFileName(Part part) throws UnsupportedEncodingException {
		for (String cd : part.getHeader("Content-Disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

}
