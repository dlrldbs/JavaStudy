package xyz.itwill.utill;

import java.util.Scanner;
import java.util.regex.Pattern;

//정규표현식 (Regular Expression) : 메타문자 (Meta Character), 회피문자 (Escape Character)등을 
//이용하여 일정한 규칙의 문자열을 표현하는 방법 - 입력값에 대한 검증
/*
^문자 : 문자(열)로 시작됨을 의미 
문자$ : 문자(열)로 종료됨을 의미 
 . : 임의의 문자 하나를 의미(\ 문자 표현 불가능)
[문자1문자2문자3] : 나열된 문자 중 하나를 의미
[^문자1문자2문자3] : 나열된 문자들이 아닌 문자 중 하나를 의미
[문자1-문자2] : 문자1부터 문자2 범위의 문자 중 하나를 의미
문자열1|문자열2|문자열3 : 나열된 문자열들 중 하나를 의미
문자열+ : 문자열이 1번이상 반복됨을 의미
문자열* : 문자열이 0번이상 반복됨을 의미
문자열? : 문자열이 0번 또는 1번 존재함을 의미
문자열{숫자} : 문자열이 숫자만큼 반복됨을 의미
문자열{숫자1,숫자2} : 문자열이 숫자1부터 숫자2 범위만큼 반복됨을 의미
(?!)문자열 : 문자열에서 대소문자를 구분하지 않음을 의미
(?=문자열) : 문자열이 반드시 포함됨을 의미
(!=문자열) : 문자열이 반드시 포함되지 않음을 의미

\s : 공백이 존재하는 문자열을 의미
\S : 공백이 존재하지 않는 문자열을 의미
\w : 영문자,숫자,특수문자(_)의 문자로만 구성된 문자열을 의미
\W : 영문자,숫자,특수문자(_)의 문자로를 제외한 문자로 구성된 문자열을 의미
\d : 숫자 형태의 문자로만 구성된 문자열을 의미
\D : 숫자 형태의 문자로만 구성되지 않은 문자열을 의미
\메타문자 : 메타문자를 일반문자로 표현함을 의미 - ex) \. : 문자.
*/

//키보드로 사용자에게 값을 입력받아 형식에 맞는 값을 비교하여 출력하는 프로그램 
// => 비정상적인 값을 입력한 경우 에러메세지를 출력하고 프로그램 종료
public class RegularExpressionApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		/*
		//아이디 입력규칙 : 영문자,숫자,특수문자(_)의 조합으로 영문자로 시작되며 6~20 범위의 문자수로
		//값으로 입력받아 사용하기 위한 규칙
		System.out.println("아이디를 입력해주세요. >> ");
		String id=scanner.nextLine();
		
		if (id==null || id.equals("")) {//사용자 입력값이 없는 경우
			System.out.println("[에러]아이디를 반드시 입력해주세요.");
			System.exit(0);
		}
		
		//아이디 관련 정규표현식을 저장하기 
		String idReg="^[a-zA-Z][a-zA-Z0-9_]{5,19}$";
		
		//Pattern 클래스 : 정규표현식을 이용하기 위한 기능을 제공하는 클래스
		//Pattern.matches(String regex, CharSquence input) : 정규표현식과 입력값을 전달받아
		//입력값이 정규표현식의 규칙과 다른 경우 [false] 반환하고 동일한 경우 [true]를 반환하는 메소드
		if(!Pattern.matches(idReg, id)) {//입력값이 정규표현식의 규칙과 다른 경우
			System.out.println("[에러]아이디를 형식에 맞게 입력해주세요.");
			System.exit(0);
		} 
		
		System.out.println("[메세지]정상적인 아이디가 입력되었습니다.");
		
		
		//비밀번호 입력규칙 : 영문자,숫자,특수문자가 반드시 1개 이상 포함되며 6~20 범위의 문자수로 
		//입력받아 사용하기 위한 규칙
		System.out.println("비밀번호를 입력해 주세요.");
		String password=scanner.nextLine();
		
		if(password==null || password.equals("")) {
			System.out.println("[에러]비밀번호를 반드시 입력해주세요.");
			System.exit(0);
		}
		
		String passwordReg="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_-]).{8,30}$";
		if(!Pattern.matches(passwordReg, password)) {
			System.out.println("[에러]비밀번호를 형식에 맞게 입력해주세요.");
			System.exit(0);
		}
		
		System.out.println("[메세지]정상적인 비밀번호가 입력되었습니다.");
		*/
		
		System.out.println("이메일을 입력해 주세요.");
		String email=scanner.nextLine();
		
		if(email==null || email.equals("")) {
			System.out.println("[에러]이메일을 반드시 입력해주세요.");
			System.exit(0);
		}
		
		//이메일 입력규칙 : [아이디@도메인] 형식으로 입력
		String emailReg="^([a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+)*$";
		if(!Pattern.matches(emailReg, email)) {
			System.out.println("[에러]이메일을 형식에 맞게 입력해주세요.");
			System.exit(0);
		}
		
		System.out.println("[메세지]정상적인 이메일을 입력되었습니다.");
		
		
		scanner.close();
	}
}
