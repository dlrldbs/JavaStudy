package basic;

//switch : 값을 비교하여 명령 선택 실행
//형식) switch(비교대상) { 
//			case 값1: 명령; 명령; ... [break;]
//			case 값2: 명령; 명령; ... [break;]
//			case 값3: 명령; 명령; ... [break;]
//			...
//			[default: 명령; 명령; ...]
//		}
// => 비교대상에는 변수 또는 연산식을 작성하여 비교하고자 하는 값을 제공
// => switch의 값을 case에 작성된 값과 비교하여 같은 경우 해당 위치로부터 작성된 모든 명령 실행
// => case의 값은 반드시 리터럴만 사용 가능하며 case의 값을 중복 선언하면 에러 발생
// => 모든 비교값이 다른 경우 default에 작성된 명령 실행 - 생략 가능
// => break 구문을 만나면 switch 구문 강제 종료

public class SwitchApp {
	public static void main(String[] args) {
		int choice=1;
		choice=2;
		choice=3;
		
		switch(choice) {
		case 1:
			System.out.println("수성으로 이동합니다.");
		case 2:
			System.out.println("금성으로 이동합니다.");
		case 3:
			System.out.println("화성으로 이동합니다.");
		}
		System.out.println("================================================");
		choice=4;
		
		//switch의 값과 case의 값이 모두 다른 경우 명령 미실행
		switch(choice) {
		case 1:
			System.out.println("수성으로 이동합니다.");
		case 2:
			System.out.println("금성으로 이동합니다.");
		case 3:
			System.out.println("화성으로 이동합니다.");
		default:
			System.out.println("지구로 이동합니다.");
		}
		
		System.out.println("================================================");
		choice=1;
		
		switch(choice) {
		case 1:
			System.out.println("수성으로 이동합니다.");
			break;
		case 2:
			System.out.println("금성으로 이동합니다.");
			break;
		case 3:
			System.out.println("화성으로 이동합니다.");
			break;
		}
		
		System.out.println("================================================");
		int jumsu = 55;
		
		//변수값이 0~100 범위의 유효값인지 아닌지를 구분하여 출력 - 입력값에 대한 유효성 검증
		if(jumsu>0 && jumsu<=100) {
		//	System.out.println("[결과]0~100 범위의 정상적인 값이 입력 되었습니다.");
		
		//변수값으로 등급을 구분하여 출력
		//100~90 : A, 89 ~ 80 : B, 79~ 70: C, 69~60 : D, 59~0 : F
		String grade="";
		switch(jumsu/10) {
			case 10:
			case 9: grade="A"; break;
			case 8: grade="B"; break;
			case 7: grade="C"; break;
			case 6: grade="D"; break;
			default : grade="F";
		}
		
		System.out.println("[결과]"+jumsu+"점은 "+grade+"학점입니다." );
		
		} else {
			System.out.println("에러]0~100 범위를 벗어난 비정상적인 값이 입력 되었습니다.");
		}
		
		System.out.println("================================================");
		
		String kor="하나";
		String eng="";
		
		switch (kor) {
		case "하나" : eng="One"; break;
		case "둘" : eng="Two"; break;
		case "셋" : eng="Three"; break;
		}
		
		System.out.println("[결과]"+kor+" = "+eng);
		System.out.println("================================================");
		
	}
}
