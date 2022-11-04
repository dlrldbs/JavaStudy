package xyz.itwill.student;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Pattern;

//학생정보를 관리하는 프로그램 작성
// => 메뉴 선택에 따른 학생정보 삽입,변경,삭제,검색 기능 제공
// => 입력과 출력은 프로그램에서 구현하고 데이터 처리는 DAO 클래스의 메소드를 호출하여 처리되도록 구현
// => DAO 디자인 패턴을 이용한 프로그램
public class StudentManagerApp {
	//키보드 입력스트림을 저장하기 위한 필드
	private BufferedReader in;
	
	public StudentManagerApp() {
		//키보드로 문자열을 입력받기 위한 입력 스트림 생성
		in=new BufferedReader(new InputStreamReader(System.in));
		
		String[] menu={"1.학생정보 삽입","2.학생정보 변경","3.학생정보 삭제","4.학생이름 검색","5.학생목록 출력","6.프로그램 종료"};
		
		System.out.println("<<학생 관리 프로그램>>");
		
		while(true) {
			//메뉴 출력
			for(String item:menu) {
				System.out.println(item);
			}
			
			//메뉴 선택
			int choice;
			try {
				System.out.print("선택[1~6] >> ");
				choice=Integer.parseInt(in.readLine());
				if(choice<1 || choice>6) { //비정상적 입력값인 경우
					throw new Exception();//인위적 예외 발생
				}
			} catch (Exception e) {//모든 예외에 대한 처리 가능
				System.out.println("[에러]메뉴를 잘못 선택하였습니다.");
				System.out.println();
				continue;
			}
			System.out.println();
			
			if(choice==6) break;
			
			//메뉴 선택에 따른 메소드 호출
			switch (choice) {
			case 1: addStudent(); break;
			case 2: modifyStudent(); break;
			case 3: removeStudent(); break;
			case 4: searchNameStudent(); break;
			case 5:  displayAllStudent(); break;
			case 6: break;
			}
			System.out.println();
		}
		
		System.out.println("[메세지]학생 관리 프로그램을 종료합니다.");
	}
	
	
	public static void main(String[] args) {
		new StudentManagerApp();
	}
	
