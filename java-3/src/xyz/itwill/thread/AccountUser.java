package xyz.itwill.thread;

//은행계좌 사용자정보(은행계좌정보, 사용자명)를 저장하기 위한 클래스
public class AccountUser extends Thread {
	private Account account; //은행계좌정보 - 포함관계
	private String username; 
	
	public AccountUser() {
		// TODO Auto-generated constructor stub
	}

	public AccountUser(Account account, String username) {
		this.account = account;
		this.username = username;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public void run() {
		//프로그램 개발자에 의해 생성된 새로운 스레드가 run() 메소드의 명령 실행
		// => 은행계좌 사용자에 의한 은행계좌의 입금 처리 메소드 호출
		//account.deposit(username, 5000);
		
		synchronized (account) {
			account.withDraw(username, 5000);
		}
		
		
	}
	
}
