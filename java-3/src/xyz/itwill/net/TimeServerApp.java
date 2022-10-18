package xyz.itwill.net;

import java.io.IOException;
import java.io.ObjectOutputStream;
//import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

//접속된 클라이언트에게 서버 컴퓨터의 현재 날짜와 시간을 전달하는 서버 프로그램
// => NTP(Network Time Protocol) Server : 날짜와 시간을 제공하는 서버 컴퓨터
public class TimeServerApp {
	public static void main(String[] args) {
		ServerSocket ntpServer=null;
		
		try {
			//ServerSocket 객체 생성 - 포트를 활성화시켜 클라이언트가 접속할 수 있는 환경을 제공하는 객체
			ntpServer=new ServerSocket(2000);
			
			//ServerSocket.toString() : ServerSocket 객체에 저장된 접속 관련 정보를 문자열로 반환하는 메소드
			//System.out.println("ntpServer = "+ntpServer);
			
			System.out.println("NTP Server Running");
			
			//서버 프로그램에 다수의 클라이언트 접속을 허용하도록 무한반복 사용
			while (true) {
				//ServerSocket.accept() : 클라이언트의 접속을 기다리는 메소드
				// => 클라이언트가 접속되기 전까지 스레드 일시 중지
				// => 클라이언트가 접속한하면 클라이언트의 소켓과 연결될 소켓(Socket) 객체를 
				//생성하여 반환하고 스레드 실행
				Socket socket=ntpServer.accept();
				
				//System.out.println("socket"+socket);
				
				/*
				//Scoket.getOutputStream() : Socket 객체의 출력스트림(OutputStream 객체)을 반환하는 메소드
				OutputStream out=socket.getOutputStream();
				
				//OutputStream 객체를 전달받아 객체 전달이 가능한 ObjectOutputStream 객체로 출력스트림 확장
				ObjectOutputStream stream=new ObjectOutputStream(out);
				
				//시스템의 현재 날짜와 시간이 저장된 Date 객체 생성
				Date now=new Date(); 
				
				//출력스트림을 이용하여 Date 객체 전달 - 클라이언트에게 날짜와 시간 전송
				stream.writeObject(now);
				*/
				
				new ObjectOutputStream(socket.getOutputStream()).writeObject(new Date());
				
				//로그 처리 - 기록
				//Socket.getInetAddress() : 소켓으로 연결과 외부 컴퓨터의 네트워크 정보(InetAdderess)를 반환하는 메소드
				System.out.println("[정보]클라이언트["+socket.getInetAddress().getHostAddress()+"]에게 날짜와 시간을 제공하였습니다.");
				
				//클라이언트와의 연결 해제
				socket.close();
			}			
		} catch (IOException e) {
			System.out.println("[에러]서버 네트워크에 문제가 발생하였습니다.");
		}
	}
}
