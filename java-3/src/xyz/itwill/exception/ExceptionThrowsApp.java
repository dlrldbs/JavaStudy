package xyz.itwill.exception;

public class ExceptionThrowsApp {
	//예외가 발생된 명령에서 예외 처리하지 않고 발생된 예외를 메소드를 이용하여 전달 가능
	//형식) 접근제한자 반환형 메소드명(자료형 매개변수, 자료형 매개변수 ...) throws 예외클래스,예외클래스 {}
	// => 메소드의 명령에서 발생된 예외를 메소드를 호출하는 명령으로 전달하는 방법
	public static void display() throws ArrayIndexOutOfBoundsException {
		int[] array= {10,20,30,40,50};
		
		for(int i=0;i<=array.length;i++) {
			System.out.println("array"+i+" = "+array[i]);
		}
	}
	
	public static void main(String[] args) {
		try {
			//정적메소드는 클래스를 이용하여 호출
			// => 같은 클래스에 선언된 정적메소드는 클래스 없이 메소드 호출 가능
			//ExceptionThrowsApp.display();
			//예외가 발생되는 메소드를 호출한 명령을 try~catch 구문으로 예외처리
			// => try~catch 구문으로 예외처리하지 않은 경우 일반 예외시 컴파일 에러가 발생되고
			//실행 예외시에는 JVM에 의해 자동으로 예외처리
			display();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("[에러]프로그램 실행에 예기치 못한 오류가 발생되었습니다.");
		}
		
	}
}