	//[1.학생정보 삽입] 메뉴를 선택한 경우 호출되는 메소드
	// => 키보드로 학생정보를 입력받아 STUDENT 테이블에 삽입하고 처리결과를 반환받아 출력
	public void addStudent() {
		System.out.println("### 학생정보 삽입 ###");
		
		try {
			//키보드로 학생정보를 입력받아 저장 - 입력값 검증
			// => 입력값 검증이 실패한 경우 재입력 되도록 처리
			int no;//학번을 입력받아 저장하기 위한 변수
			while(true) {//학번 입력값을 검증하기 위한 반복문
				System.out.print("학번 입력 >>");
				String noTemp=in.readLine();
				
				if(noTemp==null || noTemp.equals("")) {//입력값이 존재하지 않는 경우 
					System.out.print("[입력오류]학번을 반드시 입력해 주세요.");
					continue;//반복문 재실행
				}
				
				//학번에 대한 입력패턴을 저장한 정규표현식 작성
				String noReg="^[1-9][0-9]{3}$";
				if(!Pattern.matches(noReg, noTemp)) {//정규표현식과 입력값의 패턴이 다른 경우
					System.out.println("[입력오류]학번을 4자리 숫자로만 입력해 주세요.");
					continue;
				}
				
				no=Integer.parseInt(noTemp); //문자열을 정수값으로 변환하여 저장
				
				//STUDENT 테이블에 저장된 기존 학생정보의 학번과 중복된 경우 재입력 되도록 작성
				//학번을 전달받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 검색하여 처리
				// => StudentDAOImpl 클래스의 selectNOStudent(int no) 메소드 호출
				StudentDTO student=StudentDAOImpl.getDAO().selectNoStudent(no);
				if(student!=null) {//검색행이 있는 경우 - 학번이 중복된 경우
					System.out.println("[입력오류]현재 사용 중인 학번입니다. 다시 입력해 주세요.");
					continue;
				}
				
				break;//반복문 종료
			}
			
			String name;//이름을 저장하기 위한 변수
			while(true) {//이름 입력값을 검증하기 위한 반복문
				System.out.print("이름 입력 >> ");
				name=in.readLine();
				
				if(name==null || name.equals("")) {//입력값이 존재하지 않는 경우
					System.out.println("[입력오류]이름을 반드시 입력해 주세요.");
					continue;//반복문 재실행
				}
				
				//이름에 대한 입력패턴을 저장한 정규표현식 작성
				String nameReg="^[가-힣]{2,5}$";
				if(!Pattern.matches(nameReg, name)) {//정규표현식과 입력값의 패턴이 다른 경우
					System.out.println("[입력오류]이름은 2~5 범위의 한글만 입력해 주세요.");
					continue;
				}
				
				break;
			}
			
			String phone;//전화번호를 저장하기 위한 변수
			while(true) {//전화번호 입력값을 검증하기 위한 반복문
				System.out.print("전화번호 입력 >> ");
				phone=in.readLine();
				
				if(phone==null || phone.equals("")) {//입력값이 존재하지 않는 경우
					System.out.println("[입력오류]전화번호를 반드시 입력해 주세요.");
					continue;//반복문 재실행
				}
				
				//전화번호에 대한 입력패턴을 저장한 정규표현식 작성
				String phoneReg="(01[016789])-\\d{3,4}-\\d{4}";
				if(!Pattern.matches(phoneReg, phone)) {//정규표현식과 입력값의 패턴이 다른 경우
					System.out.println("[입력오류]전화번호를 형식에 맞게 입력해 주세요.");
					continue;
				}
				
				break;
			}
			
			String address;//주소를 저장하기 위한 변수
			while(true) {//주소 입력값을 검증하기 위한 반복문
				System.out.print("주소 입력 >> ");
				address=in.readLine();
				
				if(address==null || address.equals("")) {//입력값이 존재하지 않는 경우
					System.out.println("[입력오류]주소를 반드시 입력해 주세요.");
					continue;//반복문 재실행
				}
								
				break;
			}
			
			String birthday;//생년월일을 저장하기 위한 변수
			while(true) {//생년월일 입력값을 검증하기 위한 반복문
				System.out.print("생년월일 입력 >> ");
				birthday=in.readLine();
				
				if(birthday==null || birthday.equals("")) {//입력값이 존재하지 않는 경우
					System.out.println("[입력오류]생년월일을 반드시 입력해 주세요.");
					continue;//반복문 재실행
				}
				
				//생년월일에 대한 입력패턴을 저장한 정규표현식 작성
				String birthdayReg="(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])";
				if(!Pattern.matches(birthdayReg, birthday)) {//정규표현식과 입력값의 패턴이 다른 경우
					System.out.println("[입력오류]생년월일을 형식에 맞게 입력해 주세요.");
					continue;
				}
				
				break;
			}
			
			//입력받은 학생정보를 이용하여 StudentDTO 객체를 생성하여 필드값 변경
			// => DAO 클래스의 메소드를 호출하기 위해 필요한 값(객체)을 객체로 변환하여 전달
			StudentDTO student=new StudentDTO();
			student.setNo(no);
			student.setName(name);
			student.setPhone(phone);
			student.setAddress(address);
			student.setBirthday(birthday);
			
			//입력받은 학생정보를 이용하여 STUDENT 테이블에 삽입 처리
			// => StudentDAOImpl 클래스의 insertStudent(StudentDTO student) 메소드 호출
			//싱글톤 클래스는 객체를 반환받아 메소드를 직접 호출하여 사용 - 참조변수 불필요 
			int rows=StudentDAOImpl.getDAO().insertStudent(student);
			
			System.out.println("[처리결과]"+rows+"명의 학생정보를 삽입하였습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//[2.학생정보 변경] 메뉴를 선택한 경우 호출되는 메소드
	public void modifyStudent() {
			
	}
	
	//[3.학생정보 삭제] 메뉴를 선택한 경우 호출되는 메소드
	public void removeStudent() {
			
	}	
	
	//[4.학생정보 검색] 메뉴를 선택한 경우 호출되는 메소드
	public void searchNameStudent() {
			
	}
	
	//[5.학생정보 출력] 메뉴를 선택한 경우 호출되는 메소드
	// => STUDENT 테이블에 저장된 모든 학생정보를 검색하여 결과를 반환받아 출력 
	public void displayAllStudent() {
			System.out.println("### 학생목록 출력 ###");
			
			//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 저장
			// => StudentDAOImpl 클래스의 selectAllStudentList(StudentDTO student) 메소드 호출
			List<StudentDTO> studentList=StudentDAOImpl.getDAO().selectAllStudentList();
			
			//List.isEmpty() : List 객체에 요소가 있는 경우 [false]를 반환하고 요소가 없는 
			//경우 [true]를 반환하는 메소드
			if(studentList.isEmpty()) {
				System.out.println("[처리결과]저장된 학생정보가 없습니다.");
				return;
			}
			
			System.out.println("=============================================================");
			System.out.println("학번\t이름\t전화번호\t주소\t\t생년월일");
			System.out.println("=============================================================");
			//List 객체의 요소를 제공받아 처리하는 반복문
			for(StudentDTO student:studentList) {
				System.out.println(student.getNo()+"\t"+student.getName()+"\t"+student.getPhone()+"\t"+student.getAddress()+"\t"+student.getBirthday());
			}
			System.out.println("=============================================================");
	}
}
