package oop;

//메소드(Method) : 필드를 사용하여 필요한 기능을 제공하기 위한 명령들의 모임

//메소드 선언 방법
//형식) 자료형 메소드명(자료형 변수명, 자료형 변수명,...) {
//            명령;
//            명령;
//            ...
//      }
// => 반환형(ReturnType) : 메소드를 호출하여 얻을 수 있는 결과값의 자료형
// ※ void : 무반환형 - 메소드를 호출하여 얻을 수 있는 결과값이 없는 경우 사용하는 자료형     
// => 매개변수(Parameter = Argument) : 메소드의 명령을 실행하기 메소드 호출시 값을 전달받아
//    저장하기 위한 변수

//return : 메소드를 종료하는 키워드 - 제어문
//형식1) if(조건식) return;  => 조건식의 결과가 참인 경우 메소드 종료 - 반환형) void
//형식2) return 대상; => 메소드 종료시 대상의 값을 반환하여 메소드를 호출한 명령에게 제공
// => 메소드의 반환형과 반환되는 대상의 자료형이 반드시 동일

//메소드 호출(Method Invoke) : 메소드를 호출해야 메소드의 명령이 실행되어 기능 제공
//형식) 객체.메소드명(값,값,...);
// => 객체가 저장된 참조변수를 이용하여 메소드에 접근해 메소드 호출
// => 메소드 호출시 나열된 값이 매개변수에 차례대로 전달되어 저장
// => 매개변수에 값이 정상적으로 전달되지 않은 경우 메소드 호출 불가능

//참조가 목적인 클래스 - 객체 생성을 위한 클래스 
public class Method {
	void displayOne() {
		System.out.println("### Method 클래스의 displayOne() 메소드 호출 ###");
	}
	
	void displayTwo() {
		System.out.println("### Method 클래스의 displayTwo() 메소드 호출 ###");
	}
	
	void printOne() {
		int tot=0;
		for(int i=1;i<=100;i++) {
			tot+=i;
		}
		System.out.println("1~100 범위의 정수들의 합계 = "+ tot);
	}
	
	//메소드 호출시 매개변수에 값이 정상적으로 전달되어 저장되야만 메소드의 명령 실행
	// => 매개변수에 값이 저장되지 않을 경우 메소드 호출 불가능 - 에러 발생
	void printTwo(int num) {
		//매개변수에 저장된 값에 대한 검증
		if(num<0) {//비정상적인 값이 매개변수에 저장된 경우
			System.out.println("[에러]매개변수에 0보다 큰 정수값이 저장되어야 됩니다.");
			return;//메소드 종료
		}
				
		int tot=0;
		for(int i=1;i<=num;i++) {
			tot+=i;
		}
		System.out.println("1~"+num+" 범위의 정수들의 합계 = "+ tot);
	}
	
	void printThree(int num1, int num2) {
		/*
		if(num1>num2) {//비정상적인 값이 매개변수에 저장된 경우
			System.out.println("[에러]첫번째 전달값이 두번째 전달값보다 작아야 됩니다.");
			return;//메소드 종료
		}
		*/
		
		if(num1>num2) {
			int temp=num1;
			num1=num2;
			num2=temp;
		}
		
		int tot=0;
		for(int i=num1;i<=num2;i++) {
			tot+=i;
		}
		System.out.println(num1+"~"+num2+" 범위의 정수들의 합계 = "+ tot);
	}
	
	int returnTot(int num1, int num2) {
		if(num1>num2) {
			int temp=num1;
			num1=num2;
			num2=temp;
		}
		
		int tot=0;
		for(int i=num1;i<=num2;i++) {
			tot+=i;
		}
		
		//변수에 저장된 값을 메소드 종료하며 반환
		// => 반환되는 값의 자료형과 메소드 반환형이 반드시 동일
		return tot;
	}
	
	//매개변수로 정수값을 전달받아 홀수와 짝수를 구분하여 반환하는 메소드
	// => false 반환 : 홀수, true 반환 : 짝수
	boolean isOddEven(int num) {
		if(num%2!=0) {
			return false;
		} else {
			return true;
		}
	}
	
	//배열을 반환하는 메소드
	int[] returnArray() {
		/*
		int[] array={10,20,30,40,50};
		return array;//참조변수에 저장된 배열의 메모리 주소 반환 - 배열 반환
		*/
		
		//return {10,20,30,40,50};//에러 발생
		return new int[]{10,20,30,40,50};
	}
	
	//3개의 매개변수에 정수값을 전달받아 합계를 계산하여 반환하는 메소드
	int sumOne(int num1, int num2, int num3) {
		return num1+num2+num3;
	}
	
	//배열을 전달받아 배열의 모든 요소값들의 합계를 계산하여 반환하는 메소드
	int sumTwo(int[] array) {
		int tot=0;
		for(int num:array) {
			tot+=num;
		}
		return tot;
	}
	
	//매개변수 생략 기호(...)를 사용하여 매개변수를 선언한 경우 값을 0개 이상 전달받아 저장 가능
	// => 매개변수로 값들을 전달받아 내부적으로 배열을 생성하여 요소값으로 저장  
	int sumThree(int...array) {
		int tot=0;
		for(int num:array) {
			tot+=num;
		}
		return tot;
	}
}
 