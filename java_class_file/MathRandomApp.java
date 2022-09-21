package basic;

//프로그램으로부터 난수값을 제공받아 출력하는 프로그램 작성
//=> 난수값 : 불규칙적으로 발생되는 숫자값

public class MathRandomApp {
	public static void main(String[] args) {
		//Math 클래스 : 수학 과련 기능을 제공하는 클래스
		
		//Math.random() : 0.0보다 크거나 작고 1.0보다 작은 실수 난수값을 반환하는 메소드
		for(int i=1;i<=5;i++) {
			System.out.println(i+"번째 실수 난수값 = "+Math.random());
		} 
		System.out.println("=======================================================");
		for(int i=1;i<=5;i++) {
			//(int)(Math.random()*100 >> 0 <=난수값<100 = 난수값 : 0~99
			System.out.println(i+"번째 정수 난수값 = "+(int)(Math.random()*100));
		}
		
	}
}
