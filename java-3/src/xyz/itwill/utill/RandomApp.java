package xyz.itwill.utill;

import java.util.Random;

//java.utill 패키지 : 프로그램 작성에 유용한 기능을 제공하는 클래스가 선언된 패키지

//Scanner 클래스 : 입력장치로부터 값을 제공받기 위한 기능을 메소드로 제공하는 클래스 
//Arrays 클래스 : 배열 요소를 처리하기 위한 기능을 메소드로 제공하는 클래스
//Random 클래스 : 난수값 관련 기능을 메소드로 제공하는 클래스
//Date 클래스 : 날짜와 시간정보를 저장하고 날짜와 시간 관련 기능을 메소드로 제공하는 클래스
//Calendar 클래스 : 날짜와 시간정보를 저장하고 날짜와 시간 관련 기능을 메소드로 제공하는 클래스
//자료구조 클래스(Collection Class) : 다수의 객체를 효율적으로 저장하고 관리하기 위한 기능을 메소드로 제공하는 클래스
//메소드로 제공하는 클래스 - ArrayList, HashSet, HashMap 등
// => Collection 인터페이스(Set 와 List) 또는 Map 인터페이스를 상속받은 자식클래스 

public class RandomApp {
	public static void main(String[] args) {
		Random random=new Random();
		
		//Random.nextInt(int bound) : 0~bound~1 범위의 정수난수를 발생하여 반환하는 메소드
		for(int i=1;i<=5;i++) {
			System.out.println(i+"번째 정수난수 = "+random.nextInt(100)); //0~99 범위의 난수 발생
		}
		
	}
}
