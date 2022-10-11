package xyz.itwill.utill;

import java.util.ArrayList;
import java.util.List;

//학생정보를 관리(저장,변경,삭제,검색 - CRUD)하는 기능을 제공하는 클래스
// => BO(Business Object) 클래스 - Manager 클래스
public class StudentManager {
	//다수의 학생정보를 저장하기 위한 컬렉션 필드
	private List<Student> studentList=new ArrayList<Student>();
	
	//학번을 전달받아 컬렉션 필드에 저장된 요소의 학번과 비교하여 같은 요소의 첨자를 반환하는 메소드
	private int getStudentIndex(int num) {
		int index=-1;
		
		//컬렉션 필드에 저장된 모든 요소에 일괄처리 하기 위한 반복문 
		for(int i=0;i<studentList.size();i++) {
			//컬렉션 필드에 저장된 요소의 학번과 매개변수로 전달받은 학번이 같은 경우
			if(studentList.get(i).getNum()==num) {
				index=i;//변수의 요소의 첨자 저장
				break;
			}
		}
		
		return index;//요소의 첨자 반환 - 컬렉션 필드에서 요소가 미검색된 경우 -1 반환
	}
	
	//학생정보를 전달받아 컬렉션 필드의 요소로 추가하고 처리 결과를 반환하는 메소드
	// => false 반환 : 컬렉션피드에 요소 추가 실패, true 반환 : 컬렉션피드에 요소 추가 성공
	// => 전달받은 학생정보의 학번이 이미 컬렉션 필드에 저장된 요소의 학번과 같은 경우 추가되지 않도록 작성 - 중복 저장 방지
	public boolean addStudent(Student student) {
		//콜렉션 필드에 저장된 학번의 학생정보인 경우
		if(getStudentIndex(student.getNum())!=-1) {
			return false;
			}
		
			studentList.add(student);
			return true;
		
	}
	
	
	//학생정보를 전달받아 컬렉션 필드의 요소를 변경하고 처리 결과를 반환하는 메소드
	// => false 반환 : 컬렉션피드에 요소 변경 실패, true 반환 : 컬렉션피드에 요소 변경 성공
	// => 전달받은 학생정보의 학번이 컬렉션 필드에 저장된 요소의 학번이 아닌 경우 변경 실패 
	public boolean modifyStudent(Student student) {
		int index=getStudentIndex(student.getNum());
		
		//컬렉션 필드에 저장된 학번의 학생정보가 아닌 경우
		if(index==-1) {
			return false;
		}
		
		studentList.set(index, student);
		return true;
	}
	
	//학번을 전달받아 컬렉션 필드의 요소를 삭제하고 처리 결과를 반환하는 메소드
	// => false 반환 : 컬렉션피드에 요소 삭제 실패, true 반환 : 컬렉션피드에 요소 삭제 성공
	// => 전달받은 학번이 컬렉션 필드에 저장된 요소의 학번이 아닌 경우 삭제 실패 
	public boolean removeStudent(int num) {
		int index=getStudentIndex(num);
		
		//컬렉션 필드에 저장된 학번의 학생정보가 아닌 경우
		if(index==-1) {
			return false;
		}
		
		studentList.remove(index);
		return true;
	}
	
	//학번을 전달받아 컬렉션 필드의 요소를 검색하여 반환하는 메소드
	public Student getStudent(int num) {
		int index=getStudentIndex(num);
		
		//컬렉션 필드에 저장된 학번의 학생정보가 아닌경우
		if(index==-1) {
			return null; //검색된 학생정보가 없는 경우 null 반환
		}
		
		return studentList.get(index);//객체에서 첨자위치의 요소를 반환하는 메소드 호출
	}
	
	
	//컬렉션 필드에 저장된 모든 학생정보를 반환하는 메소드
	public  List<Student> getStudentList() {
		return studentList;
	}
}
