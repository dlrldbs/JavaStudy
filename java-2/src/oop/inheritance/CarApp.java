package inheritance;

public class CarApp {
	public static void main(String[] args) {
		Car car=new Car("싼타페","홍길동");
		
		System.out.println("모델명 = "+car.getModelName());
		System.out.println("소유자 = "+car.getUserName());
		System.out.println("=================================================================");
		/*
		//Object.toString():참조변수에 저장된 객체정보(메모리주소)를 문자열로 변환하여 반환하는 메소드
		System.out.println("car.toString() = "+car.toString());
		//참조변수를 출력할 경우 자동으로 Object 클래스의 toString() 메소드 호출
		*/
		
		//Object 클래스의 toString() 메소드를 오버라이드 선언한 경우 자식클래스의 메소드 호출
		System.out.println("car = "+car);
		System.out.println("=================================================================");
		String name="홍길동";
		
		//String 클래스에서 toString() 메소드를 오버라이드 선언하여 String 클래스의 메소드 호출
		//String.toString() : String 객체에 저장된 문자열을 반환하는 메소드
		//System.out.println("name.toString() = "+name.toString());
		//참조변수 출력시 toString() 메소드 호출 생략 가능
		System.out.println("name = "+name);
		System.out.println("=================================================================");
		
		
	}
}
