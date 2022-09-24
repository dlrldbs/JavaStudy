package oop;
 
public class OverloadApp {
	public static void main(String[] args) {
		Overload overload=new Overload();
		
		overload.displayInt(100);
		//메소드 호출시 매개변수에 값을 잘못 전달한 경우 에러 발생
		//overload.displayInt(false);
		overload.displayBoolean(false);
		overload.displatString("홍길동");
		System.out.println("==============================================================");
		//오버로드 선언된 메소드는 매개변수에 전달되는 값에 의해 메소드를 선택 호출
		// => 메소드 오버로드에 의한 다형성
		//다형성(Polymorphism) : 같은 이름의 메소드를 호출할 경우 상태에 따라 메소드가 선택
		//호출되는 기능 - 메소드 오버로드, 메소드 오버라이드
		overload.display(200);
		overload.display(true);
		overload.display("임꺽정");
		//전달된 값을 대한 자료형의 매개변수가 없는 경우 에러 발생
		//overload.display(12.34);
		System.out.println("==============================================================");
	}
}