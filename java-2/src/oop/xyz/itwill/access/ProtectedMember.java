package xyz.itwill.access;

//protected : 필드, 메소드에 사용 가능한 접근제한자
// => 같은 패키지의 클래스에서 접근 가능하도록 설정
// => 다른 패키지의 클래스에서 접근할 경우 에러 발생되지만 상속을 사용하면 접근 가능

public class ProtectedMember {
	protected int num;
	
	protected void display() {
		System.out.println("num = "+num);
	}
}