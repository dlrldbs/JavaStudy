package xyz.itwill.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//다른 컴퓨터에서 보내온 메세지를 얻어와 출력하는 UDP 기반의 네트워크 프로그램
public class MessageReceiveApp {
	public static void main(String[] args) throws IOException {
		//DatagramSocket 객체 생성
		// => 포트를 활성화하여 다른 컴퓨터에서 보내온 패킷을 받을 수 있는 환경 제공 
		DatagramSocket socket=new DatagramSocket(4000);
		
		//전달받은 패킷에 저장된 값(메세지)를 저장하기 위한 byte 배열 선언
		byte[] data=new byte[1024];
		
		//연결 컴퓨터에서 보내온 패킷을 저장하기 위한 DatagramPacket 객체 생성
		// => DatagramPacket(data, data.length)
		DatagramPacket packet=new DatagramPacket(data, data.length);
		
		System.out.println("메세지 수신중...");
		
		//DatagramSocket.receive(DatagramPacket packet) : 연결 컴퓨터에서 보내온 패킷을
		//얻어와 저장하는 메소드 - 패킷을 받기 전까지 스레드 일시 중지
		
		socket.receive(packet);
		
		String message=new String(data);
		
		System.out.println("[결과]메세지 = "+message);
		
		socket.close();
	}
}
