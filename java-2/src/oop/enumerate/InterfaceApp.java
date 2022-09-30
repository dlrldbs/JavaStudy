package enumerate;

//인터페이스(클래스)에 상수필드를 선언한 경우의 단점
// => 상수필드를 값을 대표하는 단어(식별자)로 사용하기 부적절
// => 상수필드가 선언된 인터페이스 또는 클래스가 아무런 의미가 없이 접근 용도로만 사용
//위와 같은 단점을 해결하기 위해 Java에서 열거형(Enumerate)이라는 자료형(참조형) 제공
public class InterfaceApp {
	public static void main(String[] args) {
		//인터페이스에 선언된 상수필드값 출력 - 필드에 저장된 값이 제공되어 출력
		System.out.println("삽입 = "+InterfaceOne.INSERT);
		System.out.println("변경 = "+InterfaceOne.UPDATE);
		System.out.println("삭제 = "+InterfaceOne.DELETE);
		System.out.println("검색 = "+InterfaceOne.SELECT);
		System.out.println("===================================================================");
		System.out.println("삽입 = "+InterfaceTwo.ADD);
		System.out.println("변경 = "+InterfaceTwo.MODIFY);
		System.out.println("삭제 = "+InterfaceTwo.REMOVE);
		System.out.println("검색 = "+InterfaceTwo.SEARCH);
		System.out.println("===================================================================");
		//상수필드에 저장된 값과 동일한 자료형(원시형)의 변수를 생성하여 상수 저장 가능
		int choice=InterfaceOne.INSERT; //int choice=1;
		System.out.println("선택 = "+choice);
		System.out.println("===================================================================");
		switch (choice) {
		case InterfaceOne.INSERT:
			System.out.println("# 학생정보를 삽입합니다. #");
			break;
		case InterfaceOne.UPDATE:
			System.out.println("# 학생정보를 변경합니다. #");
			break;
		case InterfaceOne.DELETE: 
			System.out.println("# 학생정보를 삭제합니다. #");
			break;
		case InterfaceOne.SELECT: 
			System.out.println("# 학생정보를 검색합니다. #");
			break;
		}
	}
}
