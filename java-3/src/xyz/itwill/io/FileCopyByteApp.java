package xyz.itwill.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//원본파일에 저장된 값을 원시데이터로 읽어와 타겟파일에 전달하여 저장하는 프로그램 - 파일복사
// => 모든 형식의 원본파일을 복사하여 타겟파일로 저장 가능
public class FileCopyByteApp {
	public static void main(String[] args) throws IOException {
		//FileInputStream in=null;
		//FileOutputStream out=null;
		
		//BufferedInputStream : InputStream 객체를 전달받아 대량의 원시데이터를 읽기 위한
		//입력스트림을 생성하기 위한 클래스
		//보조스트림 : 스트림을 전달받아 기능을 확장하기 위한 클래스
		BufferedInputStream in=null;
		
		//BufferedOutputStream : OutputStream 객체를 전달받아 대량의 원시데이터를 읽기 위한
		//출력스트림을 생성하기 위한 클래스
		BufferedOutputStream out=null;
		
		
		try {
			in=new BufferedInputStream(new FileInputStream("c:/data/Coke.jpg"));
			
			out=new BufferedOutputStream(new FileOutputStream("c:/data/Coke_copy.jpg"));
			
			int readByte;
			while (true) {
				readByte=in.read();
				if(readByte==-1) break;
				out.write(readByte);
			}
			
			System.out.println("[메세지]파일을 성공적으로 복사 하였습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("[에러]원본파일을 찾을 수 없습니다.");
		}		
		
	}
}
