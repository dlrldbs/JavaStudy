package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//쿠키를 클라이언트에게 전달하는 서블릿
//쿠키(Cookie) : 서버(웹프로그램)와 클라이언트(브라우저)의 연결 지속성을 제공하기 위해 
//클라이언트에 저장되는 값
// => 쿠키는 접속 서버 정보를 식별자로 구분하여 클라이언트에 저장
@WebServlet("/create.itwill")
public class CookieCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//Cookie 클래스로 객체 생성
		// => Cookie 객체 : 쿠키 관련 정보를 저장하기 위한 객체
		//Cookie(String name, String value) : 생성자 매개변수에 쿠키명과 쿠키값을 매개변수에 전달하여 객체 생성 
		// => 쿠키명 : 쿠키값을 구분하기 위한 식별자
		// => 쿠키값 : 연결 지속성을 제공하기 위한 문자값
		// => 쿠키명과 쿠키값은 영문자, 숫자, 일부 특수문자만 사용하여 작성 가능
		//Cookie idCookie=new Cookie("id",URLEncoder.encode("홍길동",""));
		Cookie idCookie=new Cookie("id","abc123");
		Cookie countCookie=new Cookie("count","0");
		
		//클라이언트에게 전달되어 저장될 쿠키의 유지시간 변경
		//Cookie.setMaxAge(int expiry) : 쿠키의 유지시간(초)를 변경하는 메소드
		//쿠키의 유지시간을 변경하지 않은 경우 기본값은 [-1]로 자동설정
		// => 쿠키의 유지시간이 [-1]로 설정된 경우 쿠키는 브라우저 종료시 자동 소멸
		countCookie.setMaxAge(24*60*60); //쿠키 유지시간 : 1일
		
		//클라이언트에게 쿠키 전달 - 쿠키를 전달받은 클라이언트는 쿠키를 저장
		// => 쿠키의 유지시간을 변경하지 않은 쿠키는 브라우저 메모리에 저장 - 브라우저 종료시 자동소멸
		// => 쿠키의 유지시간을 변경한 쿠키는 쿠키 파일에 저장 - 유지시간이 지나면 자동 소멸
		//HttpServletResponse.addCookie(Cookie cookie) : 클라이언트에게 쿠키(Cookie 객체)를 전달
		response.addCookie(idCookie);
		response.addCookie(countCookie);
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>쿠키 전달</h1>");
		out.println("<hr>");
		out.println("<p>네 안에 쿠키 있다</p>");
		out.println("<hr>");
		out.println("<p><a href='read.itwill'>쿠키 읽기</a></p>");
		out.println("</body>");
		out.println("</html>");
	}

}
