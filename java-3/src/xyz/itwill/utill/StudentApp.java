package xyz.itwill.utill;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StudentApp {
	public static void main(String[] args) {
		Set<Student> studentSet=new HashSet<Student>();
	
		
		studentSet.add(new Student(1000, "Gildong"));
		studentSet.add(new Student(2000, "Gguckjeong"));
		studentSet.add(new Student(3000, "Wuchi"));
		//Set 객체에 동일한 값이 저장된 Student 객체가 요소로 저장 가능
		// => Student 객체에 저장된 값은 같지만 객체는 다르므로 요소로 저장 가능
		//hashCode() 메소드와 equals() 메소드를 오버라이드 선언하여 동일한 값이 저장된
		//객체를 Set 객체의 요소로 저장하지 않도록 설정 가능
		// => 매개변수로 전달받은 객체를 기존 요소의 HashCode와 비교하고 같은 경우 필드값을
		//비교하여 같으면 Set 객체에 추가되지 않도록 동작
		//HashCode가 다르거나 비교 필드값이 다르면 Set 객체에 요소가 추가되어 저장
		studentSet.add(new Student(4000, "Gildong"));
		
		Iterator<Student> iterator=studentSet.iterator();
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		
	}
	
}
