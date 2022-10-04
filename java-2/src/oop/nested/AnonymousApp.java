package nested;

public class AnonymousApp {
	public static void main(String[] args) {
		//인터페이스를 이용하여 참조변수 생성은 가능하지만 객체 생성 불가능 
		// => 인터페이스는 클래스가 상속받기 위한 자료형
		// => 인터페이스를 상속받은 자식클래스는 인터페이스에 선언된 모든 추상메소드를 반드시 오버라이드 선언 
		// => 자식클래스로 객체를 생성하여 인터페이스 참조변수에 객체 저장 가능
		//Anonymous anonymous=new Anonymous();
		
		//인터페이스를 상속받은 이름이 없는 자식클래스를 작성하고 자식클래스로 객체를 생성하여
		//인터페이스 참조변수에 저장
		// => 익명의 내부클래스 (Anonymous Inner Class) : 인터페이스를 상속받은 이름이 없는 자식클래스
		// => 익명의 내부클래스에서는 반드시 인터페이스의 모든 추상메소드를 오버라이드 선언
		// => 인터페이스 대신 추상클래스를 사용하여 익명의 내부클래스로 객체 생성 가능
		Anonymous anonymous=new Anonymous() {
			
			@Override
			public void display() {
				// TODO Auto-generated method stub
				System.out.println("익명의 내부클래스의 오버라이드 메소드 호출");
			}
		};
		
		anonymous.display();
	}
}
