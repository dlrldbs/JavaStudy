package xyz.itwill.utill;

//학생정보(학번,이름)를 저장하기 위한 클래스 - VO(Value Object) 클래스
public class Student {
	private int num;
	private String name;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int num, String name) {
		this.num = num;
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//Object 클래스의 toString() 메소드를 오버라이드 선언
	// => VO 클래스에 저장된 필드값을 반환받아 확인하기 위해 선언
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "학번 ="+num+", 이름 = "+name;
	}
	
	//Object 클래스의 equals() 메소드를 오버라이드 선언
	// => VO 클래스에 저장된 필드값을 비교하여 결과를 반환하기 위해 선언
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			//매개변수로 전달받은 객체를 명시적 객체 형변환하여 참조변수에 저장
			Student student=(Student)obj;
			
			//메소드의 객체(this)와 매개변수로 전달받은 객체(obj)의 필드값을 비교하여 논리값 반환
			// => 학번를 비교하여 같은 경우 [true] 반환
			if(num==student.num) return true;
		}
		//비교가 불가능하거나 학번이 다른 경우 [false] 반환
		return false;
	}
	
	//Object 클래스의 hashCode() 메소드를 오버라이드 선언
	// => VO 클래스에 저장된 필드값을 비교하여 결과를 반환하기 위해 선언
	@Override
	public int hashCode() {
		return num;
	}
	
}
