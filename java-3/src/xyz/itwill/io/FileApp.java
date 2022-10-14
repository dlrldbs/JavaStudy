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
			System.out.println("c:/data/xyz.txt 파일이 이미 존재합니다." );
		} else {
			//File.reateNewFile() : File 객체에 저장된 파일경로를 이용하여 파일을 생성하는 메소드
			// => IOException 발생되므로 예외처리해야만 에러 미발생 
			fileTwo.createNewFile();
			System.out.println("c:/data/xyz.txt 파일을 생성하였습니다." );
		}
		System.out.println("====================================================================");
		//File fileThree=new File("c:/data/xyz.txt");
		
		//File(String parent, String child) : 시스템(운영체제 - OS)의 파일경로를 부모(디렉토리)와
		//자식(파일)으로 구분하여 전달받아 File 객체를 생성하는 생성자 
		File fileThree=new File("c:/data","xyz.txt");
		
		if(fileThree.exists()) {
			//File.delete() : File 객체에 저장된 파일경로의 파일을 삭제하는 메소드
			fileThree.delete(); 
			System.out.println("c:/data/xyz.txt 파일을 삭제하였습니다." );
		} else {
			System.out.println("c:/data/xyz.txt 파일이 존재하지 않습니다." );
		}	
		System.out.println("====================================================================");
		//파일경로를 상대경로 표현방법으로 전달하여 File 객체 생성
		// => 현재 프로그램의 작업디렉토리는 프로젝트 폴더로 설정
		// => 상대경로 표현방법은 [..] 기호를 사용하여 상위 디렉토리(폴더)를 표현하며
		//[파일 | 폴더] 형식으로 폴더에 존재하는 파일 또는 하위 디렉토리(폴더) 표현 
		File fileFour=new File("src");
		
		if(fileFour.exists()) {
			//File.toString : File 객체에 저장된 파일경로를 문자열로 반환하는 메소드
			//System.out.println("파일 경로 = "+fileFour.toString());
			System.out.println("파일 경로 = "+fileFour);
			
			//File.getAbsolutePath : File 객체에 저장된 파일경로를 절대경로의 문자열로 반환하는 메소드
			System.out.println("파일 경로 = "+fileFour.getAbsolutePath());
		} else {
			System.out.println("작업디렉토리에 src 폴더가 없습니다.");
		}
		System.out.println("====================================================================");
		File fileFive=new File("c:/");
		
		//File.isDirectory() : File 객체에 저장된 파일경로가 디렉토리인 경우 [true]를 반환하는 메소드
		if(fileFive.isDirectory()) {
			//File.listFiles() : File 객체에 저장된 파일경로의 자식 파일 목록을 File 객체 배열로 반환하는 메소드
			File[] subFiles=fileFive.listFiles();
			
			System.out.println(fileFive+" 폴더의 자식 목록 >> ");
			for (File file:subFiles) {
				//File.isFile() : File 객체에 저장된 파일경로가 파일인 경우 [true]를 반환하는 메소드
				if(file.isFile()) {
					System.out.println("파일 = "+file);
				} else {
					System.out.println("폴더 = "+file);
				}
			}
		}
		System.out.println("====================================================================");
	}
}
