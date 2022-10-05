package xyz.itwill.lang;


//Wrapper 클래스 : 원시 데이터 타입의 자료형(Primitive Type)를 클래스로 표현한 자료형
// => Byte, Short, Integer, Long, Float, Double, Character, Boolean
public class WrapperApp {
	public static void main(String[] args) {
		/*
		int num1=100, num2=200;
		int num3=num1+num2;
		System.out.println("합계 = "+num3);
		*/
		/*
		//Integer : 정수값을 저장하고 정수값 관련 기능을 메소드로 제공하기 위한 클래스
		//Integer.valueOf(Object i):매개변수로 값을 전달받아 정수값이 저장된 Integer 객체를 생성하여 반환하는 메소드
		Integer num1=Integer.valueOf(100);
		Integer num2=Integer.valueOf("200");
		//Integer.intValue() : Integer 객체에 저장된 정수값을 정수형(int) 값으로 반환하는 메소드
		Integer num3=Integer.valueOf(num1.intValue()+num2.intValue());
		System.out.println("합계 = "+num3.intValue());
		*/
		
		//Wrapper 클래스는 오토박싱과 오토언박싱 기능을 사용하여 객체 생성 및 사용 가능
		//오토박싱(Auto Boxing) : 원시 데이타 타입의 값을 자동으로 Wrapper 클래스의 객체로 변환하는 기능
		//오토언박싱(Auto UnBoxing) : Wrapper 클래스의 객체를 자동으로 원시 데이타 타입의 값으로  
		Integer num1=100, num2=200; //정수값이 integer 객체로 변환되어 참조변수에 저장
		Integer num3=num1+num2; //Integer 객체에 저장된 정수값으로 변환되어 연산 처리
		System.out.println("합계 = "+num3);
		System.out.println("===================================================================================");
		//Integer.valueOf(String s, int radix) : 매개변수에 전달된 값으로 원하는 진수의
		//문자열을 정수값으로 변환하여 반환하는 메소드
		Integer num=Integer.valueOf("ABC",16); //int num=0xABC;
		System.out.println("num = "+num);
		System.out.println("===================================================================================");
		Integer su=50;
		
		System.out.println("su(10진수) = "+su);
		//Integer.toOctalString(int i) : 매개변수에 전달된 정수값을 8진수 형식의 문자열로 변환하여 반환하는 메소드
		System.out.println("su(8진수) = "+Integer.toOctalString(su));
		//Integer.toHexString(int i) : 매개변수에 전달된 정수값을 16진수 형식의 문자열로 변환하여 반환하는 메소드
		System.out.println("su(16진수) = "+Integer.toHexString(su));
		//Integer.toBinaryString(int i) : 매개변수에 전달된 정수값을 2진수 형식의 문자열로 변환하여 반환하는 메소드
		System.out.println("su(2진수) = "+Integer.toBinaryString(su));
		System.out.println("===================================================================================");
		String str1="100", str2="200";
		System.out.println("합계 = "+str1+str2); //문자열 결합
		
		//Integer.parseInt(String str) : 매개변수로 전달받은 문자열을 정수값으로 변환하여 반환하는 메소드
		// => 실행시 매개변수로 전달받은 문자열이 정수값으로 변환되지 못할 경우 NumberFormatException 발생
		System.out.println("합계 = "+(Integer.parseInt(str1)+Integer.parseInt(str2)));
		System.out.println("===================================================================================");
		
	}
}
