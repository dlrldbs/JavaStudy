package xyz.itwill.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

//키보드로 정수값을 입력받아 저장된 비밀번호와 비교하여 비교결과를 출력하는 프로그램 작성
public class PasswordMatchApp {
	public static void main(String[] args) {
		/*
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("비밀번호 입력 >> ");
		int password=scanner.nextInt();
		
		if(password==123456) {
			System.out.println("[결과]입력된 비밀번호가 맞습니다.");
		} else {
			System.out.println("[결과]입력된 비밀번호가 다릅니다.");
		}
		
		scanner.close();
		*/
		
		Scanner scanner=new Scanner(System.in);
		
		try {
			System.out.print("비밀번호 입력 >> ");
			int password=scanner.nextInt(); //InputMismatchException 발생 가능
			
			if(password!=123456) {
				//인위적으로 예외를 발생시키는 명령
				// => 프로그램 흐름이 catch 블럭으로 이동하여 명령 실행
				//형식)throw new 예외클래스(String message);
				throw new PasswordMismatchException("[결과]입력된 비밀번호가 다릅니다.");
			}
			
			//인위적 예외가 발생되지 않는 경우 실행되는 명령
			System.out.println("[결과]입력된 비밀번호가 맞습니다.");
			
		} catch (InputMismatchException e) {
			System.out.println("[에러]숫자만 입력 가능합니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			scanner.close();
		}
	}
}
