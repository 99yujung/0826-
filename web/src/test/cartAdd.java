package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cartAdd")
public class cartAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 상품조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("goddsList.jsp")
				.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cnt = 0;
		
		//세션에서 장바구니 목록 조회
		
		String[] cartList = (String[])request.getSession().getAttribute("carList");
		
		// cartList가 null이면 String[] 초기화하고 session에 추가
		if(cartList == null) {
			cartList = new String[10];
			request.getSession().setAttribute("carList",cartList);
		}
		// 선택한 상품(파라미터)를 cartList에 추가 : getParameter
		cartList[cnt++] = request.getParameter("goods");
		
		// 상품 조회 페이지로 이동
		response.sendRedirect("cartAdd");
	}

}
