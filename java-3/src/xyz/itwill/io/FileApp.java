package xyz.itwill.io;

import java.io.File;
import java.io.IOException;

//File 클래스 : 파일(디렉토리 - 폴더) 관련 정보를 저장하기 위한 클래스
public class FileApp {
	public static void main(String[] args) throws IOException {
		//File(String pathname) : 시스템(운영체제 - OS)의 파일경로를 전달받아 File 객체를 생성하는 생성자
		// => 파일경로 : 시스템의 존재하는 파일 위치를 표현하는 방법 - 절대경로 표현방법, 상대경로 표현방법
		//전대경로 표현방법 : 파일경로를 최상위 디렉토리를 기준으로 파일 위치를 표현하는 방법
		//상대경로 표현방법 : 현재 실행 프로그램의 작업디렉토리를 기준으로 파일 위치를 표현하는 방법
		// => 이클립스에서는 프로젝트 폴더를 작업 디렉토리로 처리
		//Windows 운영체제에서는 폴더(드라이브)의 파일을 구분하기 위해 \ 기호 사용
		// => Java에서는 \ 기호가 회피문자(Escape Character)를 표현하는 용도로 사용
		// => \ 기호를 문자로 사용하기 위해 \\ 형태의 회피문자(Escape Character)를 표현
		File fileOne=new File("c:\\data"); 
		
		//File.exists() : File 객체에 저장된 파일경로에 실제 파일(디렉토리)이 없는 경우 [false]를 반환하고
		//실제 파일(디렉토리)이 있는 경우[true]를 반환하는 메소드
		if(fileOne.exists()) {
			System.out.println("c:\\data 폴더가 이미 존재합니다." );
		} else {
			//File.mkdir() : File 객체에 저장된 파일경로를 이용하여 디렉토리를 생성하는 메소드
			fileOne.mkdir();
			System.out.println("c:\\data 폴더를 생성하였습니다." );
		}
		System.out.println("====================================================================");
		//File fileTwo=new File("c:\\data\\xyz.txt");
		
		//Windows 운영체제를 제외한 나머지 운영체제에서는 폴더(드라이브)와 파일을 구분하기 위해 / 기호 사용
		// => Java에서는 파일 경로를 표현하기 위해 \ 기호 대신 / 기호 사용 가능 
		File fileTwo=new File("c:/data/xyz.txt");
		
		if(fileTwo.exists()) {
			System.out.println("c:/data/xyz.txt 폴더가 이미 존재합니다." );
		} else {
			//File.reateNewFile() : File 객체에 저장된 파일경로를 이용하여 파일을 생성하는 메소드
			// => IOException 발생되므로 예외처리해야만 에러 미발생 
			fileTwo.createNewFile();
			System.out.println("c:/data/xyz.txt 폴더를 생성하였습니다." );
		}
		System.out.println("====================================================================");
		//File fileThree=new File("c:/data/xyz.txt");
		//File(String parent, String child) : 시스템(운영체제 - OS)의 파일경로를 전달받아 File 객체를 생성하는 생성자
		//File fileThree=new File("c:/data/xyz.txt");
	}
}
