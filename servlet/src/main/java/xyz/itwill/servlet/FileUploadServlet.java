package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

//원시데이터(멀티파트 폼데이터)를 전달받은 경우 원시데이터를 처리하기 위한 클래스를 사용하여 웹프로그램 작성
// => Apache 그룹에서 배포한 commons-fileupload 라이브러리의 클래스 사용 - 선택적 파일 업로드
// => Oreilly 그룹에서 배포한 cos 라이브러리의 클래스 사용 - 무조건 파일 업로드

//Oreilly 그룹에서 배포한 cos 라이브러리 파일을 다운로드 받아 프로젝트에 연결하는 방법 - (빌드 - Build) 처리하는 방법
//1.http://www.servlets.com 접속 => COS File Library 메뉴 클릭 >> cos-22.05.zip 다운로드
//2.cos-22.05.zip 파일 압축 풀기 => cos-22.05 폴더 이동 >> lib 폴더 이동 >> cos.jar 파일 복사
//3.프로젝트 >> src/main/webapp >> WEB-INB >> lib >> cos.jar 파일 붙여넣기
// => 라이브러리 파일이 자동으로 빌드 처리 - Web App Libraries 확인

//입력페이지(file_upload.html)에서 전달된 입력값(올린이)과 입력파일명을 반환받아 클라이언트에게 전달하는 서블릿
// => 전달된 입력파일은 서버 디렉토리에 저장되도록 처리 - 업로드(Upload)
@WebServlet("/upload.itwill")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//비정상적인 요청에 대한 처리
		if(request.getMethod().equals("GET")) {
			//response.sendRedirect("file_upload.html");
			//return;
		}
		
		//전달파일을 저장하기 위한 서버 디렉토리의 파일 시스템 경로를 반환받아 저장
		// => 작업 디렉토리(WorkSpace)가 아닌 웹디렉토리(WebApps)의 파일 시스템 경로 반환
		//주의)WAS 프로그램 실행(Start)될 때 작업 디렉토리의 프로젝트 파일이 웹디렉토리의 자원으로 동기화 처리
		// => 작업 디렉토리에는 업로드 파일이 없으므로 동기화 처리될 경우 웹디렉토리의 업로드
		String saveDirectory=request.getServletContext().getRealPath("/upload");
		//System.out.println(saveDirectory);
		
		//MultipartRequest 클래스로 객체 생성
		// => MultipartRequest 객체 : 멀티파트 폼데이터를 처리하기 위한 기능을 제공하는 객체
		// => MultipartRequest 객체를 생성하면 모든 입력파일을 전달받아 서버 디렉토리에 자동 저장 - 자동 업로드 처리
		//MultipartRequest(HttpServletRequest request,String saveDirectory, int maxPostSize, String encoding, FileRenamePolicy policy);
		// => request(필수) : 요청정보가 저장된 HttpServletRequest 객체 전달
		// => saveDirectory(필수) : 전달파일을 저장하기 위한 서버 디렉토리의 파일 시스템 경로 전달
		// => maxPostSize(선택) : 처리 가능한 멀티파트 폼데이터의 크기 전달 - 단위 : Byte
		// => encoding(선택) : 멀티파트 폼데이터로 전달되는 문자값에 대한 캐릭터셋 전달
		// => policy(선택) : 파일이름을 변경하기 위한 기능을 제공하는 FileRenamePolicy 객체 전달
		//FileRenamePolicy 객체 : 전달파일을 업로드 처리할 때 서버 디렉토리 전달파일과 같은
		//이름의 파일이 이미 존재할 경우 전달파일의 이름을 변경하여 업로드 처리하기 위한 기능을 제공하는 객체
		// => 생성자 매개변수에 FileRenamePolicy 객체를 전달하지 않은 경우 서버 디렉토리에 
		//전달파일과 같은 이름의 파일이 있는 경우 전달파일로 기존 파일을 덮어씌우기(OverWrite) 하여 저장
		//MultipartRequest mr=new MultipartRequest(request, saveDirectory, 20*1024*1024, "utf-8", null);
		//FileRenamePolicy 객체는 FileRenamePolicy 인터페이스를 상속받은 자식클래스로 생성
		// => cos 라이브러리의 DefaultFileRenamePolicy 클래스를 사용하여 FileRenamePolicy 객체 생성 
		MultipartRequest mr=new MultipartRequest(request, saveDirectory, 20*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		
		//전달값을 반환받아 저장
		//MultipartRequest.getParameter(String name) : 멀티파트 폼데이터로 전달된 문자값을
		//문자열(String 객체)로 반환하는 메소드
		String name=mr.getParameter("name");
		
		//전달받은 파일명(입력파일명)을 반환받아 저장
		//MultipartRequest.getOriginalFileName(String name) : 멀티파트 폼데이터로 전달된 
		//입력 파일의 이름을 문자열로 반환하는 메소드
		//String fileone=mr.getOriginalFileName("fileone");
		//String filetwo=mr.getOriginalFileName("filetwo");
		
		//업로드 처리된 파일명을 반환받아 저장
		//MultipartRequest.getFilesystemName(String name) : 멀티파트 폼데이터로 전달된
		//파일에 대한 업로드 파일 이름을 문자열로 반환하는 메소드
		String fileone=mr.getFilesystemName("fileone");
		String filetwo=mr.getFilesystemName("filetwo");
		
		//응답결과 생성
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>입력값과 입력파일</h1>");
		out.println("<hr>");
		out.println("<p>올린이 = "+name+"</p>");
		out.println("<p>파일명 = "+fileone+"</p>");
		out.println("<p>파일명 = "+filetwo+"</p>");
		out.println("</body>");
		out.println("</html>");
	}

}
