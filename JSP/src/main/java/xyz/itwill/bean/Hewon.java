package xyz.itwill.bean;

//JavaBean 클래스 : 웹프로그램 실행을 위해 WAS 프로그램에 의해 자동 생성되어 관리되는 
//객체를 생성하기 위한 클래스 - useBean 태그에서 사용하기 위한 클래스
// => 웹프로그램 요청시 전달된 값이 저장될 객체를 생성할 목적의 클래스

//JavaBean 클래스 작성규칙
// => 전달값의 이름과 동일한 이름으로 필드를 선언
// => public 접근지정자로 선언된 기본 생성자(매개변수가 없느 생성자)가 반드시 존재
// => 필드값을 반환하는 메소드(Getter)와 필드값을 변경하는 메소드(Setter) 메소드를 필드명을 기반으로 작성

//회원정보를 저장하기 위한 클래스 - VO 클래스
public class Hewon {
	private String name;
	private String phone;
	private String address;
	
	public Hewon() {
		// TODO Auto-generated constructor stub
	}

	public Hewon(String name, String phone, String address) {
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
