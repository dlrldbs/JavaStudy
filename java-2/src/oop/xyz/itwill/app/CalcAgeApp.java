package xyz.itwill.app;

import java.util.Date;
//java.lang 패키지의 자료형은 기본적으로 import 처리되어 제공
import java.util.Scanner;

//키보드로 이름과 태어난 년도를 입력받아 이름과 나이를 출력하는 프로그램 작성
//ex) 이름 입력 >> 홍길동
//	  태어난 년도 입력 >> 2000
//	  [결과]홍길동님의 나이는 23살입니다.
public class CalcAgeApp {
	public static void main(String[] args) {
		//Scanner 클래스로 객체를 생성하여 참조변수에 저장
		Scanner scanner=new Scanner(System.in);
		
		//키보드를 이용하여 사용자로부터 이름과 태어난 년도를 입력받아 저장
		System.out.print("이름 입력 >> ");
		String name=scanner.nextLine();
		
		System.out.print("태어난 년도 >> ");
		int birthYear=scanner.nextInt();
		
		//java.util.Date 클래스로 객체를 생성하여 참조변수에 저장
		// => java.util.Date : 날짜와 시간정보를 저장하기 위한 클래스
		//Date 클래스의 기본 생성자를 이용하여 객체를 생성할 경우 Date 객체에는 시스템(운영체제 - OS)의 
		//현재 날짜와 시간이 저장
		Date now=new Date();
		//Date.toString() : Date 객체에 저장된 날짜와 시간을 문자열로 변환하여 반환하는 메소드
		//System.out.println("now.toString = "+now.toString());
		//참조변수 출력할 경우 toString() 메소드 호출 생략 가능
		//System.out.println("now = "+now);
		
		
		
		
		//Date 객체로부터 현재 년도를 반환받아 저장
		//Date.getYear() : Date 객체에 저장된 날짜와 시간 중 년도를 반환하는 메소드
		// => Date 객체에 저장된 년도는 1900년부터 1년에 1씩 증가된 값으로 표현
		// => @Deprecated 어노테이션이 적용된 메소드
		//@Deprecated : 메소드 사용을 권장하지 않도록 설정하는 어노테이션(Annotation)
		// => @Deprecated 설정된 메소드를 호출할 경우 경고 발생
		//@SuppressWarnings : 경고 메세지를 제거하는 어노테이션
		// => value 속성을 사용하여 경고 관련 속성값을 설정
		// => value 속성외에 다른 속성이 없는 경우 속성값만 설정 가능
		//@SuppressWarnings(value = "deprecation")
		@SuppressWarnings("deprecation")
		int currentYear=now.getYear()+1900;
		
		//태어난 년도를 이용하여 나이 계산하여 저장
		//int age=2022-birthYear+1;
		int age=currentYear-birthYear+1;
		
		//결과 출력
		System.out.println("[결과]"+name+"님의 나이는 "+age+"살입니다.");
		
		scanner.close();
		
	}
}
