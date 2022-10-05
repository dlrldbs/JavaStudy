package xyz.itwill.thread;

//다중 스레드 프로그램
// => 프로그램 개발자가 스레드를 직접 생성하여 여러 명령을 동시에 실행되도록 만든 프로그램
// => 프로그램의 모든 스레드가 소멸되면 프로그램 종료
// => GUI 프로그램, Web 프로그램 등은 다중 스레드 프로그램으로 작성

//프로그램 개발자가 새로운 스레드를 생성하여 명령을 실행하는 방법-1
//1.Thread 클래스를 상속받은 자식클래스 작성
//2.Thread 클래스를 상속받은 자식클래스에 run() 메소드를 오버라이드 선언
// => run() 메소드에는 프로그램 개발자에 의해 생성된 스레드가 실행할 명령 작성
//3.Thread 클래스를 상속받은 자식클래스로 객체 생성 - Thread 객체 생성
//4.자식클래스의 객체로 start() 메소드 호출 - Thread 객체의 start() 메소드 호출
// => Thread 객체로 새로운 스레드를 만들어 자식클래스에 오버라이드 선언된 run() 메소드의 명령 실행

//프로그램 개발자가 새로운 스레드를 생성하여 명령을 실행하는 방법-2
//1.Runnable 인터페이스를 상속받은 자식클래스 작성
// => 자식클래스가 다른 클래스를 상속받아 Thread 클래스를 상속받지 못할 경우 사용하는 방법
//2.Runnable 인터페이스를 상속받은 자식클래스에 run() 메소드를 오버라이드 선언
//=> run() 메소드에는 프로그램 개발자에 의해 생성된 스레드가 실행할 명령 작성
//3.Thread 객체 생성 - 생성자 매개변수에 Runnable 인터페이스를 상속받은 자식클래스의 객체를 전달받아 생성
//4.Thread 객체로 start() 메소드 호출
//=> Thread 객체로 새로운 스레드를 만들어  Runnable 인터페이스를 상속받은 자식클래스의 
//오버라이드 선언된 run() 메소드에 명령 실행

public class MultiThreadApp {
	//main() 메소드에 의해 전달되는 모든 예외는 JVM에 의해 자동으로 예외 처리
	public static void main(String[] args) throws InterruptedException {
		//JVM에 의해 main 스레드가 생성되어 main() 메소드의 명령 실행
		
		/*
		//Thread 객체를 생성하여 start() 메소드 호출
		// => 새로운 스레드가 만들어지면 Thread 클래스의 run() 메소드를 호출하여 명령 실행
		// => Thread 클래스의 run() 메소드에는 명령 미존재
		Thread thread=new Thread();
		thread.start();
		*/
		
		/*
		MultiThreadOne one=new MultiThreadOne();
		one.start();
		//one.start();
		*/
		
		//Thread 객체로 start() 메소드외 다른 메소드를 호출하지 않을 경우 참조변수를 사용하지
		//않고 객체를 생성하여 직접 start() 메소드 호출
		// => 새로운 스레드가 생성되어 MultiThreadOne 클래스의 run() 메소드의 명령 실행
		new MultiThreadOne().start();	
		//하나의 Thread 객체는 start() 메소드로 하나의 스레드만 생성하여 명령 실행 가능
		new MultiThreadOne().start();	

		//Thread(Runnable target) : Runnable 인터페이스를 상속받은 자식클래스의 객체를 전달
		//받아 Thread 객체 생성
		new Thread(new MultiThreadTwo()).start();
		
		for(char i='0';i<='9';i++) {
			System.out.print(i);
			
			//Thread.sleep(long ms) : 현재 명령을 실행하는 스레드를 원하는 시간(ms)만큼 
			//일시적으로 중지하는 메소드 
			// => InterruptedException 발생 : 일반 예외 - 예외처리를 하지 않으면 에러 발생
			Thread.sleep(500);			
		}
	}
}