package xyz.itwill.lang;

import java.util.Scanner;

//키보드로 주민등록번호를 입력받아 생년월일과 성별을 출력하는 프로그램 작성
// => 주민번호는 14자리이며 7번째 자리에 반드시 - 문자가 존재
// => 비정상적인 주민번호가 입력된 경우 에러 메세지 출력 후 재입력되도록 처리
//ex) 주민번호 입력[ex.901225-1234567] >> 000101-456789
//		[결과]생년월일 - 2000년 01월 1일, 성별 = 여자
public class PersonNumberApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		//주민번호를 입력받아 저장 >> 입력값 검증
		String number;
		while(true) {
			System.out.print("주민번호 입력 >> ");
			//입력된 문자열의 앞뒤 공백을 제거한 후 변수에 저장
			//number=scanner.nextLine().trim();
			//입력된 문자열의 모든 공백을 제거한 후 변수에 저장
			number=scanner.nextLine().replace(" ","");
			//정상적인 주민번호가 입력된 경우 반복문 종료
			//if(number.length()==14 && number.charAt(6)=="-") break;
			if(number.length()==14 && number.indexOf("-")==6) break;
			System.out.println("[에러]형식에 맞게 주민번호를 입력해 주세요.");
			
		}	
		
		scanner.close();
		
		//입력된 주민번호에서 8번째 자리의 문자를 분리하여 저장
		String separation=number.substring(7, 8);
		//System.out.println("separation"+separation);
		
		//입력된 주민번호에서 생년월일을 분리하여 저장
		String birthday="";
		if(separation.equals("1") || separation.equals("2")) {
			//String.concat(String str) : String 객체에 저장된 문자열에 매개변수에 저장된 
			//문자열을 결합하여 반환하는 메소드 >> + 연산자로 문자열을 결합하는 것을 권장
			//birthday=birthday.concat("19");
			birthday+="19";
		} else if (separation.equals("3") || separation.equals("4")) {
			birthday+="20";
		}
		
		birthday+=number.substring(0,2)+"년 ";
		birthday+=number.substring(2,4)+"월 ";
		birthday+=number.substring(4,6)+"일 ";
		
		//입력된 주민번호에서 성별을 구분하여 저장
		String gender="";
		if(separation.equals("1") || separation.equals("3")) {
			gender="남자";
		} else if (separation.equals("2") || separation.equals("4")) {
			gender="여자";
		}
		
		System.out.println("[결과]생년월일"+birthday+", 성별 = "+gender);
		
	}
}
