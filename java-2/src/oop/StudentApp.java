package oop;

public class StudentApp {
	public static void main(String[] args) {
		/*
		Student student1=new Student(1000,"홍길동",90,90);
		Student student2=new Student(2000,"임꺽정",94,98);
		Student student3=new Student(3000,"전우치",92,80);
		Student student4=new Student(4000,"일지매",76,82);
		Student student5=new Student(5000,"배성진",84,86);
		
		//student1.calcTot();
		//student2.calcTot();
		//student3.calcTot();
		//student4.calcTot();
		//student5.calcTot();
		
		student1.display();
		student2.display();
		student3.display();
		student4.display();
		student5.display();
		System.out.println("=======================================================");
		student1.setKor(100);
		//student1.calcTot();
		student1.display();
		System.out.println("=======================================================");
		
		
		//객체를 저장할 수 있는 참조요소가 5개인 배열 생성
		Student[] students=new Student[5];
		
		//배열의 참조요소에 객체를 생성하여 저장 - 객체 배열
		students[0]=new Student(1000,"홍길동",90,90);
		students[1]=new Student(2000,"임꺽정",94,98);
		students[2]=new Student(3000,"전우치",92,80);
		students[3]=new Student(4000,"일지매",76,82);
		students[4]=new Student(5000,"배성진",84,86);
		
		//참조변수(요소)에 null이 저장된 상태에서 메소드를 호출한 경우 NullPointerException 발생 가능
		for (int i=0;i<students.length;i++) {
			//참조변수(요소)에 저장된 값이 null이 아닌 경우에만 메소드 호출
			// => NullPointerException 발생 방지
			if(students[i]!=null) {
				students[i].display();
			}
		}	
		System.out.println("=======================================================");
		*/
		Student[] students= {new Student(1000,"홍길동",90,90), new Student (2000,"임꺽정",94,98)
							, new Student (3000,"전우치",92,80),new Student (4000,"일지매",76,82)
							, new Student (5000,"배성진",84,86)};
		
		//int total=0; //모든 학생들의 성적 합계를 저장하기 위한 변수
		
		for (Student student:students) {
			student.display();
			
			//total+=student.get.Tot(); //학생 총점을 반환받아 총합계 변수에 누적
			
			//total+=student.getTot(); //학생 총점을 반환받아 총합계 변수에 누적
			//정적 필드는 클래스를 이용하여 접근 
			//형식)클래스명.필드명
			// => 정적 필드의 접근지정자가 private인 경우 접근 불가능
			//Student.total+=student.getTot();
			
			//정적메소드는 클래스를 이용하여 호출
			//형식)클래스명.메소드명.(값,값,...);
			Student.setTotal(Student.getTotal()+student.getTot()); 
		}
		System.out.println("=======================================================");
		//System.out.println("총합계 = "+total); //모든 학생들의 점수 총합계를 출력
		System.out.println("총합계 = "+Student.getTotal());
		System.out.println("=======================================================");
	}
}
