package xyz.itwill.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.itwill.dao.GuestDAO;

//글번호를 출력페이지(select.itwill)에서 전달된 글번호를 반환받아 GUEST 테이블에 저장된 해당 
//글번호의 게시글을 삭제하고 게시글 목록 출력페이지(select.itwill)로 이동하기 위한 URL 주소 전달하는 서블릿 - 처리페이지
@WebServlet("/delete.itwill")
public class GuestDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//비정상적인 요청에 대한 처리
		if(request.getParameter("no")==null) {//전달값(글번호)이 없는 경우
			//클라이언트에게 에러코드 전달
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);//400
			return;
		}
		
		//전달값(글번호)을 반환받아 저장 - 문자열 >> 정수값
		int no=Integer.parseInt(request.getParameter("no"));
		
		//글번호를 전달받아 GUEST 테이블에 저장된 해당 글번호의 게시글을 삭제하는 DAO 클래스의 
		int rows=GuestDAO.getDAO().deleteGuest(no);
		
		if(rows>0) {//삭제행이 있는 경우
			response.sendRedirect("select.itwill");
		} else { //삭제행이 없는 경우 - 비정상적인 요청
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);//400
		}
	}
	
}