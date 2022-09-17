package basic;

//자료형(DataType) : 값이나 특정 대상을 표현하기 위한 키워드 또는 식별자 
// => 값이나 특정 대상을 저장하기 위한 변수 생성을 위해 사용
//1.원시형(PrimitiveType) : 값을 표현하기 위한 자료형 - 키워드
// => 숫자형(정수형, 실수형, 문자형) - 연산 가능, 논리형
//2.참조형(ReferenceType) : 특정 대상을 표현하기 위한 자료형 - 식별자(클래스)
// => String 클래스 : 문자열을 표현하기 위한 자료형(클래스)

//컴퓨터에서 값을 표현하는 단위 : 1Bit(0 또는 1) >> 1Byte(8Bit) - Character

public class DataTypeApp {
	public static void main(String[] args) {
		//정수형(IntegerType) 리터럴 : 소숫점이 없는 숫자값  
		// => Java의 정수형 리터럴은 기본적으로 4Byte(Interger)로 표현 >> -2147483648~2147483647
		System.out.println("<<정수형(IntegerType)>>");
		System.out.println("정수값(10진수 100) = "+100);//숫자값 >> 10진수 정수값을 표현한 리터럴
		//println() 메소드는 무조건 10진수의 정수값으로 변환하여 출력 처리
		System.out.println("정수값(8진수 100) = "+0100);//0숫자값 >> 8진수 정수값을 표현한 리터럴
		System.out.println("정수값(16진수 100) = "+0x100);//0x숫자값 >> 16진수 정수값을 표현한 리터럴
		System.out.println("정수값(10진수 100) = "+100L);//숫자값L >> 8Byte(Long)의 정수값을 표현한 리터럴
		
		System.out.println("정수값 = "+2147483647);
		//4Byte로 표현 가능한 정수값 = -2147483648~2147483647
		// => 4Byte로 표현 불가능한 정수값을 사용할 경우 에러 발생
		//System.out.println("정수값 = "+2147483648);
		//4Byte로 표현 불가능한 정수값은 정수값 뒤에 [L]를 붙여 8Byte 정수값으로 표현하여 사용
		System.out.println("정수값 = "+2147483648L);
		
		//정수값을 표현하기 위한 자료형 - byte(1Byte), short(2Byte), int(4Byte), long(8Byte)
		byte a1=127;//1Byte : -128~127
		short a2=32767;//2Byte : -32768~32767 
		int a3=2147483647;//4Byte : -2147483648~2147483647
		long a4=2147483648L;//8Byte
		
		System.out.println("a1 = "+a1);
		System.out.println("a2 = "+a2);
		System.out.println("a3 = "+a3);
		System.out.println("a4 = "+a4);
		
		//int a5=100L;//불가능 : 값에 대한 변형이 발생될 수 있으므로 에러 발생
		long a5=100;//가능
		System.out.println("a5 = "+a5);
		System.out.println("==========================================================");
		//실수형(DoubleType) 리터럴 : 소숫점이 있는 숫자값
		// => Java의 실수형 리터럴은 기본적으로 8Byte(Double)로 표현
		System.out.println("<<실수형(IntegerType)>>");
		System.out.println("실수값(4Byte) = "+12.3F);//실수값F >> 4Byte(Float)의 실수값을 표현한 리터럴 
		System.out.println("실수값(8Byte) = "+12.3);//실수값 >> 8Byte(Double)의 실수값을 표현한 리터럴
		//println() 메소드는 아주 작은 실수값 또는 아주 커다란 실수값을 지수형태로 변환하여 출력
		System.out.println("실수값(8Byte) = "+0.000000000123);
		//실수값을 지수형태로 표현하여 사용 가능
		System.out.println("실수값(8Byte) = "+1.23E10);
		
		//실수값을 표현하기 위한 자료형 - float(4Byte), double(8Byte)
		float b1=1.23456789F;//정밀도 : 7자리
		double b2=1.23456789;//정밀도 : 15자리
		
		System.out.println("b1 = "+b1);
		System.out.println("b2 = "+b2);
		System.out.println("==========================================================");
		//문자형(CharacterType) 리터럴 : ' ' 안에 하나의 문자로 표현
		// => Java의 문자형 리터럴은 기본적으로 2Byte(Double)로 표현
		// => 일반 문자와 회피 문자로 구분하여 사용
		//회피 문자(Escape Character) : 표현 불가능한 문자를 표현하기 위해 방법 - \ 기호 사용
		// => '\n' : Enter , '\t' : Tab, \' : 문자 ', \" : 문자 ", \\ : 문자 \, '\0' : NULL 문자
		//문자형 리터럴은 내부적으로 약속된 정수값(0~65535)으로 표현 : 유니코드(UniCode)
		// => 'A' : 65, 'a' : 97, '0' : 48, ' ' : 32, '\n' : 13, '가' : 44032 - 완성형
		System.out.println("<<문자형(CharacterType)>>");
		System.out.println("문자형(2Byte) = "+'A');
		System.out.println("문자형(2Byte) = "+'가');
		System.out.println("문자형(2Byte) = "+'\'');
		System.out.println("문자형(2Byte) = "+'\\');
		
		//문자값을 표현하기 위한 자료형 - char(2Byte)
		char c1='A';//문자형 변수에는 문자값에 대한 약속된 정수값이 저장
		char c2=65;//문자형 변수에는 문자값에 대한 약속된 정수값을 직접 저장 가능
		char c3='a'-32;//문자값에 대한 연산 결과값 저장 가능
		
		System.out.println("c1 = "+c1);
		System.out.println("c2 = "+c2);
		System.out.println("c3 = "+c3);
		
		char c4=45000;
		System.out.println("c4 = "+c4);
		System.out.println("==========================================================");
		//논리형(BooleanType) 리터럴 : false(거짓), true(참)
		// => Java의 논리형 리터럴은 기본적으로 1Byte(Boolean)로 표현
		System.out.println("<<논리형(BooleanType)>>");
		System.out.println("논리형(1Byte) = "+false);
		System.out.println("논리형(1Byte) = "+true);
		//관계 연산자(비교 연산자)를 이용한 연산식의 결과값으로 논리형 리터럴 제공
		System.out.println("논리형(1Byte) = "+(20<10));
		System.out.println("논리형(1Byte) = "+(20>10));
		
		//논리값을 표현하기 위한 자료형 - boolean(1Byte)
		boolean d1=false;
		boolean d2=20>10;
		System.out.println("d1 = "+d1);
		System.out.println("d2 = "+d2);
		System.out.println("==========================================================");
		//문자열(StringType) 리터럴 : " " 안에 0개 이상의 문자들로 표현
		// => 문자열은 원시형(기본형)이 아닌 참조형으로 String 클래스로 표현
		System.out.println("<<문자열(StringType)>>");
		System.out.println("문자열 = "+"홍길동");
		System.out.println("유관순 열사가 \"대한독립 만세\"를 외쳤습니다.");
		
		//문자열을 표현하기 위한 자료형 : String 클래스
		String name="임꺽정";
		System.out.println("이름 = "+name);
		System.out.println("==========================================================");
	}
}