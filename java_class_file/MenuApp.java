package basic;

import java.util.Scanner;

//키보드로 메뉴 중 하나를 입력받아 선택메뉴에 대한 기능을 제공하는 프로그램
// => [프로그램 종료] 메뉴를 선택하기 전까지 원하는 기능을 계속 제공
// => 선택 메뉴가 존재하지 않을 경우 에러메세지 출력 후 재입력
public class MenuApp {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("<<학생 관리 프로그램>>");
		
		while(true) {//무한루프
			//메뉴 출력
			System.out.println("1.학생정보 삽입");
			System.out.println("2.학생정보 변경");
			System.out.println("3.학생정보 삭제");
			System.out.println("4.학생정보 검색");
			System.out.println("5.프로그램 종료");
			
			//메뉴 선택 - 키보드로 정수값을 입력받아 저장
			System.out.print("메뉴 선택[1~5] >> ");
			int choice=scanner.nextInt();
			
			if(choice<0 || choice>5) {//비정상적인 값이 입력된 경우
				System.out.println("[에러]선택된 메뉴가 존재하지 않습니다.\n");
				continue;
			}
			
			if(choice==5) {//[5.프로그램 종료] 메뉴를 선택한 경우
				break;//반복문 종료
			}

			switch (choice) {
			case 1: 
				System.out.println("[결과]학생정보를 삽입 하였습니다.");
				break;
			case 2: 
				System.out.println("[결과]학생정보를 변경 하였습니다.");
				break;
			case 3: 
				System.out.println("[결과]학생정보를 삭제 하였습니다.");
				break;
			case 4: 
				System.out.println("[결과]학생정보를 검색 하였습니다.");
				break;
			}
			System.out.println();
		}
		
		System.out.println("[메세지]학생 관리 프로그램을 종료합니다.");
		scanner.close();
	}
}