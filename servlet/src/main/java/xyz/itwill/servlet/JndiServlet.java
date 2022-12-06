package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

//JNDI(Java Naming Directory Interface) : WAS 프로그램에 객체 생성에 필요한 정보를 이름(식별자)
//으로 구분하여 저장하고 필요한 경우 객체 생성 정보를 제공받아 객체를 생성하여 사용하는 기능
// => 객체 생성에 필요한 정보를 제공하는 파일 필요 - src/main/webapp/META-INF/context.xml

//WAS 프로그램에 등록된 자원(Resource)을 이용하여 DataSource 객체를 생성하고 DataSource 객체에
//저장된 다수의 Connection 객체중 하나를 제공받아 클라이언트에게 접속정보를 전달하는 서블릿
@WebServlet("/jndi.itwill")
public class JndiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		try {
			//InitialContext 객체 생성
			// => WAS 프로그램에 등록된 자원을 이용하여 객체를 생성하여 제공하기 위한 객체
			// => NamingException(이름에 대한 자원 정보가 없는 발생되는 예외) 발생 - 예외처리
			InitialContext ic=new InitialContext();
			
			//InitialContext.lookup(String name) : 매개변수로 전달받은 이름의 자원을 WAS 
			//프로그램에게 제공받아 객체를 생성하여 반환하는 메소드
			// => Object 타입의 객체를 반환하므로 반드시 명시적 객체 형변환하여 사용
			DataSource dataSource=(DataSource)ic.lookup("java:comp/env/jdbc/oracle");
			
			Connection con=dataSource.getConnection();
						
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>DBCP(JNDI)</h1>");
			out.println("<hr>");
			out.println("<p>con = "+con+"</p>");
			out.println("</body>");
			out.println("</html>");
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
