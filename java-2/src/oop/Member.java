package oop;
  
//this : 메소드에 숨겨져 있는 매개변수 - 키워드
// => this 매개변수의 자료형은 메소드가 선언된 클래스
// => 메소드를 호출한 객체의 메모리 주소(HashCode)를 자동으로 전달받아 저장하는 참조변수
// => 메소드에서 객체의 필드 또는 메소드를 사용하기 위해 this 키워드 사용
// => this 키워드를 사용하지 않아도 자동으로 객체의 필드 또는 메소드에 접근하여 사용 가능

//메소드에 this 매개변수가 존재하는 이유
// => 필드는 객체마다 메모리(Heap)에 따라 생성되지만 메소드는 객체에 상관없이 메모리(Static)에 
//미리 하나만 생성 - 프로토타입 클래스(Prototype Class)
// => 메소드에서 필드를 사용할 때 this 키워드를 사용하여 객체를 구분하여 필드에 접근

//this 키워드를 표현하여 사용하는 경우
//1.메소드에서 매개변수의 이름을 필드의 이름과 동일하게 작성한 경우 필드를 표현하기 위해
//this 키워드 사용 - 생성자와 Setter 메소드
//2.생성자에서 다른 생성자를 호출하여 초기화 작업을 하기 위한 this 키워드 사용
//3.이벤트 처리 프로그램 또는 다중 스레드 프로그램의 메소드에서 객체 자체를 표현하기 위한 this 키워드 사용

//회원정보(아이디,이름,이메일)를 저장하기 위한 클래스
// => VO(Value Object) 클래스 : 값 저장이 목적인 객체를 생성하기 위한 클래스
public class Member {
	//필드(Field) 선언
	// => 객체 생성시 객체의 필드에는 기본값(숫자형:0,논리형:false,참조형:null)이 자동 저장
	// => 객체 생성시 필드에 저장될 기본값 변경 가능
	private String id="NoId";
	private String name="NoName";
	private String email="NoEmail";
	
	//생성자(Constructor) 선언 : 객체를 생성하기 위한 특별한 메소드
	// => 생성자를 선언하지 않으면 매개변수가 없는 기본 생성자가 제공되어 처리
	//생성자를 선언하는 이유는 객체의 필드를 원하는 값으로 초기화 처리하기 위해 선언 
	// => 생성자를 선언하면 기본 생성자는 미제공
	//형식) 접근지정자 클래스명(자료형 매개변수,...) { 초기화명령; ... }
	// => 반환형을 작성하지 않으며 생성자의 이름은 반드시 클래스의 이름과 동일하게 작성 - 작성규칙
	// => 메소드 오버로드 선언 가능 : 매개변수의 자료형 또는 갯수가 다른 여러개의 생성자 선언 가능
	
	//매개변수가 없는 생성자 - 기본 생성자(Default Constructor)
	// => 초기화 작업 미구현 - 객체 생성시 필드에는 기본값이 초기값으로 저장
	// => 매개변수가 없는 생성자를 선언하지 않으면 상속시 문제가 발생되므로 선언하는 것을 권장
	//이클립스를 사용하여 기본 생성자 자동 완성
	// => [Ctrl]+[Space] >> 나열된 목록 중 Constructor 선택 
	public Member() {
		//this(값,값,...) : this 키워드로 다른 생성자를 호출하는 명령
		// => 생성자에서만 사용 가능한 명령
		// => 다른 명령보다 먼저 실행되도록 작성 - 다른 명령이 먼저 작성된 경우 에러 발생
		//this("NoId","NoName","NoEmail");
	}
	
	//매개변수가 있는 생성자
	// => 매개변수에 전달되어 저장된 값으로 필드의 초기값으로 저장
	// => 객체 생성시 필드에 원하는 값이 저장되도록 생성자 작성
	//이클립스를 사용하여 매개변수가 있는 생성자 자동 완성
	// => [Alt]+[Shift]+[S] >> 팝업 메뉴 >> [O] >> 필드 선택 >> Generate	
	public Member(String id) {
		this.id=id;
	}
	
	public Member(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Member(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	//메소드(Method) 선언
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	//필드값을 출력하는 메소드
	public void display() {
		System.out.println("아이디 = "+id);
		System.out.println("이름 = "+name);
		System.out.println("이메일 = "+email);
	}
}
