package inheritance;

//이벤트 관련 회원정보(아이디,이름,이메일)를 저장하기 위한 클래스
// => 회원정보를 저장하는 Member 클래스(아이디,이름)를 상속받아 작성하는 것을 권장 - 재사용성 증가
// => extends 키워드로 기존 클래스(부모클래스)를 상속받아 새로운 클래스(자식클래스) 작성
// => 자식클래스는 부모클래스의 필드 또는 메소드에 접근하여 사용 가능 - 상속성(Inheritance)
// => Java에서는 단일 상속만 가능 - 부모클래스는 하나만 설정 가능
public class MemberEvent extends Member {
	/*
	//부모클래스(Member)을 상속받아 사용하므로 필드 미선언 
	private String id;
	private String name;
	*/
	private String email;
	
	//자식클래스의 메소드에서 this 키워드로 자식클래스 객체의 필드 또는 메소드를 참조하고
	//없는 경우 자동으로 super 키워드로 부모클래스 객체의 필드 또는 메소드 참조
	//super 키워드 : 자식클래스의 메소드에서 부모클래스의 객체를 저장하기 위한 숨겨진 매개변수
	// => super 키워드로 자식클래스의 메소드에서 부모클래스 객체의 필드 또는 메소드에 접근
	// => super 키워드를 사용하지 않아도 자식클래스의 메소드에서는 부모클래스 객체의 필드 또는 메소드 사용 가능
	
	//super 키워드를 사용하는 경우
	//1.자식클래스의 생성자에서 부모클래스의 생성자를 호출하기 위해 super 키워드 사용
	// => 형식) super(값,값,...);
	// => 부모클래스의 생성자를 호출하는 명령 전에 다른 명령을 작성하면 에러 발생
	//2. 자식클래스의 메소드에서 부모클래스의 숨겨진 메소드를 호출하기 위해 super 키워드 사용
	// => 형식) super.메소드명(값,값,..);
	
	
	
	public MemberEvent() {
		//부모클래스의 기본생성자 호출 - 부모클래스의 객체 생성
		//super();//기본생성자를 호출하는 명령은 생략 가능
	}

	/*
	public MemberEvent(String id, String name, String email) {
		super();//기본생성자 호출
		//자식클래스에서 필드 또는 메소드에 접근하는 순서 
		// => 자식클래스의 필드 또는 메소드 참조 후 없는 경우 부모클래스의 필드 또는 메소드 참조
		// => 부모클래스의 은닉화 선언된 필드 또는 메소드 접근 불가능
		//this.id = id;
		setId(id);
		//this.name = name;
		setName(name);
		this.email = email;
	}
	*/

	//[Alt]+[Shift]+[S] >> 팝업메뉴 >> [O] >> 부모클래스의 생성자 선택 >> 필드 선택 >> Generate
	public MemberEvent(String id, String name, String email) {
		//부모클래스의 매개변수가 선언된 생성자 호출 
		// => 부모클래스 객체에 원하는 초기값이 저장되도록 설정 - Setter 메소드 미호출
		super(id, name);
		this.email = email;
	}

	/*
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
	*/

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	/*
	//메소드 오버라이드(Method Override) : 상속 관계에서 부모클래스의 메소드를 자식클래스에서
	//재선언하는 기능
	// => 부모클래스의 메소드를 자식클래스의 객체가 사용하기 부적절한 경우 부모클래스의 메소드를
	//자식클래스에서 재선언하여 사용
	//메소드 오버라이드 작성 규칙 - 부모클래스의 메소드와 같은 접근제한자, 반환형, 메소드명, 매개변수, 예외전달을 사용하여 메소드 작성
	// => 부모클래스의 메소드는 숨겨지고 자식클래스의 메소드에만 접근 가능
	public void display() {
		//System.out.println("아이디 = "+id);
		System.out.println("아이디 = "+getId());
		//System.out.println("이름 = "+name);
		System.out.println("이름 = "+getName());
		System.out.println("이메일 = "+email);
	}
	*/
	
	//이클립스에서는 부모클래스의 메소드를 자식클래스에서 오버라이드 선언하도록 자동완성하는 기능 제공
	// => 오버라이드 선언하고 싶은 부모클래스의 메소드명을 입력 >> [Ctrl] + [Space] >> Override 선언
	//@Override : 오버라이드 선언된 메소드를 표현하기 위한 어노테이션
	// => 메소드 오버라이드 작성 규칙을 위반한 경우 에러 발생
	//어노테이션(Annotation) : API 문서에서 특별한 설명을 제공하기 위한 기능을 구현
	// => Java Source작성에 필요한 특별한 기능을 제공 위해 사용되는 어노테이션 : 
	@Override
	public void display() {
		//super 키워드로 부모클래스의 숨겨진 메소드 호출
		super.display();//아이디와 이름 출력
		System.out.println("이메일 = "+email);
		
	}
	
	
	
}