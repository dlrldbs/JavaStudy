package basic;

import java.util.Scanner;

//System.out : 출력스트림을 사용하여 값을 화면에 출력하는 기능을 제공하는 객체 
//System.in : 입력스트림을 사용하여 키보드로부터 전달된 값을 입력하는 기능을 제공하는 객체 

//사용자에게 키보드로 이름과 나이를 입력받아 출력하는 프로그램 작성
public class ScannerApp {
	public static void main(String[] args) {
		//Scanner 클래스 : 입력장치(키보드, 파일 등)로부터 전달된 값을 반환하기 위한 기능을 제공하는 클래스
		//Scanner 클래스로 객체를 생성하여 변수에 저장
		// => 변수에 저장된 객체를 사용하여 메소드 호출 - 원하는 기능 구현
		//System.in 객체를 사용하여 키보드로부터 값을 전달받기 위한 Scanner 객체 생성
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("이름 입력 >> ");
		//Scanner.nextLine() : 입력값을 전달받아 문자열로 변환하여 반환하는 메소드
		//키보드로 입력된 값을 문자열로 반환받아 변수에 저장
		// => 키보드 입력값이 없는 경우 프로그램의 흐름(스레드 - Thread)이 일시 중지
		// => 키보드로 값을 입력후 엔터(Enter)를 입력되면 프로그램의 흐름이 다시 실행 
		String name=scanner.nextLine();
		
		System.out.print("나이 입력 >> ");
		//Scanner.nextInt() : 입력값을 전달받아 정수값으로 변환하여 반환하는 메소드
		//키보드로 입력된 값을 정수값으로 반환받아 변수에 저장
		// => 키보드로 입력된 값이 정수값이 아닌 경우 예외(Exception) 발생
		int age=scanner.nextInt();
		
		System.out.println("[결과]"+name+"님의 나이는 "+age+"살입니다.");
		
		//Scanner.close() : Scanner 객체를 제거하는 메소드
		scanner.close();
	}
}
