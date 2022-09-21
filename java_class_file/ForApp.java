package basic;

//for : 명령에 대한 반복 횟수가 정해져 있는 경우 사용되는 명령
//형식) for(초기식;조건식;증강식) {명령; 명령; ... }
// => 초기식 : 변수에 초기값을 저장하는 연산식, 증강식 : 변수값을 증가 또는 감소시키는 연산식
// => 초기식, 조건식, 증강식은 반드시 ;를 이용하여 구분 -; 기호를 반드시 2번 사용
// => 초기식 >> 조건식(참) - { }안의 명령 실행 >> 증감식 >> 조건식(참) - { }안의 명령 실행 >> 증감식
// => 조건식의 결과가 거짓(false)인 경우 for 구문 종료
// => 조건식의 결과가 항상 참(true)인 경우 무한반복
// => 주의) 조건식의 결과가 항상 참(true)인 경우 무한반복 - 무한루프(Endless Loop)
// => 초기식, 증감식은 , 기호를 이용하여 나열 작성 가능
// => 초기식, 조건식, 증감식 생략 - 조건식이 생략된 경우 무조건 참으로 처리

//프로그램 흐름 파악하기 위한 이클립스 기능 - Debug Perspective(환경) 사용
//중지점(breakpoint) 설정 >> [F11] : Debug 기능 실행 단축기 >> Debug Perspective 변환
// >> [F6] : 현재 클래스에서 명령을 하나씩 실행(프로그램의 흐름 파악) >>
// 프로그램 강제 종료(Terminal : Ctrl+F2) >> Java Perspective 변환 >> 중지점 제거

public class ForApp {
	public static void main(String[] args) {
		//*Java Programming*를 화면에 5번 출력
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		System.out.println("==================================================================");
		//*Java Programming*를 화면에 5번 출력
		for(int i=1; i<=5; i++) {
			System.out.println("Java Programming");
		}		
		System.out.println("==================================================================");
		
		//*Java Programming*를 화면에 5번 출력
		for(int i=5; i>=5; i--) {
			System.out.println("Java Programming");
		}		
		System.out.println("==================================================================");
		//*Java Programming*를 화면에 5번 출력
		for(int i=2; i<=10; i+=2) {
			System.out.println("Java Programming");
		}		
		System.out.println("==================================================================");
		//*1	2	3	4	5* 출력
		for(int i=1; i<=5; i++) {
			System.out.println(i+"\t");
		}
		System.out.println(); //엔터(Enter(\t))만 출력
		System.out.println("==================================================================");
		//*5	4	3	2	1* 출력
		for(int i=1; i<=5; i++) {
			System.out.println((6-i)+"\t");
		}
		System.out.println();
		System.out.println("==================================================================");
		//"2	4	6	8	10" 출력
		/*
		for(int i=2;i<=10;i+=2) {
			System.out.println(i+"\t");
		}
		*/
		for(int i=1;i<=10;i++) {
			if(i%2==0) {
			System.out.println(i+"\t");
			}
		}
		System.out.println();
		System.out.println("==================================================================");
		//1~100 범위의 정수들의 합계를 계산하는 프로그램
		int tot=0; //정수들의 합계를 저장할 변경
		for(int i=1; i<=100; i++) { //tot=1+2+3...+98+99+100
			tot+=i;
		}
		System.out.println("1~100 범위의 정수들의 합계 = "+tot);
		System.out.println("==================================================================");
		//두 변수에 저장된 정수값 범위의 합계를 계산하여 출력
		int begin=20, end=80;
		/*
		if(begin>end) {
			System.out.println("[에러]시작값이 종료값보다 작아야 됩니다.");
			System.exit(0); //프로그램을 강제로 종료하는 메소드 호출
		}
		*/
		
		//시작값이 종료값보다 큰 경우 두 변수에 저장된 값을 서로 바꾸어 저장되도록 작성
		if(begin>end) {
			//알고리즘(Algorithm) : 프로그램 작성시 발생되는 문제를 해결하기 위한 명령의 모임
			//치환 알고리즘(Swap Algorithm) : 변수값을 서로 바꾸어 저장하는 알고리즘
			int temp=begin;
			begin=end;
			end=temp;
		}
		
		
		int sum=0;
		for(int i=begin;i<=end;i++) {
			sum+=i;
		}
		System.out.println(begin+end+"범위의 정수들의 합계 = "+sum);
		
		System.out.println("==================================================================");
		for(int i=1,j=5;i<=5;i++,j--) {
			System.out.println("i = "+i+", j = "+j);
		}
		System.out.println("==================================================================");
		int i=1;
		
		for(;i<=4;i++) {
			System.out.println(i+"\t");
		}
		
		for(;i>=1;i--) {
			System.out.println(i+"\t");
		}
		
		System.out.println();
		System.out.println("==================================================================");
		/*
		//조건식이 생략되면 무조건 참으로 처리 - 무한루프 : 종료되지 않는 반복문
		for(;;) {
			System.out.println("무한 반복되어 실행되는 명령");
		}
		*/
		//무한루프 하단에 작성된 명령은 실행되지 못하는 명령이므로 에러 발생
		//System.out.println("==================================================================");
		
		}
}

