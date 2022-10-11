package xyz.itwill.utill;

import java.util.Collections;
import java.util.List;

//학생관리 프로그램
public class StudentManagerApp {
	public static void main(String[] args) {
		StudentManager manager=new StudentManager();
		
		//학생정보를 전달하여 저장매체(컬렉션 필드)에 저장하는 메소드 호출
		manager.addStudent(new Student(1000, "홍길동"));
		manager.addStudent(new Student(2000, "임꺽정"));
		manager.addStudent(new Student(3000, "전우치"));
		manager.addStudent(new Student(4000, "일지매"));
		
		boolean result=manager.addStudent(new Student(5000, "장길산"));
		if(result) {
			System.out.println("[메세지]학생정보를 성공적으로 저장하였습니다.");
		} else {
			System.out.println("[메세지]이미 저장된 학번의 학생정보이므로 저장되지 않습니다.");
		}
		System.out.println("====================================================================================");
		//학번이 [2000]인 학생정보를 검색하여 출력
		Student seartStudent=manager.getStudent(2000);
		
		if(seartStudent==null) {//검색된 학생이 없는 경우
			System.out.println("[메세지]해당 학번의 학생정보를 찾을 수 없습니다.");
		} else {
			System.out.println(seartStudent);//학생정보 출력
		}
		System.out.println("====================================================================================");
		//학번이 [2000]인 이름을 [임걱정]으로 변경
		seartStudent.setName("임걱정");
		
		manager.modifyStudent(seartStudent);
		System.out.println("[메세지]학생정보를 성공적으로 변경하였습니다.");
		System.out.println("====================================================================================");
		//학번이 [4000]인 학생정보를 저장매체에서 삭제
		if(manager.removeStudent(4000)) {//삭제된 학생정보가 있는 경우
			System.out.println("[메세지]학생정보를 성공적으로 삭제하였습니다.");
		} else {
			System.out.println("[메세지]해당 학번의 학생정보를 찾을 수 없습니다.");
		}
		
		System.out.println("====================================================================================");
		//저장매체에 저장된 모든 학생정보를 반환하는 메소드 호출
		List<Student> students=manager.getStudentList();
		
		for(Student student:students) {
			//Student.toString() 메소드 자동 호출 - 필드값 반환
			System.out.println(student);
		}
		System.out.println("====================================================================================");
		//List 객체에 저장된 요소를 정렬하여 출력
		//Collections.sort(List<T>list) 메소드의 매개변수에 전달되는 List 객체는 요소값을
		//비교하기 위한 기능의 compareTo() 메소드가 오버라이드 선언되지 않은 경우 에러 발생 
		Collections.sort(students);
		
		for(Student student:students) {
			//Student.toString() 메소드 자동 호출 - 필드값 반환
			System.out.println(student);
		}
	}
}
