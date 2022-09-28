package xyz.itwill.access;

//public : 클래스, 필드, 메소드에 사용 가능한 접근제한자
// => 모든 패키지의 클래스에서 접근 가능하도록 설정

//public 클래스 : 다른 패키지에 클래스에서 접근할 수 있도록 작성된 클래스
// => public 클래스가 아닌 경우 다른 패키지에 클래스에서 접근 불가능 - 에러 발생
// => 소스파일에 public 클래스는 하나만 작성 가능

public class PublicMember {
	public int num;
	
	public void display() {
		System.out.println("num = "+num);
	}
}