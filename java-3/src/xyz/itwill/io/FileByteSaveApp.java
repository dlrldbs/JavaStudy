package xyz.itwill.io;

import java.io.FileOutputStream;
import java.io.IOException;

//키보드 입력값을 원시데이터로 제공받아 파일에 전달하여 저장하는 프로그램
// => EOF(End Of File : 입력종료 - Ctrl+Z) 신호를 입력하면 프로그램 종료
public class FileByteSaveApp {
	public static void main(String[] args) throws IOException {
		System.out.println("[메세지]키보드를 눌러 값을 입력해 주세요.[프로그램 종료 : Ctrl+Z]");
		
		//FileOutputStream : 파일에 원시데이터를 전달하기 위한 출력스트림을 생성하기 위한  클래스
		//FileOutputStream(String name) : 파일경로를 전달받아 파일 출력스트림을 생성하는 생성자 
		// => 전달받은 파일경로에 파일이 없는 경우 FileNotFoundException 발생 - 예외처리
		// => 예외처리 하지 않고 예외를 전달한 경우 파일을 자동으로 생성하여 출력스트림 반환
		// => 전달받은 파일경로에 파일이 있는 경우 기존 파일값 대신 새로운 값이 파일에 저장 - 덮어씌우기
		//FileOutputStream out=new FileOutputStream("c:/data/byte.txt");
		
		//FileOutputStream(String name,boolean append) : 파일경로와 추가 유무에 대한 논리값을 
		//전달받아 파일 출력스트림을 생성하는 생성자
		// => false : 파일 덮어씌우기(기본), true : 파일 이어쓰기
		FileOutputStream out=new FileOutputStream("c:/data/byte.txt",true);
		
		int readByte;
		
		while(true) {
			//키보드 입력스트림에서 원시데이터를 반환받아 저장
			readByte=System.in.read();
			if(readByte==-1) break;
			out.write(readByte); //파일 출력스트림으로 원시데이터를 전달하여 저장 - SAVE
		}
		
		//FileOutputStream.close() : 파일 출력스트림을 제거하는 메소드
		// => 파일에는 입력스트리 또는 출력스트림을 1개씩만 생성 가능
		// => 파일 처리를 위한 입력스트림 또는 출력스트림은 사용 후 반드시 제거
		out.close();
		System.out.println("c:\\data\\byte.txt 파일에 키보드 입력값이 저장 되었습니다.");
	}
}
