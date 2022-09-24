package oop;

//Car 클래스를 사용하여 작성된 프로그램
public class CarApp {
	public static void main(String[] args) {
		//Car 클래스로 객체를 생성하여 참조변수에 저장
		// => 하나의 클래스로 서로 다른 객체를 여러개 생성 가능
		// => 객체를 생성하면 객체의 필드에는 기본값(숫자형:0,논리형:false,참조형:null)이 자동 저장
		Car carOne=new Car();
		Car carTwo=new Car();
		Car carThree=carTwo;//참조변수에 다른 참조변수에 저장된 객체의 주소를 전달받아 저장
		
		System.out.println("carOne = "+carOne);
		System.out.println("carTwo = "+carTwo);
		System.out.println("carThree = "+carThree);
		System.out.println("==============================================================");
		//참조변수.필드 : 참조변수에 저장된 객체로 필드에 접근하여 사용
		//문제점)객체를 사용하여 필드에 직접 접근하여 필드값을 변경할 경우 비정상적인 값 저장 가능
		//해결법)클래스 선언시 필드를 은닉화 처리하여 선언 - 은닉화 선언된 필드에 접근할 경우 에러 발생
		//carOne.modelName="티코";//필드값 변경
		//필드값을 직접 변경하지 못하므로 필드값을 변경하는 Setter 메소드 호출하여 필드값 변경
		carOne.setModelName("티코");
		//carOne.engineStatus=true;
		carOne.setEngineStatus(true);
		//carOne.currentSpeed=100;
		carOne.setCurrentSpeed(100);
		
		//System.out.println("첫번째 자동차의 모델명 = "+carOne.modelName);//필드값 출력
		//필드값을 직접 사용하지 못하므로 필드값을 반환하는 Getter 메소드 호출하여 필드값 반환받아 출력
		System.out.println("첫번째 자동차의 모델명 = "+carOne.getModelName());//필드값 출력
		//System.out.println("첫번째 자동차의 엔진상태 = "+carOne.engineStatus);
		System.out.println("첫번째 자동차의 엔진상태 = "+carOne.isEngineStatus());
		//System.out.println("첫번째 자동차의 모델명 = "+carOne.modelName);//필드값 출력
		//System.out.println("첫번째 자동차의 현재속도 = "+carOne.currentSpeed);
		System.out.println("첫번째 자동차의 현재속도 = "+carOne.getCurrentSpeed());
		System.out.println("==============================================================");
		//carTwo.modelName="싼타페";
		carTwo.setModelName("싼타페");
		
		//System.out.println("두번째 자동차의 모델명 = "+carTwo.modelName);
		System.out.println("두번째 자동차의 모델명 = "+carTwo.getModelName());
		//System.out.println("두번째 자동차의 엔진상태 = "+carTwo.engineStatus);
		System.out.println("두번째 자동차의 엔진상태 = "+carTwo.isEngineStatus());
		//System.out.println("두번째 자동차의 현재속도 = "+carTwo.currentSpeed);
		System.out.println("두번째 자동차의 현재속도 = "+carTwo.getCurrentSpeed());
		System.out.println("==============================================================");
		//참조변수.메소드명(값,...) : 참조변수에 저장된 객체를 사용하여 메소드 호출
		carTwo.startEngine();
		carTwo.speedUp(50);
		carTwo.speedUp(30);
		carTwo.speedDown(40);
		carTwo.speedZero();
		carTwo.stopEngine();
		System.out.println("==============================================================");
	}
}
