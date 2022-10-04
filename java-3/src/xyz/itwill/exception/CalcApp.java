package xyz.itwill.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

//키보드로 정수값 2개를 입력받아 첫번째 정수값으로 두번째 정수값을 나눈 몫을 계산하여 출력하는 프로그램 작성
public class CalcApp {
	public CalcApp() throws InputMismatchException, ArithmeticException {
	//public CalcApp() throws Exception {//메소드에서 발생된 모든 예외를 Exception 클래스 하나로 전달 가능
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("첫번째 정수값 입력 >> ");
		//Scanner.nextInt() : 입력값을 정수값으로 변환하여 반환하는 메소드
		// => 입력값이 정수값으로 변환되지 못할 경우 InputMismatchException 발생 - 예외처리
		// => 직접 예외처리하지 않고 메소드를 사용하여 발생 예외 전달 가능 
		int num1=scanner.nextInt();
		
		System.out.print("두번째 정수값 입력 >> ");
		int num2=scanner.nextInt();
		
		//어떤수를 0으로 나눈 경우 ArithmeticException 발생
		System.out.println("[결과]"+num1+" / "+num2+" = "+(num1/num2));
		
		scanner.close();
	}
	
	public static void main(String[] args) {
		/*
		try {
			//생성자를 이용하여 객체 생성 - 생성자의 명령 실행 
			// => 예외가 전달된 메소드 호출 - 예외처리
			new CalcApp();
		} catch (InputMismatchException e) {
			System.out.println("[에러]정수값만 입력 가능합니다.");
		} catch (ArithmeticException e) {
			System.out.println("[에러]0으로 나눌수 없습니다.");
		} catch (Exception e) {
			//Exception : 모든 예외클래스의 부모클래스
			// => 모든 예외 객체를 전달받아 참조변수에 저장하여 예외처리 가능
			System.out.println("[에러]프로그램에 예기치 못한 오류가 발생되었습니다.");
		}
		*/
		
		try {
			new CalcApp();
		} catch (InputMismatchException | ArithmeticException e) {
			//catch 블럭에서 예외클래스를 | 연산자로 연결하여 다수의 예외에 대한 처리 가능
			System.out.println("[에러]형식에 맞는 값을 입력해 주세요.");
		} catch (Exception e) {
			System.out.println("[에러]프로그램에 예기치 못한 오류가 발생되었습니다.");
		}
	}
}