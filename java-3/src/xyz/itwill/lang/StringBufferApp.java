package xyz.itwill.lang;

//StringBuffer 클래스 : 문자열을 저장하기 위한 클래스
// => String 객체는 저장된 문자열을 메소드로 직접 처리하지 않고 문자열 자체를 처리하는 메소드 제공
// => StringBuffer 객체에 저장된 문자열을 직접 처리하는 메소드 제공
// => String 클래스보다 StringBuffer 클래스의 메소드가 문자열의 처리 속도가 우수
public class StringBufferApp {
	public static void main(String[] args) {
		//StringBuffer 클래스는 new 연산자로 생성자를 호출하여 객체 생성
		StringBuffer sb=new StringBuffer("ABC");
		
		//StringBuffer.toString() : StringBuffer 객체에 저장된 문자열을 반환하는 메소드
		System.out.println("sb.toString() = "+sb.toString());
		System.out.println("sb = "+sb);
		
		//StringBuffer 객체에 저장된 문자열을 반환받아 String 객체로 생성하여 참조변수에 저장
		String str=sb.toString();
		System.out.println("str = "+str);
		System.out.println("===================================================================================");
		//StringBuffer.append(Object o) : StringBuffer 객체에 저장된 문자열에 매개변수에 
		//저장된 값을 추가하는 메소드
		// => String 객체에 저장된 문자열에 += 연산자를 사용한 효과와 동일
		sb.append("DEF");
		System.out.println("sb = "+sb);
		System.out.println("===================================================================================");
		//StringBuffer.insert(int offset, Object o) : StringBuffer 객체에 저장된 문자열에 매개변수에
		//저장된 문자열을 원하는 위치에 삽입하는 메소드
		sb.insert(4,"X"); 
		System.out.println("sb = "+sb);
		System.out.println("===================================================================================");
		//StringBuffer.deleteCharAt(int index) : StringBuffer 객체에 저장된 문자열에 매개변수에
		//저장된 위치의 문자를 제거하는 메소드
		sb.deleteCharAt(2);
		System.out.println("sb = "+sb);
		System.out.println("===================================================================================");
		//StringBuffer.delete(int beginIndex, int endIndex) : StringBuffer 객체에 저장된 문자열에 매개변수에
		//저장된 시작위치부터 종료위치의 문자열을 제거하는 메소드
		sb.delete(4, 6);
		System.out.println("sb = "+sb);
		System.out.println("===================================================================================");
		//StringBuffer.reserve() : StringBuffer 객체에 저장된 문자열을 역순으로 나열되도록
		//다시 저장하는 메소드
		sb.reverse();
		System.out.println("sb = "+sb);
		System.out.println("===================================================================================");
		
	}
}
