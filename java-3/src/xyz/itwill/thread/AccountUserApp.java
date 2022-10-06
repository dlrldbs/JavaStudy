package xyz.itwill.thread;

//다중스레드 프로그램의 문제점
//동일한 다수의 스레드가 run()메소드의 명령을 동시에 실행할 경우 메소드를 호출하여 
//필드값(공유)을 변경하면 잘못된 처리결과 발생 가능  
//해결법)스레드 동기화를 이용하여 스레드에 대한 메소드 호출 제어
//스레드 동기화(Thread Synchronize) : 스레드에 의한 메소드 호출 시 메소드의 명령을 모두 처리 
//하기 전까지 다른 스레드에 호출을 방지하기 위한 기능
// => 스레드를 일시 중지하여 명령이 실행되지 않도록 스레드 락(Lock) 기능 제공

//스레드 동기화 처리 방법
//1.Synchronized 키워드를 이용하여 스레드 선언 - 동기화 메소드 (Synchronized Method) 
//형식) 접근제한자 synchronized 반환형 메소드명(자료형 매개변수명,...) {}
//2.Synchronized 키워드로 블럭을 설정하여 메소드 호출
//형식) synchronized(객체) {객체,메소드명(값,...); ,,,}
// => 객체로 호출되는 모든 메소드는 동기화 처리되어 실행
 

public class AccountUserApp {
	public static void main(String[] args) {
		//은행계좌정보를 생성하여 저장
		Account account=new Account(10000); //잔액 : 10000원
		
		/*
		//단일 스레드를 이용하여 은행계좌사용자를 생성하여 입금 처리
		AccountUser[] users=new AccountUser[3];
		users[0]=new AccountUser(account, "홍길동");
		users[1]=new AccountUser(account, "임꺽정");
		users[2]=new AccountUser(account, "전우치");
		
		for(AccountUser user:users) {
			user.getAccount().deposit(user.getUsername(), 5000);
		}
		*/
		
		//다중 스레드를 이용하여 은행계좌 사용자를 생성하여 입금 처리
		new AccountUser(account, "홍길동").start();
		new AccountUser(account, "임꺽정").start();
		new AccountUser(account, "전우치").start();
		
	}
}
