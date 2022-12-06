package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트에 의해 전달된 쿠키를 읽어 쿠키값을 클라이언트에 전달하는 서블릿
// => 클라이언트는 요청 URL 주소의 접속 서버 정보를 이용하여 해당 서버 정보를 저장된 모든 
//쿠키를 웹프로그램 요청시 무조건 전달
@WebServlet("/read.itwill")
public class CookieReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//클라이언트에서 보내온 모든 쿠키를 반환받아 저장
		//HttpServletRequest.getCookies() : 클라이언트에서 보내온 모든 쿠키를 Cookie 객체 
		//배열로 반환하는 메소드
		Cookie[] cookies=request.getCookies();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>쿠키 읽기</h1>");
		out.println("<hr>");
		if(cookies==null) {//클라이언트에서 보내온 쿠키가 없는 경우
			out.println("<p>네 안에 쿠키 없다.</p>");
		} else {
			String id="";
			String count="";
			
			//Cookie 객체 배열에 저장된 요소값(Cookie 객체)를 반복적으로 제공받아 처리
			for(Cookie cookie:cookies) {
				//클라이언트에서 보내온 쿠키 중 쿠키명을 비교하여 원하는 쿠키값을 반환받아 저장
				//Cookie.getName() : Cookie 객체에 저장된 쿠키명을 반환하는 메소드
				if(cookie.getName().equals("id")) {
					//Cookie.getValue() : Cookie 객체에 저장된 쿠키값을 반환하는 메소드
					id=cookie.getValue();
				} else if(cookie.getName().equals("count")) {
					count=cookie.getValue();
				}
			}
			
			//클라이언트에게 쿠키값을 전달하여 출력
			if(!id.equals("")) {//쿠키값이 있는 경우
				out.println("<p>아이디 = "+id+"</p>");
			}
			
			if(!count.equals("")) {//쿠키값이 있는 경우
				int cnt=Integer.parseInt(count)+1;
				out.println("<p>서블릿 요청횟수 = "+cnt+"</p>");
				
				//기존에 클라이언트에 저장된 쿠키의 이름과 같은 이름의 쿠키를 전달하면 쿠키값 변경 가능
				Cookie cookie=new Cookie("count", cnt+"");
				cookie.setMaxAge(24*60*60);
				response.addCookie(cookie);
			}
		}

		out.println("<hr>");
		out.println("<p><a href='create.itwill'>쿠키 전달</a></p>");
		out.println("<p><a href='remove.itwill'>쿠키 제거</a></p>");
		out.println("</body>");
		out.println("</html>");
	}

}
