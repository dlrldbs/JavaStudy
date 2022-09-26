package oop;

public class SingletonApp {
	public static void main(String[] args) {
		/*
		//new 연산자로 생성자를 호출하여 객체 생성 - 객체를 여러 개 생성하여 사용 가능
		// => 생성된 객체를 참조변수에 저장하여 참조변수에 객체를 참조하여 메소드 호출
		Singleton singleton1=new Singleton();
		Singleton singleton2=new Singleton();
		
		System.out.println("singleton1 = "+singleton1);
		System.out.println("singleton2 = "+singleton2);
		
		singleton1.display();
		singleton2.display();
		*/
		
		//싱글톤 클래스는 생성자가 은닉화 선언되어 new 연산자로 객체 생성 불가능
		//Singleton singleton=new Singleton();
		//클래스 생성시 미리 생성되어 시스템 필드에 저장된 객체를 반환하는 정적 메소드 호출
		// => 프로그램에서 객체를 하나만 제공받아 사용 
		Singleton singleton1=Singleton.getInstace();
		Singleton singleton2=Singleton.getInstace();
		
		System.out.println("singleton1 = "+singleton1);
		System.out.println("singleton2 = "+singleton2);
		
		singleton1.display();
		singleton2.display();
		System.out.println("==============================================================");
		//싱글톤 클래스는 참조변수에 객체를 저장하여 참조변수로 메소드를 호출하지 않고 객체를
		//반환받아 메소드를 직접 호출하여 사용하는 것을 권장
		Singleton.getInstace().display();
		System.out.println("==============================================================");
	}
}
