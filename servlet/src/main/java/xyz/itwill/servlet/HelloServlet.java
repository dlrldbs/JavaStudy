package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet : Java Web Program - Server + let 합성어로 웹에서 실행되는 프로그램 
// => 클라이언트 요청에 의해 WAS(Web Application Server)로 실행되어 웹문서를 동적으로 생성하여 응답
//웹문서를 동적으로 생성하여 응답 - Servlet 프로그램은 WAS에 의해 관리(생성,사용,소멸)
//WAS(Web Application Server) : Web Server(요청과 응답) + Web Container(서블릿 관리)

//서블릿 프로그램 작성 방법
//1.HttpServlet 클래스(J2EE >> Apache Tomcat)를 상속받은 자식클래스 작성 - 서블릿 클래스
// => HttpServlet 클래스를 상속받은 자식클래스는 객체직렬화 클래스로 serialVersionUID 필드를 선언하는 것을 권장
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//2.doGet() 메소드 또는 doPost() 메소드를 오버라이드 선언
	// => 클라이언트 요청에 대한 처리와 처리결과를 동적으로 웹문서로 생성하여 응답하기 위한 메소드 - 요청처리 메소드
	// => WAS(Web Application Server) 프로그램에 의해 자동 호출되는 메소드
	//doGet() : 클라이언트가 해당 웹프로그램을 GET 방식으로 요청한 경우 호출되는 메소드
	//doPost() : 클라이언트가 해당 웹프로그램을 POST 방식으로 요청한 경우 호출되는 메소드
	//doGet() 메소드 또는 doPost() 메소드 대신 service() 메소드 오버라이드 선언 가능
	// => service() : 클라이언트가 해당 웹프로그램에 대해 모든 방식으로 요청한 경우 호출되는 메소드
	// => service() 메소드가 doGet() 메소드 또는 doPost() 메소드보다 호출 우선순위가 높게 설정
	//WAS 프로그램에 의해 메소드가 호출될 때 HttpServletRequest(Request) 객체와  
	//HttpServletRespponse 객체(response)가 매개변수에 저장되어 제공
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpServletRequest : 리퀘스트 메세지(요청 관리 정보)를 표현한 객체 - 입력
		//HttpServletResponse : 리스폰즈 메세지(응답 관련 정보)를 표현한 객체 - 출력
		
		//3.클라이언트에게 응답할 결과에 대한 파일의 형식(MimeType) 설정(변경)
		//형식)HttpServletResponse,setContentType(String mimeType[;charset=encoding])
		// => 응답파일이 문서파일인 경우 문자의 형태(캐릭터셋 : CharacterSet : 인코딩) 설정
		// => 기본 응답파일 형식 : text/html, 캐릭터셋 : ISO-8859-1(서유럽어)
		response.setContentType("text/html;charset=utf-8");
		
		//4.클라이언트 요청에 의해 생성된 응답파일에 대한 출력스트림을 반환받아 저장
		//형식)HttpServletResponse.getOutputStream() : 원시데이터(1Byte)를 전달할 수 있는
		//출력스트림(ServletOutputStream 객체)를 반환하는 메소드
		// => 그림, 소리, 동영상 파일 등을 생성하여 클라이언트에게 응답하기 위한 출력스트림 
		//형식)HttpServletResponse.getWriter() : 인코딩 처리된 문자데이터(2Byte)를 전달할 수 
		//있는 출력스트림(PrintWriter 객체)를 반환하는 메소드
		// => PlanText, HTML, XML, JSON 파일 등과 같은 문서파일을 생성하여 클라이언트에게 응답하기 위한 출력스트림
		PrintWriter out=response.getWriter();
		
		//5.요청에 대한 처리와 처리에 대한 결과를 출력스트림을 사용하여 응답파일 생성
		out.println("<!DOCTYPE html>");//출력스트림으로 문자열(HTML 태그)을 전달하여 문서파일
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Servlet</h1>");
		out.println("<hr>");
		out.println("<p>Hello! Servlet</p>");
		out.println("</body>");
		out.println("</html>");
		
		//6.서블릿 클래스를 서블릿(웹프로그램)으로 실행되도록 설정
		// => [web.xml] 파일에서 서블릿 클래스를 서블릿(웹프로그램)으로 등록하여 서블릿을 
		//요청할 수 있는 URL 주소를 매핑 설정
		//클라이언트가 매핑된 URL 주소로 서블릿을 요청하면 WAS 프로그램은 서블릿 클래스를
		//객체로 생성하여 요청 처리 메소드를 호출하여 요청에 대한 처리와 응답결과를 생성
		// => 서블릿 클래스가 이미 객체로 생성된 경우에는 요청 처리 메소드만 호출하여 실행
		
	}
}
