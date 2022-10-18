package xyz.itwill.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

//채팅 서버 프로그램 - 다중 스레드 프로그램
// => 클라이언트에서 보내온 메세지를 전달받아 접속된 모든 클라이언트에게 전달하는 기능 제공
// => 클라이언트와의 연결과 소켓은 새로운 스레드를 생성하여 독립적으로 입출력되도록 작성
public class ChatServerApp {
	//접속된 모든 클라이언트의 소켓정보를 저장하기 위한 콜렉션 필드
	private List<SocketThread> clientList=null;
	
	public ChatServerApp() {
		ServerSocket chatServer=null;
		
		try {
			chatServer=new ServerSocket(5000);
			System.out.println("[메세지]채팅 서버 동작중 ...");
			
			clientList=new ArrayList<SocketThread>();
			
			while(true) {
				try {
					//클라이언트가 접속되면 클라이언트와 연결된 Socket 객체를 반환받아 저장
					Socket client=chatServer.accept();
					
					System.out.println("[접속로그]"+client.getInetAddress().getHostAddress()+"의 컴퓨터에서 접속하였습니다.");
					
					//Thread 클래스를 상속받은 자식클래스로 객체 생성 - Thread 객체 생성
					SocketThread socketThread=new SocketThread(client);
					
					//콜렉션 필드에 저장된 List 객체에 요소(SocketThread 객체)를 추가하여 저장
					clientList.add(socketThread);
					
					//Thread 객체로 새로운 스레드를 생성하여 run() 메소드의 명령 실행 
					socketThread.start();
				} catch (IOException e) {
					System.out.println("[에러로그]클라이언트의 접속 관련 문제가 발생되었습니다.");
				}
			}
		} catch (IOException e) {
			System.out.println("[에러로그]서버가 정성적으로 동작되지 않습니다.");
		}
	}
	
	public static void main(String[] args) {
		new ChatServerApp();
	}
	
	//현재 서버에 접속된 모든 클라이언트에게 메세지를 전달하는 메소드
	public void sendMessage(String message) {
		//List 객체에 저장된 요소(SocketThread 객체)를 하나씩 제공받아 반복 처리
		for(SocketThread client:clientList) {
			//SocketThread 객체의 출력스트림을 이용하여 클라이언트에게 메세지 전달
			client.out.println(message);
		}
	}
	
	//클라이언트와 연결된 소켓을 이용하여 입출력 기능을 제공하기 위한 클래스
	// => 독립적인 입력 또는 출력 기능을 제공하기 위해 새로운 스레드를 생성하여 실행되도록 설정
	public class SocketThread extends Thread {
		//클라이언트의 소켓과 연결된 Socket 객체를 저장하기 위한 필드 
		private Socket socket;
		
		//클라이언트에서 보내온 메세지를 읽기 위한 입력스트림을 저장하기 위한 필드
		private BufferedReader in;
		
		//클라이언트로 메세지를 보내기 위한 출력스트림을 저장하기 한 필드
		private PrintWriter out;
		
		public SocketThread(Socket socket) {
			this.socket = socket;
		}
		
		//새로운 스레드가 실행하기 위한 명령 작성
		// => 클라이언트의 메세지를 전달받아 모든 접속 클라이언트에게 전달하는 명령 실행
		@Override
		public void run() {
			String aliasName=""; //클라이언트의 대화명을 저장하기 위한 변수 선언
			
			try {
				//클라이언트 연결과 소켓의 입력스트림을 반환받아 대량의 문자데이터를 
				//읽을 수 있는 입력스트림으로 확장 
				in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				//클라이언트와 연결된 소켓의 출력스트림을 반환받아 모든 형식의 값을 문자열로
				//전달할 수 있는 출력 스트림으로 확장
				//out=new PrintWriter(socket.getOutputStream()); //출력버퍼 사용 
				//PrintWriter(OutputStream out, boolean autoFlush) : autoFlush 매개변수에
				//[true]를 전달할 경우 출력버퍼를 사용하지 않고 출력스트림에 값을 직접 전달
				out=new PrintWriter(socket.getOutputStream(),true);
				
				//클라이언트에서 보내온 대화명을 얻어와 변수에 저장
				// => 클라이언트에서 대화명을 입력받아 전달할 때까지 스레드 일시 중지
				aliasName=in.readLine();
				
				//현재 접속된 모든 클라이언트에게 입장 메세지를 전달
				sendMessage("["+aliasName+"]님이 입장하였습니다.");
				
				//클라이언트에서 보내온 메세지를 전달받아 현재 접속된 모든 클라이언트에게 전달
				// => 클라이언트가 접속을 종료하기 전까지 반복 처리
				// => 클라이언트가 접속을 종료하면 클라이언트와 연결된 소켓의 입력스트림과 
				//출력스트림에 제거되어 IOException 발생
				while(true ) {
					sendMessage("["+aliasName+"]"+in.readLine());
				}		
			} catch (IOException e) {
				//클라이언트가 접속을 종료한 경우 실행될 명령 작성
				// => 콜렉션 필드에 저장된 List 객체에서 접속 종료된 클라이언트의 소켓정보(SocketThread)를 삭제
				// => 현재 접속중인 모든 클라이언트에게 퇴장메세지 전달
				clientList.remove(this); //this 키워드로 현재 사용중인 SocketThread 객체 표현
				sendMessage("["+aliasName+"]님이 퇴장하였습니다.");
				
				System.out.println("[해제로그]"+socket.getInetAddress().getHostAddress()+"의 컴퓨터에서 퇴장하였습니다.");
			}
		}
	}
}




