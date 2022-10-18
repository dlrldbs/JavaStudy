package xyz.itwill.net;

import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

//키보드로 메세지를 입력받아 서버에 접속하여 접속 서버에 전달하는 클라이언트 프로그램 
public class EchoClientApp {
	public static void main(String[] args) throws IOException {
		//키보드 입력스트림을 대량의 문자데이터를 입력받을 수 있는 입력스트림으로 확장
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("전달 메세지 입력 >> ");
		String message=in.readLine();
		
		try {
			//Socket 객체 생성 - 서버 접속
			Socket socket=new Socket("192.168.13.27",3000);
			
			/*
			//소켓의 출력스트림을 반환받아 대량의 문자데이터를 전달할 수 있는 출력스트림으로 확장
			BufferedWriter out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//출력스트림을 이용하여 서버에 문자열(메세지) 전달 
			// => 문자데이터를 출력스트림으로 보내지 않고 출력버퍼에 저장 - 일정크기가 되면 출력스트림으로 전달
			out.write(message);
			//출력버퍼에 존재하는 문자데이터를 출력스트림으로 전달
			out.flush();
			*/
			
			//소켓의 출력스트림을 반환받아 모든 형식의 값을 전달할 수 있는 출력스트림으로 확장
			PrintWriter out=new PrintWriter(socket.getOutputStream());
			
			//PrintWriter.println(Object o) : 모든 형식의 값을 문자열로 처리하여 출력스트림으로 전달하는 메소드 
			out.println(message);
			out.flush();
			
			//접속 해제
			socket.close();
		} catch (IOException e) {
			System.out.println("[에러]서버에 접속할 수 없습니다.");
		}
	}
}
