package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿(웹프로그램)은 클라이언트 요청에 의해 WAS 프로그램에 등록된 서블릿 클래스를 읽어
//메모리에 저장하고 서블릿 객체로 생성하여 요청 처리 메소드를 호출
// => 클라이언트 요청에 의한 서블릿 객체가 이미 생성되어 있는 경우 새로운 서블릿 객체를
//생성하지 않고 기존 서블릿 객체를 사용하여 요청 처리 메소드 호출
// => WAS 프로그램 종료되면 WAS 프로그램에 의해 관리되는 모든 서블릿 객체 소멸
// => WAS 프로그램의 주요 기능 중 하나는 서블릿 객체를 관리하는 웹컨테이너(WebContainer) 기능 제공
//컨테이너(Container) : 프로그램 관련 객체(Component)의 생명주기(LifeCycle)를 관리(생성,사용,소멸)하는 프로그램

@WebServlet("/life.itwill")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	//생성자(Constructor) : 클래스 자료형으로 객체를 생성하기 위한 특별한 메소드
	// => 초기화 작업 관련 명령 작성 - 객체 생성시 필드에 필요한 초기값 저장
	// => 서블릿을 클라이언트가 요청한 경우 WAS 프로그램이 서블릿 클래스로 서블릿 객체를 
	//생성하기 위해 한번만 호출
	public LifeCycleServlet() {
		System.out.println("### LifeCycleServlet 클래스의 생성자 호출 - 서블릿 객체 생성 ###");
		
		//name="홍길동";
	}
	
	//WAS 프로그램에 의해 서블릿 객체된 후 가장 먼저 한번만 자동 호출되는 메소드
	// => 초기화 작업 관련 명령 작성
	// => 서블릿은 생성자 대신 init() 메소드를 이용하여 초기화 작업 명령을 작성하는 것을 권장
	//생성자 대신 init() 메소드로 초기화 작업 명령을 작성하는 이유
	// => init() 메소드의 매개변수로 ServletConfig 객체를 전달받아 메소드에서 사용 가능
	//ServletConfig 객체 : 웹자원(WebContext)을 생성하기 위한 환경설정 관련 정보를 저장한 객체
	// => [web.xml] 파일에서 제공되는 값을 얻어와 서블릿 클래스에서 사용 가능 - 유지보수의 효율성 증대 
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("### LifeCycleServlet 클래스의 init() 메소드 호출 ###");
		//name="홍길동";
		
		//ServletConfig.getServletContext() : ServletContext 객체를 반환하는 메소드
		// => ServletContext 객체 : 웹자원 관련 정보를 저장한 객체
		//ServletContext.getInitParameter(String name) : [web.xml] 파일에서 context-param
		//엘리먼트로 제공되는 값을 얻어와 반환하는 메소드
		name=config.getServletContext().getInitParameter("name");
	}
	
	//WAS 프로그램에 의해 서블릿 객체가 소멸되기전 마지막으로 한번만 자동 호출되는 메소드
	
	// => 마무리 작업 관련 명령 작성
	// => WAS 프로그램이 종료될 경우 WAS 프로그램에 의해 관리된 모든 서블릿 객체 소멸
	@Override
	public void destroy() {
		System.out.println("### LifeCycleServlet 클래스의 destroy() 메소드 호출 ###");
	}
	
	//클라이언트 요청에 대한 처리와 처리 결과를 파일로 응답하기 위한 명령을 작작성하는 메소드
	// => 클라이언트 요청마다 WAS 프로그램에 의해 서블릿 객체로 반복 호출되는 메소스
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("### LifeCycleServlet 클래스의 service() 메소드 호출 ###");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>서블릿의 생명주기 (Life Cycle)</h1>");
		out.println("<hr>");
		out.println("<p>"+name+"님, 안녕하세요</p>");
		out.println("</body>");
		out.println("</html>");
	}
}
