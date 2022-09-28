
package xyz.itwill.access;

//package(default) : 클래스, 필드, 메소드에 사용 가능한 접근제한자
// => 클래스,필드,메소드 작성시 접근제한자 관련 키워드를 사용하지 않으면 package 접근제한자로 설정
// => 같은 패키지의 클래스에서 접근 가능하도록 설정
// => 다른 패키지의 클래스에서 접근할 경우 무조건 에러 발생 

public class PackageMember {
	int num;
	
	void display() {
		System.out.println("num = "+num);
	}
}