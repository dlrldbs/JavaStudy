package realization;

//인터페이스(Interface) : 현재에 존재하는 대상을 클래스보다 추상적으로 표현하기 위한 자료형
// => 상수필드(Constant Field)와 추상메소드(Abstract Method)만 선언 가능
// => JDK8 이상에서는 기본메소드(Default Method)와 정적메소드(Static Method)도 선언 가능
//형식) public interface 인터페이스명 {
//			자료형 필드명=값; //상수필드 - public static final 제한자 생략 가능
//			...
//			반환형 메소드명(자료형 매개변수명,...); //추상메소드 - public abstract 제한자 생략 가능
//			...
//		}
// => 인터페이스의 이름은 파스칼 표기법 권장

//인터페이스는 클래스에게 상수필드 또는 추상메소드를 상속 - 다중 상속 가능
//형식) public class 클래스명 implements 인터페이스명,인터페이스명,...{ }
// => 인터페이스를 상속받은 자식클래스는 무조건 상속받은 모든 인터페이스의 모든 추상메소드를 오버라이드 선언
// => 인터페이스로 객체 생성은 불가능하지만 참조변수를 생성하여 자식클래스의 객체 저장 가능

//인터페이스는 다른 인터페이스 상속 가능 - 다중 상속
//형식) public interface 인터페이스명 extends 인터페이스명,인터페이스명,... { }

//인터페이스 선언하여 클래스가 상속받아 사용하는 이유
//1.클래스의 단일 상속 관련 문제를 보완하기 위해 인터페이스 사용
//ex) public class 늑대인간 extends 인간,늑대 => 불가능
//	  public class 늑대인간 extends 인간 implements 늑대 => 가능
//	  public class 흡혈늑대인간 extends 인간 implements 늑대,흡혈귀 => 가능
//2.클래스에 대한 작업지시서의 역할을 제공하기 위해 인터페이스 사용
//ex) TV & Radio & SmartPhone >> 볼륨 증가, 볼륨 감소 - 인터페이스
// => 인터페이스를 상속받은 모든 자식클래스에 동일한 형태의 메소드가 선언되도록 규칙을 제공
// => 클래스간의 결합도를 낮춰 시스템 변경에 따른 유지보수 효율성 증가

public class WolfHumanApp {
	public static void main(String[] args) {
		WolfHuman wolfHuman=new WolfHuman();
		
		wolfHuman.speak();
		wolfHuman.walk();
		wolfHuman.smile();
		wolfHuman.change();
		wolfHuman.cryLoudly();
		wolfHuman.fastWalk();
		System.out.println("===================================================================================");
		//부모클래스를 참조변수로 생성하여 자식 클래스의 객체 저장
		// => 참조변수는 부모클래스의 메소드만 호출 가능
		// => 객체 형변환을 이용하여 참조변수로 자식클래스의 메소드 호출 가능
		Human human=new WolfHuman();
		
		human.smile();
		human.speak();
		human.walk();
		System.out.println("===================================================================================");
		//명시적 객체 형변환을 이용하여 자식 클래스의 메소드 호출
		((WolfHuman)human).change();
		System.out.println("===================================================================================");
		//인터페이스로 참조변수를 저장하여 자식클래스의 객체 저장
		//Wolf wolf=new WolfHuman();
		
		//자식클래스가 같은 클래스와 인터페이스는 명시적 객체 형변환을 이용하여 자식클래스 객체 저장 가능
		//객체를 공유하여 사용 가능
		Wolf wolf=(Wolf)human;
		
		//묵시적 객체 형변환에 의해 자동으로 자식클래스의 메소드 호출
		wolf.cryLoudly();
		wolf.fastWalk();
		System.out.println("===================================================================================");
	}
}
