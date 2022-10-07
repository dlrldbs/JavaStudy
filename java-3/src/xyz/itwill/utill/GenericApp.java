package xyz.itwill.utill;

//Generic 클래스로 객체를 생성하여 사용하는 프로그램
// => 제네릭 대신 설정된 클래스의 객체만 필드에 저장 가능 - 제한적인 객체 저장
// => 필드값을 반환받아 사용할 때 명시적 객체 형변환 불필요

public class GenericApp {
	public static void main(String[] args) {
		//제네릭 클래스를 사용할 경우 제네릭 대신 사용할 클래스를 전달해야만 사용 가능
		// => 전달받아 클래스를 제네릭 대신 사용하여 필드 또는 메소드 완성
		Generic<Integer> generic1=new Generic<Integer>();
		
		//제네릭으로 설정된 클래스와 동일한 자료형의 객체를 전달하여 필드에 저장
		// => 제네릭으로 설정된 클래스와  다른 자료형의 객체를 전달할 경우 에러 발생
		generic1.setField(100);//오토박싱
		//generic1.setField(12.34);
		
		Integer returnObject1=generic1.getField();
		
		System.out.println("필드값 = "+returnObject1);
		System.out.println("===============================================================");
		Generic<Double> generic2=new Generic<Double>();
		
		generic2.setField(12.34);
		Double returnObject2=generic2.getField();
		
		System.out.println("필드값 = "+returnObject2);
		System.out.println("===============================================================");
		/*
		//제네릭의 부모클래스를 상속받지 않은 자식클래스로 제네릭 클래스를 이용하여 에러 발생
		Generic<String> generic3=new Generic<String>();
		
		generic3.setField("홍길동");
		String returnObject3=generic3.getField();
		
		System.out.println("필드값 = "+returnObject3);
		System.out.println("===============================================================");
		*/
		
		
		
	}
}
