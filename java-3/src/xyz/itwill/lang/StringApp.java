package xyz.itwill.lang;

//String 클래스 : 문자열을 표현하기 위한 클래스
// => 문자열을 저장하기 위한 객체
// => String 객체에 저장된 문자열에 대한 다양한 기능을 메소드로 제공
// => String 객체는 문자열을 내부적으로 byte 배열로 처리하여 배열 요소에 문자를 하나씩 저장 
public class StringApp {
	public static void main(String[] args) {
		//문자열은 " " 기호를 사용하여 String 객체로 표현 가능
		// => " " 기호를 사용하여 String 객체를 생성할 경우 메모리의 메소드 영역에 객체 생성
		// => 정적영역 (메소드영역)에는 동일한 문자열이 저장된 String 객체를 하나만 생성
		String str1="ABC"; //String 객체를 생성하여 참조변수에 저장
		
		//String.toString() : String 객체에 저장된 문자열을 반환하는 메소드
		System.out.println("str1.toString() = "+str1.toString());
		//참조변수를 출력할 경우 toString() 메소드 호출 - 메소드 호출 생략 가능
		System.out.println("str1 = "+str1);
		System.out.println("===================================================================================");
		// " " 기호를 사용하여 String 객체를 표현한 경우 동일한 문자열이 저장된 String 객체가 
		//존재하면 기존 String 객체를 제공받아 사용 - String 객체 재사용
		String str2="ABC";
		
		//참조변수를 == 연산자로 비교한 경우 참조변수에 저장된 객체의 메모리 주소를 비교
		// => String 객체의 문자열을 비교하는 것이 아니라 String 객체의 메모리 주소를 비교
		if(str1==str2) {
			System.out.println("str1 변수와 str2 변수에 저장된 String 객체의 메모리 주소가 같습니다. ");
		} else {
			System.out.println("str1 변수와 str2 변수에 저장된 String 객체의 메모리 주소가 다릅니다. ");
		}
		System.out.println("===================================================================================");
		//new 연산자로 생성자를 호출하여 String 객체를 생성한 경우 메모리의 Heap 영역에 객체 생성
		String str3=new String("ABC");
		
		if(str1==str3) {
			System.out.println("str1 변수와 str3 변수에 저장된 String 객체의 메모리 주소가 같습니다. ");
		} else {
			System.out.println("str1 변수와 str3 변수에 저장된 String 객체의 메모리 주소가 다릅니다. ");
		}
		System.out.println("===================================================================================");
		//String.equals(String str) : String 객체에 저장된 문자열과 매개변수로 전달받은
		//문자열을 비교하여 다른 경우 false를 반환하고 같은 경우 true를 반환하는 메소드
		// => 영문자는 대소문자를 구분하여 비교
		if(str1.equals(str3)) {
			System.out.println("str1 변수와 str3 변수에 저장된 String 객체의 문자열이 같습니다.");
		} else {
			System.out.println("str1 변수와 str3 변수에 저장된 String 객체의 문자열이 다릅니다. ");
		}
		System.out.println("===================================================================================");
		String str4="abc";
		
		if(str1.equals(str4)) {
			System.out.println("str1 변수와 str3 변수에 저장된 String 객체의 문자열이 같습니다.");
		} else {
			System.out.println("str1 변수와 str3 변수에 저장된 String 객체의 문자열이 다릅니다. ");
		}
		System.out.println("===================================================================================");
		//(String.equalsIgnoreCase(String str) : String 객체에 저장된 문자열과 매개변수로
		//전달받은 문자열을 대소문자를 구분없이 비교하여 다른 경우 false를 반환하고 같은 경우
		//true를 반환하는 메소드
		if(str1.equalsIgnoreCase(str4)) {
			System.out.println("str1 변수와 str4 변수에 저장된 String 객체의 문자열이 같습니다.");
		} else {
			System.out.println("str1 변수와 str4 변수에 저장된 String 객체의 문자열이 다릅니다. ");
		}
		System.out.println("===================================================================================");
		//String.compareTo(String str) : String 객체에 저장된 문자열과 매개변수로 전달받은 
		//문자열을 비교하여 String 객체의 문자열이 큰 경우 양수를 반환하고 매개변수의 문자열이
		//큰 경우 음수를 반환하며 같은 경우 0을 반환하는 메소드
		if(str1.compareTo(str4)>0) {
			System.out.println("str1 변수에 저장된 문자열이 str4 변수에 저장된 String 객체의 문자열보다 큽니다.");
		} else if (str1.compareTo(str4)<0) {
			System.out.println("str1 변수에 저장된 문자열이 str4 변수에 저장된 String 객체의 문자열보다 작습니다.");
		} else {
			System.out.println("str1 변수에 저장된 문자열이 str4 변수에 저장된 String 객체의 문자열과 같습니다.");
		}
		System.out.println("===================================================================================");
		//String.getBytes() : String 객체에 저장된 문자열을 byte 배열로 변환하여 반환하는 메소드
		// => byte 배열의 요소에는 문자열의 문자 코드값(정수값)이 차례대로 저장
		byte[] array=str1.getBytes();
		
		for(byte ch:array) {
			//byte 배열 요소값을 문자료 형변환하여 출력
			System.out.print((char)ch);
		}
		System.out.println();
		System.out.println("===================================================================================");
		
	}
}
