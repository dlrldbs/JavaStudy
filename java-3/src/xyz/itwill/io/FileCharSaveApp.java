package xyz.itwill.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//키보드 입력값을 문자데이터로 제공받아 파일에 전달하여 저장하는 프로그램
// => EOF (End Of File ; 입력종료 - Ctrl+Z) 신호를 입력하면 프로그램 종료
public class FileCharSaveApp {
	public static void main(String[] args) throws IOException {
		InputStreamReader in=new InputStreamReader(System.in);
		
		//FileWriter : 파일에 문자데이터를 전달하기 위한 출력스트림을 생성하기 위한 클래스
		//FileWriter(String filename) : 파일경로를 전달받아 파일 출력스트림을 생성하는 생성자
		// => 전달받은 파일경로에 파일이 없는 경우 FileNotFoundException 발생 - 예외처리
		// => 예외처리 하지 않고 예외를 전달한 경우 파일을 자동으로 생성하여 출력스트림 제공
		// => 전달받은 파일경로에 파일이 있는 경우 기존 파일값 대신 새로운 값이 파일에 저장 - 덮어씌우기
		//FileWriter out=new FileWriter("c:/data/char.txt");
		FileWriter out=new FileWriter("c:/data/char.txt",true);
		
		int readByte;
		while(true) {
			
			readByte=in.read();
			if(readByte==-1) break;
			//문자데이터를 출력스트림을 이용하여 전달하여 저장 - SAVE
			out.write(readByte);
		}
		
		//FileWriter.close() : 파일 출력스트림을 제거하는 메소
		out.close();
		System.out.println("[메세지]c:\\data\\char.txt 파일에 키보드 입력값이 저장되었습니다.");
	}
}
