package member;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;


/**
 * Servlet implementation class MemberInsertServ
 */
@WebServlet("/member/memberInsert.do")
public class MemberInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//등록 페이지 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("memberInsert.jsp")
				   .forward(request, response);
	}

	//등록 처리 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//파라미터를 VO에 담기
		MemberVO member = new MemberVO();
		member.setId(request.getParameter("id"));
		member.setPw(request.getParameter("pw"));
		member.setJob(request.getParameter("job"));
		member.setGender(request.getParameter("gender"));
		member.setReason(request.getParameter("reason"));
		member.setMailyn(request.getParameter("mailyn"));
		
		try {
			BeanUtils.copyProperties(member, request.getParameterMap());
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		
   	 	
		
		System.out.println("=========map=========");
		Map<String, String[]> map = request.getParameterMap();
		System.out.println("id=" + map.get("id"));
		
		System.out.println("=========names=========");
		Enumeration<String> pnames = request.getParameterNames();
		while(pnames.hasMoreElements()) {
			System.out.println(pnames.nextElement());
		}
		//checkbox
		System.out.println("=========values=========");
		String strHobby = "";
		String[] hobby = request.getParameterValues("hobby");
		System.out.println(Arrays.toString(hobby)); //[ski, read]
		if(hobby != null) {
			for (String temp : hobby) {
				strHobby += temp + "/"; // "ski/read" 
				System.out.println(temp);
			}
		}
		member.setHobby(strHobby);
		
	//	request.getParameterMap();
		System.out.println(member);
		//DB 등록 처리
		MemberDAO dao = new MemberDAO();
		dao.insert(member);
		//목록으로 이동
		response.sendRedirect("memberSelectAll.do");
	}
}
