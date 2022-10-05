package xyz.itwill.thread;

//스레드(Thread) : 프로그램에서 명령을 실행하기 위한 최소의 작업 단위 - 프로그램 흐름

//단일 스레드 프로그램
// => JVM에 의해 생성된 main 스레드를 이용하여 main() 메소드의 명령 실행
// => main() 메소드가 종료되면 main 스레드는 자동 소멸 - 프로그램 종료
public class SingleThreadApp {
	public static void main(String[] args) {
		/*
		System.out.println("SingleThreadApp 클래스의 main() 메소드 시작");
		//Thread 클래스 : 스레드 관련 정보를 저장하고 스레드 관련 기능을 메소드로 제공하는 클래스
		//Thread.currentThread() : 현재 사용중인 스레드에 대한 Thread 객체를 반환하는 메소드
		//Thread.getName() : Thread 객체에 저장된 스레드의 이름(식별자)을 반환하는 메소드 
		System.out.println("["+Thread.currentThread().getName()
				+"] 스레드에 의해 main() 메소드의 명령 실행");
		
		//객체를 사용하여 메소드를 호출한 경우 스레드가 클래스의 메소드로 이동하여 명령 실행
		// => 메소드의 명령을 모두 실행한 뒤 다시 되돌아와 나머지 명령 실행
		new SingleThread().display();//객체를 생성한 후 메소드 호출
		
		System.out.println("SingleThreadApp 클래스의 main() 메소드 종료");
		*/
		
		new SingleThread().display();
		
		for(char i='0';i<='9';i++) {
			System.out.print(i);
		}
	}
}