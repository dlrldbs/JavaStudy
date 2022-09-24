package oop;

public class MemberApp {
	public static void main(String[] args) {
		//new 연산자로 클래스의 매개변수가 없는 기본 생성자를 사용하여 객체 생성
		// => 생성된 객체의 필드는 기본값으로 자동 초기화
		// => new 연산자로 호출한 생성자가 없는 경우 에러 발생 - 객체 생성 불가능
		Member member1=new Member();
	
		//Getter 메소드를 호출하여 필드값을 반환받아 출력
		System.out.println("아이디 = "+member1.getId());
		System.out.println("이름 = "+member1.getName());
		System.out.println("이메일 = "+member1.getEmail());
		System.out.println("===============================================================");
		//Setter 메소드를 호출하여 매개변수의 전달값으로 객체의 필드값 변경
		member1.setId("aaa");
		member1.setName("홍길동");
		member1.setEmail("hgd@google.com");
		
		/*
		System.out.println("아이디 = "+member1.getId());
		System.out.println("이름 = "+member1.getName());
		System.out.println("이메일 = "+member1.getEmail());
		*/
		member1.display();
		System.out.println("===============================================================");
		Member member2=new Member("bbb");
		member2.display();
		System.out.println("===============================================================");
		Member member3=new Member("ccc", "임꺽정");
		member3.display();
		System.out.println("===============================================================");
		Member member4=new Member("ddd", "전우치", "chon@itwill.xyz");
		member4.display();
		System.out.println("===============================================================");
	}
}
