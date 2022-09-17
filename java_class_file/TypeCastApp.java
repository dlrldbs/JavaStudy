package basic;

//형변환(TypeCast) : 값의 자료형을 일시적으로 변환하여 사용하는 방법
// => 자동 형변환(JVM), 강제 형변환(프로그래머)
public class TypeCastApp {
	public static void main(String[] args) {
		//자동 형변환 : 자료형이 다른 값을 연산하기 위해 JVM에 의해 자료형이 변환
		// => 표현의 범위가 작은 자료형의 값이 커다란 자료형의 값으로 형변환되어 연산
		// => byte - short - char - int - long - float - double
		// => int 자료형보다 작은 자료형은 무조건 int 자료형으로 형변환되어 연산 처리 
		System.out.println("결과 = "+(3+1.5));//3+1.5 >> 3.0+1.5 >> 4.5
		
		double su=10;//10 >> 10.0
		System.out.println("su = "+su);
		
		System.out.println("결과 = "+(95/10));//정수/정수 >> 정수
		System.out.println("결과 = "+(95.0/10.0));//실수/실수 >> 실수
		System.out.println("결과 = "+(95.0/10));//정수/실수 >> 실수(자동 형변환)
		System.out.println("결과 = "+(95/10.));//실수/정수 >> 실수(자동 형변환)
		
		int kor=95, eng=90;//점수 입력
		int tot=kor+eng;//총점 계산
		//double ave=tot/2;//평균 계산 - 연산 결과 : 정수값 >> 변수값 : 92.0
		double ave=tot/2.;//평균 계산 - 연산 결과 : 실수값 >> 변수값 : 92.5
		System.out.println("총점 = "+tot+", 평균 = "+ave);
		
	}
}