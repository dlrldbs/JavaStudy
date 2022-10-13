package xyz.itwill.io;

import java.io.IOException;

//java.io 패키지 : 입력과 출력 관련 클래스가 선언된 패키지

//스트림(Stream) : 값을 전달하기 위한 목적으로 생성된 입력 클래스 또는 출력 클래스의 객체
// => 시냇물을 흐르는 모양을 모델링하여 만들어 값이 한방향으로만 전달되며 순차적으로 처리

//원시데이터 기반 스트림(Byte Stream) : 가공되지 않은 원시데이터를 전달하기 위한 입출력 스트림
// => 값을 1Byte 단위로 입력 또는 출력하기 위한 스트림
// => InputStream 클래스와 OutputStream 클래스를 최상위 클래스로 하는 자식클래스

//키보드로 원시데이터를 입력받아 모니터에 전달하여 입력하는 프로그램
// => EOF (End Of File : Ctrl+Z) 신호를 입력하면 프로그램 종료
public class ByteStreamApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[메세지]키보드를 눌러 값을 입력해 주세요.[프로그램 종료: Ctrl+Z]");
		
		//키보드 입력값을 저장하기 위한 변수
		int readByte;
		
		while(true) {
			//System.in : Java 프로그램 개발을 위해 기본적으로 제공되는 입력스트림
			// => InputStream 클래스를 기반으로 제공되는 입력스트림(객체)
			// => 키보드를 누르면 이벤트가 발생된 키보드의 값을 입력스트림으로 전달
			//InputStream.read() : 입력스트림에 존재하는 값을 읽어 반환하는 메소드
			// => 입력스트림에 값이 없는 경우 스레드는 일시 중지 상태로 전환
			// => 입력스트림을 엔터(Enter)가 입력될 경우 스레드 다시 실행
			//입력스트림 또는 출력스트림 관련 메소드는 IOException 발생
			// => 일반 예외이므로 예외처리 하지 않을 경우 에러 발생
			readByte=System.in.read();
			
			//입력종료신호(Ctrl+Z : EOF)가 전달된 경우 반복문 종료
			if(readByte==-1) break;
			
			//System.out : Java 프로그램 개발을 위해 기본적으로 제공되는 모니터 출력스트림
			// => OutStream 클래스(PrintStream 클래스)를 기반으로 제공되는 출력스트림(객체) 
			// => 출력스트림에 값을 전달하면 모니터에 출력
			//OutStream.write(int b) : 출력스트림에게 값(1Byte)을 전달하는 메소드
			System.out.write(readByte);
		}
		System.out.println("[메세지]프로그램을 종료합니다.");
	}
}
