package oop;

//실행이 목적인 클래스 => main 메소드가 선언된 클래스 - 프로그램 
public class MethodApp {
	public static void main(String[] args) {
		//클래스로 객체를 생성하여 객체의 메모리 주소를 참조변수에 저장
		// => 같은 패키지의 클래스는 패키지 표현없이 클래스만 사용하여 접근 가능
		// => 참조변수를 사용하여 객체의 필드 또는 메소드 접근
		Method method=new Method();
		//참조변수에 저장된 값을 출력할 경우 "자료형@메모리주소" 형식으로 제공된 결과값 출력
		System.out.println("method = "+method);
		System.out.println("==============================================================");
		//메소드 호출 : 메소드를 호출하면 프로그램 흐름(스레드)이 객체의 메소드로 이동하여
		//메소드의 명령을 실행하고 메소드가 종료되면 다시 되돌아와 다음 명령 실행
		method.displayOne();
		method.displayTwo();
		method.displayOne();
		System.out.println("==============================================================");
		method.printOne();
		method.printOne();
		System.out.println("==============================================================");
		method.printTwo(80);
		method.printTwo(50);
		method.printTwo(-30);
		System.out.println("==============================================================");
		//메소드 호출시 나열될 값이 매개변수에 차례대로 전달되어 저장
		method.printThree(25, 75);
		method.printThree(12, 96);
		method.printThree(77, 45);
		System.out.println("==============================================================");
		//메소드를 호출하여 반환되는 결과값을 변수에 저장
		// => 메소드 명령에 대한 결과값을 지속적으로 사용할 경우 변수에 저장
		int tot=method.returnTot(34, 86);
		//입력과 출력 명령은 프로그램에서 작성 
		// => 메소드에서는 값에 대한 계산만 하고 입력과 출력은 미작성 - 프로그램에 대한 독립성 확보
		System.out.println("합계(메소드 호출의 반환 결과값) = "+tot);
		//반환값을 일시적으로 사용할 경우 변수에 미저장
		System.out.println("합계 = "+method.returnTot(40,80));
		System.out.println("==============================================================");
		boolean result=method.isOddEven(10);
		if(result) {
			System.out.println("매개변수에 전달된 값은 [짝수]입니다.");
		} else {
			System.out.println("매개변수에 전달된 값은 [홀수]입니다.");
		}
		
		//if 구문의 조건식 대신 논리값을 반환하는 메소드를 호출하여 명령 선택 실행 
		if(method.isOddEven(11)) {
			System.out.println("매개변수에 전달된 값은 [짝수]입니다.");
		} else {
			System.out.println("매개변수에 전달된 값은 [홀수]입니다.");
		}
		System.out.println("==============================================================");
		//메소드 호출시 반환되는 배열의 메모리 주소를 참조변수에 저장 - 배열의 요소 참조 가능
		int[] array=method.returnArray();
		for(int num:array) {
			System.out.print(num+" ");
		}
		System.out.println();
		System.out.println("==============================================================");
		System.out.println("합계 = "+method.sumOne(10, 20, 30));
		//매개변수에 값이 정상적으로 전달되지 않을 경우 메소드 호출에 대한 에러 발생 
		//System.out.println("합계 = "+method.sumOne());
		//System.out.println("합계 = "+method.sumOne(10, 20));
		//System.out.println("합계 = "+method.sumOne(10, 20, 30, 40));
		System.out.println("==============================================================");
		//System.out.println("합계 = "+method.sumTwo({10,20,30}));//에러 발생
		System.out.println("합계 = "+method.sumTwo(new int[]{10, 20, 30}));
		System.out.println("합계 = "+method.sumTwo(new int[]{}));
		System.out.println("합계 = "+method.sumTwo(new int[]{10, 20}));
		System.out.println("합계 = "+method.sumTwo(new int[]{10, 20, 30, 40}));
		System.out.println("==============================================================");
		System.out.println("합계 = "+method.sumThree(10, 20, 30));
		System.out.println("합계 = "+method.sumThree());
		System.out.println("합계 = "+method.sumThree(10, 20));
		System.out.println("합계 = "+method.sumThree(10, 20, 30, 40));
		System.out.println("==============================================================");
	}
}

