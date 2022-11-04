package xyz.itwill.student;

import java.util.List;

//DAO 클래스가 반드시 상속받기 위한 인터페이스
// => 추상메소드를 이용하여 모든 DAO 클래스가 동일한 형태로 작성되도록 메소드 작성 규칙 작성
public interface StudentDAO {
	//학생정보를 전달받아 STUDENT 테이블에 삽입하고 삽입행의 갯수를 반환하는 메소드
	//int insertStudent(int no,String name,String phone,String address,String birthday);
	int insertStudent(StudentDTO student);
	
	//학생정보를 전달받아 STUDENT 테이블에 저장된 학생정보를 변경하고 변경행의 갯수를 반환하는 메소드 
	int updateStudent(StudentDTO student);
	
	//학번을 전달받아 STUDENT 테이블에 저장된 학생정보를 삭제하고 삭제행의 갯수를 반환하는 메소드
	int deleteStudent(int no);
	
	//학번을 전달받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 검색하여 반환하는 메소드
	StudentDTO selectNoStudent(int no);
	
	//이름을 전달받아 STUDENT 테이블에 저장된 해당 이름의 학생목록을 검색하여 반환하는 메소드
	List<StudentDTO>  selectNameStudent(String name);
	
	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 반환하는 메소드
	List<StudentDTO> selectAllStudentList();
}
