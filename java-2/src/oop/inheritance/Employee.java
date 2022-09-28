package inheritance;

//static 제한자 - 필드, 메소드, 클래스(내부클래스)에 설정 가능한 제한자 

//final 제한자 - 필드, 메소드, 클래스에 설정 가능한 제한자
//1.final 필드 - 필드 작성 시 final 제한자를 사용하여 선언
//형식) 접근제한자 final 자료형 필드명=값;
// => 필드에 저장된 값 변경 불가능 - 필드값을 변경할 경우 에러 발생
// => 필드 선언시 반드시 초기값이 저장되도록 설정
//2.final 메소드 - final 제한자를 사용하여 선언한메소드
//형식) 접근제한자 final 반환형 메소드명(자료형 매개변수명,...) { 명령; ... }
// => 자식클래스에서 절대로 오버라이드 선언하지 못하도록 설정하는 메소드
//3.final 클래스 - final 제한자를 사용하여 선언한 클래스
//형식) public final class 클래스명 {}
// => 다른 클래스에서 상속받을 수 없는 클래스

//사원정보(사원번호,사원이름)를 저장하기 위한 클래스
// => 모든 사원 관련 클래스가 상속받아야 되는 부모클래스
// => 객체 생성이 목적이 아닌 상속이 목적인 클래스로 작성 - 추상클래스 작성하는 것을 권장
//추상클래스(Abstract Class) : abstract 제한자를 사용하여 선언된 클래스 
// => 객체 생성 불가능 -> 상속 전용 클래스
// => 형식) public abstract class 클래스명 {}
//abstract 제한자 - 클래스, 메소드에 설정 가능한 제한자
public abstract class Employee {
	private int empNo;
	private String empName;
	
	//상수필드(Constant Field) : 프로그램에서 값(리터럴) 대신 사용하기 위해 의미있는 단어로 제공되는 절대값
	//형식) public static final 자료형 상수명=값;
	// => 상수명은 스네이크 표기법을 사용하여 작성하는 것을 권장
	public static final double INCENTIVE_RATE=1.5;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empNo, String empName) {
		super();
		this.empNo = empNo;
		this.empName = empName;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	/*
	//급여를 계산하여 반환하는 메소드
	//자식클래스에서 부모클래스의 메소드를 오버라이드 선언하지 않아도 에러 미발생
	// => 자식클래스에서 메소드를 오버라이드 선언하지 않은 경우 부모클래스의 메소드 호출 - 비정상 결과 출력
	public int computePay() {
		return 0; 
	}
	*/
	
	//자식클래스에서 부모클래스의 메소드를 무조건 오버라이드 선언되도록 설정하기 위해 추상 메소드로 선언
	//추상메소드(Abstract Method) : abstract 제한자를 사용하여 선언된 메소드
	// => 메소드의 머릿부만 작성하고 몸체부는 작성하지 않는 미완성된 메소드
	//형식) 접근제한자 abstract 반환형 메소드명(자료형 매개변수명,...);
	// => 추상메소드가 선언된 클래스는 무조건 추상클래스로 선언
	public abstract int computePay();
	
	//인센티브를 계산하여 반환하는 메소드
	// => 모든 사원에게 급여의 150%를 인센티브로 제공되도록 계산
	//자식클래스에서 메소드를 오버라이드 선언하면 비정상적인 결과값 반환
	// => 자식클래스에서 메소드를 오버라이드 선언하지 못하도록 final 메소드로 선언
	public final int computeIncentive() {
		//추상메소드를 호출한 경우 묵시적 객체 형변환에 의해 자식클래스의 메소드 호출
		//return (int)(computePay()*1.5);
		return (int)(computePay()*INCENTIVE_RATE);
	}
	
}
